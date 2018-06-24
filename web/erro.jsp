<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="cabecalho.jsp" %>

    <h1 style="color: red">Erro.</h1>
    <br>
    <p><%= request.getAttribute("msg_erro")%>
    </p>
    <br><br>

<%@include file="rodape.html" %>
