<%-- 
    Document   : editarCategoria
    Created on : 01/10/2018, 15:14:34
    Author     : vanes
--%>

<%@page import="modelo.categoria.CategoriaDAO"%>
<%@page import="modelo.categoria.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%int id = Integer.parseInt(request.getParameter("id"));
    Categoria cat = new Categoria();
    CategoriaDAO dao = new CategoriaDAO();
    cat = dao.obterCategoria(id);
%>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="css/header.css">
        <link rel="stylesheet" href="css/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar categoria</title>
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
        <h1 class="conteudo"><img src="icons/checked.png"> Alterar categoria</h1>
        <%
            String mensagem = (String) request.getAttribute("mensagem");
            if (mensagem != null) {
        %>
        <div><b><%= mensagem%></b></div>
        <%
            }
        %>
        
        <form action="EditarCategoriaServlet">
            <p><input class="form-control" type="number" readonly="true" value="<%=id%>" name="id"/></p>
            <p><b>Descrição atual: </b><%= cat.getCategoria_descricao()%></p>
            <p>Nova descrição: </p>
            <p><input class="form-control" type="text" name="descricao"/></p>
            <p><input class="btn" type="submit" value="Alterar"/></p>
            
        </form>
        </div>
    </body>
</html>

