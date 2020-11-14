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
        <script>sendGet("autenticadoServlet")</script>            
    </head>
    
    <body onload="onLoad()">
        <jsp:include page="WEB-INF/header.jsp">           
            <jsp:param name="escolher" value="true"/>
        </jsp:include>
        
	<article>
            <div class="">
                <div class="grid-container pequeno">              
                    <a href='novoPedido.jsp' class='grid menu'>Novo pedido</a>
                    <a href='pedidos.jsp' class='grid menu'>Meus pedidos</a>

                    <div class='${adm ? '' : 'hide'}'>
                        <a href='ingredientes.jsp' class='grid menu'>Ingrediente</a>
                    </div>

                    <div class='${adm ? '' : 'hide'}'>                    
                        <a href='relatorio.jsp' class='grid menu'>Relatorio</a>                                   
                    </div>
                </div>  
                        
                <div id="msg" class="painel-bg ${erro != null ? 'mensagem' : ''} ${mensagem != null ? 'mensagem' : ''}">
                    <p id="erro" class="center" style="color: red">${erro}</p>
                    <p id="mensagem" class="center" style="color: green">${mensagem}</p> 
                </div>
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
