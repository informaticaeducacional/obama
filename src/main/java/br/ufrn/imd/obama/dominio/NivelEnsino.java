package br.ufrn.imd.obama.dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NivelEnsino extends Entidade implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public static final int ID_NIVEL_ENSINO_PROVISORIO = -1;
	
	public static final int ID_EDUCACAO_INFANTIL = 1;
	public static final int ID_ANOS_INICIAIS = 2;
	public static final int ID_ANOS_FINAIS = 3;
	public static final int ID_ENSINO_MEDIO = 4;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String denominacao;
	private String denominacaoAbreviada;

	public NivelEnsino() {
		super();
	}

	public NivelEnsino(int id, String denominacao) {
		this.id = id;
		this.denominacao = denominacao;
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
	
	public String getDenominacaoAbreviada() {
		if(this.id == ID_NIVEL_ENSINO_PROVISORIO) {
			return "TEMA CURRICULAR";
		}
		return denominacaoAbreviada;
	}
	
	public void setDenominacaoAbreviada(String denominacaoAbreviada) {		
		this.denominacaoAbreviada = denominacaoAbreviada;
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
		NivelEnsino other = (NivelEnsino) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
