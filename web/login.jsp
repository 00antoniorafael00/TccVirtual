<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="cabecalho.jsp" %>


    <h1>Login</h1>
    <br><br>
   
    <form action="UsuarioControle">
        <input type="hidden" name="op" value="AUTENTICAR">
        <label for="matricula">Matricula: </label><br>
        <input type="text" name="matricula" id="matricula" value=""><br><br>
        <label for="senha">Senha: </label><br>
        <input type="password" name="senha" id="senha" value=""><br><br>
        <input class="button" type="submit" value="Entrar">
    </form>

<%@include file="rodape.html" %>
