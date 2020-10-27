/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Entities.*;
import Highway.EclipseLinkMgr;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "pedidosServlet", urlPatterns = {"/pedidosServlet"})
public class pedidosServlet extends HttpServlet {

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

        List<Pedido> pedidos = new ArrayList<Pedido>();
        
        if (session != null) {
            String usuario = (String) session.getAttribute("usuario");
            pedidos = EclipseLinkMgr.Query("SELECT p FROM Pedido p WHERE p.usuario = '" + usuario + "'");        
        }

        try (PrintWriter out = response.getWriter()) {
            if (session != null) {              
                out.println("<h1>Seus pedidos: </h1><br>");
                
                out.println("<table>");

                out.println("<tr>");
                out.println("<th>Pão</th>");
                out.println("<th>Carne</th>");
                out.println("<th>Salada</th>");                
                out.println("<th>Molho</th>"); 
                out.println("<th>Preço</th>");                
                out.println("</tr>"); 
                
                for (Pedido pedido : pedidos) {
                    out.println("<tr>");
                    
                    List<Ingrediente> ingredientes = EclipseLinkMgr.Ingredientes(pedido);
                    String[] nomes = EclipseLinkMgr.NomeIngredientes(ingredientes);
                    
                    out.println("<td>" + nomes[0] + "</td>");
                    out.println("<td>" + nomes[1] + "</td>");                    
                    out.println("<td>" + nomes[2] + "</td>");
                    out.println("<td>" + nomes[3] + "</td>");
                    out.println("<td>" + EclipseLinkMgr.Preco(ingredientes) + "</td>");  
                    
                    out.println("</tr>"); 
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
