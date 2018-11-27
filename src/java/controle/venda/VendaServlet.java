/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.venda;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.venda.VendaNegocio;

/**
 *
 * @author vanes
 */
public class VendaServlet extends HttpServlet {

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
        String cookieValor = "";
        
        Cookie[] cookies = request.getCookies();
        for(int i = 0; cookies != null && i < cookies.length; i++){
            Cookie c = cookies[i];
            if(c.getName().equals("pw1.cc")){
                cookieValor = c.getValue();
                break;
            }
        }
        
        String id_cliente = request.getParameter("login");
        double total = Double.parseDouble(request.getParameter("total"));
        
        VendaNegocio vendaNegocio = new  VendaNegocio();
        boolean sucessoVenda = vendaNegocio.novaVenda(id_cliente, cookieValor, total);

        if(sucessoVenda){
            request.setAttribute("mensagem", "Compra realizada com sucesso");
            request.setAttribute("msg", "success");
            RequestDispatcher rd = request.getRequestDispatcher("ApagarCarrinhoServlet"); // despacha a requisição para a página main.jsp, encaminhando as instância de request e response 
            rd.forward(request, response);
        }else{
            request.setAttribute("mensagem", "Não foi possivel realizar a compra");
            request.setAttribute("msg", "danger");
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/usuario/main.jsp"); // despacha a requisição para a página main.jsp, encaminhando as instância de request e response 
            rd.forward(request, response);
        }
        
    }

}
