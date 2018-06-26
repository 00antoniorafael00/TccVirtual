<%@page import="br.edu.ifrs.modelo.Professor"%>
<%@page import="br.edu.ifrs.modelo.Coordenador"%>
<%@page import="br.edu.ifrs.modelo.Administrador"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="cabecalho.jsp" %>


<%
    Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
%>

 
        <%
            if (usuario instanceof Administrador || usuario instanceof Coordenador){
        %>
            <p><a href="#">Cadastrar Banca</a></p>
        <%
        }
        %>
        
        <%
            if (usuario instanceof Administrador || usuario instanceof Professor){
        %>
        <p><a href="consultarBancas.jsp">Consultar Banca</a></p>        
        <%
        }
        %>
        
        <p><a href="index.jsp">Voltar</a></p>
        



<%@include file="rodape.html" %>
