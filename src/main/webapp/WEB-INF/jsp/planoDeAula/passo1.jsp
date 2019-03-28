<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" uri="tagSisInt" %>
<%@ taglib prefix="td" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<div id="div-inputsOAs">
    <c:forEach items="${objetosPlanoDeAula}" var="obj" varStatus="count" begin="0">
        <input class="inputsOAs" type="hidden" name="planoDeAula.objetosAprendizagem[${count.index}].id" value="${obj.id}"/>
    </c:forEach>
</div>
<div class="col s10 offset-s1">
    <div class="row">
        <div class="row"></div>
        <div class="input-field col s6">
            <input id="textoBusca" type="text" value="" maxlength="50" class="validate"/>
            <label for="textoBusca" class="hide-on-med-and-down">Qual o nome do OA?</label>
        </div>
        <div class="row"></div>
        <div class="col s6 tabela-planoDeAula-form">
            <table class="table tabela-selecao">
                <thead>
                <tr>
                    <th>Selecione</th>
                    <th></th>
                </tr>
                </thead>
                <tbody id="selecao-oa">
                <c:forEach items="${objetos}" var="obj">
                    <tr id="row-${obj.id}">
                        <td class="nome-objeto">${obj.nome}</td>
                        <td>
                            <button id="btnAdicionar" oa-id="${obj.id}" oa-nome="${obj.nome}"
                                    class="btn btn-table-oa btn-adicionar" type="button"
                                    title="Adicionar">
                                <i class="material-icons">add</i>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col s6 tabela-planoDeAula-form">
            <table class="table">
                <thead>
                <tr>
                    <th>OA selecionado</th>
                    <th></th>
                </tr>
                </thead>
                <tbody id="selecionados">
                <c:forEach items="${objetosPlanoDeAula}" var="obj">
                    <tr id="row-${obj.id}">
                        <td class="nome-objeto">${obj.nome}</td>
                        <td>
                            <button id="btnRemover" oa-id="${obj.id}" oa-nome="${obj.nome}"
                                    class="btn btn-table-oa btn-remover-oa" type="button"
                                    title="Remover">
                                <i class="material-icons">delete</i>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="row"></div>
    <button type="button" class="btn link-voltar grey darken-1 link-navegacao left" role="button"	onclick="irPara('container-passo2');">Voltar</button>
    <button id="btnEnviar" type="submit" onclick="setarTextAreaMetodologia()" class="btn grey darken-1 link-avancar link-navegacao right">Enviar para revisão
    </button>
</div>