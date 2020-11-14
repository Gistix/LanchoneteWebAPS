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
        <script>sendGet("autenticadoServlet")</script>           
    </head>
    <body onload="onLoad()">   
        <jsp:include page="WEB-INF/header.jsp">
            <jsp:param name="relatorio" value="true"/>           
        </jsp:include>                
                
	<article>                                   
            <div class="center">
                <div class="form-pesq">
                        <div>
                            <div class="center">
                                <div class="ladoalado form-pesquisa-rel">
                                    <div class="form form-pesq-title">
                                        Inicio:                      
                                        <br><br>Fim:                           
                                    </div >

                                    <form name="relatorioForm" method="post" action="relatorioServlet">
                                        <input type="date" name="data-inicio" required class="input-data">

                                        <input type="time" name="hora-inicio" required class="input-hora"><br/>
                                        <br>
                                        <input type="date" name="data-fim" required class="input-data">

                                        <input type="time" name="hora-fim" required class="input-hora"><br/>
                                </div>
                            </div>                           
                                         <div class="center butao-pesq">
                                            <input type="submit" value="Pesquisar" class="botao aceitar">                                                                                                                                                      
                                        </div>
                                    </form>  
                                    
                            <div id="content">
                                <jsp:include page="WEB-INF/tabela.jsp"/>                          
                            </div>
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

