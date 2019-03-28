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
        <script src="${ctx}/resources/plugins/dataTables/datatables.min.js"></script>
        <script src="${ctx}/resources/plugins/dataTables/Scroller-1.4.4/js/dataTables.scroller.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.16/js/dataTables.material.min.js"></script>
        <script src="${ctx}/resources/js/planoDeAula/tabela-PlanoDeAula.js"></script>
    </jsp:attribute>
    <jsp:body>
        <c:if test="${!usuarioLogado.isLogado()}">
            <div id="lembrete_plano" class="row">
                <div class="col s2">
                    <div class="card-panel blue fixed-action-btn"
                         style="max-width: 12%; height: 170px;">
                        <div class="center">
							<span class="white-text"> <i class="material-icons small">error_outline</i>
							</span>

                        </div>
                        <div>
							<span class="white-text"> Lembre-se: Para criar seus planos
								de aula no OBAMA, faça login ou cadastre-se! </span>
                        </div>

                    </div>
                </div>
            </div>
        </c:if>
        <div class="row">
            <div class="row">
                <tags:card-obama titulo="${titulo}">
                	<c:if test="${meusPlanos}">
						<ul id="tabs-swipe-demo" class="tabs">
						    <li class="tab col s3"><a class="active" href="#planos">Criados por mim</a></li>
						    <li class="tab col s3"><a href="#planos-compartilhados">Compartilhados comigo</a></li>
						</ul>
					</c:if>
					<div id="planos" class="col s12">
						<table class="table tabela-planoDeAula highlight">
	                        <thead>
	                        <tr>
	                            <th>Título</th>
	                            <th>Data de submissão</th>
	                            <c:if test="${!meusPlanos}">
	                                <th>Autor</th>
	                            </c:if>
	                            <c:if test="${!validados}">
	                                <th>Status</th>
	                            </c:if>
	                            <th>Ações</th>
	                        </tr>
	                        </thead>
	                        <tbody>
	                        <c:forEach items="${planos}" var="plano">
	                            <tr>
	                                <td><a href="${linkTo[PlanoDeAulaController].visualizar}${plano.id}">
	                                        ${plano.titulo}</a></td>
	                                <td class="format-timestamp">${plano.dataCadastro}</td>
	                                <c:if test="${!meusPlanos}">
	                                    <td>${plano.autor.nome}</td>
	                                </c:if>
	                                <c:if test="${!validados}">
	                                    <td>
	                                        <i class="material-icons black-text"
	                                           title="${plano.statusPlanoDeAula.denominacao}">${plano.statusPlanoDeAula.icon_class}</i>
	                                    </td>
	                                </c:if>
	                                <td>
	
	                                    <!-- Botão de download plano de aula -->
	                                    <a id="btnBaixarPDF" class="icon-black"
	                                       href="${linkTo[RelatorioController].imprimirPlanoDeAula}${plano.id}"
	                                       target="_blank" title="Baixar PDF">
	                                        <i class="material-icons">file_download</i>
	                                    </a>
	                                    <!-- Botão de editar plano de aula -->
	                                    <c:if test="${(plano.status == 4) or (plano.status == 2) or usuarioLogado.isAdministrador()}">
	                                        <a id="btnEditar"
	                                           class="icon-laranja btnAnchor"
	                                           title="Editar plano de aula"
	                                           href="${linkTo[PlanoDeAulaController].editar}${plano.id}#${plano.token}">
	                                            <i class="material-icons">create</i>
	                                        </a>
	                                    </c:if>
	                                    <c:if test="${meusPlanos}">
	                                        <a id="btnRemover" class="icon-vermelho"
	                                           href="${linkTo[PlanoDeAulaController].remover}${plano.id}"
	                                           title="Excluir plano de aula">
	                                            <i class="material-icons icon-vermelho">delete_forever</i>
	                                        </a>
	                                    </c:if>
	                                </td>
	                            </tr>
	                        </c:forEach>
	                        </tbody>
	                    </table>
					</div>
		            <c:if test="${meusPlanos}">
						<div id="planos-compartilhados" class="col s12">
							<table class="table tabela-planoDeAula2 highlight">
		                        <thead>
		                        <tr>
		                            <th>Título</th>
		                            <th>Data de submissão</th>
		                            <c:if test="${!meusPlanos}">
		                                <th>Autor</th>
		                            </c:if>
		                            <c:if test="${!validados}">
		                                <th>Status</th>
		                            </c:if>
		                            <th>Ações</th>
		                        </tr>
		                        </thead>
		                        <tbody>
		                        <c:forEach items="${planosCompartilhados}" var="plano">
		                            <tr>
		                                <td><a href="${linkTo[PlanoDeAulaController].visualizar}${plano.id}">
		                                        ${plano.titulo}</a></td>
		                                <td class="format-timestamp">${plano.dataCadastro}</td>
		                                <c:if test="${!meusPlanos}">
		                                    <td>${plano.autor.nome}</td>
		                                </c:if>
		                                <c:if test="${!validados}">
		                                    <td>
		                                        <i class="material-icons black-text"
		                                           title="${plano.statusPlanoDeAula.denominacao}">${plano.statusPlanoDeAula.icon_class}</i>
		                                    </td>
		                                </c:if>
		                                <td>
		
		                                    <!-- Botão de download plano de aula -->
		                                    <a id="btnBaixarPDF" class="icon-black"
		                                       href="${linkTo[RelatorioController].imprimirPlanoDeAula}${plano.id}"
		                                       target="_blank" title="Baixar PDF">
		                                        <i class="material-icons">file_download</i>
		                                    </a>
		                                    <!-- Botão de editar plano de aula -->
		                                    <c:if test="${(plano.status == 4) or (plano.status == 2) or usuarioLogado.isAdministrador()}">
		                                        <a id="btnEditar"
		                                           class="icon-laranja btnAnchor"
		                                           title="Editar plano de aula"
		                                           href="${linkTo[PlanoDeAulaController].editar}${plano.id}#${plano.token}">
		                                            <i class="material-icons">create</i>
		                                        </a>
		                                    </c:if>
		                                    <c:if test="${meusPlanos}">
		                                        <a id="btnRemover" class="icon-vermelho"
		                                           href="${linkTo[PlanoDeAulaController].remover}${plano.id}"
		                                           title="Excluir plano de aula">
		                                            <i class="material-icons icon-vermelho">delete_forever</i>
		                                        </a>
		                                    </c:if>
		                                </td>
		                            </tr>
		                        </c:forEach>
		                        </tbody>
		                    </table>
						</div>
					</c:if>
                </tags:card-obama>
            </div>
        </div>

    </jsp:body>
</tags:layout>

