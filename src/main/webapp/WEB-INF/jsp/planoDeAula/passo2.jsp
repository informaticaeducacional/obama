<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" uri="tagSisInt"%>
<%@ taglib prefix="td" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="row">
    <div class="row"></div>
    <div id="campoInstEnsino" class="col s10 offset-s1"
         style="display: block;">
        <div class="row">
            <div class="input-field col s12">
                <!-- 					<input name="instEnsino" type="text" class="validate" />  -->
                <input name="planoDeAula.escola" class="validate" id="instEnsino" type="text" value="${planoDeAula.escola}"/>
                <label for="instEnsino" class="hide-on-med-and-down obrigatorio">Qual o nome da instituição a que se destina esse plano de aula?</label>
                <label for="instEnsino" class="hide-on-large-only obrigatorio">Instituição de ensino</label>
            </div>
        </div>
    </div>
    <div id="campoTitulo" class="col s10 offset-s1" style="display: block;">
        <div class="row">
            <div class="input-field col s12">
                <!-- 					<input name="titulo" type="text" class="validate" /> -->
                <input class="validate" id="titulo" type="text" name="planoDeAula.titulo" value="${planoDeAula.titulo}"/>
                <label for="titulo" class="hide-on-med-and-down obrigatorio">Escreva uma frase curta que defina sua aula.</label>
                <label for="titulo" class="hide-on-large-only obrigatorio">Título</label>
            </div>
        </div>
    </div>
    <div id="campoAnoEnsino" class="col s10 offset-s1" style="display: block;">
        <div class="row">
            <div class="col s12" id="campoAno">
                <label for="anoEnsino" class="hide-on-med-and-down obrigatorio">A qual ano de ensino esta proposta de aula melhor se aplica?</label>
                <label for="anoEnsino" class="hide-on-large-only obrigatorio">Ano de ensino</label>
                <select id="anoEnsino" name="planoDeAula.anoEnsino.id">
                    <c:forEach items="${anosEnsino}" var="ano">
                        <c:choose>
                            <c:when test="${ano.id == planoDeAula.anoEnsino}">
                                <option value="${ano.id}" selected>${ano.denominacao}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${ano.id}">${ano.denominacaoCompleta}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
        </div>
    </div>
    <div id="campoDuracao" class="col s10 offset-s1"
         style="display: block;">
        <div class="row">
            <div class="input-field col s12">
                <input  class="validate" id="duracao" type="number" name="planoDeAula.duracaoEmMinutos" value="${planoDeAula.duracaoEmMinutos}"/>
                <label for="duracao" class="hide-on-med-and-down obrigatorio">Quanto tempo (em minutos) você acha necessário para a aplicação deste	plano de aula?</label>
                <label for="duracao" class="hide-on-large-only obrigatorio">Duração (minutos)</label>
            </div>
        </div>
    </div>
    <div class="col s10 offset-s1">
        <button type="button" class="btn link-avancar grey darken-1 link-navegacao right" role="button" onclick="irPara('container-passo2');">Avançar</button>
    </div>
</div>