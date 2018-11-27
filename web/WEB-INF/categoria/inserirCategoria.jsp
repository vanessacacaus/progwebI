<%-- 
    Document   : inserirCategoria
    Created on : 30/09/2018, 14:02:30
    Author     : vanes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="css/header.css">
        <link rel="stylesheet" href="css/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserir categoria</title>
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
            <h1 class="conteudo"><img src="icons/checked.png"> Inserir categoria</h1>
        <%
            String mensagem = (String) request.getAttribute("mensagem");
            if (mensagem != null) {
        %>
        <div><b><%= mensagem%></b></div>
        <%
            }
        %>
        <form action="InserirCategoriaServlet">
            <p><b>Descrição da categoria:</b></p>
            <p><input class="form-control" type="text" name="descricao"/></p>
            <p><input class="btn" type="submit" value="Salvar"/></p>
        </form>
        </div>
    </body>
</html>
