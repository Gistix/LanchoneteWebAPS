/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Entities.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Highway.*;
import java.util.Enumeration;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import static javax.servlet.http.HttpServletResponse.*;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Giovanni
 */
@WebServlet(urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {

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

        //response.setContentType("text/html;charset=UTF-8");

        if (Utilidades.AutenticarSomente(request)) {
            if (Utilidades.EstaLogado(request)) {
                request.setAttribute("erro", "Voçê já está logado.");
                request.getRequestDispatcher("escolher.jsp").forward(request, response);                     
            }         
        } else {
            String usuario = request.getParameter("usuario");
            String senha = request.getParameter("senha");

            Cliente cliente =  DAOEclipseLink.Login(usuario, senha);
            
            if (cliente != null) {
                HttpSession session = request.getSession();
                
                session.setAttribute("usuario", usuario);
                session.setAttribute("senha", senha);
                session.setAttribute("adm", cliente.getAdm());
                
                response.sendRedirect(response.encodeRedirectURL("escolher.jsp"));  
            } else {
                request.setAttribute("erro", "Senha ou usuário incorretos.");
                request.getRequestDispatcher("index.jsp").forward(request, response); 
            }
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
