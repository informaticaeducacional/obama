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
        <script src="${ctx}/resources/js/ConverterObjetoParaVRaptor.js"></script>
        <script src="${ctx}/resources/js/oa/formulario.js"></script>
    </jsp:attribute>
    <jsp:body>
            <section>
                <tags:card-obama titulo="Objetos de Aprendizagem">
                    <form id="formBusca" method="post">
                        <div class="row">
                            <tags:input name="dadosDaBusca.texto" value="${dadosDaBusca.texto}"
                                        classes="col s12 m12 l12" titulo="O que você procura?"/>
                            <tags:select name="dadosDaBusca.idNivelEnsino" value="${dadosDaBusca.idNivelEnsino}"
                                         titulo="Selecione o nível de ensino" options="${niveis}"
                                         classes="col s12 m12 l4"/>
                            <tags:select name="dadosDaBusca.idTemaConteudo" value="${dadosDaBusca.idTemaConteudo}"
                                         titulo="Selecione o tema curricular" options="${temas}"
                                         classes="col s12 m12 l4"/>
                            <tags:select name="dadosDaBusca.idTipoVisualizacao"
                                         value="${dadosDaBusca.idTipoVisualizacao}"
                                         titulo="Selecione o tipo" options="${tipos}" classes="col s12 m12 l4"/>
                            <tags:select id="descritor" name="dadosDaBusca.idDescritor"
                                         value="${dadosDaBusca.idDescritor}"
                                         titulo="Selecione o descritor" options="${descritores}"
                                         classes="col s12 m12 l12"/>
                            <div class="row"></div>
                            <div class="center">
                            	<button name="buscar" class="btn grey darken-3">Buscar</button>
                            </div>
                        </div>
                    </form>
                </tags:card-obama>
                <c:if test="${not empty totalOAEncontrado}">
                    <div class="row" align="center">
                        <h5>${totalOAEncontrado}</h5>
                    </div>
                </c:if>
                <div class="row" id="cards-row">
                    <c:forEach items="${objetos}" var="oa" varStatus="oaStatus">
                        <tags:card-oa oa="${oa}"/>
                        <tags:modal id="${'modal'.concat(oa.id)}" titulo="${oa.nome}">
                            <tags:infoOA oa="${oa}"/>
                        </tags:modal>
                    </c:forEach>
                    <div class="col offset-s6" style=" padding-top:20px;">
                        <c:if test="${not empty objetos}">
                            <a class="btn-floating btn-large tooltipped" data-position="top" data-delay="50"
                               data-tooltip="Carregar mais resultados" href="#" id="loadMore"
                               style="background-color: #03a9f4;"><i class="material-icons">add</i></a>
                        </c:if>
                    </div>
                </div>
            </section>
    </jsp:body>
</tags:layout>

