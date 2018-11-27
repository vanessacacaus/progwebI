/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.venda;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.venda.VendaNegocio;

/**
 *
 * @author vanes
 */
public class CancelaVendaServlet extends HttpServlet {

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
            int id_venda = Integer.parseInt(request.getParameter("id_venda"));
            
            VendaNegocio vendaNegocio = new VendaNegocio();
            
            boolean sucessoExcluir = vendaNegocio.cancelarVenda(id_venda);
            
            if(sucessoExcluir){
                request.setAttribute("mensagem", "Compra cancelada com sucesso");
                request.setAttribute("msg", "success");
                RequestDispatcher rd = request.getRequestDispatcher("chamaListaPedidos"); // despacha a requisição para a página main.jsp, encaminhando as instância de request e response 
                rd.forward(request, response);
            }else{
                request.setAttribute("mensagem", "Não foi possivel cancelar a compra");
                request.setAttribute("msg", "danger");
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/funcionario/listaPedidos.jsp"); // despacha a requisição para a página main.jsp, encaminhando as instância de request e response 
                rd.forward(request, response);
                }
            
    }
}
