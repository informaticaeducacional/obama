<%--
  Created by IntelliJ IDEA.
  User: samue
  Date: 10/02/2018
  Time: 02:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" uri="tagSisInt" %>
<%@ taglib prefix="td" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<tags:layout>
    <jsp:attribute name="cabecalho"></jsp:attribute>
    <jsp:attribute name="rodape">
    </jsp:attribute>
    <jsp:body>
        <div class="row" style="margin-top: 6em;">
        	<div class="hide-on-med-and-down">
	            <div class="col s12 center" style="margin-top: 10px;">
	                <img style="width: 30%;" src="${ctx}/resources/imagens/logo-principal.png"/>
	            </div>
            </div>
            <div class="hide-on-large-only">
	            <div class="col s12 center" style="margin-top: 80px;">
	                <img style="width: 60%;" src="${ctx}/resources/imagens/logo-principal.png"/>
	            </div>
			</div>
        </div>
        <div class="row">
            <form action="${linkTo[ObjetosAprendizagemController].busca}" method="post">
                <div class="input-field col s12 l6 offset-l3 ">
                    <i class="material-icons prefix">search</i>
                    <input id="icon_prefix" type="text" class="validate" name="dadosDaBusca.texto">
                    <label for="icon_prefix">Digite aqui para pesquisar</label>
                </div>
                <div class="col s12">
                    <button class="col s6 m4 l2 offset-s3 offset-m4 offset-l5 waves-effect waves-light btn blue"
                       type="submit">Pesquisar</button>
                </div>
                <div class="row">
                </div>
                <div class="col s12 center">
                    <a class="blue-text" href="${linkTo[ObjetosAprendizagemController].busca}">Busca avançada</a>
                </div>
            </form>
        </div>
    </jsp:body>
</tags:layout>