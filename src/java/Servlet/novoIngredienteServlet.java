/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Entities.Ingrediente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Entities.Pedido;
import Highway.DAOBase;
import java.util.Date;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Giovanni
 */
@WebServlet(name = "novoIngredienteServlet", urlPatterns = {"/novoIngredienteServlet"})
public class novoIngredienteServlet extends HttpServlet {

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
        
        if (Utilidades.AutenticarSomente(request) && !Utilidades.EstaLogado(request)) {
            response.setStatus(201);
            response.setHeader("erro", "Voce precisa estar logado para acessar essa página.");
            response.setHeader("url", "index.jsp");        
        } else if (Utilidades.EADM(request)) {
            int tipo = Integer.parseInt(request.getParameter("select"));
            String nome = request.getParameter("nome");
            float preco = Float.parseFloat(request.getParameter("preco"));

            Ingrediente ingrediente = new Ingrediente(-1, nome, tipo, preco);

            DAOBase.QueryInsert(ingrediente);

            request.setAttribute("mensagem", "Ingrediente '" + nome + "' adicionado com sucesso.");
            request.getRequestDispatcher("escolher.jsp").forward(request, response);            
        }
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
