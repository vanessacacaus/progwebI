<%-- 
    Document   : meusDados
    Created on : 28/09/2018, 11:49:38
    Author     : vanes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String login = (String) session.getAttribute("login");
    String nome = (String) session.getAttribute("nome");
    String tipo = (String) session.getAttribute("tipo");
    if (login != null) {
%>
<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="css/header.css">
        <link rel="stylesheet" href="css/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Excluir dados</title>
    </head>
    <body> 
      
    <!-----------------------------------------------------------------------------------
                                    Header inicia aqui
    ------------------------------------------------------------------------------------>
    
    <%
        if(tipo.equals("funcionario")){
    %>
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
            <li class="col"><a href="chamarListaUsuariosServlet">Usuarios</a></li>
            <li class="col"><a href="chamaListaPedidos">Pedidos</a></li>
            <li class="col"><a href="LogoutServlet">Sair</a></li>
            </ul>
        </nav>
        </header>
    <!-------------------------------menu-funcionario------------------------------->
    <%
        }
    %>
    <%
        if(tipo.equals("usuario")){
    %>
           <!-------------------------menu cliente------------------------------>
        <header>
            <div class="cabecalho">
            <h1> <img src="icons/car.png"> Ecommerce</h1>
            </div>
        <nav class="navbar navbar-light" style="background-color: #e5759b;">
            <ul class="row">
            <li class="col"><a href="chamaMainServlet">Index</a></li>
            <li class="col"><a href="meusDadosServlet">Dados</a></li>
            <li class="col"><a href="chamaMeusPedidos">Meus Pedidos</a></li>
            <li class="col"><a href="VerCarrinhoServlet?login="<%=login%>><img src="icons/shopping.png"></a></li>
            <li class="col"><a href="LogoutServlet">Sair</a></li>
        </ul>
        </nav>
        </header>
            <!-------------------------menu cliente------------------------------>
    <%
        }
    %>
    
    
    
    
    
    <!---------------------------------------------------------------------------
    Header acaba aqui
    ------------------------------------------------------------------------------------>
    
      
        <div class="container borda"> 
        <form action="ExcluirUsuarioServlet" method="post">
            <h1 class="conteudo"><img src="icons/bin.png"> Excluir usuário</h1>
        <%
            String mensagem = (String) request.getAttribute("mensagem");
            if (mensagem != null) {
        %>
        <div><b><%= mensagem%></b></div>
        <%
            }
        %>
            
        <p><b>Login: </b><%= login %></p>
        <p><b>Nome: </b><%= nome %>:</p><br>
            <p>Digite a senha para excluir:</p>
            <p><input class="form-control" type="password" name="senha" /></p>
            <p><input class="btn" type="submit" value="Excluir" /></p>
        </form>
        </div>
    </body>
</html>
<%
    } else {
        request.setAttribute("mensagem", "Erro ao passar dados");
        RequestDispatcher rd = request.getRequestDispatcher("meusDados.jsp");
        rd.forward(request, response);
    }
%>
