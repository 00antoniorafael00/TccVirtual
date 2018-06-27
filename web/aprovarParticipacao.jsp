<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.edu.ifrs.modelo.Administrador"%>
<%@page import="br.edu.ifrs.modelo.Professor"%>
<%@page import="br.edu.ifrs.modelo.Banca"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="cabecalho.jsp" %>

    <%
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
   
        if (usuario instanceof Administrador || usuario instanceof Professor){
            
            Banca banca = (Banca)request.getAttribute("banca");
            DateFormat data = new SimpleDateFormat("dd/MM/yyyy");  
            String sData = data.format(banca.getDataBanca().getTime());

            DateFormat hora = new SimpleDateFormat("HH:mm");  
            String sHora = hora.format(banca.getHorarioBanca().getTime());
    %>
    
    <br><br><br>

        
        
        
        <label for="titulotrabalho">Título do Trabalho: </label>
        <input type="text" name="titulotrabalho" id="titulotrabalho" value="<%= banca.getTcc().getTitulo() %>" disabled><br><br>
    
        <label for="autor">Autor: </label>
        <input type="text" name="autor" id="autor" value="<%= banca.getTcc().getAutor().getNome() %>" disabled><br><br>    

        <label for="orientador">Orientador: </label>
        <input type="text" name="orientador" id="orientador" value="<%= banca.getTcc().getAutor().getMatricula() %>" disabled><br><br>    
 
        <label for="palavras">Palavras chaves: </label>
        <input type="text" name="palavras" id="palavras" value="<%= banca.getTcc().getPalavrasChaves() %>" disabled><br><br>           
        
        <label for="areaprincipal">área principal: </label>
        <input type="text" name="areaprincipal" id="areaprincipal" value="<%= banca.getTcc().getAreaPrincipal() %>" disabled><br><br>  
        
        <label for="areasecundaria">área secundária: </label>
        <input type="text" name="areasecundaria" id="areasecundaria" value="<%= banca.getTcc().getAreaSecundaria() %>" disabled><br><br> 
        
        <label for="data">Data: </label>
        <input type="text" name="data" id="data" value="<%= sData %>" disabled>
        
        <label for="hora">Hora: </label>
        <input type="text" name="hora" id="hora" value="<%= sHora %>" disabled><br><br>  
        
        <label for="resumo">resumo do trabalho: </label><br>
        <input type="text" name="resumo" id="resumo" value="<%= banca.getTcc().getResumo() %>" disabled><br><br>   
        
        <label>Avaliadores: </label><br>         
        <%  
            for (Professor professor : banca.getProfessoresBanca()) {

        %>                                                         
            <input type="text" name="resumo" id="resumo" value="<%= banca.getTcc().getOrientador().getMatricula() %>" disabled><br>
            

        <%     
            }
        %>
        <br><br><br>
        <form action="BancaControle">
        <input type="hidden" name="idbanca" value="<%= banca.getId() %>">
        <input type="hidden" name="op" value="APROVAR">
        <input class="button" type="submit" value="Aprovar Participação na Banca">
        </form>
        
        <br>
        
        <form action="BancaControle">
        <input type="hidden" name="idbanca" value="<%= banca.getId() %>">
        <input type="hidden" name="op" value="NEGAR">
        <input class="button" type="submit" value="Negar Participação na Banca">
        </form>    
        
    <%
    }
    %>








<%@include file="rodape.html" %>