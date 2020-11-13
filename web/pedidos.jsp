<%-- 
    Document   : index
    Created on : Oct 20, 2020, 2:31:19 PM
    Author     : Giovanni
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Entities.Ingrediente"%>
<%@page import="java.util.List"%>
<%@page import="Entities.Pedido"%>
<%@page import="Highway.DAOPedido"%>
<%@page import="Highway.DAOIngrediente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Highway</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
        <script src="${pageContext.request.contextPath}/script.js"></script>
        <script>sendGet("pedidosServlet")</script>
    </head>
    <body>   
        <jsp:include page="WEB-INF/header.jsp">           
            <jsp:param name="pedidos" value="true"/>
        </jsp:include>
        
	<article>
            <div class="center grid-container grande">
                <%
                HttpSession session2 = request.getSession(false);

                if (session2 != null) {
                    Object objUsuario = session2.getAttribute("usuario");

                    if (objUsuario != null && !((String)objUsuario).isEmpty()){
                        List<Pedido> pedidos = DAOPedido.Pedidos((String) objUsuario);
                        
                        for (Pedido pedido : pedidos) {
                           List<Ingrediente> ingredientes = DAOIngrediente.Ingredientes(pedido);
                           String[] nomes = DAOIngrediente.NomeIngredientes(ingredientes);  
                                if (pedidos.indexOf(pedido) == 0) {
                           %>                            
                                    <div class='grid pedido ${pedido ? 'ativo' : ''}'>
                                <%}else{%>        
                                     <div class='grid pedido'>  
                                <%}%>          
                                <div class='pedidocontainer'>
                                    <%=pedido.numero%> - <%=new SimpleDateFormat("dd/MM/yyyy").format(pedido.dataHora)%>

                                    <div class='ingredientes'>
                                        <%=nomes[0]%>
                                        </br>

                                        <%=nomes[1]%> 
                                        </br>

                                        <%if(nomes[2] != "") {%>
                                        <%=nomes[2]%>
                                        </br>                
                                        <%}%>

                                        <%if(nomes[3] != "") {%>
                                        <%=nomes[3]%>
                                        </br>                
                                        <%}%>
                                    </div>

                                    <div class='total'>                    
                                        Total: R$ <%=String.format("%.2f", DAOPedido.Preco(ingredientes))%>  
                                    </div>
                                </div>
                            </div>                             
                           
                           <%                           
                        }
                    }
                }
                %>
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
