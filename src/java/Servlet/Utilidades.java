/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import javax.servlet.http.*;

/**
 *
 * @author Giovanni
 */
public class Utilidades {
    public static Boolean AutenticarSomente (HttpServletRequest request) {
        return request.getContentType().equals("text/plain;charset=UTF-8") && request.getContentLength() == 10; 
        /*String autentica = request.getParameter("autentica");
        return autentica != null && autentica.equals("autentica");*/
    }
    
    public static Boolean EstaLogado (HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        
        if (session != null) {
            Object usuario = session.getAttribute("usuario");
            
            if (usuario != null && !((String)usuario).isEmpty())
                return true;
        }
        
        return false;
    }
}
