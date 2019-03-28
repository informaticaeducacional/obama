package br.ufrn.imd.obama.dominio;

import java.util.ArrayList;
import java.util.List;

public enum AnoEnsino {
	ANO_0(1, "Infantil",NivelEnsino.ID_EDUCACAO_INFANTIL, "EDUCAÇÃO INFANTIL"),
	ANO_1(2, "1º Ano",NivelEnsino.ID_ANOS_INICIAIS, "ANOS INICIAIS"),
	ANO_2(3, "2º Ano",NivelEnsino.ID_ANOS_INICIAIS, "ANOS INICIAIS"),
	ANO_3(4, "3º Ano",NivelEnsino.ID_ANOS_INICIAIS, "ANOS INICIAIS"),
	ANO_4(5, "4º Ano",NivelEnsino.ID_ANOS_INICIAIS, "ANOS INICIAIS"),
	ANO_5(6, "5º Ano",NivelEnsino.ID_ANOS_INICIAIS, "ANOS INICIAIS"),
	ANO_6(7, "6º Ano",NivelEnsino.ID_ANOS_FINAIS, "ANOS FINAIS"),
	ANO_7(8, "7º ano",NivelEnsino.ID_ANOS_FINAIS, "ANOS FINAIS"),
	ANO_8(9, "8º Ano",NivelEnsino.ID_ANOS_FINAIS, "ANOS FINAIS"),
	ANO_9(10, "9º Ano",NivelEnsino.ID_ANOS_FINAIS, "ANOS FINAIS"),
	ANO_10(11, "1º Ano",NivelEnsino.ID_ENSINO_MEDIO, "ENSINO MÉDIO"),
	ANO_11(12, "2º Ano",NivelEnsino.ID_ENSINO_MEDIO, "ENSINO MÉDIO"),
	ANO_12(13, "3º Ano",NivelEnsino.ID_ENSINO_MEDIO, "ENSINO MÉDIO");
	
	private int id;
	private String denominacao;
	private String denominacaoNivel;
	private int idNivelEnsino;
	private static List<AnoEnsino> todosOsAnos;
	
	static{
		todosOsAnos = new ArrayList<>();
		todosOsAnos.add(ANO_0);
		todosOsAnos.add(ANO_1);
		todosOsAnos.add(ANO_2);
		todosOsAnos.add(ANO_3);
		todosOsAnos.add(ANO_4);
		todosOsAnos.add(ANO_5);
		todosOsAnos.add(ANO_6);
		todosOsAnos.add(ANO_7);
		todosOsAnos.add(ANO_8);
		todosOsAnos.add(ANO_9);
		todosOsAnos.add(ANO_10);
		todosOsAnos.add(ANO_11);
		todosOsAnos.add(ANO_12);		
	}
	
	private AnoEnsino(int id, String denominacao, int idNivelEnsino, String denominacaoNivel) {
		this.id = id;
		this.denominacao = denominacao;
		this.setIdNivelEnsino(idNivelEnsino);
		this.denominacaoNivel = denominacaoNivel;
	}
	
	private AnoEnsino() {		
		this.id = 0;
	}
	
	public static String getDenominacaoPorId(int id) {
		String denominacaoEncontrada = new String("");
		for (AnoEnsino anoEnsino : todosOsAnos) {
			if(anoEnsino.getId() == id) {
				denominacaoEncontrada = anoEnsino.getDenominacao();
			}
		}		
		return denominacaoEncontrada;
	}
	
	public static List<AnoEnsino> getAll() {
		return todosOsAnos;
	}
	
	public static List<AnoEnsino> getAnoPorNivelEnsino(int idNivelEnsino) {
		List<AnoEnsino> anosPorNivel = new ArrayList<>();
		switch (idNivelEnsino) {
			case NivelEnsino.ID_EDUCACAO_INFANTIL:
				anosPorNivel.add(ANO_0);
				break;
				
			case NivelEnsino.ID_ANOS_INICIAIS:
				anosPorNivel.add(ANO_1);
				anosPorNivel.add(ANO_2);
				anosPorNivel.add(ANO_3);
				anosPorNivel.add(ANO_4);
				anosPorNivel.add(ANO_5);			
				break;
				
			case NivelEnsino.ID_ANOS_FINAIS:
				anosPorNivel.add(ANO_6);
				anosPorNivel.add(ANO_7);
				anosPorNivel.add(ANO_8);
				anosPorNivel.add(ANO_9);
				break;
				
			case NivelEnsino.ID_ENSINO_MEDIO:
				anosPorNivel.add(ANO_10);
				anosPorNivel.add(ANO_11);
				anosPorNivel.add(ANO_12);
				break;	
				
			default:
				return todosOsAnos;
		}
		return anosPorNivel;
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
	
	public String getDenominacaoCompleta() {
		return denominacao.concat(" - ").concat(denominacaoNivel);
	}
	

	public void setDenominacao(String denominacao) {
		this.denominacao = denominacao;
	}

	public int getIdNivelEnsino() {
		return idNivelEnsino;
	}

	public void setIdNivelEnsino(int idNivelEnsino) {
		this.idNivelEnsino = idNivelEnsino;
	}

}
