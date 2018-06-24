<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.edu.ifrs.modelo.Usuario"%>

<!DOCTYPE html>
<html>

   <head>

      <title>Prog III</title>
      <meta charset="utf-8" />
      <link rel="stylesheet" type="text/css" href="css/estilos.css">

   </head>

   <body>
            <div id= "cabecalho">
               <img id= "logo" src="img/logo.png" alt="logo">
               <img id= "logoSia" src="img/SIA.png" alt="logosia">
               <h1 id="titulo"> Sistema Trabalho <span class= "verde"> Prog III</span></h1>
            </div>

            <div id="menu">
               
                  <ul id= "itens-menu">
                     <li><a href="index.jsp">Usuário</a></li>
                     <li><a href="index.jsp">TCC</a></li>
                     <li><a href="banca.jsp">Banca</a></li>
                     <li><a href="index.jsp">Página Inicial</a></li>
                  
                
                    <%
                        if (session.getAttribute("usuario") != null) {
                            %>
                            <li><a href="index.jsp">Cadastros</a></li>
                            <li><a href="UsuarioControle?op=SAIR">Sair</a><br><li>
                            <%
                        } else { 
                            %>
                            <li><a href="login.jsp">Login</a></li>

                            <%
                        }
                    %> 
                </ul>
            </div>
            <div class="conteudo">
