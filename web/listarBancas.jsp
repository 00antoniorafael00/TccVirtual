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
                <th>Título do Trabalho</th>
                <th>Curso</th>
                <th>Autor</th>
                <th>Modalidade</th>
                <th>Data</th>
                <th>Hora</th>
                <th>Situação</th>                
                <th>Aprovar Participação</th>     
                <th>Editar Banca</th>   
            </tr>
            <%
                Banca[] bancas = (Banca[])request.getAttribute("bancas");
                for (Banca banca : bancas) {
                    
                DateFormat data = new SimpleDateFormat("dd/MM/yyyy");  
                String sData = data.format(banca.getDataBanca().getTime());
                
                DateFormat hora = new SimpleDateFormat("HH:mm");  
                String sHora = hora.format(banca.getHorarioBanca().getTime());
            %>
            <tr>

                <td><%= banca.getTcc().getTitulo() %>
                </td>
                <td><%= banca.getTcc().getAutor().getCurso().getNome() %>
                </td>
                <td><%= banca.getTcc().getAutor().getNome() %>
                </td>
                <td><%= banca.getModalidadeBanca() %>
                </td>      
                <td><%= sData %>
                </td>
                <td><%= sHora %>
                </td>
                <td><%= banca.getSituacao() %>
                </td>  
                <td>
                    
                <%  if (banca.getSituacao() == 'A') {                                   // se situacao da banca for “Em Analise” e o professor logado for um avaliador
                        for (Professor professor : banca.getProfessoresBanca()) {
                            if (professor.getMatricula() == usuario.getMatricula()){   // se for gera link para Aprovar Participação
                %>                                                         
                            <a href="BancaControle?idbanca=<%=banca.getId()%>&op=APROVACAO">Aprovar Participação</a>
                            
                <%
                            break;
                            }
                        }
                    }
                %>
                </td>
                <td>
                    <% // Caso de uso 29 - Editar Banca %>
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