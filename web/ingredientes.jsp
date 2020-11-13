<%-- 
    Document   : montar-lanche
    Created on : 23 de out. de 2020, 12:46:38
    Author     : mmarc
--%>

<%@page import="Entities.Ingrediente.Tipo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Highway.DAOIngrediente"%>
<%@page import="Entities.Ingrediente"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fazer pedido</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
        <script src="${pageContext.request.contextPath}/script.js"></script>
        <script>sendGet("novoIngredienteServlet")</script>
    </head>
    <body onload="onLoadSelect()">
        <jsp:include page="WEB-INF/header.jsp">           
            <jsp:param name="ingredientes" value="true"/>
        </jsp:include>
	<article>  
            
            <div class="center">
                <div class="grid-container grande">              
                    <form name="novoIgndForm " method="post" class='grid-ingredientes' action="novoIngredienteServlet">
                            <div class="center2 ladoalado">
                                <img alt="icone-ingrediente" id="icone-ingrediente" class="icone-ingrediente pao">

                                <div style="padding-left: 10px">
                                    <label for="select">Tipo:</label><br>
                                    <select name="select" onchange="onChangeTipo(this)">
                                        <%
                                        for (Tipo tipo : Tipo.values()) {
                                            if (tipo != Tipo.Erro) {
                                        %>
                                                <option value="<%=tipo.ordinal()%>"><%=tipo.name()%></option>   
                                        <%  
                                            }
                                        }
                                        %>
                                    </select>
                                    <br>
                                    <div style="line-height:50%;">
                                        <br>
                                    </div>
                                    
                                    <label for="nome">Nome:</label><br>
                                    <input type="text" name="nome" required style="width: 125px"><br>
                                    <div style="line-height:50%;">
                                        <br>
                                    </div>                                    
                                    
                                    <label for="preco">Preço:</label> <br>                              
                                    <input type="number" name="preco" required style="width: 125px"><br>                               
                                </div>
                            </div>
                        <div class="center">
                            <input type="submit" value="Adicionar Ingrediente" class="botao aceitar" style="margin-top: 20px">   
                        </div>
                    </form>                

                    <%List<Ingrediente> ingredientes = DAOIngrediente.TodosIngredientesNaoUtilizados();%>            
                                    
                    <form name="removeIgndForm" method="post" class='grid-ingredientes' action="removeIngredienteServlet">
                        <div class="center ladoalado">
                            <div>    
                                <label for="select">Tipo:</label><br>
                                <select name="select" onchange="onChangeTipoRemover(this)">
                                    <%
                                    for (Tipo tipo : Tipo.values()) {
                                        if (tipo != Tipo.Erro) {
                                    %>
                                            <option value="<%=tipo.ordinal()%>"><%=tipo.name()%></option>   
                                    <%  
                                        }
                                    }
                                    %>
                                </select>
                                <br>
                                <div style="line-height:50%;">
                                    <br>
                                </div>

                                <label for="ingrediente">Ingrediente:</label><br>

                                <%
                                for (int i = 1; i < 5; i++) {
                                    String nomeIngre = Ingrediente.Tipo.fromInt(i).toString();
                                %>
                                    <select id="<%=nomeIngre%>" name="select-ingrediente" style="width: 150px">
                                        <%
                                        for (Ingrediente ingrediente : ingredientes) {
                                            if (ingrediente.tipo == i) {
                                        %>
                                        <option value="<%=ingrediente.numero%>"><%=ingrediente.nome%></option>   
                                        <%  
                                            }
                                        }
                                        %>
                                    </select>
                                <%  
                                }
                                %>                                                                 
                            </div>
                        </div>
                           
                        <br>
                            
                        <div class="center ladoalado">    
                            <p style="max-width: 200px">Ingredientes em uso não podem ser removidos.</p>
                        </div>
                            
                        <div class="center-bottom">
                            <input type="submit" value="Remover Ingrediente" class="botao aceitar" style="margin-top: 20px">   
                        </div>
                    </form>
                </div>  

                <p id="erro" class="center" style="color: red"></p>
                <p id="mensagem" class="center" style="color: green"></p>   
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
