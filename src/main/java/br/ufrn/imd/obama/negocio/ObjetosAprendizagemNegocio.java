package br.ufrn.imd.obama.negocio;

import br.ufrn.imd.obama.dominio.Descritor;
import br.ufrn.imd.obama.dominio.NivelEnsino;
import br.ufrn.imd.obama.dominio.ObjetoAprendizagem;
import br.ufrn.imd.obama.dominio.TemaConteudo;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.jboss.weld.util.collections.ArraySet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ObjetosAprendizagemNegocio {


    public ObjetosAprendizagemNegocio() {
    }

    public JsonElement serializarObjetosDeAprendizagem(List<ObjetoAprendizagem> objetos){
        JsonArray jsonArray = new JsonArray();
        for (ObjetoAprendizagem  obj : objetos) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("id",obj.getId());
            jsonObject.addProperty("titulo",obj.getNome());
            jsonObject.addProperty("link",obj.getLink());
            jsonObject.addProperty("autor",obj.getId());
            jsonObject.addProperty("siteAutor",obj.getId());
            jsonObject.addProperty("email",obj.getId());
            HashMap<NivelEnsino, Set<TemaConteudo>> niveisETemas = retornarHashMapNiveisETema(obj.getDescritores());
            jsonObject.add("niveisEnsino",serializarJsonArrayParaNiveisDeEnsino(niveisETemas));
            jsonObject.add("descritores",serializarJsonArrayParaDescritores(obj.getDescritores()));
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }

    public HashMap<NivelEnsino, Set<TemaConteudo>> gerarHashMapParaNivelTema(List<Descritor> descritores) {
        HashMap<NivelEnsino, Set<TemaConteudo>> conteudosPorNivel = new HashMap<>();
        for (Descritor descritor: descritores) {
            Set<TemaConteudo> tema = conteudosPorNivel.get(descritor.getNivelEnsino());
            if(tema != null) {
                tema.add(descritor.getTemaConteudo());
                conteudosPorNivel.put(descritor.getNivelEnsino(), tema);
            } else {
                tema = new ArraySet<TemaConteudo>();
                tema.add(descritor.getTemaConteudo());
                conteudosPorNivel.put(descritor.getNivelEnsino(), tema);
            }
        }
        return conteudosPorNivel;
    }

    /**
     * Gera uma hashmap para extrair niveis de ensino e tema de conteúdo
     * @param descritores
     */
    public HashMap<NivelEnsino, Set<TemaConteudo>> retornarHashMapNiveisETema(List<Descritor> descritores) {
        HashMap<NivelEnsino, Set<TemaConteudo>> temasMap = new HashMap<>();

        for(Descritor descritor : descritores) {
            Set<TemaConteudo> temaConteudos = new HashSet<>();
            if (temasMap.get(descritor.getNivelEnsino()) != null) {
                temaConteudos = temasMap.get(descritor.getNivelEnsino());
            }
            temaConteudos.add(descritor.getTemaConteudo());
            temasMap.put(descritor.getNivelEnsino(),temaConteudos);
        }
        return temasMap;
    }

    public JsonElement serializarJsonArrayParaNiveisDeEnsino(HashMap<NivelEnsino,Set<TemaConteudo>> nivelETema) {
        JsonArray jsonArrayNiveis = new JsonArray();
        Set<NivelEnsino> niveis = nivelETema.keySet();
        for(NivelEnsino nivel : niveis) {
            JsonObject jsonNivel = new JsonObject();
            jsonNivel.addProperty("id",nivel.getId());
            jsonNivel.addProperty("denominacao",nivel.getDenominacao());
            JsonArray jsonArrayTemas = new JsonArray();
            for(TemaConteudo tema : nivelETema.get(nivel)) {
                JsonObject jsonTema = new JsonObject();
                jsonTema.addProperty("id", tema.getId());
                jsonTema.addProperty("denominacao", tema.getDenominacao());
                jsonArrayTemas.add(jsonTema);
            }
            jsonNivel.add("temas",jsonArrayTemas);
            jsonArrayNiveis.add(jsonNivel);
        }
        return jsonArrayNiveis;
    }

    public JsonElement serializarJsonArrayParaDescritores(List<Descritor> descritores) {
        JsonArray jsonArrayDescritores = new JsonArray();
        for(Descritor descritor : descritores) {
            JsonObject jsonDescritor = new JsonObject();
            jsonDescritor.addProperty("id",descritor.getId());
            jsonDescritor.addProperty("denominacao",descritor.getDescricao());
            jsonDescritor.addProperty("descricaoCompleta",descritor.getDescricaoCompleta());
            jsonDescritor.addProperty("codigo",descritor.getCodigo());
            jsonArrayDescritores.add(jsonDescritor);
        }
        return jsonArrayDescritores;
    }
}
