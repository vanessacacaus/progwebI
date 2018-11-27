<%-- 
    Document   : verCategorias
    Created on : 30/09/2018, 16:07:14
    Author     : vanes
--%>

<%@page import="modelo.venda.VendaDAO"%>
<%@page import="modelo.venda.Venda"%>
<%@page import="modelo.venda.VendaNegocio"%>
<%@page import="modelo.categoria.Categoria"%>
<%@page import="modelo.categoria.CategoriaDAO"%>
<%@page import="modelo.produto.ProdutoDAO"%>
<%@page import="modelo.produto.Produto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String login = (String) session.getAttribute("login");
    VendaDAO vendaDAO = new VendaDAO();
    List<Venda> pedidos = vendaDAO.obterTodosUsuarioX(login);
    
    if (pedidos != null) {
%>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="css/header.css">
        <link rel="stylesheet" href="css/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Funcionários</title>
    </head>
    <body>
           <!-------------------------menu cliente------------------------------>
       <header>
            <div class="cabecalho">
            <h1> <img src="icons/car.png"> Ecommerce</h1>
            </div>
        <nav class="navbar navbar-light" style="background-color: #e5759b;">
            <ul class="row">
            <li class="col"><a href="chamaMainServlet">Index</a></li>
            <li class="col"><a href="meusDadosServlet">Dados</a></li>
            <li class="col"><a href="chamarListaCategoriasServlet">Categorias</a></li>
            <li class="col"><a href="chamarListarProdutosServlet">Produtos</a></li>
            <li class="col"><a href="chamarListaFuncionariosServlet">Funcionarios</a></li>
            <li class="col"><a href="chamarListaUsuariosServlet">Usuarios</a></li>
            <li class="col"><a href="chamaListaPedidos">Pedidos</a></li>
            <li class="col"><a href="LogoutServlet">Sair</a></li>
            </ul>
        </nav>
        </header>
            <!-------------------------menu cliente------------------------------>
            
            
    <div class="container borda">
        <h1 class="conteudo"><img src="icons/meeting.png"> Pedidos</h1> 
        <%
        
        %>
        <h1 class="conteudo">Olá, <%=login%>!</h1>
        <%
            String mensagem = (String) request.getAttribute("mensagem");
            if (mensagem != null) {
        %>
        <div><b><%= mensagem%></b></div>
        <%
            }
        %>
        <%
        for(Venda venda: pedidos){
        %>
        <ul class="container">
            <li class="lista"><ul class="row"> <li class="col-2 listain"><b>Id:</b> <%=venda.getId_venda() %></li><li class="col-6 listain"><b>Cliente:</b> <%= venda.getId_cliente() %></li><li class="col-2 listain"><b>Valor total: </b>R$ <%= venda.getTotal() %></li></ul></li>
        </ul>
        <%
        }
        %> 
        
        
    </body>
</html>
<%
    } else {
        request.setAttribute("mensagem", "Você não tem nenhum pedido.");
        RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
        rd.forward(request, response);
    }
%>
