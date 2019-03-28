<%--
  Created by IntelliJ IDEA.
  User: samueldb
  Date: 12/03/18
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" uri="tagSisInt"%>
<%@ taglib prefix="td" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<tags:layout>
	<jsp:attribute name="cabecalho">
        <%--<meta name="google-signin-client_id" content="616976726938-dmss0mhj9ujfm6rfds68afk5qavu2m24.apps.googleusercontent.com" />--%>
        <script src="${ctx}/resources/plugins/google/plataform.js"
			async="async" defer="defer"></script>
        <script
			src="https://apis.google.com/js/platform.js?onload=onLoadCallback"
			async defer></script>
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
            
			<form id="form-login"  action="${linkTo[LoginController].logar}" method="post" 
				class="col s10 m6 l3 card-panel transparent-form offset-l4 offset-m3 offset-s1">			
				<div class="center">
					<div class="col s12">
						<img style="width: 60%; margin-top:50px;" src="${ctx}/resources/imagens/logo-obama-2.png"/>	
					</div>
					<div class="row">
					</div>
					<div class="row" style="margin-top:50px;">
						<a id="btn-facebook" class="btn col l4 s10 offset-l1 offset-s1 blue-fb">Facebook</a>
						<a id="btn-google" class="btn col l4 s10 offset-l2 offset-s1 red">Gmail</a>
					</div>
					<div class="divider col s10 offset-s1 grey darken-3">
					</div>
					<div class="input-field col s10 offset-s1" style="margin-top:30px;">
					  <input id="email" type="email" name="usuario.email" class="validate">
					  <label for="email">E-mail</label>
					</div>
					<div class="input-field col s10 offset-s1">
					  <input id="senha" class="validate" type="password" name="usuario.senha">
					  <label for="senha">Senha</label>
					</div>
					<div class="row" style="margin-top:30px;">
						<button id="btn-entrar" class="btn col s6 offset-s3 grey darken-3">ENTRAR</button>
					</div>
					<div class="row" style="margin-top:10px;">
						<a class="col s12 grey-text" href="${linkTo[UsuarioController].esqueciMinhaSenha}">Esqueceu a senha?</a>				
					</div>
					<div class="row" style="margin-top:30px; margin-bottom:50px;">
						<a class="col s12 grey-text" href="${linkTo[UsuarioController].form}">Cadastre-se</a>				
					</div>
				</div>
			</form>
		</div>
    </jsp:body>
</tags:layout>

