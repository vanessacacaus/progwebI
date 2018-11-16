/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.produto;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.produto.ProdutoNegocio;

/**
 *
 * @author vanes
 */
public class AlterarProdutoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
                String nome_produto = request.getParameter("nome_produto");
                String descricao_produto = request.getParameter("descricao_produto");
                double preco_produto = Double.parseDouble(request.getParameter("preco_produto"));
                int id_categoria = Integer.parseInt(request.getParameter("id_categoria"));
                int idp = Integer.parseInt(request.getParameter("idp"));
                String imagem_produto = request.getParameter("nomeArquivo");
                
                ProdutoNegocio produtoNegocio = new ProdutoNegocio();
                
                boolean sucessoAlterar = produtoNegocio.alterarProduto(idp, nome_produto, preco_produto, id_categoria, imagem_produto, descricao_produto);
                if (sucessoAlterar) { 
                    request.setAttribute("mensagem", "Produto alterado com sucesso");
                    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/produto/listaProdutos.jsp"); 
                    rd.forward(request, response);
                } else {
                    request.setAttribute("mensagem", "Erro ao alterar produto"); 
                    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/produto/alterarProduto.jsp"); 
                    rd.forward(request, response);
                } 
                
    }

}
