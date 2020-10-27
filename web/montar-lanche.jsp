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
        <title>Monte seu lanche</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
    </head>
    <body>
        <header>           
            <h1 class="titletext">Monte do seu jeito!</h1>         
            <img src="https://i.ibb.co/D8J4yVj/logo-aps.png" alt="coca-icone" width=300 height=140 class="logo3"> 
        </header> 
        
	<article>           
            <div class="div-sel-ingrediente">
                <img src="https://i.ibb.co/0V8nGQ4/p-es.png" alt="hamburguer-icone" width=150 height=95>
                <h1>Pão</h1>
                <select>
                    <option value="0">Pão</option>              
                </select>
            </div>
            <div class="div-sel-ingrediente">
                <img src="https://i.ibb.co/bgfSBsh/hamburguer.png" alt="hamburguer-icone" width=150 height=95>
                <h1>Carne</h1>
                <select class="sel-ingrediente">
                  <option value="0">Carne</option>
                </select>
            </div>
            <div class="div-sel-ingrediente">
                <img src="https://i.ibb.co/vDpPCGC/salada.png" alt="hamburguer-icone" width=150 height=95>
                <h1>Salada</h1>
                <select class="sel-ingrediente">
                  <option value="0">Salada</option>
                </select>
            </div>
            <div class="div-sel-ingrediente">
                <img src="https://i.ibb.co/zfbPvts/molhos.png" alt="hamburguer-icone" width=150 height=95>
                <h1>Molho</h1>
                <select class="sel-ingrediente">
                  <option value="0">Molho</option>
                </select>
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
