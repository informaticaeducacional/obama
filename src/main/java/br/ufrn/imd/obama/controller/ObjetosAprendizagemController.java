package br.ufrn.imd.obama.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import br.ufrn.imd.obama.dao.SubmissaoOADao;
import br.ufrn.imd.obama.dominio.*;
import com.google.gson.JsonObject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.com.caelum.vraptor.view.Results;
import br.ufrn.imd.obama.anotacoes.Seguranca;
import br.ufrn.imd.obama.anotacoes.Transacional;
import br.ufrn.imd.obama.dao.DescritorDao;
import br.ufrn.imd.obama.dao.EntidadeDao;
import br.ufrn.imd.obama.dao.ObjetoAprendizagemDao;
import br.ufrn.imd.obama.dominio.utils.DadosBuscaObjetos;
import br.ufrn.imd.obama.negocio.Negocio;
import br.ufrn.imd.obama.negocio.ObjetosAprendizagemNegocio;

@Controller
public class ObjetosAprendizagemController extends ControladorVRaptor<ObjetoAprendizagem>{

	@Inject
    private Negocio negocio;

    @Inject
    private ObjetoAprendizagemDao objetoAprendizagemDao;

    @Inject
    private ObjetosAprendizagemNegocio objetosAprendizagemNegocio;

    @Inject
    private DescritorDao descritorDao;

    @Inject
    private SubmissaoOADao submissaoOADao;

    @Deprecated
    protected ObjetosAprendizagemController(){
        this(null,null);
    }

    @Inject
    public ObjetosAprendizagemController(Result resultado, EntidadeDao<ObjetoAprendizagem> dao) {
        super(resultado, dao);
    }

    private DadosBuscaObjetos validarDados(DadosBuscaObjetos dadosBuscaObjetos) {
        if((dadosBuscaObjetos.getTexto() == null || dadosBuscaObjetos.getTexto().equals(""))
                && dadosBuscaObjetos.getIdDescritor() == 0
                && dadosBuscaObjetos.getIdNivelEnsino() == 0
                && dadosBuscaObjetos.getIdTemaConteudo() == 0 && dadosBuscaObjetos.getIdTipoVisualizacao() == 0){
            return null;
        }
        return dadosBuscaObjetos;
    }

    @Seguranca(perfil = Perfil.ADMIN)
    public void cadastro() {
        resultado.include("niveis",negocio.geraListaOpcoesNiveis());
        resultado.include("temas",negocio.geraListaOpcoesTema());
        resultado.include("tipos",negocio.geraListaOpcoesTipoOa());
        resultado.include("mantenedores",negocio.geraListaOpcoesAutoresMantenedores());
        resultado.include("descritores",negocio
                .geraListaOpcoesDescritores(this.descritorDao.listar().stream().collect(Collectors.toList())));
    }

    @Seguranca(perfil = Perfil.ADMIN)
    @Transacional
    @Post
    public void salvar(ObjetoAprendizagem objetoAprendizagem, UploadedFile foto) throws IOException {
        dao.salvar(objetoAprendizagem);
        File file = new File("/opt/obama-files/oas-miniaturas/",objetoAprendizagem.getId()+".png");
        foto.writeTo(file);
        resultado.redirectTo(this).cadastro();
    }

    public void busca(DadosBuscaObjetos dadosDaBusca) {
        if(validarDados(dadosDaBusca) != null) {
            List<ObjetoAprendizagem> oas = this.objetoAprendizagemDao.buscarOA(dadosDaBusca.getTexto(),
                    dadosDaBusca.getIdNivelEnsino(),
                    dadosDaBusca.getIdTemaConteudo(),
                    dadosDaBusca.getIdDescritor(),
                    dadosDaBusca.getIdTipoVisualizacao());
            for (ObjetoAprendizagem obj: oas) {
                obj.setConteudosPorNivel(objetosAprendizagemNegocio
                        .retornarHashMapNiveisETema(obj.getDescritores()));
            }
            resultado.include("totalOAEncontrado", getTextoResultadosEncontrados(oas));
            resultado.include("objetos",oas);
            resultado.include("dadosDaBusca",dadosDaBusca);
        }

        resultado.include("niveis",negocio.geraListaOpcoesNiveis());
        resultado.include("temas",negocio.geraListaOpcoesTema());
        resultado.include("tipos",negocio.geraListaOpcoesTipoOa());
        resultado.include("descritores",negocio.geraListaOpcoesDescritores(this.descritorDao.buscarDescritoresListaveis()));
        resultado.of(this).busca(dadosDaBusca);
    }

