<%-- 
    Document   : verCategorias
    Created on : 30/09/2018, 16:07:14
    Author     : vanes
--%>

<%@page import="modelo.categoria.Categoria"%>
<%@page import="modelo.categoria.CategoriaDAO"%>
<%@page import="modelo.produto.ProdutoDAO"%>
<%@page import="modelo.produto.Produto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    CategoriaDAO daoc = new CategoriaDAO();
    ProdutoDAO dao = new ProdutoDAO();
    List<Produto> produtos = dao.obterTodosProdutos();
    
    if (produtos != null) {
%>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="css/header.css">
        <link rel="stylesheet" href="css/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produtos</title>
    </head>
    <body>
    <!-------------------------------menu-funcionario------------------------------->
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
            <li class="col"><a href="chamaListaPedidos">Pedidos</a></li>
            <li class="col"><a href="LogoutServlet">Sair</a></li>
            </ul>
        </nav>
        </header>
    <!-------------------------------menu-funcionario------------------------------->
        <div class="container borda">
        <h1 class="conteudo"><img src="icons/price.png"> Produtos</h1>
        <%
            String mensagem = (String) request.getAttribute("mensagem");
            if (mensagem != null) {
        %>
        <div class="alert alert-success" role="alert">
            <b><%= mensagem%></b>
        </div>
        <%
            }
        %>
        <%
        for(Produto produto: produtos){
        %>
        <% Categoria categoria = daoc.obterCategoria(produto.getId_categoria()); %>
        <ul class="container">
            <li class="lista"><ul class="row"> <li class="col-1 listain"><b>Id: </b> <%= produto.getId_produto() %></li><li class="col-3 listain"><b>Produto: </b><%= produto.getNome_produto() %></li><li class="col-2 listain"><b>Preço: </b> R$ <%= produto.getPreco_produto() %></li><li class="col listain"><b>Categoria: </b><%=categoria.getCategoria_descricao() %></li><li class="col-1 listain"><a href="chamarEditarProdutoServlet?idp=<%= produto.getId_produto() %>"><img src="icons/edit.png"></a></li><li class="col-1 listain"><a href="ExcluirProdutoServlet?idp=<%=produto.getId_produto()%>"><img src="icons/delete.png"></a></li></ul></li>
        </ul>
        <%
        }
        %>
        
        <br><p><a href="chamarInserirProdutoServlet">Inserir produto</a></p>
        </div>
    </body>
</html>
<%
    } else {
        request.setAttribute("mensagem", "Você não tem produtos");
        RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
        rd.forward(request, response);
    }
%>
