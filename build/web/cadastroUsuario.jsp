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
        <link rel="stylesheet" href="css/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro</title>
    </head>
    <body>
        <!----------------------------menu não logado inicio------------------------------------>
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
        <!----------------------------menu não logado fim------------------------------------>
        
        
        <div class="container borda">
        <h1 class="conteudo"><img src="icons/user.png"> Cadastro</h1>
       
        
        
       <!----------------------inicio mensagem-------------------------------->
        <%
            String mensagem = (String) request.getAttribute("mensagem");
            String msg = (String) request.getAttribute("msg");
            if (mensagem != null && msg.equals("success")) {
        %>
        <div class="alert alert-success" role="alert">
            <b><%= mensagem%></b>
        </div>
        <%
            } else if(mensagem != null && msg.equals("danger")) {
        %>
        <div class="alert alert-danger" role="alert">
            <b><%= mensagem%></b>
        </div>
        <%
        }
        %>
        <!----------------------fim mensagem-------------------------------->
        
        <form action="cadastroUsuarioServlet" method="post">
            <p>Nome:</p>
            <p><input class="form-control" type="text" name="nome" /></p>
            <p>Nome de usuário:</p>
            <p><input class="form-control" type="text" name="login" /></p>
            <p>Senha:</p>
            <p><input class="form-control" type="password" name="senha" /></p>
            <p><input class="btn" type="submit" value="Salvar" /></p>
        </form>
        </div>
    </body>
</html>
