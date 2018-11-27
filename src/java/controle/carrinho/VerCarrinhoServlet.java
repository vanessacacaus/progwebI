/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.carrinho;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.carrinho.CarrinhoComprasItem;
import modelo.carrinho.CarrinhoNegocio;

/**
 *
 * @author vanes
 */
public class VerCarrinhoServlet extends HttpServlet {

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
        
        //captura a string do cookie presente e mostra
        String cookieValor = "";
        
        Cookie[] cookies = request.getCookies();
        for(int i = 0; cookies != null && i < cookies.length; i++){
            Cookie c = cookies[i];
            if(c.getName().equals("pw1.cc")){
                cookieValor = c.getValue();
                break;
            }
        }
        
        List<CarrinhoComprasItem> carrinhoCompras = CarrinhoNegocio.obterCarrinhoCompras(cookieValor);
        request.setAttribute("carrinhoCompras", carrinhoCompras);
        request.getRequestDispatcher("WEB-INF/usuario/carrinhoLogado.jsp").forward(request, response);    

    }

}
