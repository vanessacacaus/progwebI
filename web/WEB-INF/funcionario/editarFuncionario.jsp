<%-- 
    Document   : insereFuncionario
    Created on : 03/10/2018, 16:05:12
    Author     : vanes
--%>

<%@page import="modelo.funcionario.FuncionarioDAO"%>
<%@page import="modelo.funcionario.Funcionario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String login_funcionario = request.getParameter("login_funcionario");
    
    if(login_funcionario != null){
%>
<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="css/header.css">
        <link rel="stylesheet" href="css/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar funcionario</title>
    </head>
    <body
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
        <h1 class="conteudo"><img src="icons/meeting.png"> Alterar funcionário</h1>
        <%
            String mensagem = (String) request.getAttribute("mensagem");
            if (mensagem != null) {
        %>
        <div><b><%= mensagem%></b></div>
        <%
            }
        %>
        
        <form action="AlterarFuncionarioServlet">
            <%
                Funcionario func = new Funcionario();
                FuncionarioDAO dao = new FuncionarioDAO();
                func = dao.obterFuncionario(login_funcionario);
            %>
            <p><b>Id:</b></p>
            <p><input class="form-control" type="text" readonly="true" value="<%=login_funcionario%>" name="login_funcionario"/></p>
            <p><b>Nome:</b></p>
            <p><input class="form-control" type="text" name="nome_funcionario" value="<%=func.getNome_funcionario()%>"/></p>
            <p><b>Senha:</b></p>
            <p><input class="form-control" type="password" name="senha_nova"/></p>
            <p><b>Salário:</b></p>
            <p><input class="form-control" type="number" name="salario_funcionario" step="0.01" value="<%=func.getSalario_funcionario()%>"/></p>
            <br><br>
            <p>Digite a senha antiga para continuar:</p>
            <p><input class="form-control" type="password" name="senha_funcionario"/></p>
            <p><input class="btn" type="submit" value="Cadastrar"/></p>
        </form>
        </div>
    </body>
</html>
<%
} else {
        request.setAttribute("mensagem", "Erro ao passar dados");
        RequestDispatcher rd = request.getRequestDispatcher("listaFuncionarios.jsp");
        rd.forward(request, response);
    }
%>
