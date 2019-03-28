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
        <script src="${ctx}/resources/js/usuario/lista.js"></script>
    </jsp:attribute>
    <jsp:body>
        <input id="url-atualizacao" type="hidden" value="${linkTo[UsuarioController].alterarPerfil}"/>
        <tags:card-obama titulo="Gerenciamento de usuários">
            <table class="table">
                <thead>
                <tr>
                    <th>Nome</th>
                    <th>Email</th>
                    <th>Perfil</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${usuarios}" var="usuario">
                    <tr>
                        <td>${usuario.nome}</td>
                        <td>${usuario.email}</td>
                        <td>
                            <form id="form-${usuario.id}" action="${linkTo[UsuarioController].alterarPerfil}" method="post">
                            <div class="radio-inline">
                            <label>
                                <c:choose>
                                    <c:when test="${usuario.perfil == 'ADMIN'}">
                                        <input usuario-id="${usuario.id}" value="ADMIN" class="usuario${usuario.id}" checked name="perfil" type="radio" />
                                    </c:when>
                                    <c:otherwise>
                                        <input usuario-id="${usuario.id}" value="ADMIN" class="usuario${usuario.id}" name="perfil" type="radio" />
                                    </c:otherwise>
                                </c:choose>
                                <span>Administrador</span>
                            </label>
                            </div>
                            <div class="radio-inline">
                                <label>
                                    <c:choose>
                                        <c:when test="${usuario.perfil == 'REVISOR'}">
                                            <input usuario-id="${usuario.id}" value="REVISOR" class="usuario-perfil" checked name="perfil" type="radio" />
                                        </c:when>
                                        <c:otherwise>
                                            <input usuario-id="${usuario.id}" value="REVISOR" class="usuario-perfil" name="perfil" type="radio" />
                                        </c:otherwise>
                                    </c:choose>
                                    <span>Revisor</span>
                                </label>
                            </div>
                                <div class="radio-inline">
                                    <label>
                                        <c:choose>
                                            <c:when test="${usuario.perfil == 'PADRAO'}">
                                                <input usuario-id="${usuario.id}" value="PADRAO" class="usuario${usuario.id}" checked name="perfil" type="radio" />
                                            </c:when>
                                            <c:otherwise>
                                                <input usuario-id="${usuario.id}" value="PADRAO" class="usuario${usuario.id}" name="perfil" type="radio" />
                                            </c:otherwise>
                                        </c:choose>
                                        <span>Padrão</span>
                                    </label>
                                </div>
                                <input hidden="hidden" value="${usuario.id}" name="id" />
                            </form>
                        </td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </tags:card-obama>
    </jsp:body>
</tags:layout>

