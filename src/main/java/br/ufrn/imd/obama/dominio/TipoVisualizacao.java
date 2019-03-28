package br.ufrn.imd.obama.dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum TipoVisualizacao {
	DISPOSITIVO_MOVEL(1, "Celular/Tablet", "Download"),
	DESKTOP_WEB(2,"Online", "Visualizar"),
	DESKTOP_EXECUTAVEL(3,"Download","Download");
	
	private int id;
	private String denominacao;
	private String textoBotao;
	private static Map<Integer, TipoVisualizacao> todosTipos = new HashMap<>();
	public static List<TipoVisualizacao> todosTiposList = new ArrayList<>();
	
	static {
		todosTipos.put(DISPOSITIVO_MOVEL.id, DISPOSITIVO_MOVEL);
		todosTipos.put(DESKTOP_WEB.id, DESKTOP_WEB);
		todosTipos.put(DESKTOP_EXECUTAVEL.id, DESKTOP_EXECUTAVEL);
		
		todosTiposList.add(DISPOSITIVO_MOVEL);
		todosTiposList.add(DESKTOP_WEB);
		todosTiposList.add(DESKTOP_EXECUTAVEL);
	}
	
	private TipoVisualizacao(int id, String denominacao, String textoBotao) {
		this.id = id;
		this.denominacao = denominacao;
		this.textoBotao = textoBotao;
	}
	
	public static String getTextoBotaoPorId(int id) {
		return todosTipos.get(id).getTextoBotao();
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

	public String getTextoBotao() {
		return textoBotao;
	}

	public void setTextoBotao(String textoBotao) {
		this.textoBotao = textoBotao;
	}
}
