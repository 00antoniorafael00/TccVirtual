/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.controle;

import br.edu.ifrs.modelo.Banca;
import br.edu.ifrs.modelo.Curso;
import br.edu.ifrs.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rafael
 */
@WebServlet(name = "BancaControle", urlPatterns = {"/BancaControle"})
public class BancaControle extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            String op = request.getParameter("op");
            

        if(op.equals("CADASTRAR")) cadastrar(request, response);
        else if(op.equals("FORMCONSULTAR")) formularioConsultar(request, response);
        else if(op.equals("CONSULTAR")) consultar(request, response);
        else if(op.equals("APROVACAO")) formularioAprovacao(request, response);
        else if(op.equals("APROVAR")) aprovar(request, response);
        else if(op.equals("NEGAR")) negar(request, response);
        else if(op.equals("EDITAR")) editar(request, response);
        
               
        
        } catch (Exception e) {
            request.setAttribute("msg_erro", e.getMessage());
            RequestDispatcher dispatcher = 
                    request.getRequestDispatcher("erro.jsp");
            dispatcher.forward(request, response);
        }
    }
    
    protected void cadastrar(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    }
    
    protected void formularioConsultar(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        try {

            Curso[] cursos = null; 
            Curso c = new Curso();
            
            cursos = c.listar();
    
            
            request.setAttribute("cursos", cursos);

            RequestDispatcher r = request.getRequestDispatcher("consultarBancas.jsp");

            r.forward(request, response);


        } catch (Exception e) {
            request.setAttribute("msg_erro", e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("erro.jsp");
            dispatcher.forward(request, response);
        }

    }
    
    protected void consultar(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        try {

             Banca[] bcs = null;            

            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            String titulo = request.getParameter("titulotcc");
            int curso = 0;
            
            if (!request.getParameter("curso").isEmpty()){
                curso = Integer.valueOf(request.getParameter("curso"));
            }

            Banca b = new Banca();
            
            if (!titulo.isEmpty()){
                bcs = b.consultar(usuario, titulo, curso);  // # metodo consulta no banco de dados a banca - por titulo    
                
            } else {
                bcs = b.consultar(usuario, null, curso); // # metodo consulta no banco de dados a banca - por curso 
            }
//            
            request.setAttribute("bancas", bcs);

            RequestDispatcher r = request.getRequestDispatcher("listarBancas.jsp");

            r.forward(request, response);



        } catch (Exception e) {
            request.setAttribute("msg_erro", e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("erro.jsp");
            dispatcher.forward(request, response);
        }

    }
    
    protected void formularioAprovacao(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException, Exception {
        
            int id = Integer.parseInt(request.getParameter("idbanca"));
        
            Banca banca = new Banca();            

            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

            banca = banca.consultar(id);            // retorna uma banca pelo id

            request.setAttribute("banca", banca);

            RequestDispatcher r = request.getRequestDispatcher("aprovarParticipacao.jsp");

            r.forward(request, response);
        
    }    
    
    protected void aprovar(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException, Exception {
        
            int id = Integer.parseInt(request.getParameter("idbanca"));
        
            Banca b = new Banca();            

            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

            b = b.aprovarParticipacaoBanca(id, usuario, true);      // # metodo que edita participacao de profesor na banca nesse caso para true  
            
            request.setAttribute("banca", b);

            RequestDispatcher r = request.getRequestDispatcher("bancaAprovada.jsp");

            r.forward(request, response);     
        
        
        
    }       
    
     protected void negar(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException, Exception {
        
            int id = Integer.parseInt(request.getParameter("idbanca"));
        
            Banca b = new Banca();            

            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

            b = b.aprovarParticipacaoBanca(id, usuario, false);       // metodo que edita participacao de profesor na banca nesse caso para false
            
            request.setAttribute("banca", b);

            RequestDispatcher r = request.getRequestDispatcher("bancaNegada.jsp");

            r.forward(request, response);     
        
        
        
    }       
    
    
    
    
    protected void editar(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}