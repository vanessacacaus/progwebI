<%-- 
    Document   : editarCategoria
    Created on : 01/10/2018, 15:14:34
    Author     : vanes
--%>

<%@page import="modelo.produto.Produto"%>
<%@page import="modelo.produto.ProdutoDAO"%>
<%@page import="modelo.categoria.CategoriaDAO"%>
<%@page import="java.util.List"%>
<%@page import="modelo.categoria.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    int idp = Integer.parseInt(request.getParameter("idp"));
    ProdutoDAO daop = new ProdutoDAO();
    Produto p = daop.obterProduto(idp);
    CategoriaDAO dao = new CategoriaDAO();
    List<Categoria> categorias = dao.obterTodasCategorias();
   // Categoria categoria = new Categoria();
    if (categorias != null) {
%>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="css/header.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar produtos</title>
    </head>
    <body>
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
        <div class="container borda">
        <h1 class="conteudo">Alterar produtos</h1>
        <%
            String mensagem = (String) request.getAttribute("mensagem");
            if (mensagem != null) {
        %>
        <div><b><%= mensagem%></b></div>
        <%
            }
        %>
        
        <form action="AlterarProdutoServlet">
            <p><b>Id: </b></p>
            <p><input class="form-control" type="number" readonly="true" value="<%=idp%>" name="idp"/></p>
            <p><b>Nome do produto:</b><%=p.getNome_produto() %></p>
            <p><input class="form-control" type="text" name="nome_produto"/></p>
            <p><b>Preço do produto: </b> R$ <%=p.getPreco_produto()%></p>
            <p><input class="form-control" type="number" name="preco_produto" step="0.01"/></p>
            <p><b>Categoria do produto:</b></p>
            <p><select class="form-control" name="id_categoria">
            <%
            for(Categoria categoria: categorias){
                int n = categoria.getId_categoria();
            %>
            <p> Categoria: <option value="<%=categoria.getId_categoria()%>"><%=categoria.getCategoria_descricao()%></option></p>
            <%
            }
            %>
            </select></p>
            <input class="btn" type="submit" value="Alterar"/>          
        </form>
        </div>
    </body>
</html>
<%
    } else {
        request.setAttribute("mensagem", "Erro ao passar dados");
        RequestDispatcher rd = request.getRequestDispatcher("chamarListarProdutosServlet");
        rd.forward(request, response);
    }
%>

