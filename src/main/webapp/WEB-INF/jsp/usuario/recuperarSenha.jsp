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
        <script>
            $(document).ready(function () {
                var msg = $('#msgsSite').val();
                if(msg != null && msg != "" && msg != undefined) {
                    exibirMensagem(msg);
                }
            });
        </script>
    </jsp:attribute>
    <jsp:body>
        <div class="container" style="padding: 200px 20px; width: 50%;">
            <div class="card-panel">
                <form id="solicitacao-senha" action="${linkTo[UsuarioController].trocarSenha}" method="post">
                    <div class="row">
                        <div class="col s12 left">Informe a senha que deseja utilizar para acessar o OBAMA.</div>
                        <input type="hidden" value="${usuario.id}" name="usuario.id"/>
                        <div class="input-field col s12">
                            <i class="material-icons prefix">lock</i>
                            <input id="nova-senha" name="senha" type="password" class="validate" />
                            <label for="nova-senha">Senha</label>
                        </div>
                        <div class="input-field col s12">
                            <i class="material-icons prefix">lock</i>
                            <input id="confirmar-senha" name="confirmaSenha" type="password" class="validate" />
                            <label for="confirmar-senha">ConfirmarSenha</label>
                        </div>

                        <div class="input-field col s12">
                            <button class="btn btn-flat btn-modal grey lighten-2 col s2 right">Enviar
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </jsp:body>
</tags:layout>

