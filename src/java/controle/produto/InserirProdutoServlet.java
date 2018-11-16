/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.produto;

import java.io.IOException;
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
public class InserirProdutoServlet extends HttpServlet {

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
        
                String nome = request.getParameter("nome");
                String descricao_produto = request.getParameter("descricao_produto");
                double preco = Double.parseDouble(request.getParameter("preco"));
                int id = Integer.parseInt(request.getParameter("id"));
                String imagem_produto = request.getParameter("nomeArquivo");
                
                ProdutoNegocio produtoNegocio = new ProdutoNegocio();
                boolean sucessoInserir = produtoNegocio.inserirProduto(nome, preco, id, imagem_produto, descricao_produto);
                
                if (sucessoInserir) { 
                    request.setAttribute("mensagem", "Produto inserido com sucesso");
                    RequestDispatcher rd = request.getRequestDispatcher("chamarListarProdutosServlet"); 
                    rd.forward(request, response);
                } else {
                    request.setAttribute("mensagem", "Erro ao inserir produto"); 
                    RequestDispatcher rd = request.getRequestDispatcher("chamarInserirProdutoServlet"); 
                    rd.forward(request, response);
                } 
                
                
    }

}
