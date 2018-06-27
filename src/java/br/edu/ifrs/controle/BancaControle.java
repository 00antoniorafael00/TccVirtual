/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.controle;

import br.edu.ifrs.modelo.Banca;
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
        else if(op.equals("CONSULTAR")) consultar(request, response);
        else if(op.equals("APROVACAO")) formularioAprovacao(request, response);
        else if(op.equals("APROVAR")) aprovar(request, response);
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
    
    protected void consultar(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        try {

            Banca[] bcs = null;            

            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            String titulo = request.getParameter("titulotcc");
            String curso = request.getParameter("curso");

            Banca b = new Banca();
            if (!titulo.isEmpty()){
                bcs = b.consultar(usuario, titulo, null);
            } else {
                bcs = b.consultar(usuario, null, curso);
            }
            
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
        throws ServletException, IOException {
        
    }    
    
    protected void aprovar(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
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
