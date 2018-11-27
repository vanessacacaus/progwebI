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
public class ApagarCarrinhoServlet extends HttpServlet {

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
        
        Cookie cookie = null; //cria o cookie nulo
        Cookie[] cookies = request.getCookies(); //cria um vetor de cookies para pegar todos os cookies existentes
        for(int i = 0; cookies != null && i < cookies.length; i++){
            Cookie c = cookies[i];
            if(c.getName().equals("pw1.cc")){
                cookie = c;
                break;
            }
        }
        
        String cookieValor = "";
        //cria string vazia
        if(cookie == null){ //se cookie for nulo ele cria o cookie passando a string vazia. 
            cookie = new Cookie("pw1.cc", cookieValor);
        }
        else{
            cookieValor = cookie.getValue(); //se não for nulo, ele coloca a string dentro do cookie
        }
        
        cookieValor = "";
        cookie.setValue(cookieValor);
        cookie.setMaxAge(Integer.MAX_VALUE);
        
        response.addCookie(cookie);
        
        request.setAttribute("msg", "success");
        request.getRequestDispatcher("InicioServlet").forward(request, response);
        response.sendRedirect("InicioServlet");
    }

}
