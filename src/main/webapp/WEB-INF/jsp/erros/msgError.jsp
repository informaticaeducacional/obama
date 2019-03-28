<%--
  Created by IntelliJ IDEA.
  User: samue
  Date: 08/09/2017
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" uri="tagSisInt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<c:set var="sucesso" value="success"/>
<c:set var="error" value="error"/>
<c:set var="advertencia" value="advertencia"/>

<c:if test="${not empty mensagem}">
    <c:if test="${sucesso == mensagem.category}">
    <div class="alert alert-success">

        <strong><fmt:message key="${mensagem.message}"/></strong>
    </div>
    </c:if>
    <c:if test="${error == mensagem.category}">
    <div class="alert alert-danger">
        <strong>Danger!</strong> Indicates a dangerous or potentially negative action.
    </div>
    </c:if>
</c:if>