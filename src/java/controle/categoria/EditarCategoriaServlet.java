/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.categoria;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.categoria.CategoriaNegocio;

/**
 *
 * @author vanes
 */
public class EditarCategoriaServlet extends HttpServlet {

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

                int id = Integer.parseInt(request.getParameter("id"));
                String descricao_categoria = request.getParameter("descricao");
                    
                CategoriaNegocio categoriaNegocio = new CategoriaNegocio();
                
                boolean sucessoAlterar = categoriaNegocio.alterarCategoria(descricao_categoria, id);
                    if (sucessoAlterar) { 
                        request.setAttribute("mensagem", "Sucesso ao atualizar categoria"); 
                        RequestDispatcher rd = request.getRequestDispatcher("chamarListaCategoriasServlet"); 
                        rd.forward(request, response);
                    } else {
                        request.setAttribute("mensagem", "Erro ao atualizar categoria"); 
                        RequestDispatcher rd = request.getRequestDispatcher("chamarEditarCategoriasServlet"); 
                        rd.forward(request, response);
                    }                
            }

}
