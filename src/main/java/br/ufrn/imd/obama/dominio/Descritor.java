package br.ufrn.imd.obama.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Descritor extends Entidade implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String descricao;
	private String codigo;
	
	@ManyToOne
	@JoinColumn(name="nivelensino")
	private NivelEnsino nivelEnsino;
	
	@ManyToOne
	@JoinColumn(name="temaconteudo")
	private TemaConteudo temaConteudo;

	@ManyToMany(mappedBy="descritores")
	private List<ObjetoAprendizagem> objetosAprendizagem;
		
	public Descritor() {
		super();
	}
	
	public Descritor(int id, String descricao, String codigo, NivelEnsino nivelEnsino, TemaConteudo temaConteudo) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.codigo = codigo;
		this.nivelEnsino = nivelEnsino;
		this.temaConteudo = temaConteudo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Transient
	public String getDescricaoCompleta() {		
		String descricaoCompleta = descricao;
		
		if(!codigo.equals("D0")) {
			descricaoCompleta = codigo.concat(" - ").concat(descricaoCompleta);
		}
		
		if(nivelEnsino != null && nivelEnsino.getId() != NivelEnsino.ID_NIVEL_ENSINO_PROVISORIO) {
			descricaoCompleta = nivelEnsino.getDenominacaoAbreviada().concat(" - ").concat(descricaoCompleta);
		} else {
			
		}
		return descricaoCompleta;
	}

	public NivelEnsino getNivelEnsino() {
		return nivelEnsino;
	}

	public void setNivelEnsino(NivelEnsino nivelEnsino) {
		this.nivelEnsino = nivelEnsino;
	}

	public TemaConteudo getTemaConteudo() {
		return temaConteudo;
	}

	public void setTemaConteudo(TemaConteudo temaConteudo) {
		this.temaConteudo = temaConteudo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<ObjetoAprendizagem> getObjetosAprendizagem() {
		return objetosAprendizagem;
	}

	public void setObjetosAprendizagem(List<ObjetoAprendizagem> objetosAprendizagem) {
		this.objetosAprendizagem = objetosAprendizagem;
	}
	
}
