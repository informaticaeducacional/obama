<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" uri="tagSisInt"%>
<%@ taglib prefix="td" uri="http://java.sun.com/jsp/jstl/fmt"%>
<input hidden="hidden" id="urlSalvarComentario" value="${linkTo[PlanoDeAulaController].salvarComentario}"/>
<form id="formComentario">
    <input hidden="hidden" name="idPlano" value="${planoDeAula.id}"/>
    <div>
        <div>
            <label for="comentarioID">Comentário: </label>
            <textarea id="comentarioID"
                      value="${comentario.texto}" name="comentario.texto" cols="30" rows="10"
                      placeholder="Escreva seu comentário" class="textAreaComentario"
                      style="background-color: white; max-height: 9rem;"></textarea>

        </div>
    </div>
    <button id="btnSalvarComentario" class="btn blue" type="button">
        Enviar
    </button>
</form>
<c:if test="${not empty planoDeAula.comentarios}">
    <h5>Comentários</h5>
</c:if>
<c:forEach items="${planoDeAula.comentarios}" var="cm"
           varStatus="coment">
    <ul class="collection">
        <li class="collection-item avatar"><img src="${ctx}/resources/imagens/icones/ic_forum.png"
                                                alt="" class="circle"/><b><span
                class="title">${cm.usuario.nome}</span></b>
            <p>
                    ${cm.texto}<br/>
            <div class="right" style="font-size:12px;">
                    ${cm.dataComentario}
            </div>
            </p>
            <c:if test="${cm.usuario.id == usuarioLogado.usuario.id}">
            <form>
                <a class="secondary-content" href="#" title="Remover">
                    <img src="${ctx}/resources/imagens/icones/botoes/waste-bin.png"/>
                </a>
            </form>
            </c:if>
        </li>
    </ul>
</c:forEach>