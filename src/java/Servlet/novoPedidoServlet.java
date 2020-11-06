/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Entities.Pedido;
import Highway.DAOEclipseLink;
import java.util.Date;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Giovanni
 */
@WebServlet(name = "novoPedidoServlet", urlPatterns = {"/novoPedidoServlet"})
public class novoPedidoServlet extends HttpServlet {

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
        } else {
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet novoPedido</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Servlet novoPedido at " + request.getContextPath() + "</h1>");

                int idPao = Integer.parseInt(request.getParameter("select-Pao"));
                int idCarne = Integer.parseInt(request.getParameter("select-Carne"));
                Integer idSalada = Integer.parseInt(request.getParameter("select-Salada"));
                Integer idMolho = Integer.parseInt(request.getParameter("select-Molho"));
                
                if (idSalada == 0)
                    idSalada = null;
                
                if (idMolho == 0)
                    idMolho = null;
                 
                HttpSession session = request.getSession(false);
                String usuario = (String) session.getAttribute("usuario");
                Date dataHora = new Date(System.currentTimeMillis());
                
                Pedido pedido = new Pedido(-1, usuario, idPao, idCarne, idSalada, idMolho, dataHora);

                
                //DAOEclipseLink.NovoPedido(pedido);
                DAOEclipseLink.QueryInsert(pedido);
                
                out.println(pedido.toString());                
                
                out.println(idPao);
                out.println(idCarne);
                out.println(idSalada);
                out.println(idMolho);

                response.setHeader("mensagem", "Cadastrado com sucesso.");           
                response.setHeader("url", "index.jsp");                
                
                out.println("</body>");
                out.println("</html>");
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
