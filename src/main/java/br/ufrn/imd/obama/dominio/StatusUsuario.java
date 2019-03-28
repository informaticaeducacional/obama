package br.ufrn.imd.obama.dominio;

public enum StatusUsuario {
	ATIVO(1, "ATIVO"), 
	INATIVO(2, "INATIVO");

	private final String status;

	private StatusUsuario(int ID, String status) {
	    this.status = status;
	 }

	public boolean equalsName(String outroTipo) {
		return (outroTipo == null) ? false : status.equals(outroTipo);
	}

	public String toString() {
		return this.status;
	}
}
