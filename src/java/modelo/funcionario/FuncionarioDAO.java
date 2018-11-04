/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.funcionario;

import static config.Configuracao.JDBC_SENHA;
import static config.Configuracao.JDBC_URL;
import static config.Configuracao.JDBC_USUARIO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vanes
 */
public class FuncionarioDAO {
        public List<Funcionario> obterTodosFuncionarios() {
        List<Funcionario> resultado = new ArrayList<Funcionario>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT nome_funcionario, login_funcionario, senha_funcionario, salario_funcionario FROM funcionario");
            while (resultSet.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setNome_funcionario(resultSet.getString("nome_funcionario"));
                funcionario.setLogin_funcionario(resultSet.getString("login_funcionario"));
                funcionario.setSenha_funcionario(resultSet.getString("senha_funcionario"));
                funcionario.setSalario_funcionario(resultSet.getDouble("salario_funcionario"));
                resultado.add(funcionario);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception ex) {
            return new ArrayList<Funcionario>();
        }
        return resultado;
    }
        
        public Funcionario obterFuncionario(String login_funcionario) {
        Funcionario funcionario = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareCall("SELECT nome_funcionario, senha_funcionario, salario_funcionario,login_funcionario FROM funcionario WHERE login_funcionario = ?");
            preparedStatement.setString(1, login_funcionario);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                funcionario = new Funcionario();
                funcionario.setNome_funcionario(resultSet.getString("nome_funcionario"));
                funcionario.setSenha_funcionario(resultSet.getString("senha_funcionario"));
                funcionario.setSalario_funcionario(resultSet.getDouble("salario_funcionario"));
                funcionario.setLogin_funcionario(resultSet.getString("login_funcionario"));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return funcionario;
    }
        
    public boolean inserirFuncionario(String nome_funcionario, String login_funcionario, String senha_funcionario, double salario_funcionario) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO funcionario (login_funcionario, nome_funcionario, senha_funcionario, salario_funcionario) VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, login_funcionario);
            preparedStatement.setString(2, nome_funcionario);
            preparedStatement.setString(3, senha_funcionario);
            preparedStatement.setDouble(4, salario_funcionario);
            resultado = (preparedStatement.executeUpdate() > 0);
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            return false;
        }
        return resultado;
    }

    public boolean alterarFuncionario(String nome_funcionario, String login_funcionario, String senha_funcionario, double salario_funcionario) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE funcionario SET nome_funcionario = ?, senha_funcionario = ?, salario_funcionario = ? WHERE login_funcionario = ?");
//("UPDATE funcionario SET nome_funcionario = ?, senha_funcionario = ?, salario_funcionario WHERE login_funcionario = ?");
            preparedStatement.setString(1, nome_funcionario);
            preparedStatement.setString(2, senha_funcionario);
            preparedStatement.setDouble(3, salario_funcionario);
            preparedStatement.setString(4, login_funcionario);
            resultado = (preparedStatement.executeUpdate() > 0);
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            return false;
        }
        return resultado;
    }
    
        public boolean excluirFuncionario(String login_funcionario) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM funcionario WHERE login_funcionario = ?");
            preparedStatement.setString(1, login_funcionario);
            resultado = (preparedStatement.executeUpdate() > 0);
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            return false;
        }
        return resultado;
    }
}

