<%-- 
    Document   : cadastro
    Created on : 22 de out. de 2020, 22:53:19
    Author     : mmarc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
        <script src="${pageContext.request.contextPath}/script.js"></script>    
        <script>sendGet("naoAutenticadoServlet")</script>  
        <script src="${pageContext.request.contextPath}/CryptoJS.core.js"></script>
        <script src="${pageContext.request.contextPath}/CryptoJS.md5.js"></script>        
        <script>
            function encriptarSenha(form) {
                if (form.senha.value != '') {
                    form.senha.value = CryptoJS.MD5(form.senha.value).toString();
                }
            }
        </script>
    </head>
    <body>
        <jsp:include page="WEB-INF/header.jsp">           
            <jsp:param name="cadastro" value="true"/>
        </jsp:include>
        
        <article>                  
            <div class="center">
                <div class="painel-bg geral formspace">    
                    <div class="ladoalado">
                        <div class="form">
                            Nome:<br>
                            CPF:<br>
                            Usuário:<br>
                            Senha:<br><br>
                            Endereço:<br>
                            Rua:<br>
                            Número:<br>
                            Cep:
                        </div>                 
                        <div class="form">
                            <form name="loginForm" method="post" action="cadastrarServlet" onsubmit="encriptarSenha(this)">
                                <input type="text" name="nome" pattern="[A-Za-z ]{3,60}" required><br>
                                <input type="text" name="cpf" pattern="[0-9]{11}" title="11 números" required><br>
                                <input type="text" name="usuario" pattern="[A-Za-z0-9]{4,12}" required><br>
                                <input type="password" name="senha" pattern=".{4,12}" title="De 4 a 12 caracteres" required><br><br><br>
                                <input type="text" name="rua" pattern="[A-Za-z ]{8,120}" required><br>
                                <input type="number" name="numero" required><br>
                                <input type="text" name="cep" pattern="[0-9]{8}" title="8 números" required> 
                                <br>
                        </div>  
                    </div>
                    <div class="ladoalado center">
                        <div class="espacobotao">
                            <input type="submit" value="Confirmar" class="button">
                        </div>
                                                    </form>
                        <div class="espacobotao">
                            <form method="post" action="index.jsp">
                                <button type="submit" class="button">Cancelar</button>
                            </form>
                        </div>
                        <p id="erro" class="center" style="color: red">${erro}</p>
                        <p id="mensagem" class="center" style="color: green">${mensagem}</p>                                    
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
