

<%@page import="br.edu.ifrs.modelo.Professor"%>
<%@page import="br.edu.ifrs.modelo.Coordenador"%>
<%@page import="br.edu.ifrs.modelo.Administrador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="cabecalho.jsp" %>
    <%
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
    %>
    
    <%
        if (usuario instanceof Administrador || usuario instanceof Professor){
    %>
        <form action="Controler">        
            <label for="titulo">Pesquisar o Título do Trabalho:</label>
            <input type="hidden" name="op" value="CONSULTAR">
           <input class="button" type="submit" value="Consultar">
        </form>
    <%
    }
    %>
 
            


<%@include file="rodape.html" %>