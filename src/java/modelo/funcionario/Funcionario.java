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
public class Funcionario {
    private String nome_funcionario;
    private String login_funcionario;
    private String senha_funcionario;
    private double salario_funcionario;

    public String getNome_funcionario() {
        return nome_funcionario;
    }

    public void setNome_funcionario(String nome_funcionario) {
        this.nome_funcionario = nome_funcionario;
    }

    public String getLogin_funcionario() {
        return login_funcionario;
    }

    public void setLogin_funcionario(String login_funcionario) {
        this.login_funcionario = login_funcionario;
    }

    public String getSenha_funcionario() {
        return senha_funcionario;
    }

    public void setSenha_funcionario(String senha_funcionario) {
        this.senha_funcionario = senha_funcionario;
    }

    public double getSalario_funcionario() {
        return salario_funcionario;
    }

    public void setSalario_funcionario(double salario_funcionario) {
        this.salario_funcionario = salario_funcionario;
    }
    
}
