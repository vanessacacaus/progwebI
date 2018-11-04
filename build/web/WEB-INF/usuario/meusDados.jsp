<%-- 
    Document   : meusDados
    Created on : 28/09/2018, 11:49:38
    Author     : vanes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String login = (String) session.getAttribute("login");
    String nome = (String) session.getAttribute("nome");
    if (login != null) {
%>
<!DOCTYPE html>
<html>
    <head>
         <link type="text/css" rel="stylesheet" href="css/header.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Meus dados</title>
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
        <h1 class="conteudo"><img src="icons/user.png"> Dados Pessoais</h1>
        <p><b>Login:</b> <%= login %></p>
        <p><b>Nome:</b> <%= nome %></p>

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
        <p><a href="editarDados">Editar</a></p>
        <p><a href="excluirUsuario">Excluir</a></p>
        </div>
    </body>

</html>
<%
    } else {
        request.setAttribute("mensagem", "Em breve");
        RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
        rd.forward(request, response);
    }
%>
