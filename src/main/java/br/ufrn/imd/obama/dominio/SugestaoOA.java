package br.ufrn.imd.obama.dominio;

import javax.persistence.*;

@Entity
@Table
public class SugestaoOA extends Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    @ManyToOne
    private Usuario usuario;
    @Column(columnDefinition = "text")
    private String descricao;
    @Column(columnDefinition = "text")
    private String descritores;
    private String link;

    @Enumerated(value = EnumType.STRING)
    private StatusSubmissao status;


    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescritores() {
        return descritores;
    }

    public void setDescritores(String descritores) {
        this.descritores = descritores;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public StatusSubmissao getStatus() {
        return status;
    }

    public void setStatus(StatusSubmissao status) {
        this.status = status;
    }
}
