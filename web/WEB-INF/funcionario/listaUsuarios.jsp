<%-- 
    Document   : verCategorias
    Created on : 30/09/2018, 16:07:14
    Author     : vanes
--%>

<%@page import="modelo.usuario.Usuario"%>
<%@page import="modelo.usuario.UsuarioDAO"%>
<%@page import="modelo.funcionario.FuncionarioDAO"%>
<%@page import="modelo.funcionario.Funcionario"%>
<%@page import="modelo.categoria.Categoria"%>
<%@page import="modelo.categoria.CategoriaDAO"%>
<%@page import="modelo.produto.ProdutoDAO"%>
<%@page import="modelo.produto.Produto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    UsuarioDAO dao = new UsuarioDAO();
    List<Usuario> usuarios = dao.obterTodos();
    
    if (usuarios != null) {
%>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="css/header.css">
        <link rel="stylesheet" href="css/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios</title>
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
        <h1 class="conteudo"><img src="icons/meeting.png"> Usuários</h1>       
        <%
            String mensagem = (String) request.getAttribute("mensagem");
            if (mensagem != null) {
        %>
        <div><b><%= mensagem%></b></div>
        <%
            }
        %>
        <%
        for(Usuario usuario: usuarios){
        %>
        <ul class="container">
            <li class="lista"><ul class="row"> <li class="col-2 listain"><b>Id:</b> <%= usuario.getLogin() %></li><li class="col-6 listain"><b>Nome:</b> <%= usuario.getNome() %></li><li class="col listain"><a href="ExcluirUsuarioFuncionarioServlet?login=<%= usuario.getLogin() %>"><img src="icons/delete.png"></a> </li></ul></li>
        </ul>
        <%
        }
        %>
        
    </body>
</html>
<%
    } else {
        request.setAttribute("mensagem", "Você não tem nenhum funciomário.");
        RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
        rd.forward(request, response);
    }
%>
