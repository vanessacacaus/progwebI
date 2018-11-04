/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.funcionario;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.funcionario.FuncionarioNegocio;

/**
 *
 * @author vanes
 */
public class ExcluirFuncionarioServlet extends HttpServlet {

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
        String login_funcionario = request.getParameter("login_funcionario");
        String senha_funcionario = request.getParameter("senha_funcionario");
        
        FuncionarioNegocio funcionarioNegocio = new FuncionarioNegocio();
        boolean sucessoExcluir = funcionarioNegocio.excluirFuncionario(login_funcionario, senha_funcionario);
                if (sucessoExcluir) { 
                    request.setAttribute("mensagem", "Funcionário excluido com sucesso");
                    RequestDispatcher rd = request.getRequestDispatcher("listaFuncionarios.jsp"); 
                    rd.forward(request, response);
                } else {
                    request.setAttribute("mensagem", "Erro ao excluir funcionario"); 
                    RequestDispatcher rd = request.getRequestDispatcher("inserirFuncionario.jsp"); 
                    rd.forward(request, response);
                } 
    }

}
