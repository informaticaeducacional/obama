package br.ufrn.imd.obama.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Disciplina implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String denominacao;
	@Transient
	private List<TemaConteudo> temasConteudo;

	public Disciplina() {
		super();
	}

	public Disciplina(int id, String denominacao, List<TemaConteudo> temasConteudo) {
		this.id = id;
		this.denominacao = denominacao;
		this.temasConteudo = temasConteudo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDenominacao() {
		return denominacao;
	}

	public void setDenominacao(String denominacao) {
		this.denominacao = denominacao;
	}

	public List<TemaConteudo> getTemasConteudo() {
		return temasConteudo;
	}

	public void setTemasConteudo(List<TemaConteudo> temasConteudo) {
		this.temasConteudo = temasConteudo;
	}

	@Override
	public String toString() {
		return "Disciplina [id=" + id + ", descricao=" + denominacao + ", temasConteudo=" + temasConteudo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Disciplina other = (Disciplina) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
