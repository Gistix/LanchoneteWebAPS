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
        </header> 
	<article>
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
                            <input type="submit" name="login" value="Login" class="button">
                        </form>
                    </div>
                </div>
            </div>
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
