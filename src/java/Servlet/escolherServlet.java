/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Highway.EclipseLinkMgr;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Giovanni
 */
@WebServlet(name = "escolherServlet", urlPatterns = {"/escolherServlet"})
public class escolherServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession(false);
        
        try (PrintWriter out = response.getWriter()) {
            if (session != null) {
                String usuario = (String) session.getAttribute("usuario");
                int nivel = (Integer) session.getAttribute("nivel");
                
                out.println("<table>");
                out.println("    <tr>");
                out.println("        <td><a href='novoPedido.jsp' class='griditem'>Novo pedido</a></td>");
                out.println("        <td><a href='pedidos.jsp' class='griditem'>Meus pedidos</a></td>");
                out.println("    </tr>");
                
                if (nivel >= 1) {
                    out.println("    <tr>");
                    out.println("        <td><a href='todosPedidos.jsp' class='griditem'>Exibir pedidos</a></td>");
                    
                    if (nivel == 2)
                        out.println("        <td><a href='novoIngrediente.jsp' class='griditem'>Novo ingrediente</a></td>");
                    
                    out.println("    </tr>");                    
                }
                
                out.println("</table>");            
            } else {
                out.println("<h1>Voce precisa estar logado para acessar essa página.</h1>");
                out.println("<a href='index.jsp'>Fazer login.</a>");                
            }

            out.close();
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
