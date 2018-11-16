<%-- 
    Document   : index
    Created on : 12/09/2018, 15:28:30
    Author     : leoomoreira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="css/header.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

        <title>Página de Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>        
        <header>
            <div class="cabecalho">
            <h1> <img src="icons/car.png"> Ecommerce</h1>
            </div>
            <nav class="navbar navbar-light" style="background-color: #e5759b;">
                <ul class="row">
                    <li class="col"><a href="index.jsp">Index</a></li>
                    <li class="col"><a href="login.jsp">Login</a></li>
                    <li class="col"><a href="VerCarrinhoServlet"><img src="icons/shopping.png"></a></li>
                </ul>
            </nav>
        </header>
        <div class="container borda">
        <h1 class="conteudo"> <img src="icons/user.png"> Login</h1>
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
        <form action="LoginServlet" method="post">
            <p>Nome de usuário:</p>
            <p><input class="form-control" type="text" name="login" /></p>
            <p>Senha:</p>
            <p><input class="form-control" type="password" name="senha" /></p>
                    <p><input type="radio" name="tipo" value="usuario"> Usuário</p>
                    <p><input type="radio" name="tipo" value="funcionario" checked> Funcionário</p>
            <p><input class="btn" type="submit" value="Entrar"/></p>
        </form>
        <p><a href="cadastroUsuario.jsp">Cadastre-se</a></p>
        </div>
    </body>
</html>
