package br.ufrn.imd.obama.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.inject.Inject;

import com.google.common.base.Strings;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.ufrn.imd.obama.anotacoes.PlanoDeAulaSeguranca;
import br.ufrn.imd.obama.anotacoes.Seguranca;
import br.ufrn.imd.obama.anotacoes.Transacional;
import br.ufrn.imd.obama.dao.EntidadeDao;
import br.ufrn.imd.obama.dao.ObjetoAprendizagemDao;
import br.ufrn.imd.obama.dao.PlanoDeAulaDao;
import br.ufrn.imd.obama.dominio.AnoEnsino;
import br.ufrn.imd.obama.dominio.Comentario;
import br.ufrn.imd.obama.dominio.ObjetoAprendizagem;
import br.ufrn.imd.obama.dominio.PlanoDeAula;
import br.ufrn.imd.obama.dominio.StatusSubmissao;
import br.ufrn.imd.obama.dominio.UsuarioLogado;
import br.ufrn.imd.obama.negocio.PlanoDeAulaNegocio;

@Controller
public class PlanoDeAulaController extends ControladorVRaptor<PlanoDeAula>{

    @Inject
    private PlanoDeAulaDao planoDeAulaDao;

    @Inject
    private UsuarioLogado usuarioLogado;

    @Inject
    private ObjetoAprendizagemDao objetoAprendizagemDao;

    private PlanoDeAulaNegocio planoDeAulaNegocio;

    @Deprecated
    protected PlanoDeAulaController() {
        this(null,null,null);
    }

    @Inject
    public PlanoDeAulaController(Result resultado, EntidadeDao<PlanoDeAula> dao, PlanoDeAulaNegocio planoDeAulaNegocio) {
        super(resultado, dao);
        this.planoDeAulaNegocio = planoDeAulaNegocio;
    }

    public void lista() {
        resultado.include("validados",true);
        resultado.include("planos",planoDeAulaDao.buscarPlanoPorStatus(StatusSubmissao.VALIDADO));
        resultado.include("titulo","Planos de aula");
    }

    @Transacional
    @Post
    public void salvar(PlanoDeAula planoDeAula) {
        planoDeAula.setStatusPlanoDeAula(StatusSubmissao.AGUARDADO_REVISAO);
        planoDeAula.setDataCadastro(Timestamp.valueOf(LocalDateTime.now()));
        if(!(planoDeAula.getAutor().getId() > 0)) {
            planoDeAula.setAutor(usuarioLogado.getUsuario());
        }
        this.dao.salvar(planoDeAula);
        resultado.redirectTo(this).meusPlanosDeAula();

    }

    @Transacional
    @Post
    public void salvarRascunho(PlanoDeAula planoDeAula) {
        if(Strings.isNullOrEmpty(planoDeAula.getTitulo())) {
            planoDeAula.setTitulo("PLANO DE AULA SEM TITULO.");
        }
        planoDeAulaNegocio.salvarRascunho(planoDeAula);
        JsonObject plano = new JsonObject();
        plano.addProperty("id",planoDeAula.getId());
        resultado.include("mensagem","Salvo com sucesso");
        resultado.use(Results.json()).from(plano).serialize();

    }

    @Transacional
    @Get
    @Path("/planoDeAula/remover/{idPlano}")
    public void remover(int idPlano) {
        PlanoDeAula planoDeAula = planoDeAulaDao.buscarPlanoPorId(idPlano);
        planoDeAulaDao.remover(planoDeAula);
        resultado.redirectTo(this).meusPlanosDeAula();
    }

    public void meusPlanosDeAula() {
        resultado.include("planos",planoDeAulaDao.buscarPlanoPorUsuario(usuarioLogado.getUsuario()));
        resultado.include("planosCompartilhados",planoDeAulaDao.buscarPlanoCompartilhadoComUsuario(usuarioLogado.getUsuario()));
        resultado.include("meusPlanos",true);
        resultado.include("titulo","Meus planos de aula");
        resultado.of(this).lista();
    }
    public void planosPendentes() {
        resultado.include("planos",planoDeAulaDao.buscarPlanoPorStatus(StatusSubmissao.AGUARDADO_REVISAO));
        resultado.include("titulo","Planos de aula pendentes");
        resultado.of(this).lista();
    }

    @Get
    @Path("/plano-de-Aula/{id}")
    @PlanoDeAulaSeguranca
    public void editar(String token, int id) {
        List<ObjetoAprendizagem> objetos = objetoAprendizagemDao.listar();
        PlanoDeAula planoDeAula = planoDeAulaDao.buscarPlanoPorId(id);
        objetos.removeAll(planoDeAula.getObjetosAprendizagem());
        resultado.include("planoDeAula",planoDeAula);
        resultado.include("anosEnsino",AnoEnsino.getAll());
        resultado.include("objetos",objetos);
        resultado.include("objetosPlanoDeAula",planoDeAula.getObjetosAprendizagem());
        resultado.of(this).form();
    }

    @PlanoDeAulaSeguranca
    @Get
    @Path("/planoDeAula/visualizar/{id}")
    public void visualizar(int id) {
        PlanoDeAula planoDeAula = dao.buscarPorId(id);

        if(planoDeAula.getStatusPlanoDeAula().equals(StatusSubmissao.VALIDADO)){
            resultado.include("validado",true);
        } else if(planoDeAula.getStatusPlanoDeAula().equals(StatusSubmissao.AGUARDADO_REVISAO)
        || planoDeAula.getStatusPlanoDeAula().equals(StatusSubmissao.NECESSARIO_AJUSTE)){
            resultado.include("pendente",true);
        }
        resultado.include("planoDeAula",planoDeAula);
    }

    @Seguranca
    public void form() {
        resultado.include("anosEnsino",AnoEnsino.getAll());
        resultado.include("objetos",objetoAprendizagemDao.listar());
    }

    @Post
    @Transacional
    public void compartilharPlanoDeAula(PlanoDeAula planoDeAula, String emails) {
        if(Strings.isNullOrEmpty(planoDeAula.getTitulo())) {
            planoDeAula.setTitulo("PLANO DE AULA SEM TITULO.");
        }
        JsonElement resposta = planoDeAulaNegocio.compartilharPlanoDeAula(planoDeAula,emails);
        resultado.use(Results.json()).withoutRoot().from(resposta).serialize();
    }

    @Post
    @Transacional
    public void salvarComentario(int idPlano,Comentario comentario) {
        PlanoDeAula planoDeAula = dao.buscarPorId(idPlano);
        planoDeAulaNegocio.salvarComentario(planoDeAula,comentario);
        resultado.use(Results.json()).withoutRoot().from(planoDeAula.getComentarios()).serialize();
    }

    @Post
    @Transacional
    public void enviarParaReajuste(int idPlano, StatusSubmissao status, String feedback) {
        this.planoDeAulaNegocio.feedbackPlanodeAula(idPlano,status,feedback);
        resultado.use(Results.json()).withoutRoot().from("").serialize();
    }

    @Post
    @Transacional
    public void validarPlanoDeAula(int idPlano,Comentario comentario) {
        PlanoDeAula planoDeAula = dao.buscarPorId(idPlano);
        planoDeAula.setStatusPlanoDeAula(StatusSubmissao.VALIDADO);
        dao.salvar(planoDeAula);
        resultado.use(Results.json()).withoutRoot().from(planoDeAula.getComentarios()).serialize();
    }


}
