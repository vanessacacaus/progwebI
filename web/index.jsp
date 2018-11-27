<%-- 
    Document   : verCategorias
    Created on : 30/09/2018, 16:07:14
    Author     : Vanessa Cacau
    Co-Authors  : Leonardo Moreira, Amanda Lima
--%>

<%@page import="modelo.carrinho.CarrinhoComprasItem"%>
<%@page import="modelo.categoria.Categoria"%>
<%@page import="modelo.categoria.CategoriaDAO"%>
<%@page import="modelo.produto.ProdutoDAO"%>
<%@page import="modelo.produto.Produto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    CategoriaDAO daoc = new CategoriaDAO();
    ProdutoDAO dao = new ProdutoDAO();
    List<Produto> produtos = dao.obterTodosProdutos();
    
    if (produtos != null) {
%>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="css/header.css">
        <link rel="stylesheet" href="css/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ecommerce</title>
    </head>
    <body>
        <!------------------------------header deslogado------------------------------------->
        <header>
            <div class="cabecalho">
            <h1> <img src="icons/car.png"> Ecommerce</h1>
            </div>
            <nav class="navbar navbar-light" style="background-color: #e5759b;">
                <ul class="row">
                    <li class="col"><a href="index.jsp">Index</a></li>
                    <li class="col"><a href="login.jsp">Login</a></li>
                    <li class="col"><a href="VerCarrinhoServlet"><img class="sacola" src="icons/shopping.png"></a></li>
                </ul>
            </nav>
        </header>
        <!------------------------------header deslogado------------------------------------->
        
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
        <h1 class="conteudo"><img src="icons/price.png"> Produtos</h1>        
        
        <%
        for(Produto produto: produtos){
        %>
        <% Categoria categoria = daoc.obterCategoria(produto.getId_categoria()); %>
        
        
        <!-----------------------------card-produtos---------------------------------->
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
        }
        %>
        
        
        </div>
    </body>
</html>
<%
    } else {
        request.setAttribute("mensagem", "Você não tem produtos");
        RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
        rd.forward(request, response);
    }
%>
