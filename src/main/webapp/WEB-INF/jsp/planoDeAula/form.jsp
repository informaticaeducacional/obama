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
        <script src="https://www.gstatic.com/firebasejs/3.3.0/firebase.js"></script>

    <!-- CodeMirror -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.17.0/codemirror.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.17.0/codemirror.css"/>

    <!-- Firepad -->
        <link rel="stylesheet" href="https://cdn.firebase.com/libs/firepad/1.4.0/firepad.css"/>
        <link rel="stylesheet" href="${ctx}/resources/css/firepad-custom.css"/>
        <script src="https://cdn.firebase.com/libs/firepad/1.4.0/firepad.min.js"></script>
        <script src="${ctx}/resources/js/planoDeAula/firepad-userlist.js"></script>
        <link rel="stylesheet" href="${ctx}/resources/css/firepad-userlist.css" />

    </jsp:attribute>
    <jsp:attribute name="rodape">
        <script>
            $(document).ready(function(){
                $('.tap-target').tapTarget('open');
            });

            $(document).ready(function () {
                $('#modalCompartilhar').modal({
                    dismissible: false
                })

                $(".powered-by-firepad").remove();
            })
        </script>
        <script src="${ctx}/resources/js/planoDeAula/plano-de-aula-firebase.js"></script>
        <script src="${ctx}/resources/js/planoDeAula/salvar-rascunho.js"></script>
        <script src="${ctx}/resources/js/planoDeAula/escolha-oa.js"></script>
    </jsp:attribute>
    <jsp:body>
        <section>
            <div class="row"></div>
            <tags:card-obama titulo="Dados do plano de aula">
                <form id="form-planoAula" method="post" action="${linkTo[PlanoDeAulaController].salvar}">
                    <div class="row">
                        <div>
                            <div class="col s6 l6">
                                <button id="btn-salvarRascunho" type="button"
                                        class="btn grey darken-1 right"
                                        title="Salvar rascunho">
                                    Salvar rascunho
                                    <i class="material-icons">save</i>
                                </button>
                            </div>
                            <div class="col s6 l6">
                                <a class="btn grey darken-1 modal-trigger"
                                   href="#modalCompartilhar">
                                    Compartilhar
                                    <i class="material-icons">share</i>
                                </a>
                            </div>
                            <div id="modalCompartilhar" class="modal">
                                <div class="modal-content">
                                    <h4>Compartilhar plano de aula</h4>
                                    <p>Basta informar o e-mail dos eu amigos (cadastrados no OBAMA). Você pode adicionar
                                        vários e-mails separados por ponto e vírgula.</p>
                                    <div id="campoEmail" class="col s10 offset-s1" style="display: block;">
                                        <div class="row">
                                            <div class="input-field col s12">
                                                <textarea class="validate materialize-textarea" id="emailCoautores"
                                                          name="emails" type="text" value="${emails}"><c:forEach
                                                        items="${planoDeAula.coautores}"
                                                        var="coautor">${coautor.email};</c:forEach></textarea>
                                                <label for="emailCoautores" class="hide-on-med-and-down obrigatorio">Informe
                                                    o e-mail do(s) seu(s) amigo(s).</label>
                                                <label for="emailCoautores" class="hide-on-large-only obrigatorio">E-mail
                                                    coautores</label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button id="btnCompartilhar" type="button"
                                            class="modal-action modal-close btn-flat blue right"
                                            title="Compartilhar">
                                        OK
                                    </button>
                                    <button type="button" class="modal-action modal-close btn-flat left">Fechar</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <ul id="tabs-swipe-demo" class="tabs tabs-fixed-width">
                            <li id="passo1" class="tab col s3"><a id="irPasso1" class="active" href="#container-passo1">Passo 1</a>
                            </li>
                            <li id="passo2" class="tab col s3"><a id="irPasso2" href="#container-passo2">Passo 2</a></li>
                            <li id="passo3" class="tab col s3"><a id="irPasso3" href="#container-passo3">Passo 3</a></li>
                        </ul>

                        <div id="container-passo1" class="col s12 conteudo-tab"
                             style="border-bottom-color: #1976d2 !important;">
                            <jsp:include page="passo2.jsp"/>
                        </div>

                        <div id="container-passo2" class="col s12 conteudo-tab"
                             style="border-bottom-color: #1976d2 !important;">
                            <div>
                                <jsp:include page="passo3.jsp"/>
                            </div>
                        </div>
                        <div id="container-passo3" class="col s12 conteudo-tab"
                             style="border-bottom-color: #1976d2 !important;">
                            <div>
                                <jsp:include page="passo1.jsp"/>
                            </div>
                        </div>
                    </div>

                </form>
            </tags:card-obama>

        </section>
    </jsp:body>
</tags:layout>