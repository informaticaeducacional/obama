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
        <script src="${ctx}/resources/js/oa/cadastro.js"></script>
        <script>

        </script>
    </jsp:attribute>
    <jsp:body>
        <section>

            <tags:card-obama titulo="Cadastro de objetos de aprendizagem">
                <form action="${linkTo[ObjetosAprendizagemController].salvar}" method="post"
                      enctype="multipart/form-data">
                    <tags:input name="objetoAprendizagem.nome" value="${objetoAprendizagem.nome}"
                                titulo="Nome do objeto de aprendizagem" />
                    <tags:input name="objetoAprendizagem.descricao"  value="${objetoAprendizagem.descricao}"
                                titulo="Descrição"/>
                    <tags:input name="objetoAprendizagem.link" value="${objetoAprendizagem.link}"
                                titulo="Link do objeto de aprendizagem" />
                    <tags:select id="select-teste" name="objetoAprendizagem.tipoVisualizacao.id"
                                 value="${objetoAprendizagem.tipoVisualizacao.id}"
                                 titulo="Tipo de visualização" options="${tipos}"/>
                    <tags:select name="objetoAprendizagem.autoresMantenedores[0].id" value=""
                                 titulo="Autor do objeto de aprendizagem" options="${mantenedores}"/>
                    <div class="switch">
                        <label>
                            Inativo
                            <input name="objetoAprendizagem.ativo" type="checkbox">
                            <span class="lever"></span>
                            Ativo
                        </label>
                    </div>
                    <br/>
                    <div class="file-field input-field">
                        <div class="btn grey darken-3">
                            <span>File</span>
                            <input name="foto" type="file" accept="image/*">
                        </div>
                        <div class="file-path-wrapper">
                            <input class="file-path validate " type="text">
                        </div>
                    </div>
                    <br/>
                    <div id="inputsDescritores"></div>
                    <ul id="collection-descritores" class="collection">
                    </ul>
                    <a href="#oaCadastro-modal" class="btn modal-trigger btn grey darken-3">Adicionar descritores</a>
                    <div class="row"></div>
                    <div class="row center">
                        <button name="buscar"
                                class="btn blue btn-buscar btn grey darken-3">
                            <i class="material-icons left">save</i>salvar
                        </button>
                    </div>
                </form>
            </tags:card-obama>

            <tags:modal id="oaCadastro-modal" titulo="Cadastro de descritores">
                <tags:select name="nivelObjeto" value=""
                             titulo="Selecione um nivel de ensino" options="${niveis}"/>
                <tags:select name="temaObjeto" value=""
                             titulo="Selecione um tema curricular" options="${temas}"/>
                <tags:select id="descritor-select" name="objetoAprendizagem.descritores.id"
                             value="${objetoAprendizagem.descritores.id}"
                             titulo="Adicione um descritor ao objeto de aprendizagem" options="${descritores}"/>
                <button id="btn-add-descritor" class="btn">Adicionar</button>
            </tags:modal>
        </section>
    </jsp:body>
</tags:layout>

