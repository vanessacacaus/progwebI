<%-- 
    Document   : main
    Created on : 12/09/2018, 15:35:24
    Author     : leoomoreira
--%>


<%@page import="java.util.List"%>
<%@page import="modelo.produto.ProdutoDAO"%>
<%@page import="modelo.categoria.CategoriaDAO"%>
<%@page import="modelo.categoria.Categoria"%>
<%@page import="modelo.produto.Produto"%>
<%@page import="modelo.usuario.UsuarioNegocio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
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
        
        <div class="container borda">
            <h1 class="conteudo">Olá, <%=login%>!</h1>
            
        <%
                CategoriaDAO daoc = new CategoriaDAO();
                ProdutoDAO dao = new ProdutoDAO();
                List<Produto> produtos = dao.obterTodosProdutos();
    
                if (produtos != null) {

                    for(Produto produto: produtos){
                    %>
                    <% Categoria categoria = daoc.obterCategoria(produto.getId_categoria()); %>

        <!-----------------------------card-produtos---------------------------------->
      <%
          if(tipo.equals("usuario")){
      %>      
        <div class="larguraProds">
            <h5 class="card-header bg-transparent bordinha row"><b>Cod: 000<%= produto.getId_produto() %> - <%= produto.getNome_produto() %></b></h5>
        <div class="card-body bg-transparent bordinha row">
            <img class="produtos imgProd" src="imgProdutos/<%=produto.getImagem_produto()%>" alt="<%= produto.getNome_produto() %>">
                <div class="col-6"><%= produto.getDescricao_produto() %></div>
                <div class="col-2">R$ <%= produto.getPreco_produto() %></div>
                <div class="col-2"><i><%=categoria.getCategoria_descricao() %></i></div>
        </div> 
        <div class="card-footer bg-transparent bordinha row">
                  <form action="AdicionarCarrinhoServlet">
                      <input type="hidden" name="id_produto" value="<%= produto.getId_produto()%>">
                      Unidade(s): <input type="number" name="quantidade" step="1" value="1"/>
                      <input class="btn" type="submit" value="Adicionar"/>
                  </form>
        </div>
        </div> 
        <br>
        <!-----------------------------card-produtos---------------------------------->
        <%
        } else if(tipo.equals("funcionario")){
        %>
        <div class="larguraProds">
            <h5 class="card-header bg-transparent bordinha row"><b>Cod: 000<%= produto.getId_produto() %> - <%= produto.getNome_produto() %></b></h5>
        <div class="card-body bg-transparent bordinha row">
            <img class="produtos imgProd" src="imgProdutos/<%=produto.getImagem_produto()%>" alt="<%= produto.getNome_produto() %>">
                <div class="col-6"><%= produto.getDescricao_produto() %></div>
                <div class="col-2">R$ <%= produto.getPreco_produto() %></div>
                <div class="col-2"><i><%=categoria.getCategoria_descricao() %></i></div>
        </div> 
        </div> 
        <br>        
        <%
        }
        %>
        
        <%
                    }
            }
        %>
        </div>
    </body>
</html>
<%
    } else {
        request.setAttribute("mensagem", "Você não possui um login válido");
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }
%>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           