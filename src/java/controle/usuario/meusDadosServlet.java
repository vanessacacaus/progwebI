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
import modelo.funcionario.Funcionario;
import modelo.funcionario.FuncionarioDAO;
import modelo.usuario.Usuario;
import modelo.usuario.UsuarioDAO;

/**
 *
 * @author vanes
 */
public class meusDadosServlet extends HttpServlet {

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
                //response.setContentType("text/html;charset=UTF-8");
                HttpSession session = request.getSession();
                
                String login = (String) session.getAttribute("login");
                String tipo = (String) session.getAttribute("tipo");
                
                if(tipo.equals("usuario")){
                    UsuarioDAO dao = new UsuarioDAO();
                    Usuario usuario = new Usuario();
                    usuario = dao.obterUsuario(login);
                
                    //criar na camada de negocio o ler o usuario, por isso aqui está nulo
                    String nome = usuario.getNome();
                
                    session.setAttribute("nome", nome); //envia atributo para proxima
                    session.setAttribute("login", login);
                    
                } else if(tipo.equals("funcionario")){
                    FuncionarioDAO dao = new FuncionarioDAO();
                    Funcionario funcionario = new Funcionario();
                    funcionario = dao.obterFuncionario(login);
                
                    //criar na camada de negocio o ler o usuario, por isso aqui está nulo
                    String nome = funcionario.getNome_funcionario();
                
                    session.setAttribute("nome", nome); //envia atributo para proxima
                    session.setAttribute("login", login);
                }
                
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/usuario/meusDados.jsp");
                rd.forward(request, response);
    }
}