    public String getTextoResultadosEncontrados(List<ObjetoAprendizagem> objetos) {
        String mensagem = "Ops... Nenhum resultado foi encontrado. :'(";
        if(objetos != null && !objetos.isEmpty()) {
            int totalResultados = objetos.size();
            if(totalResultados >= 1 && totalResultados <= 5) {
                mensagem = "Ahh... Encontramos apenas "+objetos.size()+" recursos. :(";
            } else if(totalResultados > 6 && totalResultados <= 10) {
                mensagem = "Encontramos "+objetos.size()+" recursos. Que tal? ;)";
            } else if(totalResultados > 10 && totalResultados <= 20) {
                mensagem = "Encontramos "+objetos.size()+" recursos. Bastante, hein?! =)";
            } else if(totalResultados > 20) {
                mensagem = "Eita! Encontramos "+objetos.size()+" recursos! =D";
            }
        }
        return mensagem;
    }

    @Get
    @Path("/objetosAprendizagem/opcoesDescritores/nivelEnsino/{nivelEnsino}/temaConteudo/{temaConteudo}")
    public void opcoesDescritores(int nivelEnsino, int temaConteudo) {
        List<Descritor> descritores = descritorDao.buscarDescritoresPorNivelETema(nivelEnsino,temaConteudo, false);
        resultado.use(Results.json()).withoutRoot().from(descritores).include("nivelEnsino").serialize();
    }

    @Get
    @Path("/objetosAprendizagem/todosDescritores/nivelEnsino/{nivelEnsino}/temaConteudo/{temaConteudo}")
    public void todosDescritores(int nivelEnsino, int temaConteudo) {
        List<Descritor> descritores = descritorDao.buscarTodosDescritoresPorNivelETema(nivelEnsino,temaConteudo);
        resultado.use(Results.json()).withoutRoot().from(descritores).include("nivelEnsino").serialize();
    }
    
    @Get
    @Path("/objetosAprendizagem/visualizar/{idOA}")
    public void visualizar(int idOA) {
    	ObjetoAprendizagem oa = dao.buscarPorId(idOA);
    	resultado.include("oa", oa);
    }
    
    @Seguranca( perfil = Perfil.REVISOR )
    public void gerenciar() {
    	List<ObjetoAprendizagem> oas = objetoAprendizagemDao.getListaOrdenada();
    	resultado.include("titulo", "Gerenciamento de OA");
    	resultado.include("oas", oas);
    }
    
    @Transacional
    @Get
    @Path("/objetosAprendizagem/gerenciar/{idOA}")
    public void ativarOA(int idOA) {
    	ObjetoAprendizagem oa = dao.buscarPorId(idOA);
    	JsonObject json = new JsonObject();
    	json.addProperty("mensagem", "OA alterado com sucesso!");
    	oa.setAtivo(!oa.isAtivo());
    	dao.salvar(oa);
    	resultado.use(Results.json()).withoutRoot().from(json).serialize();
    }

    @Seguranca
    public void sugestao() {

    }

    @Post
    @Transacional
    public void sugerir(SugestaoOA submissao) {
        submissao.setStatus(StatusSubmissao.AGUARDADO_REVISAO);
        this.submissaoOADao.salvar(submissao);
        resultado.include("mensagem","Agradecemos a sua colaboração. Sua sugestão foi encaminhada com sucesso!");
        resultado.redirectTo(this).sugestao();

    }
}
