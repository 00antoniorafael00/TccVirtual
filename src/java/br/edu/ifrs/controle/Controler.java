/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.controle;

import br.edu.ifrs.modelo.Tcc;
import br.edu.ifrs.modelo.GenericoDAO;
import br.edu.ifrs.modelo.Professor;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
 * methods.
 *
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
        * @throws IOException if an I/O error occurs 1669375
 */
@WebServlet(name = "Controler", urlPatterns = {"/Controler"})
public class Controler extends HttpServlet {

    private String titulo;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String op = request.getParameter("op");

            if (op.equals("CONSULTAR")) {
                consultar(request, response);
            } else if (op.equals("EscolhaTcc")) {
                consutarDados(request, response);
            }

        } catch (Exception e) {
            request.setAttribute("msg_erro", e.getMessage());
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("erro.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void consutarDados(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            Integer id = Integer.parseInt(request.getParameter("tituloEscolhido"));
             GenericoDAO tcc = new GenericoDAO();
            ArrayList<String> estudantes = tcc.selecionaOrientadoreEstudante(id);
            request.setAttribute("nomes", estudantes);
            ArrayList<Professor> professores = tcc.selecionaProfessores();
            request.setAttribute("professores", professores);
            request.setAttribute("id", id);
            RequestDispatcher r = request.getRequestDispatcher("formulario.jsp");
            r.forward(request, response);

        } catch (ServletException | IOException e) {
            try {
                request.setAttribute("msg_erro", e.getMessage());
                RequestDispatcher dispatcher = request.getRequestDispatcher("erro.jsp");
                dispatcher.forward(request, response);
            } catch (ServletException | IOException ex) {

            }
        }
    }
    
    
    
    private void consultar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        try {
            GenericoDAO tccDAO = new GenericoDAO();
             ArrayList<Tcc> listaTccs = tccDAO.selecionarTccs();
            request.setAttribute("tccs", listaTccs);
            RequestDispatcher r = request.getRequestDispatcher("mostraTcc.jsp");
            r.forward(request, response);
        } catch (ServletException | IOException e) {
            request.setAttribute("msg_erro", e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("erro.jsp");
            dispatcher.forward(request, response);
        }
    }

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
