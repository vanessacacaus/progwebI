/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.usuario;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.usuario.UsuarioDAO;
import modelo.usuario.UsuarioNegocio;

/**
 *
 * @author vanes
 */
public class cadastroUsuarioServlet extends HttpServlet {

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
            //entrada: pegar atraves de request, os parametros passados para a os inputs
            String nome = request.getParameter("nome");
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            
            //processamento: identificar a classe de negocio e efetuar a ação de inserir
            UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
            boolean erroInserir = usuarioNegocio.testeUsuario(login);
            boolean sucessoInserir = usuarioNegocio.inserirUsuario(nome, login, senha);

            if(erroInserir){
                request.setAttribute("mensagem", "Usuario já existe, escolha outro login");
                RequestDispatcher rd = request.getRequestDispatcher("cadastroUsuario.jsp");
                rd.forward(request, response);
            } else {
                if(sucessoInserir){
                    request.setAttribute("mensagem", "Usuario inserido com sucesso.");
                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);
                } else {
                    request.setAttribute("mensagem", "Não foi possível inserir o usuário");
                    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/usuario/cadastroUsuario.jsp");
                    rd.forward(request, response);
                }
            }
    }

}
