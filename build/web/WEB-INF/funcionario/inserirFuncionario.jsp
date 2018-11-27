<%-- 
    Document   : insereFuncionario
    Created on : 03/10/2018, 16:05:12
    Author     : vanes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="css/header.css">
        <link rel="stylesheet" href="css/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar funcionario</title>
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
        <h1 class="conteudo"><img src="icons/meeting.png"> Cadastro funcionário</h1>
        <%
            String mensagem = (String) request.getAttribute("mensagem");
            if (mensagem != null) {
        %>
        <div><b><%= mensagem%></b></div>
        <%
            }
        %>
        
        <form action="InserirFuncionarioServlet">
            <p>Nome:</p>
            <p><input class="form-control" type="text" name="nome_funcionario"/></p>
            <p>Login:</p>
            <p><input class="form-control" type="text" name="login_funcionario"/></p>
            <p>Senha:</p>
            <p><input class="form-control" type="password" name="senha_funcionario"/></p>
            <p>Salário:</p>
            <p><input class="form-control" type="number" name="salario_funcionario" step="0.01"/></p>
            <p><input class="btn" type="submit" value="Cadastrar"/></p>
        </form>
        </div>
    </body>
</html>
