<%@page import="br.edu.ifrs.modelo.Administrador"%>
<%@page import="br.edu.ifrs.modelo.Professor"%>
<%@page import="br.edu.ifrs.modelo.Banca"%>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.text.DateFormat" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="cabecalho.jsp" %>
    <%
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
   
        if (usuario instanceof Administrador || usuario instanceof Professor){
    %>
        <br>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Título do Trabalho</th>
                <th>Autor</th>
                <th>Modalidade</th>
                <th>Data</th>
                <th>Hora</th>
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
                <td><%= banca.getTcc().getTitulo() %>
                </td>
                <td><%= banca.getTcc().getAutor().getNome() %>
                </td>
                <td><%= banca.getModalidadeBanca() %>
                </td>      
                <td><%= banca.getDataBanca().getTime() %>
                </td>
                <td><%= banca.getHorarioBanca().getTime() %>
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
    <%
    }
    %>



<%@include file="rodape.html" %>