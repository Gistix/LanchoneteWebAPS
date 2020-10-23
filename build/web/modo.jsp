<%-- 
    Document   : modo
    Created on : Oct 20, 2020, 2:52:43 PM
    Author     : Giovanni
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
                <form action="PostgreLogin" method="get">
                    Nome: <input type="text" nome="nome"><br>
                    RA: <input type="text" nome="ra"><br>
                    Curso: <input type="text" nome="curso"><br>
                    Sigla: <input type="text" nome="sigla"><br>
                    <input type="submit" name="salvar" value="Salvar Aluno">
               </form>  
                <div class="row">
                    <div class="column">
                        <a href="#" class="griditem">Cliente</a>

                    </div>
                    <div class="column">
                        <a href="#" class="griditem">Administrador</a>
                    </div>
                </div>        
    </body>
</html>
