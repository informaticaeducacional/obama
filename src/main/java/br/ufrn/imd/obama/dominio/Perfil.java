package br.ufrn.imd.obama.dominio;

public enum Perfil {
	ADMIN(1, "Administrador"), 
	REVISOR(2, "Revisor"), 
	PADRAO(3, "Padrão");

	private String denominacao;
	private int id;

	private Perfil(int id, String perfil) {
		this.setId(id);
	    this.setDenominacao(perfil);
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

	public boolean equalsName(String outroTipo) {
		return (outroTipo == null) ? false : getDenominacao().equals(outroTipo);
	}

	public String toString() {
		return this.getDenominacao();
	}
}
