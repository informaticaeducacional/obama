package br.ufrn.imd.obama.util;

import br.ufrn.imd.obama.conversor.ConvertivelOpcaoSelect;

import java.util.ArrayList;
import java.util.List;
/**
 * Dto que auxilia montar selects na jsp
 */
public class OpcaoSelect {
    private Object chave;
    private Object valor;
    public OpcaoSelect(Object chave, Object valor) {
        this.chave = chave;
        this.valor = valor;
    }
    /**
     * Converte objeto para opcao select
     * @param opcaoConvertivel instancia de opcao convertivel
     * @return retorna o opção select convertido
     */
    public static OpcaoSelect converteParaOpcaoSelect(ConvertivelOpcaoSelect opcaoConvertivel) {
        return new OpcaoSelect(opcaoConvertivel.getChave(), opcaoConvertivel.getValor());
    }
    /**
     * Converte a lista de valores de tipos de opcaoselect para uma lista de {@link OpcaoSelect}
     *
     * @param listaTodos lista de valores
     *
     * @return retorna uma lista de {@link OpcaoSelect}
     */
    public static List<OpcaoSelect> toListaOpcoes(ConvertivelOpcaoSelect[] listaTodos) {
        List<OpcaoSelect> lista = new ArrayList<>();
        for (ConvertivelOpcaoSelect opcao: listaTodos) {
            lista.add(OpcaoSelect.converteParaOpcaoSelect(opcao));
        }
        return lista;
    }
    public Object getChave() {
        return chave;
    }
    public void setChave(String chave) {
        this.chave = chave;
    }
    public Object getValor() {
        return valor;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }
}
