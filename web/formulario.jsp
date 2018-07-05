<%-- 
    Document   : formulario
    Created on : 26/jun/2018, 10:22:03
    Author     : ubunto
--%>

<%@page import="br.edu.ifrs.modelo.Professor"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">


<%@include file="cabecalho.jsp" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
    <h1>Cadastra Banca</h1>

    <hr>

    <% ArrayList<String> nomes = (ArrayList<String>) request.getAttribute("nomes");%>
    <form action="salvar" id="form" method="post">
        <table>
            <tr>
            <td><label for="nome">Título do Trabalho</label></td>
            <td><input type="text" name="titulo" id="tituloTrabalho" size="20" value="<%=nomes.get(2)%>"></td>
            </tr>
            <tr>
            <td><label for="nome">Autor:</label></td>
            <td><input type="text" name="autor" id="autor" size="20" value="<%=nomes.get(1)%>"></td>
            </tr>
            <tr>
            <td><label for="descricao">Orientador</label></td>
            <td><input type="text" name="orientador" id="orientador" size="30" value="<%=nomes.get(0)%>"></td>
            </tr>          
            <tr>
            <td><label for="sala">Data da Banca</label></td>
            <td><input type="date" name="dataBanca" id="dataBanca" ></td>
            </tr> 
            <tr>
            <td><label for="sala">Horário da Banca</label></td>
            <td><input type="time" name="horario" id="horario" size="10" step="2"></td>
            </tr>  
            <tr>
            <td> <label for="nome">Modalidade:</label></td>
            <td><input type="text" name="modalidade" id="modalidade" size="20"</td>
            </tr> 
            <tr>
            <td><label for="nome">Número da sala</label></td>
            <td><input type="number" name="numeroSalas" id="numeroSala" min="0" max="500" size="20"></td>
            </tr> 
            <tr>
            <td><label for="avaliadores">Avaliadores</label></td>
            <td>
                <select id="avaliadores" name="avaliadores" multiple>
                    <%  ArrayList<Professor> professores = (ArrayList<Professor>) request.getAttribute("professores");
                        String guardaDados = "";
                        for (Professor prof : professores) {
                            guardaDados += prof + ";";
                    %>
                    <option value="<%=prof.getMatricula() %>"><%=prof.getNome() %></option>
                    <%  }

                    %>
                </select>
            </td>
            </tr> 
            <tr>
                <% 
                    int id = (Integer) request.getAttribute("id");
                %>
            <input type="hidden" value="<%=id%>" name="id">
            <td rowspan="2">
               <input type="submit"  id="bt" value="Enviar" href="index.jsp" id="bt">
                <input type="reset" value="Limpar">
            </td>
            </tr>
        </table>
    </form>
</body>
<script src="algoritmos.js" type="text/javascript"></script>

<%@include file="rodape.html" %>