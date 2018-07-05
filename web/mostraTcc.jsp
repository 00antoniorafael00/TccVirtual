<%-- 
    Document   : mostraTcc
    Created on : 26/jun/2018, 9:24:23
    Author     : ubuntu 1669375
--%>

<%@page import="br.edu.ifrs.modelo.Tcc"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="cabecalho.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Controler" method="get">
            <select name="tituloEscolhido">
                <%            ArrayList<Tcc> tccs = (ArrayList<Tcc>) request.getAttribute("tccs");
                    for (Tcc tcc : tccs) {
                %>
                <option value="<%=tcc.getId()%>"><%=tcc.getTitulo()%></option>
                <%  }

                %>
            </select>
            <input type="submit" name="op" value="EscolhaTcc">
        </form>
    </body>
</html>

<%@include file="rodape.html" %>