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
public class InserirFuncionarioServlet extends HttpServlet {

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
            String senha_funcionario = request.getParameter("senha_funcionario");
            double salario_funcionario = Double.parseDouble(request.getParameter("salario_funcionario"));
        //processamento
            FuncionarioNegocio funcionarioNegocio = new FuncionarioNegocio();
            boolean sucessoInserir = funcionarioNegocio.inserirFuncionario(nome_funcionario, login_funcionario, senha_funcionario, salario_funcionario);
         
        //saída
            if (sucessoInserir) { 
                    request.setAttribute("mensagem", "Funcionário inserido com sucesso");
                    RequestDispatcher rd = request.getRequestDispatcher("chamarListaFuncionariosServlet"); 
                    rd.forward(request, response);
                } else {
                    request.setAttribute("mensagem", "Erro ao inserir funcionario"); 
                    RequestDispatcher rd = request.getRequestDispatcher("chamaInserirFuncionarioServlet"); 
                    rd.forward(request, response);
                } 
            
            
    }

}
