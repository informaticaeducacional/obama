package br.ufrn.imd.obama.dominio;

import java.util.HashMap;
import java.util.Map;

public enum StatusSubmissao {
	AGUARDADO_REVISAO(1,"Aguardando revisão","restore"),
	NECESSARIO_AJUSTE(2,"Necessário ajuste","error_outline"),
	VALIDADO(3,"Validado","done_all"),
	RASCUNHO(4,"Rascunho","assignment_late"),
	REMOVIDO(5,"Removido","not_interested"),
	SUGESTAO_REJEITADA (6,"Sugestão rejeitada","not_interested");

	private int id;
	private String denominacao;
	private String icon_class;
	private static Map<Integer, StatusSubmissao> todos = new HashMap<>();
	private static Map<Integer, StatusSubmissao> statusPlanoDeAula = new HashMap<>();
	private static Map<Integer, StatusSubmissao> statusOas = new HashMap<>();

	static {
		todos.put(AGUARDADO_REVISAO.id, AGUARDADO_REVISAO);
		todos.put(NECESSARIO_AJUSTE.id, NECESSARIO_AJUSTE);
		todos.put(VALIDADO.id, VALIDADO);
		todos.put(RASCUNHO.id, RASCUNHO);
		todos.put(REMOVIDO.id, REMOVIDO);
		todos.put(SUGESTAO_REJEITADA.id, SUGESTAO_REJEITADA);
		todos.put(VALIDADO.id, VALIDADO);
		//Options para submissão de OA
		statusOas.put(SUGESTAO_REJEITADA.id, SUGESTAO_REJEITADA);
		statusOas.put(AGUARDADO_REVISAO.id, AGUARDADO_REVISAO);
		statusOas.put(VALIDADO.id, VALIDADO);
		//Options para planos de aula
		statusPlanoDeAula.put(AGUARDADO_REVISAO.id, AGUARDADO_REVISAO);
		statusPlanoDeAula.put(NECESSARIO_AJUSTE.id, NECESSARIO_AJUSTE);
		statusPlanoDeAula.put(VALIDADO.id, VALIDADO);
		statusPlanoDeAula.put(RASCUNHO.id, RASCUNHO);
		statusPlanoDeAula.put(REMOVIDO.id, REMOVIDO);

	}
	
	private StatusSubmissao(int id, String denominacao, String icon_class) {
		this.id = id;
		this.denominacao = denominacao;
		this.icon_class = icon_class;		
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

	public String getIcon_class() {
		return icon_class;
	}

	public void setIcon_class(String icon_class) {
		this.icon_class = icon_class;
	}
	
	public static StatusSubmissao getStatusPorId(int idStatus) {
		return todos.get(idStatus);
	}

	public static Map<Integer, StatusSubmissao> getTodos() {
		return todos;
	}

	public static void setTodos(Map<Integer, StatusSubmissao> todos) {
		StatusSubmissao.todos = todos;
	}

	public static Map<Integer, StatusSubmissao> getStatusPlanoDeAula() {
		return statusPlanoDeAula;
	}

	public static void setStatusPlanoDeAula(Map<Integer, StatusSubmissao> statusPlanoDeAula) {
		StatusSubmissao.statusPlanoDeAula = statusPlanoDeAula;
	}

	public static Map<Integer, StatusSubmissao> getStatusOas() {
		return statusOas;
	}

	public static void setStatusOas(Map<Integer, StatusSubmissao> statusOas) {
		StatusSubmissao.statusOas = statusOas;
	}
}
