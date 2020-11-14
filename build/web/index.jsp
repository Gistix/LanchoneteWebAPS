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
        <script>sendGet("naoAutenticadoServlet")</script>    
        <script src="${pageContext.request.contextPath}/CryptoJS.core.js"></script>
        <script src="${pageContext.request.contextPath}/CryptoJS.md5.js"></script>
        <script>
            function encriptarSenha(form) {
                if (form.senha.value != '') {
                    //form.senha.value = CryptoJS.SHA256(form.senha.value).toString();
                    form.senha.value = CryptoJS.MD5(form.senha.value).toString();
                }
            }
        </script>   
    </head>
    <body onload="onLoad()">   
        <jsp:include page="WEB-INF/header.jsp">
            <jsp:param name="index" value="true"/>           
        </jsp:include>                
                
	<article>                                   
            <div class="center">
                <div class="painel-bg geral">
                    <div class="center">
                        <img src="${pageContext.request.contextPath}/img/ico-usuario.png" alt="ico-usuario" style="padding-bottom: 5px" width=80 height=80>
                    </div>
                    
                    <div class="formspace ladoalado center">
                        <div class="form">
                            Usuário:
                            <br>Senha:
                        </div>
                        
                        <form name="loginForm" method="post" action="loginServlet" onsubmit="encriptarSenha(this)">
                            <input type="text" name="usuario" pattern=".{4,12}" required><br/>
                            <input type="password" name="senha" pattern=".{4,12}" required><br/>                              
                    </div> 

                        <div>
                            <div class="center">
                                <input type="submit" value="Login" class="button">                                                                                                                                                      
                            </div>
                            
                            <div class="center">
                                <div>
                                    <br> Não possui uma conta? Cadastre-se <a href="cadastro.jsp">aqui</a>. 
                                </div>
                            </div>   
                        </div> 
                    </form>
                        
                        <div class="formspace center">                                
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
