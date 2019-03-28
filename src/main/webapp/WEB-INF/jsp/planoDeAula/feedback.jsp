<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" uri="tagSisInt"%>
<%@ taglib prefix="td" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="row">
    <div class="col s12 m12">
        <div class="card">
            <div class="card-content">
                            <span class="card-title">Discussão e avaliação do plano de aula
                              <a class="tooltipped" data-position="top" style="float: right;" data-delay="50"
                                 data-tooltip="O quadro de discussão e avaliação de planos de aula
                                 só é visivel para os revisores e os autores do plano de aula.">
                                  <img width="24" height="24"
                                       src="${ctx}/resources/imagens/icones/question.png"/>
                              </a>
                            </span>
            </div>
            <div class="card-action">
                    <c:forEach items="${planoDeAula.comentarios}" var="cm">
                            <div class="painel-comentarios-feedback">
                                <b style="">${cm.usuario.nome}:</b><span
                                    class="data-comentarioFeedback format-date right">${cm.dataComentario}</span><br/>
                                <span>${cm.texto}</span>
                            </div>
                    </c:forEach>
                <form id="formFeedback">
                    <input hidden="hidden" name="idPlano" value="${planoDeAula.id}"/>
                    <div class="input-field">
                        <input id="feedback-input" name="comentario.texto" value="${comentario.texto}"
                                     type="text"
                                     placeholder="Responder" class="validate"/>
                    </div>
                    <div class="row right-align">
                        <a id="comentar-planoDeAula" style="color: #039be5 !important;" href="">
                            Enviar
                        </a>
                    </div>
                    <c:if test="${usuarioLogado.isRevisor()}">
                        <div class="row right-align">
                            <a id="reajuste-planoDeAula" style="color: #fade43 !important;" href="">
                                Enviar para reajuste
                            </a>
                            <a id="valida-planoDeAula" style="color: #00e527 !important;" href="">
                                Validar
                            </a>
                        </div>
                    </c:if>
                </form>
            </div>
        </div>
    </div>
</div>
<div id="urls">
    <input hidden="hidden" id="urlReajuste" value="${linkTo[PlanoDeAulaController].enviarParaReajuste}"/>
    <input hidden="hidden" id="urlValidar" value="${linkTo[PlanoDeAulaController].validarPlanoDeAula}"/>
</div>