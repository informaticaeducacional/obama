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
                console.log(msg);
                if(msg != null && msg != "" && msg != undefined) {
                    exibirMensagem(msg);
                }
            })
        </script>
    </jsp:attribute>
    <jsp:body>
        <section>
            <tags:card-obama titulo="Submissão de OA">
                <form action="${linkTo[ObjetosAprendizagemController].sugerir}" method="post">
                    <div class="row">
                        <input name="submissao.usuario.id" type="hidden" value="${usuarioLogado.usuario.id}"/>
                        <tags:input name="submissao.nome" value=""
                                    classes="col s12 m4 l4" titulo="Qual é o nome do OA?"/>
                        <tags:input name="submissao.link" value=""
                                    classes="col s12 m4 l4" titulo="Onde posso acessar?"/>
                        <tags:input name="submissao.descritores" value=""
                                    classes="col s12 m4 l4" titulo="Quais habilidades (BNCC/PCN) podem ser desenvolvidas?"/>
                        <tags:input name="submissao.descricao" value=""
                                    classes="col s12 m12 l12" titulo="Descreva o OA em poucas palavras"/>
                        <div class="row"></div>
                        <div class="center">
                            <button id="btn-submissao" type="submit" name="buscar" class="btn grey darken-3">Submeter OA</button>
                        </div>
                    </div>
                </form>
            </tags:card-obama>
        </section>
    </jsp:body>
</tags:layout>

