package br.ufrn.imd.obama.dominio;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comentario")
public class Comentario implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Usuario usuario;

	@Column(columnDefinition="text", name="texto")
	private String texto;
	
	private Timestamp dataComentario;

	@Column(nullable=true)
	private boolean deletado;
	
	@ManyToOne
	private PlanoDeAula planoDeAula;

	private boolean comentarioDeFeedback;
	
	public Comentario() {
		super();
	}

	public Comentario(int id, Usuario usuario, String texto) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.texto = texto;
	}

	public int getId() {
		return id;
	}
	
	public String getIdStr() {
		return id+"";
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Timestamp getDataComentario() {
		return dataComentario;
	}

	public void setDataComentario(Timestamp dataComentario) {
		this.dataComentario = dataComentario;
	}
	
	public boolean isDeletado() {
		return deletado;
	}

	public void setDeletado(boolean deletado) {
		this.deletado = deletado;
	}	

	public PlanoDeAula getPlanoDeAula() {
		return planoDeAula;
	}

	public void setPlanoDeAula(PlanoDeAula planoDeAula) {
		this.planoDeAula = planoDeAula;
	}

	public boolean isComentarioDeFeedback() {
		return comentarioDeFeedback;
	}

	public void setComentarioDeFeedback(boolean comentarioDeFeedback) {
		this.comentarioDeFeedback = comentarioDeFeedback;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((texto == null) ? 0 : texto.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		Comentario other = (Comentario) obj;
		if (id != other.id)
			return false;
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

}
