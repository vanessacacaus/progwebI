<%-- 
    Document   : inserirCategoria
    Created on : 30/09/2018, 14:02:30
    Author     : vanes
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.categoria.CategoriaDAO"%>
<%@page import="modelo.categoria.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    CategoriaDAO dao = new CategoriaDAO();
    List<Categoria> categorias = dao.obterTodasCategorias();
    String nomeArquivo = (String) request.getAttribute("nomeArquivo");
   // Categoria categoria = new Categoria();
    if (categorias != null) {
%>
<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="css/header.css">
        <link rel="stylesheet" href="css/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserir produto</title>
    </head>
    <body>
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
            <li class="col"><a href="chamaListaPedidos">Pedidos</a></li>
            <li class="col"><a href="LogoutServlet">Sair</a></li>
            </ul>
        </nav>
        </header>
    <!-------------------------------menu-funcionario------------------------------->
        <div class="container borda">
        <h1 class="conteudo">Inserir produto</h1>
        <%
            String mensagem = (String) request.getAttribute("mensagem");
            if (mensagem != null) {
        %>
        <div><b><%= mensagem%></b></div>
        <%
            }
        %>
        <form action="uploadImagemServlet" enctype="multipart/form-data" method="post">
            <p>Imagem do produto:</p>
            <p><input type="file" name="image" accept=".jpg"/></p> 
            <p><input class="btn" type="submit" value="Carregar"/></p>
        </form>
            
        <form action="InserirProdutoServlet">
            <p><input class="form-control" type="text" name="nomeArquivo" readonly="true" value="<%=nomeArquivo%>"/></p>
            <p>Nome do produto:</p>
            <p><input class="form-control" type="text" name="nome" value=""/></p>
            <p>Descrição do produto:</p>
            <p><input class="form-control" type="text" name="descricao_produto" value=""/></p>
            <p>Preço:</p>
            <p><input class="form-control" type="number" name="preco" step="0.01" value="0"/></p>
            <p><select class="form-control" name="id">
            <%
            for(Categoria categoria: categorias){
                int n = categoria.getId_categoria();
            %>
            <p> Categoria: <option value="<%=categoria.getId_categoria()%>"><%=categoria.getCategoria_descricao()%></option></p>
            <%
            }
            %>
            </select></p>
            
            <p><input class="btn" type="submit" value="Salvar"/></p>
        </form>
        </div>
    </body>
</html>
<%
    } else {
        request.setAttribute("mensagem", "Em breve");
        RequestDispatcher rd = request.getRequestDispatcher("meusDados.jsp");
        rd.forward(request, response);
    }
%>