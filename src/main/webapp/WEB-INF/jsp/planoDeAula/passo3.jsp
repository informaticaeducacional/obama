<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" uri="tagSisInt"%>
<%@ taglib prefix="td" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%--
  Created by IntelliJ IDEA.
  User: samueldb
  Date: 13/03/18
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>

<div class="row">
    <div class="row"></div>
    <div id="campoDescricao" class="col s10 offset-s1" style="">
        <div class="row">
            <!-- Descrição plano de aula -->
            <div id="userlist"></div>
            <div id="firepad-container">
            </div>
        </div>
    </div>
    <div class="col s10 offset-s1">
        <div id="inputCoautores">
            <c:forEach items="${planoDeAula.coautores}" var="coautor" varStatus="count">
                <input name="planoDeAula.coautores[${count.index}].id" value="${coautor.id}"  hidden="hidden"/>
            </c:forEach>
        </div>
            <input id="inputMetodologia" name="planoDeAula.metodologia" type="hidden" value=""/>
            <input name="planoDeAula.autor.id" type="hidden" value="${planoDeAula.autor.id}"/>
            <input name="planoDeAula.status" type="hidden" value="${planoDeAula.status}"/>
            <input id="inputToken" name="planoDeAula.token" type="hidden" value="${planoDeAula.token}"/>
            <input id="id" name="planoDeAula.id" type="hidden" value="${planoDeAula.id}"/>
        <button type="button" class="btn link-voltar grey darken-1 link-navegacao left" role="button"	onclick="irPara('container-passo1');">Voltar</button>
        <button type="button" class="btn link-avancar grey darken-1 link-navegacao right" role="button" onclick="irPara('container-passo3');">Avançar</button>
    </div>
    <input id="salvar-rascunho" value="${linkTo[PlanoDeAulaController].salvarRascunho}" type="hidden">
    <input id="url-compartilharPlano" value="${linkTo[PlanoDeAulaController].compartilharPlanoDeAula}" type="hidden">
</div>
