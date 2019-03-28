package br.ufrn.imd.obama.dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoObjeto extends Entidade implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String tipoObjeto;
	
	public TipoObjeto() {
		super();
	}

	public TipoObjeto(int id, String tipoObjeto) {
		this.id = id;
		this.tipoObjeto = tipoObjeto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoObjeto() {
		return tipoObjeto;
	}

	public void setTipoObjeto(String tipoObjeto) {
		this.tipoObjeto = tipoObjeto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((tipoObjeto == null) ? 0 : tipoObjeto.hashCode());
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
		TipoObjeto other = (TipoObjeto) obj;
		if (id != other.id)
			return false;
		if (tipoObjeto == null) {
			if (other.tipoObjeto != null)
				return false;
		} else if (!tipoObjeto.equals(other.tipoObjeto))
			return false;
		return true;
	}
	
	
	
	
	
	
}
