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
import modelo.usuario.Usuario;
import modelo.usuario.UsuarioDAO;
import modelo.usuario.UsuarioNegocio;

/**
 *
 * @author vanes
 */
public class editarUsuarioServlet extends HttpServlet {

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
                
                String login = (String) session.getAttribute("login");
                    UsuarioDAO dao = new UsuarioDAO();
                    Usuario usuario = new Usuario();
                    UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
                                        
                    String nomeNovo = request.getParameter("nome");
                    String senhaTeste = request.getParameter("senha");
                
                    boolean sucessoAlterar = usuarioNegocio.alterarUsuario(nomeNovo, login, senhaTeste);
                    if (sucessoAlterar) { // caso o login e senha estejam corretos
                        request.setAttribute("mensagem", "Sucesso ao atualizar"); 
                        session.setAttribute("nome", nomeNovo);
                        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/usuario/meusDados.jsp"); // despacha a requisição para a página main.jsp, encaminhando as instância de request e response 
                        rd.forward(request, response);
                    } else {
                        request.setAttribute("mensagem", "Erro ao atualizar"); // coloca uma mensagem no objeto request
                        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/usuario/editarDados.jsp"); // despacha a requisição para a página index.jsp, encaminhando as instância de request e response
                        rd.forward(request, response);
                    }
    }
}