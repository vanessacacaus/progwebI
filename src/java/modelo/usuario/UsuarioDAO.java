/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.usuario;

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
 * @author Leonardo Oliveira Moreira
 * 
 * Classe que representa os acessos aos dados de usuários persistidos em um banco de dados relacional
 */
public class UsuarioDAO {

    /**
     * Método utilizado para recuperar todos os usuários registrados no arquivo
     *
     * @return
     */
    public List<Usuario> obterTodos() {
        List<Usuario> resultado = new ArrayList<Usuario>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT nome_usuario, login_usuario, senha_usuario FROM usuario");
            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                //n tenho ctz sobre isso
                usuario.setNome(resultSet.getString("nome_usuario"));
                usuario.setLogin(resultSet.getString("login_usuario"));
                usuario.setSenha(resultSet.getString("senha_usuario"));
                resultado.add(usuario);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception ex) {
            return new ArrayList<Usuario>();
        }
        return resultado;
    }

    /**
     * Método utilizado para obter um usuário pelo login
     *
     * @param login
     * @return
     */
    public Usuario obterUsuario(String login) {
        Usuario usuario = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareCall("SELECT nome_usuario, login_usuario, senha_usuario FROM usuario WHERE login_usuario = ?");
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                usuario = new Usuario();
                usuario.setNome(resultSet.getString("nome_usuario"));
                usuario.setLogin(resultSet.getString("login_usuario"));
                usuario.setSenha(resultSet.getString("senha_usuario"));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            return null;
        }
        return usuario;
    }

    /**
     * Método utilizado para inserir um novo usuário
     *
     * @param nome
     * @param login
     * @param senha
     * @return
     */
    public boolean inserirUsuario(String nome, String login, String senha) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO usuario (login_usuario, nome_usuario, senha_usuario) VALUES (?, ?, ?)");
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, nome);
            preparedStatement.setString(3, senha);
            resultado = (preparedStatement.executeUpdate() > 0);
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            return false;
        }
        return resultado;
    }

    /**
     * Método utilizado para alterar um usuário já existente
     *
     * @param nome
     * @param login
     * @param senha
     * @return
     */
    public boolean alterarUsuario(String nome, String login, String senha) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE usuario SET nome_usuario = ?, senha_usuario = ? WHERE login_usuario = ?");
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, senha);
            preparedStatement.setString(3, login);
            resultado = (preparedStatement.executeUpdate() > 0);
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            return false;
        }
        return resultado;
    }

    /**
     * Método para excluir um usuário já existente
     *
     * @param login
     * @return
     */
    public boolean excluirUsuario(String login) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM usuario WHERE login_usuario = ?");
            preparedStatement.setString(1, login);
            resultado = (preparedStatement.executeUpdate() > 0);
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            return false;
        }
        return resultado;
    }

}
