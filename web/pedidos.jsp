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
        <script src="${pageContext.request.contextPath}/script.js"></script>
        <script>sendGet("pedidosServlet");</script>        
    </head>
    <body>   
        <header>           
            <h1 class="titletext">HIGHWAY</h1>         
            <img src="https://i.ibb.co/D8J4yVj/logo-aps.png" alt="coca-icone" width=300 height=140 class="logo"> 
            <div>
                Test <a href="logoutServlet">Logout</a>  
            </div>
        </header> 
        
	<article>
            <div id="content" class="center">              
                
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
