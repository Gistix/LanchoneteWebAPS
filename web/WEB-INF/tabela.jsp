<%@page import="java.util.Date"%>
<%@page import="Highway.DAOIngrediente"%>
<%@page import="Entities.Ingrediente"%>
<%@page import="Highway.DAOPedido"%>
<%@page import="java.util.List"%>
<%@page import="Entities.Pedido"%>
<%@page import="java.text.SimpleDateFormat"%>
<% 
    // Funciona normal
    Object tabela = request.getAttribute("tabela");

    if (tabela != null && (boolean)tabela == true) {
        // Com getAttribute não funciona mas com getParameter sim????
        String dataInicio = (String)request.getParameter("data-inicio");                                
        String horaInicio = (String)request.getParameter("hora-inicio");

        String dataFim = (String)request.getParameter("data-fim"); // getParameter
        String horaFim = (String)request.getParameter("hora-fim");

        System.out.println(dataInicio + " " + horaInicio);
        System.out.println(dataFim + " " + horaFim);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        
        //Date inicio = dateFormat.parse(dataInicio + " " + horaInicio);
        //Date fim = dateFormat.parse(dataFim + " " + horaFim);
        
        List<Pedido> pedidos = DAOPedido.PedidosIntervalo(dataInicio + " " + horaInicio + ":00", dataFim + " " + horaFim + ":60");
        //List<Pedido> pedidos = DAOPedido.PedidosIntervalo(inicio, fim);       
        List<Ingrediente> ingredientes = DAOIngrediente.TodosIngredientes();
        
        float total = 0.0f;
       %>
       
        <table class="tabela">
            <tr>
                <th>Número</th>
                <th>Cliente</th>
                <th>Data/Hora</th>
                <th>Preço</th>                
            </tr>
            
            <%
            for (Pedido pedido : pedidos) {
                float preco = pedido.Preco(ingredientes);
                total += preco;          
            %>
                <tr>
                    <td><%=pedido.numero%></td>
                    <td><%=pedido.usuario%></td>
                    <td><%=dateFormat.format(pedido.dataHora)%></td>
                    <td>R$ <%=String.format("%.2f", preco)%></td>                   
                </tr>
            <%
            }
            %>              
           
            <tr>
                <th>Quantidade</th>               
                <th></th>
                <th></th>
                <th>Total</th>                
            </tr>             
             
            <tr>
                <td><%=pedidos.size()%></td>                
                <td></td>
                <td></td>
                <td>R$ <%=String.format("%.2f", total)%></td>                
            </tr>            
        </table>       
       
       <%    
    }
%>