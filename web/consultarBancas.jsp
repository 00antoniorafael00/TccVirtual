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
        <h1>Consultar Banca</h1> <br/>
        <form action="BancaControle">        
            <input type="hidden" name="op" value="CONSULTAR">
            <label for="titulo">Titulo: </label><br>
            <input type="text" name="titulotcc" id="titulotcc" value=""><br><br>
            <label for="curso">Curso: </label><br>
            <input type="text" name="curso" id="curso" value=""><br><br>
            
            
            <input class="button" type="submit" value="Consultar">
            

        </form>
    <%
    }
    %>
 
            


<%@include file="rodape.html" %>