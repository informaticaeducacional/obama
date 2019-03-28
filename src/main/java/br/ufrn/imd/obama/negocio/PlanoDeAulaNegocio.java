package br.ufrn.imd.obama.negocio;

import br.ufrn.imd.obama.dao.PlanoDeAulaDao;
import br.ufrn.imd.obama.dao.UsuarioDao;
import br.ufrn.imd.obama.dominio.*;
import br.ufrn.imd.obama.util.GerenciadorEmail;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public class PlanoDeAulaNegocio {

    private PlanoDeAulaDao planoDeAulaDao;
    private UsuarioLogado usuarioLogado;
    private UsuarioDao usuarioDao;

    @Inject
    public PlanoDeAulaNegocio(PlanoDeAulaDao planoDeAulaDao, UsuarioLogado usuarioLogado, UsuarioDao usuarioDao) {
        this.planoDeAulaDao = planoDeAulaDao;
        this.usuarioLogado = usuarioLogado;
        this.usuarioDao = usuarioDao;
    }

    public void salvarRascunho(PlanoDeAula planoDeAula) {
        PlanoDeAula planoParaSalvar = popularPlanoDeAula(planoDeAula);
        planoDeAulaDao.salvar(planoParaSalvar);
    }

    private PlanoDeAula popularPlanoDeAula(PlanoDeAula planoDeAula) {
        if(!(planoDeAula.getAutor().getId() > 0)) {
            planoDeAula.setAutor(usuarioLogado.getUsuario());
        }
        planoDeAula.setDataCadastro(new Timestamp(System.currentTimeMillis()));
        if(planoDeAula.getStatus() != StatusSubmissao.NECESSARIO_AJUSTE.getId()){
            planoDeAula.setStatusPlanoDeAula(StatusSubmissao.RASCUNHO);
        }
        return planoDeAula;
    }

    public JsonElement gerarJsonMensagens(int idPlanoDeAula, JsonArray mensagens, JsonArray coautores) {
        JsonObject plano = new JsonObject();
        plano.addProperty("id",idPlanoDeAula);
        plano.add("mensagens",mensagens);
        plano.add("coautores",coautores);
        return plano;
    }

    public JsonElement compartilharPlanoDeAula(PlanoDeAula planoDeAula, String emails) {
        String listaDeEmails[] = emails.split(";");
        List<String> emailsValidos =  new ArrayList<>();
        JsonArray jsonArray = new JsonArray();
        for (String email:listaDeEmails) {
            Optional<Usuario> usuarioOptional = usuarioDao.buscarPorEmail(email.trim());
            JsonObject jsonMensagem = getMensagemUsuarioInvalido(usuarioOptional,planoDeAula,email);
            if(jsonMensagem !=null) {
                jsonArray.add(jsonMensagem);
            } else {
                emailsValidos.add(email);
            }
        }
        salvarRascunho(planoDeAula);
        JsonArray jsonCoautores = new JsonArray();
        for(Usuario autor : planoDeAula.getCoautores()) {
            JsonObject jsonAutor = new JsonObject();
            jsonAutor.addProperty("id",autor.getId());
            jsonCoautores.add(jsonAutor);
        }
        JsonElement jsonElement = gerarJsonMensagens(planoDeAula.getId(), jsonArray,jsonCoautores);
        enviarEmailCompartilhamento(emailsValidos);
        return jsonElement;
    }

    private JsonObject getMensagemUsuarioInvalido(Optional<Usuario> usuarioOptional, PlanoDeAula planoDeAula, String email) {
        JsonObject jsonMensagem = new JsonObject();
        if(usuarioOptional.isPresent()) {
            if(planoDeAula.getCoautores() != null) {
                planoDeAula.getCoautores().add(usuarioOptional.get());
                jsonMensagem = null;
            } else {
                planoDeAula.setCoautores(new HashSet<>());
                planoDeAula.getCoautores().add(usuarioOptional.get());
            }
        } else {
            jsonMensagem.addProperty("mensagem","Email "+email+" inválido ou não está cadastrado");
        }
        return jsonMensagem;
    }

    private void enviarEmailCompartilhamento(List<String> emailsDalidos) {
        String mensagem =  "Olá! "+usuarioLogado.getUsuario().getNome()+" compartilhou um plano de aula com você. " +
                "Acesse os planos de aula em obama.imd.ufrn.br.";
        for(String email : emailsDalidos) {
            GerenciadorEmail.enviarEmail(email,"Plano de aula compartilhado - OBAMA",mensagem);
        }
    }

    public void salvarComentario(PlanoDeAula planoDeAula, Comentario comentario){
        comentario = popularComentario(planoDeAula, comentario);
        if(planoDeAula.getComentarios() == null) {
            planoDeAula.setComentarios(new HashSet<Comentario>());
            planoDeAula.getComentarios().add(comentario);
        } else {
            planoDeAula.getComentarios().add(comentario);
        }

        planoDeAulaDao.salvar(planoDeAula);

    }
    private Comentario popularComentario (PlanoDeAula planoDeAula, Comentario comentario){
        comentario.setPlanoDeAula(planoDeAula);
        comentario.setDataComentario(Timestamp.valueOf(LocalDateTime.now()));
        comentario.setUsuario(usuarioLogado.getUsuario());
        comentario.setDeletado(false);
        if(planoDeAula.getStatusPlanoDeAula().equals(StatusSubmissao.VALIDADO)) {
            comentario.setComentarioDeFeedback(false);
        } else {
            comentario.setComentarioDeFeedback(true);
        }
        return comentario;
    }

    public void feedbackPlanodeAula (int id, StatusSubmissao status, String feedback) {
        PlanoDeAula planoDeAula = this.planoDeAulaDao.buscarPlanoPorId(id);
        planoDeAula.setStatusPlanoDeAula(status);
        this.planoDeAulaDao.salvar(planoDeAula);
        enviarEmailDeFeedback(planoDeAula,feedback);
    }

    private void enviarEmailDeFeedback (PlanoDeAula planoDeAula, String feedback) {
        GerenciadorEmail.enviarEmail(planoDeAula.getAutor().getEmail(),"OBAMA - Revisão plano de aula",
                mensagemFeedback(planoDeAula.getAutor().getNome(),planoDeAula.getStatusPlanoDeAula().getDenominacao(),feedback));
        if(planoDeAula.getCoautores() != null) {
            if(!planoDeAula.getCoautores().isEmpty()) {
                for(Usuario usuario : planoDeAula.getCoautores()) {
                    GerenciadorEmail.enviarEmail(usuario.getEmail(),"OBAMA - Revisão plano de aula",
                            mensagemFeedback(usuario.getNome(),planoDeAula.getStatusPlanoDeAula().getDenominacao(),feedback));
                }
            }
        }
    }

    private String mensagemFeedback (String autor,String status, String feedback) {
        return "Olá "+autor+"! O plano de aula que você produziu na plataforma OBAMA foi avaliado. " +
                "Segue o feedback da avaliação abaixo: \n \n"+ "Status do plano de aula: "+ status +". \n \n" + feedback;
    }
}
