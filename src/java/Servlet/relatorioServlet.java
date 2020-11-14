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
@WebServlet(name = "relatorioServlet", urlPatterns = {"/relatorioServlet"})
public class relatorioServlet extends HttpServlet {

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
  
        if (Utilidades.EstaLogado(request) && Utilidades.EADM(request)) {
            /*String dataInicio = request.getParameter("data-inicio");
            String horaInicio = request.getParameter("hora-inicio");
 
            String dataFim = request.getParameter("data-fim");
            String horaFim = request.getParameter("hora-fim");*/        
                       
            request.setAttribute("tabela", true);
            /*request.setAttribute("data-inicio", dataInicio);
            request.setAttribute("hora-inicio", horaInicio); 
            request.setAttribute("data-fim", dataInicio);
            request.setAttribute("hora-fim", horaInicio);   */
            request.getRequestDispatcher("relatorio.jsp").forward(request, response);            
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
