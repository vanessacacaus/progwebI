/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.usuario;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.usuario.UsuarioNegocio;

/**
 *
 * @author vanes
 */
public class ExcluirUsuarioServlet extends HttpServlet {

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
            HttpSession session = request.getSession();
            String login = (String) session.getAttribute("login");
            String senha = (String) request.getParameter("senha");
            
            UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
            boolean sucessoExcluir = usuarioNegocio.excluirUsuario(login, senha);
                     if (sucessoExcluir) { // caso o login e senha estejam corretos
                        request.setAttribute("msg", "success");
                        request.setAttribute("mensagem", "Sucesso ao excluir"); 
                        RequestDispatcher rd = request.getRequestDispatcher("index.jsp"); // despacha a requisição para a página main.jsp, encaminhando as instância de request e response 
                        rd.forward(request, response);
                    } else {
                        request.setAttribute("msg", "danger");
                        request.setAttribute("mensagem", "Erro ao excluir"); // coloca uma mensagem no objeto request
                        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/usuario/meusDados.jsp"); // despacha a requisição para a página index.jsp, encaminhando as instância de request e response
                        rd.forward(request, response);
                    }           
            

    }
}
