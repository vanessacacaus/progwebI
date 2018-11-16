/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.carrinho;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.carrinho.CarrinhoNegocio;

/**
 *
 * @author vanes
 */
public class RemoverCarrinhoServlet extends HttpServlet {

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
        int id_produto = Integer.parseInt(request.getParameter("id_produto"));
        
        Cookie cookie = null;
        Cookie[] cookies = request.getCookies();
        for(int i = 0; cookies != null && i < cookies.length; i++){
            Cookie c = cookies[i];
            if(c.getName().equals("pw1.cc")){
                cookie = c;
                break;
            }
        }
        
        String cookieValor = "";
        
        if(cookieValor == null){
            cookie = new Cookie("pw1.cc", cookieValor);
        }
        else{
            cookieValor = cookie.getValue();
        }
        
        cookieValor = CarrinhoNegocio.removerProduto(cookieValor, id_produto);
        cookie.setMaxAge(Integer.MAX_VALUE);
        
        response.addCookie(cookie);
        
        request.setAttribute("mensagem", "produto removido do carrinho de compras");
        request.getRequestDispatcher("InicioServlet").forward(request, response);
        response.sendRedirect("InicioServlet");
    }

}
