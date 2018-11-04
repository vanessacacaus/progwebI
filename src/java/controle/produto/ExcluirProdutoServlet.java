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
public class ExcluirProdutoServlet extends HttpServlet {

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
            int idp = Integer.parseInt(request.getParameter("idp"));
            
            ProdutoNegocio produtoNegocio = new ProdutoNegocio();
            boolean sucessoExcluir = produtoNegocio.excluirProduto(idp);
            if(sucessoExcluir){ 
                    request.setAttribute("mensagem", "Produto excluído com sucesso");
                    RequestDispatcher rd = request.getRequestDispatcher("chamarListarProdutosServlet"); 
                    rd.forward(request, response);
                } else {
                    request.setAttribute("mensagem", "Erro ao excluir produto"); 
                    RequestDispatcher rd = request.getRequestDispatcher("chamarListarProdutosServlet"); 
                    rd.forward(request, response);
                } 
            
    }
}
