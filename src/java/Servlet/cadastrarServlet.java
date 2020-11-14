/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Entities.Cliente;
import Highway.DAOBase;
import Highway.DAOCliente;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Giovanni
 */
@WebServlet(urlPatterns = {"/cadastrarServlet"})
public class cadastrarServlet extends HttpServlet {

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

        if (!Utilidades.AutenticarSomente(request)) {
            if (!Utilidades.EstaLogado(request)) {                       
                String usuario = request.getParameter("usuario");
                String senha = request.getParameter("senha");    
                String nome = request.getParameter("nome");
                String cpf = request.getParameter("cpf");              

                String rua = request.getParameter("rua");    
                String numeroStr = request.getParameter("numero");
                String cep = request.getParameter("cep");       

                //if (usuario.isEmpty() || senha.isEmpty() || nome.isEmpty() || cpf.isEmpty() || rua.isEmpty() || numeroStr.isEmpty() || cep.isEmpty()) {
                if (usuario == null || senha == null || nome == null || cpf == null || rua == null || numeroStr == null || cep == null) {                    
                    // Não deveria acontecer, mas...
                    request.setAttribute("erro", "Por favor preencha todos os campos.");
                    request.getRequestDispatcher("cadastro.jsp").forward(request, response);                    
                } else {
                    Boolean existe = DAOCliente.UsuarioCPFExiste(usuario, cpf);

                    if (existe) {
                        //response.setHeader("erro", "Já existe um usuario com esse nome ou cpf.");
                        request.setAttribute("erro", "Já existe um usuario com esse nome ou cpf.");
                        request.getRequestDispatcher("cadastro.jsp").forward(request, response);
                    } else {
                        Cliente cliente = new Cliente(nome, cpf, usuario, senha, rua, Integer.parseInt(numeroStr), cep, false);                   
                        DAOBase.QueryInsert(cliente);

                        /*response.setStatus(201);
                        response.setHeader("mensagem", "Cadastrado com sucesso.");           
                        response.setHeader("url", "index.jsp");    */                      
                        
                        request.setAttribute("mensagem", "Cadastrado com sucesso.");
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
                }
            } else {
                response.setStatus(201);
                response.setHeader("erro", "Voçê já está logado e não pode se cadastrar de novo.");           
                response.setHeader("url", "escolher.jsp");                  
                //request.setAttribute("erro", "Voçê já está logado e não pode se cadastrar de novo.");
                //request.getRequestDispatcher("escolher.jsp").forward(request, response);                   
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
