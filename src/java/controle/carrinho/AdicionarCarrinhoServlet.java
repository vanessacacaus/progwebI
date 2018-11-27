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
public class AdicionarCarrinhoServlet extends HttpServlet {

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
        String login = request.getParameter("login");

                
        int id_produto = Integer.parseInt(request.getParameter("id_produto"));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        
        Cookie cookie = null; //cria um cookie nulo
        Cookie[] cookies = request.getCookies(); //pega os cookies
        //percorre os o vetor de cookies
        for(int i = 0; cookies != null && i < cookies.length; i++){
            Cookie c = cookies[i];
            if(c.getName().equals("pw1.cc")){
                cookie = c; 
                break;
            } //recupera o cookie se houver um
        }
        
        String cookieValor = ""; //cria a string cookieValor zerada
        
        if(cookie == null){
            cookie = new Cookie("pw1.cc", cookieValor);
        } // se não há cookie, ele cria um novo cookie
        else {
            cookieValor = cookie.getValue();
        }
        
        cookieValor = CarrinhoNegocio.salvarProduto(cookieValor, id_produto, quantidade); //salva os dados dentro da string cookieValor
        cookie.setValue(cookieValor);
        cookie.setMaxAge(Integer.MAX_VALUE);
        
        response.addCookie(cookie);
        
        request.setAttribute("login", login);
        request.setAttribute("msg", "success");
        request.setAttribute("mensagem", "produto adicionado ao carrinho de compras");
        request.getRequestDispatcher("InicioServlet").forward(request, response);
    }

}
