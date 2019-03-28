package br.ufrn.imd.obama.dominio;

import br.ufrn.imd.obama.conversor.ConvertivelOpcaoSelect;

public enum TipoCadastro implements ConvertivelOpcaoSelect{

	PADRAO("Padrao"),
	GOOGLE("Google"),
	FACEBOOK("Facebook");

	private String chave;

	private TipoCadastro(String chave) {
	    this.chave = chave;
	}

	@Override
	public String getChave() {
		return this.getChave();
	}

	@Override
	public String getValor() {
		return this.toString();
	}
}


