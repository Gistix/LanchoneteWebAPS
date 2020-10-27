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
    </head>
    <body>
        <header>
            <h1 class="titletext">Cadastre-se</h1>
            <img src="https://i.ibb.co/D8J4yVj/logo-aps.png" alt="coca-icone" width=300 height=140 class="logo">
        </header> 
        
        <article>                  
            <div class="center">
                <div class="row formspace">                  
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
                            <form action="cadastrar" method="get">
                                <input type="text" nome="nome"><br>
                                <input type="cpf" nome="cpf"><br>
                                <input type="text" nome="usuario"><br>
                                <input type="password" nome="senha"><br><br><br>
                                <input type="endereco" nome="rua"><br>
                                <input type="endereco" nome="numero"><br>
                                <input type="endereco" nome="cep">                           
                                <br>
                                <div class="row">
                                    <div class="column">
                                        <input type="submit" name="confirmar-cadastro" value="Confirmar" class="button">
                                    </div>
                                    <div class="column">
                                            <form method="get" action="index.jsp">
                                                <button type="submit" class="button">Cancelar</button>
                                            </form>
                                    </div>
                                </div> 
                            </form>
<<<<<<< HEAD
=======
                            <br>
                            <div class="row">
                                <div class="column">
                                    <input type="submit" name="confirmar-cadastro" value="Confirmar" class="button">
                                </div>
                                <div class="column">
                                    <form method="get" action="index.jsp">
                                        <button type="submit" class="button">Cancelar</button>
                                    </form>
                                </div>
                            </div>  
>>>>>>> origin/main
                        </div>                                         
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
