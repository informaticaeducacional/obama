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
        <%--<meta name="google-signin-client_id" content="616976726938-dmss0mhj9ujfm6rfds68afk5qavu2m24.apps.googleusercontent.com" />--%>
        <script src="${ctx}/resources/plugins/google/plataform.js" async="async" defer="defer"></script>
        <script src="https://apis.google.com/js/platform.js?onload=onLoadCallback" async defer></script>
        <script src="${ctx}/resources/js/usuario/google-auth.js"></script>
    </jsp:attribute>
    <jsp:attribute name="rodape">
        <script src="${ctx}/resources/js/usuario/form-cadastro.js"></script>
        <script src="${ctx}/resources/js/usuario/cadastro-rs.js"></script>
    </jsp:attribute>
    <jsp:body>
    	<div class="row">
    		 <form id="form-rs" action="${linkTo[LoginController].logar}" method="post">
             	<input id="nome-rs" type="hidden" name="usuario.nome" class="validate" />
            	<input id="email-rs" type="hidden" name="usuario.email" class="validate" />
             	<input id="tipo-rs" type="hidden" name="usuario.tipoCadastro.valor" class="validate" />
             	<input id="redeSocial" type="hidden" name="redeSocial" value="true" class="validate" />
            </form>
            <input id="google-url" hidden="hidden" value="${linkTo[LoginController].logar}" />
            <input id="urlCadastro" type="hidden" value="${linkTo[UsuarioController].salvar}"/>
			<form id="form-cadastro" class="col s10 m6 l3 card-panel transparent-form offset-l4 offset-m3 offset-s1">			
				<div class="center">
					<div class="col s12">
						<img style="width: 60%; margin-top:50px;" src="${ctx}/resources/imagens/logo-obama-2.png"/>	
					</div>
					<div class="row">
					</div>
					<div class="row" style="margin-top:50px;">
						<a id="btn-facebook" class="waves-effect waves-light btn col l4 s10 offset-l1 offset-s1 blue-fb">Facebook</a>					
						<a id="btn-google" class="waves-effect waves-light btn col l4 s10 offset-l2 offset-s1 red">Gmail</a>
					</div>
					<div class="divider col s10 offset-s1 grey darken-3">
					</div>
					<div class="input-field input-field-cadastro-usuario col s10 offset-s1" style="margin-top:30px;">
					  <input id="nome" name="usuario.nome" type="text" class="validate" required="required">
					  <label for="nome">Nome completo</label>
					</div>
					<div class="input-field input-field-cadastro-usuario col s10 offset-s1">
					  <input id="email"name="usuario.email" class="validate" type="email" value="${usuario.email}" required="required">
					  <label for="email">E-mail</label>
					</div>
					<div class="input-field input-field-cadastro-usuario col s10 offset-s1">
					  <input id="senha" name="usuario.senha" class="validate" type="password" value="${usuario.senha}" required="required">
					  <label for="senha">Senha</label>
					</div>
					<div class="input-field input-field-cadastro-usuario col s10 offset-s1">
					  <input id="confirmaSenha" type="password" name="usuario.confirmaSenha" class="validate" value="${usuario.confirmaSenha}" required="required">
					  <label for="confirmaSenha">Confirmar senha</label>
					</div>
					<div class="col s10 offset-s1">
						 <span>Ao clicar em CADASTRAR, você afirma que leu e concorda com nossos <a class="modal-trigger" href="#modalTermo">Termos e Política de Dados</a>.</span>
					</div>
					<div class="row">
						<button id="btn-cadastrar" class="waves-effect waves-light btn col s6 offset-s3 grey darken-3"  style="margin-top:15px !important;">CADASTRAR</button>					
					</div>
					<div class="row" style="margin-top:10px;margin-top:10px;">
						<a class="col s12 grey-text" href="${linkTo[LoginController].form}">Já está cadastrado? Clique aqui!</a>			
					</div>
				</div>
			</form>
		</div>
    

        <!-- Modal Structure -->
        <div id="modalTermo" class="modal">
            <div class="modal-content">
                <h4>Termo de consentimento e Política de Dados</h4>
                <label for="dados-cadastrais" class="label-title">Dados cadastrais</label>
                <p id="dados-cadastrais" style="text-align: justify;">
                    Realizo meu cadastro na plataforma Objetos de Aprendizagem para Matemática
                    (OBAMA), de minha livre e espontânea vontade,
                    e autorizo que minhas informações, mais específicamente e-mail,
                    nome e instituição de ensino, sempre que necessário,
                    sejam informados e publicados nos Planos de Aula e Objetos de Aprendizagem
                    que eu venha a produzir ou disponibilizar nesta plataforma.
                </p>
                <label for="producao-conteudo" class="label-title">Produção de conteúdo</label>
                <p id="producao-conteudo" style="text-align: justify;">
                    Autorizo, de minha livre e espontânea vontade, os administradores da plataforma Objetos de Aprendizagem para Matemática (OBAMA) a disponibilizarem qualquer Plano de Aula ou
                    Objeto de Aprendizagem que eu venha a produzir ou disponibilizar por meio do site obama.imd.ufrn.br,
                    com as seguintes condições: disponível sob Licença Creative Commons Atribuição-CompartilhaIgual 4.0
                    Internacional. Esta licença permite copiar e redistribuir o material em qualquer suporte ou formato
                    e remixar, transformar, e criar a partir do material para qualquer fim, mesmo que comercial, desde que
                    seja citado o autor e licenciante e os trabalhos derivados tenham a mesma licença ou uma outra
                    compatível. Ou seja, você terá a propriedade de quaisquer direitos de propriedade intelectual que
                    você detenha sobre aos Planos de Aula e Objetos de Aprendizagem. Em resumo, aquilo que pertence a você,
                    permanece com você, nós apenas iremos disponibilizá-los para que outras pessoas possam acessar esses materiais.
                </p>
            </div>
            <div class="modal-footer">
                <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">Li e concordo com os termos</a>
            </div>
        </div>

    </jsp:body>
</tags:layout>

