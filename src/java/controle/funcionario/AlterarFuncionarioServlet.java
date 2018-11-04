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
import modelo.funcionario.Funcionario;
import modelo.funcionario.FuncionarioDAO;
import modelo.funcionario.FuncionarioNegocio;

/**
 *
 * @author vanes
 */
public class AlterarFuncionarioServlet extends HttpServlet {

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
        
        //entrada
        String nome_funcionario = request.getParameter("nome_funcionario");
        String login_funcionario = request.getParameter("login_funcionario");
        String senha_nova = request.getParameter("senha_nova");
        String senha_funcionario = request.getParameter("senha_funcionario");
        double salario_funcionario = Double.parseDouble(request.getParameter("salario_funcionario"));
        
        //processamento
        Funcionario f = new Funcionario();
        FuncionarioDAO dao = new FuncionarioDAO();
        FuncionarioNegocio funcionarioNegocio = new FuncionarioNegocio();
        
        f = dao.obterFuncionario(login_funcionario);
        System.out.println(f == null);
        System.out.println(f.getSenha_funcionario());
        System.out.println(senha_funcionario);
        if(f.getSenha_funcionario().equals(senha_funcionario)){
            System.out.println("1");
            boolean sucessoAlterar = funcionarioNegocio.alterarFuncionario(nome_funcionario, login_funcionario, senha_nova, salario_funcionario);
            if(sucessoAlterar){
                System.out.println("2");
                    request.setAttribute("mensagem", "Funcionário alterado com sucesso");
                    RequestDispatcher rd = request.getRequestDispatcher("chamarListaFuncionariosServlet"); 
                    rd.forward(request, response);
                } else {
                System.out.println("3");
                    request.setAttribute("mensagem", "Erro ao alterar funcionario"); 
                    RequestDispatcher rd = request.getRequestDispatcher("chamarEditarFuncionarioServlet"); 
                    rd.forward(request, response);
                } 
        } else {
            request.setAttribute("mensagem", "Senha incorreta"); 
            RequestDispatcher rd = request.getRequestDispatcher("chamarEditarFuncionarioServlet"); 
            rd.forward(request, response);
        }
    }
}
