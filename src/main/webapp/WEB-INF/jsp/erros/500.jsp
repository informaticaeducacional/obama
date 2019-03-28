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
        <script src="${ctx}/resources/js/usuario/form-cadastro.js"></script>
    </jsp:attribute>
    <jsp:body>
        <div class="section">
            <div class="row">
                <div class="col s12 m8 offset-m2">
                    <div class="card">
                        <div style="background-color: #F0F4E3;" class="card-content center-align white-text">
                            <img class="responsive-img" src="${ctx}/resources/imagens/internal-error.png" />
                        </div>
                        <div class="card-action center-align">
                            <a href="#" onclick="history.go(-1); return false;" class="waves-effect blue btn" style="margin: 20px">Voltar</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</tags:layout>

