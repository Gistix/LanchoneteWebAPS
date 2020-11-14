<%-- 
    Document   : header
    Created on : 13 de nov de 2020, 01:20:42
    Author     : Giovanni
--%>
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
                    <li class="item ${param.index ? 'active' : ''} ${usuario == null ? '' : 'hide'}"><a href="index.jsp">Home</a></li>
                    <li class="item ${param.cadastro ? 'active' : ''} ${usuario == null ? '' : 'hide'}"><a href="cadastro.jsp">Cadastrar</a></li>
                    
                    <li class="item ${param.escolher ? 'active' : ''} ${usuario == null ? 'hide' : ''}"><a href="escolher.jsp">Home</a></li>
                    <li class="item ${param.novoPedido ? 'active' : ''} ${usuario == null ? 'hide' : ''}"><a href="novoPedido.jsp">Novo Pedido</a></li>
                    <li class="item ${param.pedidos ? 'active' : ''} ${usuario == null ? 'hide' : ''}"><a href="pedidos.jsp">Meus Pedidos</a></li>	
                    <li class="item ${param.ingredientes ? 'active' : ''} ${adm ? '' : 'hide'}"><a href="ingredientes.jsp">Ingredientes</a></li>	
                    <li class="item ${param.relatorio ? 'active' : ''} ${adm ? '' : 'hide'}"><a href="relatorio.jsp">Relatorio</a></li>																						
                </div>
            </ul>
        </nav>
        <div class="info ${usuario == null ? 'hide' : ''}">
            <a class="sair" href="logoutServlet">Sair</a><p>&nbsp(${usuario})</p>  
        </div>                
    </div>
</header>