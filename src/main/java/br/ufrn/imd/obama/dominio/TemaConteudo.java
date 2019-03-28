package br.ufrn.imd.obama.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class TemaConteudo extends Entidade implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String denominacao;
	
	@ManyToOne
	@JoinColumn(referencedColumnName="id", name="disciplina")
	private Disciplina disciplina;
	
	@Transient
	private List<Descritor> descritores;
	
	public TemaConteudo() {
		super();
	}

	public TemaConteudo(int id, String conteudo, List<Descritor> descritores, Disciplina disciplina) {
		this.id = id;
		this.denominacao = conteudo;
		this.descritores = descritores;
		this.disciplina = disciplina;
	}
	/**
	 * Retorna o id
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * Altera o id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * retorna denominação
	 * @return
	 */
	public String getDenominacao() {
		return denominacao;
	}
	/**
	 * Modifica denominação
	 * @param denominacao
	 */
	public void setDenominacao(String denominacao) {
		this.denominacao = denominacao;
	}
	/**
	 * retorna descritores
	 * @return
	 */
	public List<Descritor> getDescritores() {
		return descritores;
	}
	/**
	 * Modifica descritores
	 * @param descritores
	 */
	public void setDescritores(List<Descritor> descritores) {
		this.descritores = descritores;
	}
	
	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	
	@Override
	public String toString() {
		return "TemaConteudo [id=" + id + ", conteudo=" + denominacao + ", descritores=" + descritores + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((denominacao == null) ? 0 : denominacao.hashCode());
		result = prime * result + ((descritores == null) ? 0 : descritores.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TemaConteudo other = (TemaConteudo) obj;
		if (denominacao == null) {
			if (other.denominacao != null)
				return false;
		} else if (!denominacao.equals(other.denominacao))
			return false;
		if (descritores == null) {
			if (other.descritores != null)
				return false;
		} else if (!descritores.equals(other.descritores))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
}
