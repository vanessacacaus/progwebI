<%-- 
    Document   : verCategorias
    Created on : 30/09/2018, 16:07:14
    Author     : vanes
--%>

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
    FuncionarioDAO dao = new FuncionarioDAO();
    List<Funcionario> funcionarios = dao.obterTodosFuncionarios();
    
    if (funcionarios != null) {
%>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="css/header.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Funcionários</title>
    </head>
    <body>
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
            <li class="col"><a href="LogoutServlet">Sair</a></li>
            </ul>
        </nav>
        </header>
    <div class="container borda">
        <h1 class="conteudo"><img src="icons/meeting.png"> Funcionários</h1>       
        <%
            String mensagem = (String) request.getAttribute("mensagem");
            if (mensagem != null) {
        %>
        <div><b><%= mensagem%></b></div>
        <%
            }
        %>
        <%
        for(Funcionario funcionario: funcionarios){
        %>
        <ul class="container">
            <li class="lista"><ul class="row"> <li class="col-2 listain"><b>Id:</b> <%= funcionario.getLogin_funcionario() %></li><li class="col-6 listain"><b>Nome:</b> <%= funcionario.getNome_funcionario() %></li><li class="col-2 listain"><b>Salário:</b> <%= funcionario.getSalario_funcionario() %></li><li class="col listain"><a href="chamarEditarFuncionarioServlet?login_funcionario=<%= funcionario.getLogin_funcionario() %>"><img src="icons/edit.png"></a></li><li class="col listain"><a href="ExcluirFuncionarioServlet?login_funcionario=<%= funcionario.getLogin_funcionario() %>"><img src="icons/delete.png"></a> </li></ul></li>
        </ul>
        <%
        }
        %>
        
        <br><p><a href="chamaInserirFuncionarioServlet">Inserir funcionário</a></p>
    </body>
</html>
<%
    } else {
        request.setAttribute("mensagem", "Você não tem nenhum funciomário.");
        RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
        rd.forward(request, response);
    }
%>
