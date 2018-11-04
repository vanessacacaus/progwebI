/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.funcionario;

/**
 *
 * @author vanes
 */
public class FuncionarioNegocio {
    
        public boolean inserirFuncionario(String nome_funcionario, String login_funcionario, String senha_funcionario, double salario_funcionario){
            FuncionarioDAO dao = new FuncionarioDAO();
            return dao.inserirFuncionario(nome_funcionario, login_funcionario, senha_funcionario, salario_funcionario);
        }
        
        public boolean alterarFuncionario(String nome_funcionario, String login_funcionario, String senha_funcionario, double salario_funcionario){
            FuncionarioDAO dao = new FuncionarioDAO();
            return dao.alterarFuncionario(nome_funcionario, login_funcionario, senha_funcionario, salario_funcionario);
        }

        public boolean excluirFuncionario(String login_funcionario, String senha_funcionario){
            FuncionarioDAO dao = new FuncionarioDAO();
            return dao.excluirFuncionario(login_funcionario);
        }
}
