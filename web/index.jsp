<%-- 
    Document   : index
    Created on : Oct 20, 2020, 2:31:19 PM
    Author     : Giovanni
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Highway</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
    </head>
    <body>
        <header>           
            <h1 class="titletext">HIGHWAY</h1>         
            <img src="https://i.ibb.co/D8J4yVj/logo-aps.png" alt="coca-icone" width=300 height=140 class="logo"> 
        </header> 
        
	<article>                                   
            <table>
                <tr>
                    <td class="center">
                        <img src="https://image.flaticon.com/icons/png/512/16/16480.png" alt="usuario-icone" width=80 height=80>
                    </td>                                        
                </tr>
                <tr>
                    <td>
                        <div class="center">
                            <div class="row formspace">                  
                                <div class="form">
                                    Usuário:
                                    <br>Senha:        
                                </div>
                                <div class="form">
                                <form action="login" method="get">
                                    <input type="text" nome="usuario"><br>
                                    <input type="password" nome="senha"><br>
                                    <div>
                                        <input type="submit" name="login" value="Login" class="button">                                                                                                                                                         
                                    </div>                                  
                                </form>
                                    <form>
                                        Não tem conta? cadastre-se <a href="cadastro.jsp">aqui</a>
                                    </form>
                                </div>                         
                            </div> 
                        </div>
                    </td>                  
                </tr>                
            </table>           
       </article>
            
        <footer>
            <ul>
                <p>SISTEMA LANCHONETE WEB</p>
            </ul>	

            <ul>					
                <li><p>APS Ciência da Computação 4º Semestre 2020, UNIP.</p></li>			
            </ul>			
        </footer>                         
    </body>
</html>
