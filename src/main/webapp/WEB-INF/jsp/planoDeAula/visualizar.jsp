<%--
  Created by IntelliJ IDEA.
  User: samueldb
  Date: 12/03/18
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" uri="tagSisInt" %>
<%@ taglib prefix="td" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<tags:layout>
    <jsp:attribute name="cabecalho">

    </jsp:attribute>
    <jsp:attribute name="rodape">
        <script src="${ctx}/resources/js/planoDeAula/comentarios.js"></script>
        <script src="${ctx}/resources/js/planoDeAula/revisao.js"></script>
        <script src="http://html2canvas.hertzen.com/build/html2canvas.js"></script>
    </jsp:attribute>
    <jsp:body>
        <section class="">
            <input id="planoDeAula-id" hidden value="${planoDeAula.id}"/>
            <input id="url-revisao" hidden value="${linkTo[PlanoDeAulaController].enviarParaReajuste}"/>
            <div class="row">
                <div id="visualizacao-pa" class="row">
                    <tags:card-obama titulo="${planoDeAula.titulo}">
                        <embed  src="${linkTo[RelatorioController].imprimirPlanoDeAula}${planoDeAula.id}" width="100%" height="600px" type='application/pdf'>
                        <c:if test="${planoDeAula.status == 1}">
                            <c:if test="${usuarioLogado.isRevisor()}">
                                <div class="row center">
                                    <button id="btn-revisao" type="button" data-target="modal-revisao" class="btn grey darken-2 modal-trigger">Avaliar plano de aula</button>
                                </div>
                            </c:if>
                        </c:if>
                    </tags:card-obama>
                </div>
            </div>
        </section>

        <!-- Modal Structure -->
        <div id="modal-revisao" class="modal">
            <div class="modal-content">
                <h4 class="center">Avaliação de plano de aula</h4>
                <div class="row">
                    <div class="input-field col s12">
                        <textarea id="text-feedback" class="materialize-textarea"></textarea>
                        <label for="text-feedback">Descreva suas considerações sobre o plano de aula.</label>
                    </div>
                </div>
            </div>
            <div class="modal-footer center">
                <button id="btn-reajuste" type="button" class="btn-flat orange-text">Enviar para reajuste</button>
                <button id="btn-aprovacao" type="button" class="btn-flat green-text">Validar plano de aula</button>
            </div>
        </div>
    </jsp:body>
</tags:layout>

