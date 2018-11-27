<%-- 
    Document   : verCategorias
    Created on : 30/09/2018, 16:07:14
    Author     : vanes
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.categoria.Categoria"%>
<%@page import="modelo.categoria.CategoriaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    CategoriaDAO dao = new CategoriaDAO();
    List<Categoria> categorias = dao.obterTodasCategorias();
    
    if (categorias != null) {
%>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="css/header.css">
        <link rel="stylesheet" href="css/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categorias</title>
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
            <h1 class="conteudo"> <img src="icons/checked.png"> Categorias</h1>      
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
        for(Categoria categoria: categorias){
            int n = categoria.getId_categoria();
        %>
        <ul class="container">
            <li class="lista"><ul class="row"><li class="col listain"><b>Id:</b> <%= categoria.getId_categoria()%></li><li class="col-9 listain"><b>Descrição:</b> <%= categoria.getCategoria_descricao()%></li><li class="col listain"><a href="chamarEditarCategoriaServlet?id=<%=categoria.getId_categoria()%>"><img src="icons/edit.png" alt="alterar categoria"></a></li><li class="col listain"><a href="ExcluirCategoriaServlet?id=<%=categoria.getId_categoria()%>"><img src="icons/delete.png" alt="excluir categoria"></a></li></ul></li> 
        </ul>
        <%
        }
        %>
        
        
        <p><a href="chamarInserirCategoriaServlet">Inserir categoria</a></p>
        </div>
    </body>
</html>
<%
    } else {
        request.setAttribute("mensagem", "Você não tem nenhuma categoria");
        RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
        rd.forward(request, response);
    }
%>
