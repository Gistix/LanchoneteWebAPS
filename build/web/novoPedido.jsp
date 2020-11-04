<%-- 
    Document   : montar-lanche
    Created on : 23 de out. de 2020, 12:46:38
    Author     : mmarc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fazerr pedido</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
    </head>
    <body>
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
                            <li class="active item"><p>Novo Pedido</p></li>
                            <li class="item"><a href="pedidos.jsp">Meus Pedidos</a></li>	
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
            <div class="form-bg ladoalado">

                <div class="div-sel-ingrediente">
                    <img src="${pageContext.request.contextPath}/img/pao.png" alt="pão-icone" class="icone-ingrediente">
                    
                    <div class="center">
                        <select class="sel-ingrediente">
                            <option value="0">Pão</option>              
                        </select>
                    </div>
                </div>
                    
                <div class="div-sel-ingrediente">
                    <img src="${pageContext.request.contextPath}/img/carne.png" alt="hamburguer-icone" class="icone-ingrediente">
                    <div class="center">
                        <select class="sel-ingrediente">
                          <option value="0">Carne</option>
                        </select>
                    </div>
                </div>
                    
                <div class="div-sel-ingrediente">
                    <img src="${pageContext.request.contextPath}/img/salada.png" alt="salada-icone" class="icone-ingrediente">
                    <div class="center">
                        <select class="sel-ingrediente">
                          <option value="0">Salada</option>
                        </select>
                    </div>
                </div>
                    
                <div class="div-sel-ingrediente">
                    <img src="${pageContext.request.contextPath}/img/molho.png" alt="molho-icone" class="icone-ingrediente">
                    <div class="center">
                        <select class="sel-ingrediente">
                          <option value="0">Molho</option>
                        </select>
                    </div>
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
