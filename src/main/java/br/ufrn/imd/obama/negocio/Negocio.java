package br.ufrn.imd.obama.negocio;


import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.inject.Inject;

import br.ufrn.imd.obama.dao.AutorMantenedorDao;
import br.ufrn.imd.obama.dao.NivelEnsinoDao;
import br.ufrn.imd.obama.dao.TemaConteudoDao;
import br.ufrn.imd.obama.dominio.AnoEnsino;
import br.ufrn.imd.obama.dominio.AutorMantenedor;
import br.ufrn.imd.obama.dominio.Descritor;
import br.ufrn.imd.obama.dominio.NivelEnsino;
import br.ufrn.imd.obama.dominio.TemaConteudo;
import br.ufrn.imd.obama.dominio.TipoVisualizacao;
import br.ufrn.imd.obama.util.OpcaoSelect;

public class Negocio {
    @Inject
    private NivelEnsinoDao nivelEnsinoDao;

    @Inject
    private TemaConteudoDao temaConteudoDao;

    @Inject
    private AutorMantenedorDao autorMantenedorDao;

    public List<OpcaoSelect> geraListaOpcoesNiveis() {
        List<NivelEnsino> todos = this.nivelEnsinoDao.listar();
        return todos.stream().map(
                nivel -> new OpcaoSelect(nivel.getDenominacao(), nivel.getId()))
                .collect(Collectors.toList());
    }

    public List<OpcaoSelect> geraListaOpcoesTema() {
        List<TemaConteudo> todos = this.temaConteudoDao.listar();
        return todos.stream().map(
                tema -> new OpcaoSelect(tema.getDenominacao(), tema.getId()))
                .collect(Collectors.toList());
    }

    public List<OpcaoSelect> geraListaOpcoesAutoresMantenedores() {
        List<AutorMantenedor> todos = this.autorMantenedorDao.listar();
        return todos.stream().map(
                mantenedor -> new OpcaoSelect(mantenedor.getNome(), mantenedor.getId()))
                .collect(Collectors.toList());
    }

    public List<OpcaoSelect> geraListaOpcoesTipoOa() {
        List<TipoVisualizacao> todos = TipoVisualizacao.todosTiposList;
        return todos.stream().map(
                tipo -> new OpcaoSelect(tipo.getDenominacao(), tipo.getId()))
                .collect(Collectors.toList());
    }

    public List<OpcaoSelect> geraListaOpcoesDescritores(List<Descritor> todos) {
        return todos.stream().map(
                descritor -> new OpcaoSelect(descritor.getNivelEnsino().getDenominacaoAbreviada()
                        + " - "+ descritor.getCodigo() +" - "+ descritor.getDescricao(), descritor.getId()))
                .collect(Collectors.toList());
    }

    public List<OpcaoSelect> geraListaOpcoesAnoEnsino() {
        List<AnoEnsino> todos = AnoEnsino.getAll();
        return todos.stream().map(
                descritor -> new OpcaoSelect(descritor.getDenominacao(), descritor.getId()))
                .collect(Collectors.toList());
    }

    public List<OpcaoSelect> geraAjaxListaOpcoesDescritores(List<Descritor> todos) {
        return todos.stream().map(
                descritor -> new OpcaoSelect(descritor.getNivelEnsino().getDenominacaoAbreviada()
                        + " - "+ descritor.getCodigo() +" - "+ descritor.getDescricao(), descritor.getId()))
                .collect(Collectors.toList());
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

}
