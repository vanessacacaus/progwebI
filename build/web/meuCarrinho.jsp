<%-- 
    Document   : verCategorias
    Created on : 30/09/2018, 16:07:14
    Author     : vanes
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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produtos</title>
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
        <%
            List<CarrinhoComprasItem> carrinhoCompras = (List<CarrinhoComprasItem>) request.getAttribute("carrinhoCompras");
            if(carrinhoCompras != null && carrinhoCompras.size() > 0)
            {
        %>
        <h1 class="conteudo"><img src="icons/cart.png"> Carrinho de compras</h1>
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
        <%
            double total = 0;
            for(CarrinhoComprasItem cci: carrinhoCompras){
                Produto produto = cci.getProduto();
                CategoriaDAO catDAO = new CategoriaDAO();
                Categoria categoria = catDAO.obterCategoria(produto.getId_categoria());
        %>

            <div class="card" style="width: 18rem;">
                <img class="card-img-top" src="imgProdutos/<%=produto.getImagem_produto()%>" alt="<%= produto.getNome_produto() %>">
                <div class="card-body">
                    <h5 class="card-title"><b><%= produto.getId_produto() %> - <%= produto.getNome_produto() %></b></h5>
                  <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                  <p>R$ <%= produto.getPreco_produto() %> - <i><%=categoria.getCategoria_descricao() %></i></p>
                  
                  <form action="AdicionarCarrinhoServlet">
                      <p><input type="hidden" name="id_produto" value="<%= produto.getId_produto()%>"></p>
                      <p>Unidade(s): <input type="number" name="quantidade" step="1" value="1"/></p>
                      <p><input class="btn" type="submit" value="Adicionar"/></p>
                  </form>
                </div>
            </div>
        
        <%
        }
}
        %>
        
        
        </div>
    </body>
</html>
<%
    } else {
        request.setAttribute("mensagem", "Você não tem produtos no carrinho");
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }
%>
