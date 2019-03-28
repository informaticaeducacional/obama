package br.ufrn.imd.obama.dominio.relatorios;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.google.common.base.Strings;

import br.ufrn.imd.obama.dominio.ObjetoAprendizagem;
import br.ufrn.imd.obama.dominio.Usuario;

public class RelatorioPlanoDeAula extends Relatorio{

    private String titulo;
    private String autor;
    private String anoEnsino;
    private String nivelEnsino;
    private String duracaoEmMinutos;
    private String objetosAprendizagem;
    private String descricao;
    private String escola;
    private String coautores;

    public RelatorioPlanoDeAula() {
    }

    public RelatorioPlanoDeAula(String titulo, String autor, Set<Usuario> coautores, String anoEnsino, String nivelEnsino, String duracaoEmMinutos,
                                List<ObjetoAprendizagem> objetosAprendizagem, String descricao, String escola) {
        this.titulo = titulo;
        this.anoEnsino = anoEnsino;
        this.nivelEnsino = nivelEnsino;
        this.duracaoEmMinutos = duracaoEmMinutos;
        this.objetosAprendizagem = gerarStringOAs(objetosAprendizagem);
        this.descricao = formatarMetodologia(descricao);
        this.escola = escola;
        this.coautores = gerarStringCoautores(coautores);
  		this.autor = autor;
    }

    private String gerarStringCoautores(Set<Usuario> coautores) {
    	Iterator<Usuario> iterator = coautores.iterator();
        String resposta = new String("");
        while(iterator.hasNext()) {
            resposta = resposta + iterator.next().getNome();
            if(iterator.hasNext()) {
               resposta = resposta + ", ";
            } else {
                resposta = resposta + ".";
            }

        }
        return resposta;
	}

	private String gerarStringOAs(List<ObjetoAprendizagem> oas) {
        Iterator<ObjetoAprendizagem> objetos = oas.iterator();
        String resposta = new String("");
        if(oas == null || oas.isEmpty()) {
        	resposta = "Não se aplica";
        } else {
	        while(objetos.hasNext()) {
	            resposta = resposta + objetos.next().getNome();
	            if(objetos.hasNext()) {
	               resposta = resposta + ", ";
	            } else {
	                resposta = resposta + ".";
	            }
	
	        }
        }
        return resposta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
    	if(!Strings.isNullOrEmpty(coautores)) {
    		autor = autor.concat(", ").concat(coautores);
    	}
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAnoEnsino() {
        return anoEnsino;
    }

    public void setAnoEnsino(String anoEnsino) {
        this.anoEnsino = anoEnsino;
    }

    public String getNivelEnsino() {
        return nivelEnsino;
    }

    public void setNivelEnsino(String nivelEnsino) {
        this.nivelEnsino = nivelEnsino;
    }

    public String getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setDuracaoEmMinutos(String duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public String getObjetosAprendizagem() {
        return objetosAprendizagem;
    }

    public void setObjetosAprendizagem(String objetosAprendizagem) {
        this.objetosAprendizagem = objetosAprendizagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEscola() {
        return escola;
    }

    public void setEscola(String escola) {
        this.escola = escola;
    }


    public String getCoautores() {
		return coautores;
	}

	public void setCoautores(String coautores) {
		this.coautores = coautores;
	}

	public String formatarMetodologia(String metodologia) {
        metodologia = metodologia.replaceAll("9px","10px");
        metodologia = metodologia.replaceAll("12px","10px");
        metodologia = metodologia.replaceAll("14px","10px");
        metodologia = metodologia.replaceAll("18px","10px");
        metodologia = metodologia.replaceAll("24px","10px");
        metodologia = metodologia.replaceAll("32px","10px");
        metodologia = metodologia.replaceAll("42px","10px");
        return metodologia;
    }
}
