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
        <script>sendGetReplace("pedidosServlet");</script>
    </head>
    <body onload="onLoad()">   
        <header>  
            <div class="table">
                <div class="header">
                    <h1 class="titletext">HIGHWAY</h1>         
                    <img src="${pageContext.request.contextPath}/img/logo.png" alt="logo" class="logo">  
                </div>
            </div>
            <div class="table barra">
                <nav>
                    <ul>
                        <div class="folding">                          
                            <li class="item"><a href="escolher.jsp">Home</a></li>
                            <li class="item"><a href="novoPedido.jsp">Novo Pedido</a></li>
                            <li class="active item"><p>Meus Pedidos</p></li>                            
                            <li class="item ${adm ? '' : 'hide'}"><a href="ctrc.html">Novo Ingrediente</a></li>	
                            <li class="item ${adm ? '' : 'hide'}"><a href="ctrv.html">Faturamento</a></li>																						
                        </div>
                    </ul>
                </nav>
                <div class="info">
                    <a class="sair" href="logoutServlet">Sair</a><p>&nbsp(${usuario})</p>  
                </div>                
            </div>
        </header>
        
	<article>
            <div id="content" class="center grid-container grande">

            </div>        
       </article>
            
        <footer>
            <ul>
                <p>LANCHONETE WEB</p>
            </ul>	

            <ul>					
                <li><p>APS Ciência da Computação 4º Semestre 2020, UNIP.</p></li>			
            </ul>			
        </footer>                         
    </body>
</html>
