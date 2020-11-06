/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Entities.*;
import Highway.DAOEclipseLink;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static javax.servlet.http.HttpServletResponse.*;
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
      
        Boolean logado = Utilidades.EstaLogado(request);
        
        if (Utilidades.AutenticarSomente(request) && !logado) {
            response.setStatus(201);
            response.setHeader("erro", "Voce precisa estar logado para acessar essa página.");
            response.setHeader("url", "index.jsp");
            //request.getRequestDispatcher("index.jsp").forward(request, response);             
        } else {
            try (PrintWriter out = response.getWriter()) {
                HttpSession session = request.getSession(false);
                String usuario = (String) session.getAttribute("usuario");
                List<Pedido> pedidos = DAOEclipseLink.Pedidos(usuario); 

                for (Pedido pedido : pedidos) {
                    List<Ingrediente> ingredientes = DAOEclipseLink.Ingredientes(pedido);
                    String[] nomes = DAOEclipseLink.NomeIngredientes(ingredientes);

                    out.println("<div class='grid pedido'>");
                    out.println("<div class='ingredientes'>");

                    out.println(nomes[0]);
                    out.println("</br>");

                    out.println(nomes[1]); 
                    out.println("</br>");

                    if(nomes[2] != "") {
                        out.println(nomes[2]);
                        out.println("</br>");                        
                    }

                    if(nomes[3] != "") {                   
                        out.println(nomes[3]);
                        out.println("</br>");
                    }


                    out.println("</div>");

                    out.println("<div class='total'>");                    
                    out.println("Total: R$" + String.format("%.2f", DAOEclipseLink.Preco(ingredientes)));  
                    out.println("</div>");

                    out.println("</div>");                     
                }
                out.close();
            }
            
        }
        /*} else {
            //out.println("<h1>Voce precisa estar logado para acessar essa página.</h1>");
            //out.println("<h1><a href='index.jsp'>Fazer login.</a></h1>");
            
            //response.setStatus(201);
            //response.sendError(HttpServletResponse.SC_UNAUTHORIZED)
            //response.setStatus(SC_OK);
            request.setAttribute("erro", "Voce precisa estar logado para acessar essa página.");
            request.getRequestDispatcher("index.jsp").forward(request, response);   
        }*/
            
        
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
