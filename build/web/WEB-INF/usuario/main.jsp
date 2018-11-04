<%-- 
    Document   : main
    Created on : 12/09/2018, 15:35:24
    Author     : leoomoreira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String login = (String) session.getAttribute("login");
    if (login != null) {
%>
<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="css/header.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página Principal</title>
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
        <h2>Olá, <%= login %>!</h2>
        </div>
    </body>
</html>
<%
    } else {
        request.setAttribute("mensagem", "Você não possui um login válido");
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }
%>