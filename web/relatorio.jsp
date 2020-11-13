<%-- 
    Document   : relatorio
    Created on : 13 de nov. de 2020, 19:41:00
    Author     : mmarc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Highway</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
        <script src="${pageContext.request.contextPath}/script.js"></script>                            
    </head>
    <body onload="onLoad()">   
        <jsp:include page="WEB-INF/header.jsp">
            <jsp:param name="relatorio" value="true"/>           
        </jsp:include>                
                
	<article>                                   
            <div class="center">
                <div class="form-pesq">
                    <div class="center">
                        <div class="form form-pesq-title">
                            Inicio:                      
                            <br><br>Fim:                           
                        </div>
                        <form class="form-pesquisa-rel" name="pesquisarRegistro" method="post" action="relatorioServlet">
                            <input type="text" name="data" required class="input-data" placeholder="DD/MM/AAAA">
                            <input type="text" name="hora" required class="input-hora" placeholder="HH:MM"><br/>
                            <br>
                            <input type="text" name="data" required class="input-data" placeholder="DD/MM/AAAA">
                            <input type="text" name="hora" required class="input-hora" placeholder="HH:MM"><br/>
                            
                            <div class="center butao-pesq">
                                <input type="submit" value="Pesquisar" class="button">                                                                                                                                                      
                            </div>
                        </form>
                                                
                    </div>                                                                                   
                        <div class="formspace">                                
                            <p id="erro" style="color: red">${erro}</p>
                            <p id="mensagem" style="color: green">${mensagem}</p>
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

