<%-- 
    Document   : montar-lanche
    Created on : 23 de out. de 2020, 12:46:38
    Author     : mmarc
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Highway.DAOEclipseLink"%>
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
    </head>
    <body onload="onLoadSelect()">
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
            <div class="form-bg" style="padding: 30px 60px">

                <% List<Ingrediente> ingredientes = DAOEclipseLink.instance.TodosIngredientes();%>
                
                <%List<Float> precos = new ArrayList<Float>();
                for (Ingrediente ingrediente : ingredientes) {
                    precos.add(ingrediente.preco);
                }%>
                
                <c:set var="precos" value="<%=precos%>" />
                
                <form name="loginForm" method="post" action="novoPedidoServlet">
                    <%
                    for (int i = 1; i < 5; i++) {
                        String nomeIngre = Ingrediente.Tipo.fromInt(i).toString();
                    %>
                        <div class="center2 ladoalado">
                            <img src="${pageContext.request.contextPath}/img/<%=nomeIngre.toLowerCase()%>.png" alt="<%=nomeIngre%>-icone" class="icone-ingrediente">

                            <div class="formspace">
                                <select name="select-<%=nomeIngre%>" class="sel-ingrediente" onchange="onChange(this, '${precos}')">
                                    <%if (i > 2) {%>
                                    <option value="0">Nenhum</option>   
                                    <%}%>

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
                                <p id="preco">R$: </p>
                            </div>
                        </div>
                    <%  
                    }
                    %> 
                    
                    <h1 id="preco-total" class="center">Total: R$ </h1>
                    <div class="center">
                        <input type="submit" value="Realizar Pedido" class="botao aceitar" style="margin-top: 20px">   
                    </div>
                </form>                
                
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
