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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página Principal</title>
    </head>
    <body>
    <%
        if(tipo.equals("funcionario")){
    %>
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
    <%
        }
    %>
    <%
        if(tipo.equals("usuario")){
    %>
        <header>
            <div class="cabecalho">
            <h1> <img src="icons/car.png"> Ecommerce</h1>
            </div>
        <nav class="navbar navbar-light" style="background-color: #e5759b;">
            <ul class="row">
            <li class="col"><a href="chamaMainServlet">Index</a></li>
            <li class="col"><a href="meusDadosServlet">Dados</a></li>
            <li class="col"><a href="LogoutServlet">Sair</a></li>
            
            <li class="col"><a href="VerCarrinhoServlet"><img src="icons/shopping.png"></a></li>
            </ul>
        </nav>
        </header>
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
                    <div class="row">  
                        <div class="col">
                    <div class="card" style="width: 18rem;">
                            <img class="card-img-top" src="imgProdutos/<%=produto.getImagem_produto()%>" alt="<%= produto.getNome_produto() %>">
                            <div class="card-body">
                                <h5 class="card-title"><b>Cod: 000<%= produto.getId_produto() %> - <%= produto.getNome_produto() %></b></h5>
                              <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                              <p>R$ <%= produto.getPreco_produto() %> - <i><%=categoria.getCategoria_descricao() %></i></p>

                              <form action="AdicionarCarrinhoServlet">
                                  <p><input type="hidden" name="id_produto" value="<%= produto.getId_produto()%>"></p>
                                  <p>Unidade(s): <input type="number" name="quantidade" step="1" value="1"/></p>
                                  <p><input class="btn" type="submit" value="Adicionar"/></p>
                              </form>
                            </div>
                    </div></div></div>


                    </ul>

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
%>