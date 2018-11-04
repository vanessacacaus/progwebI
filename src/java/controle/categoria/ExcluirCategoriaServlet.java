/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.categoria;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.categoria.Categoria;
import modelo.categoria.CategoriaNegocio;

/**
 *
 * @author vanes
 */
public class ExcluirCategoriaServlet extends HttpServlet {

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
            
                HttpSession session = request.getSession();
                
                //        int op = Integer.parseInt(request.getParameter("operador"));
                int id =  Integer.parseInt(request.getParameter("id"));
                
                CategoriaNegocio categoriaNegocio = new CategoriaNegocio();
                boolean sucessoExcluir = categoriaNegocio.excluirCategoria(id);
                
                if (sucessoExcluir) { // caso o login e senha estejam corretos
                    request.setAttribute("mensagem", "excluído com sucesso"); // coloca o atributo login na sessão do usuário
                    RequestDispatcher rd = request.getRequestDispatcher("chamarListaCategoriasServlet"); // despacha a requisição para a página main.jsp, encaminhando as instância de request e response 
                    rd.forward(request, response);
                } else {
                    request.setAttribute("mensagem", "erro ao excluir"); // coloca uma mensagem no objeto request
                    RequestDispatcher rd = request.getRequestDispatcher("chamarListaCategoriasServlet"); // despacha a requisição para a página index.jsp, encaminhando as instância de request e response
                    rd.forward(request, response);
                }
                

    
    
    }

}
