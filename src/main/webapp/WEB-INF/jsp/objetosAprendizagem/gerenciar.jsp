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
    	<script src="${ctx}/resources/js/oa/lista.js"></script>
    </jsp:attribute>
    <jsp:body>       
        <div class="row">
            <div class="row">
                <tags:card-obama titulo="${titulo}">

                    <table class="table tabela-oa highlight">
                        <thead>
                        <tr>
                            <th>Nome</th>                            
                            <th>Ações</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${oas}" var="oa">
                            <tr>
                                <td>
                                	<a href="${oa.link}">${oa.nome}</a>
                                </td>                                
                                <td>
                                   <div class="switch">
								    <label>
								      Inativo
								      <c:if test="${oa.ativo}">
								      	<input name="ativar" class="check-oa" type="checkbox" value="${oa.id}" checked/>
								      </c:if>
								      <c:if test="${!oa.ativo}">
								      	<input name="ativar" class="check-oa" type="checkbox" value="${oa.id}"/>
								      </c:if>								      
								      <span class="lever"></span>
								      Ativo
								    </label>
								  </div>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </tags:card-obama>
            </div>
        </div>

    </jsp:body>
</tags:layout>

