<%-- 
    Document   : main
    Created on : 12/09/2018, 15:35:24
    Author     : leoomoreira
--%>


<%@page import="modelo.funcionario.FuncionarioNegocio"%>
<%@page import="modelo.usuario.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="modelo.produto.ProdutoDAO"%>
<%@page import="modelo.categoria.CategoriaDAO"%>
<%@page import="modelo.categoria.Categoria"%>
<%@page import="modelo.produto.Produto"%>
<%@page import="modelo.usuario.UsuarioNegocio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  
    UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
    FuncionarioNegocio funcionarioNegocio = new FuncionarioNegocio();
    String login = (String) session.getAttribute("login");
    String tipo = (String) session.getAttribute("tipo");
        if (login != null) {
%>
<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="css/header.css">
        <link rel="stylesheet" href="css/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página Principal</title>
    </head>
    <body>
    <!---------------------------------------------------------------------------
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
        
        <div class="container borda">
            <h1 class="conteudo">Olá, <%=login%>!</h1>
        <p><b>Login:</b> <%= login %></p>
        <%
            if(tipo.equals("usuario")){
                String nome = usuarioNegocio.obterUsuario(login).getNome();
        %>
        <p><b>Nome:</b> <%= nome %></p>
        <%
        } else if(tipo.equals("funcionario")){
                String nomeF = funcionarioNegocio.obterFuncionario(login).getNome_funcionario();

        %>
        <p><b>Nome:</b> <%= nomeF %></p>
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
        request.setAttribute("mensagem", "Você não possui um login válido");
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }
%>