package br.ufrn.imd.obama.dominio.relatorios;

import br.ufrn.imd.obama.dominio.ObjetoAprendizagem;

import java.util.Iterator;
import java.util.List;

public class OldRelatorioPlanoDeAula extends Relatorio{
    private String titulo;
    private String autor;
    private String anoEnsino;
    private String nivelEnsino;
    private String duracaoEmMinutos;
    private String objetosAprendizagem;
    private String escola;
    private String resumo;
    private String objetivoGeral;
    private String objetivoEspecifico;
    private String metodologia;
    private String recursosAvaliativos;
    private String referencias;

    public OldRelatorioPlanoDeAula(String titulo, String autor, String anoEnsino, String nivelEnsino, String duracaoEmMinutos, List<ObjetoAprendizagem> objetosAprendizagem, String escola, String resumo, String objetivoGeral, String objetivoEspecifico, String metodologia, String recursosAvaliativos, String referencias) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoEnsino = anoEnsino;
        this.nivelEnsino = nivelEnsino;
        this.duracaoEmMinutos = duracaoEmMinutos;
        this.objetosAprendizagem = gerarStringOAs(objetosAprendizagem);
        this.escola = escola;
        this.resumo = resumo;
        this.objetivoGeral = objetivoGeral;
        this.objetivoEspecifico = objetivoEspecifico;
        this.metodologia = metodologia;
        this.recursosAvaliativos = recursosAvaliativos;
        this.referencias = referencias;
    }

    private String gerarStringOAs(List<ObjetoAprendizagem> oas) {
        Iterator<ObjetoAprendizagem> objetos = oas.iterator();
        String resposta = "";
        while(objetos.hasNext()) {
            resposta = resposta + objetos.next().getNome();
            if(objetos.hasNext()) {
                resposta = resposta + ", ";
            } else {
                resposta = resposta + ".";
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

    public String getEscola() {
        return escola;
    }

    public void setEscola(String escola) {
        this.escola = escola;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getObjetivoGeral() {
        return objetivoGeral;
    }

    public void setObjetivoGeral(String objetivoGeral) {
        this.objetivoGeral = objetivoGeral;
    }

    public String getObjetivoEspecifico() {
        return objetivoEspecifico;
    }

    public void setObjetivoEspecifico(String objetivoEspecifico) {
        this.objetivoEspecifico = objetivoEspecifico;
    }

    public String getMetodologia() {
        return metodologia;
    }

    public void setMetodologia(String metodologia) {
        this.metodologia = metodologia;
    }

    public String getRecursosAvaliativos() {
        return recursosAvaliativos;
    }

    public void setRecursosAvaliativos(String recursosAvaliativos) {
        this.recursosAvaliativos = recursosAvaliativos;
    }

    public String getReferencias() {
        return referencias;
    }

    public void setReferencias(String referencias) {
        this.referencias = referencias;
    }
}

