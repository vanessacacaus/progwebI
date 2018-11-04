<%-- 
    Document   : cadastroUsuario
    Created on : 17/09/2018, 23:20:34
    Author     : vanes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="css/header.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro</title>
    </head>
    <body>
        <header>
            <div class="cabecalho">
            <h1> <img src="icons/car.png"> Ecommerce</h1>
            </div>
            <nav class="navbar navbar-light" style="background-color: #e5759b;">
                <ul class="row">
                    <li class="col"><a href="index.jsp">Index</a></li>
                    <li class="col"><a href="listaProdutosCliente.jsp">Produtos</a></li>
                </ul>
            </nav>
        </header>
        <div class="container borda">
        <h1 class="conteudo"><img src="icons/user.png"> Cadastro</h1>
        <form action="cadastroUsuarioServlet" method="post">
            <p>Nome:</p>
            <p><input class="form-control" type="text" name="nome" /></p>
            <p>Nome de usuário:</p>
            <p><input class="form-control" type="text" name="login" /></p>
            <p>Senha:</p>
            <p><input class="form-control" type="password" name="senha" /></p>
            <p><input class="btn" type="submit" value="Salvar" /></p>
        </form>
        <%
            String mensagem = (String) request.getAttribute("mensagem"); //retorna a mensagem de cadastro bem sucedido ou falho
            if (mensagem != null) {
        %>
        <div class="alert alert-success" role="alert">
            <b><%= mensagem%></b>
        </div>
        <%
            }
        %>
        </div>
    </body>
</html>
