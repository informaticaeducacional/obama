package br.ufrn.imd.obama.dominio.utils;

public class DadosBuscaObjetos {

    private String texto;
    private int idNivelEnsino;
    private int idTemaConteudo;
    private int idDescritor;
    private int idTipoVisualizacao;

    public DadosBuscaObjetos(String texto, int idNivelEnsino, int idTemaConteudo, int idDescritor, int idTipoVisualizacao) {
        this.texto = texto;
        this.idNivelEnsino = idNivelEnsino;
        this.idTemaConteudo = idTemaConteudo;
        this.idDescritor = idDescritor;
        this.idTipoVisualizacao = idTipoVisualizacao;
    }

    public DadosBuscaObjetos() {


    }

    public String getTexto() {
        if(this.texto == null) {
            setTexto("");
        }
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getIdNivelEnsino() {
        return idNivelEnsino;
    }

    public void setIdNivelEnsino(int idNivelEnsino) {
        this.idNivelEnsino = idNivelEnsino;
    }

    public int getIdTemaConteudo() {
        return idTemaConteudo;
    }

    public void setIdTemaConteudo(int idTemaConteudo) {
        this.idTemaConteudo = idTemaConteudo;
    }

    public int getIdDescritor() {
        return idDescritor;
    }

    public void setIdDescritor(int idDescritor) {
        this.idDescritor = idDescritor;
    }

    public int getIdTipoVisualizacao() {
        return idTipoVisualizacao;
    }

    public void setIdTipoVisualizacao(int idTipoVisualizacao) {
        this.idTipoVisualizacao = idTipoVisualizacao;
    }
}
