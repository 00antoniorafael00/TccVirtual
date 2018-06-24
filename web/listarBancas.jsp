<%@page import="br.edu.ifrs.modelo.Professor"%>
<%@page import="br.edu.ifrs.modelo.Banca"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="cabecalho.jsp" %>
    <%
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
    %>
 
        <br>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Situação</th>
                <th>Aprovar Participação</th>               
            </tr>
            <%
                Banca[] bancas = (Banca[])request.getAttribute("bancas");
                for (Banca banca : bancas) {
            %>
            <tr>
                <td><%= banca.getId() %>
                </td>
                <td><%= banca.getSituacao() %>
                </td>
                <td>                
                <%  if (banca.getSituacao() == 'A') {
                        for (Professor professor : banca.getProfessoresBanca()) {
                            if (professor.getMatricula() == usuario.getMatricula()){ 
                %>                                                         
                            <a href="#">Aprovar Participação</a>
                            
                <%
                            break;
                            }
                        }
                    }
                %>
                </td>
            </tr>
            <%
                }
            %>
           
        </table><br>




<%@include file="rodape.html" %>