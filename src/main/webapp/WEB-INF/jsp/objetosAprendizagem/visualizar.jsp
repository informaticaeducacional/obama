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
            	<h3>${oa.nome}</h3>
                <div class="row">                	
                    <tags:card-oa oa="${oa}"/>
                       <tags:modal id="${'modal'.concat(oa.id)}" titulo="${oa.nome}">
                       <tags:infoOA oa="${oa}"/>
                    </tags:modal>	                    
                </div>
            </section>
    </jsp:body>
</tags:layout>

