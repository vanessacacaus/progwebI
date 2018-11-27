/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.venda;

import static config.Configuracao.JDBC_SENHA;
import static config.Configuracao.JDBC_URL;
import static config.Configuracao.JDBC_USUARIO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.usuario.Usuario;

/**
 *
 * @author vanes
 */
public class VendaDAO {
    public boolean inserirVenda(String itens, String id_cliente, double total) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO venda (itens, id_cliente, total) VALUES (?, ?, ?)");
            preparedStatement.setString(1, itens);
            preparedStatement.setString(2, id_cliente);
            preparedStatement.setDouble(3, total);
            resultado = (preparedStatement.executeUpdate() > 0);
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            return false;
        }
        return resultado;
    }
    
    public boolean excluirVenda(int id_venda) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM venda WHERE id_venda = ?");
            preparedStatement.setInt(1, id_venda);
            resultado = (preparedStatement.executeUpdate() > 0);
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            return false;
        }
        return resultado;
    }

    public Venda obterVenda(int id_venda) {
        Venda venda = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareCall("SELECT id_venda, itens, id_cliente, total FROM venda WHERE id_venda = ?");
            preparedStatement.setInt(1, id_venda);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                venda = new Venda();
                venda.setId_venda(resultSet.getInt("id_venda"));
                venda.setItens(resultSet.getString("itens"));
                venda.setId_cliente(resultSet.getString("id_cliente"));
                venda.setTotal(resultSet.getDouble("total"));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            return null;
        }
        return venda;
    }  
    
    public List<Venda> obterTodos() {
        List<Venda> resultado = new ArrayList<Venda>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id_venda, itens, id_cliente, total FROM venda");
            while (resultSet.next()) {
                Venda venda = new Venda();
                venda.setId_venda(resultSet.getInt("id_venda"));
                venda.setItens(resultSet.getString("itens"));
                venda.setId_cliente(resultSet.getString("id_cliente"));
                venda.setTotal(resultSet.getDouble("total"));
                resultado.add(venda);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception ex) {
            return new ArrayList<Venda>();
        }
        return resultado;
    }
    
    public List<Venda> obterTodosUsuarioX(String id_cliente) {
        List<Venda> resultado = new ArrayList<Venda>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareCall("SELECT id_venda, itens, id_cliente, total FROM venda WHERE id_cliente = ?");
            preparedStatement.setString(1, id_cliente);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Venda venda = new Venda();
                venda = new Venda();
                venda.setId_venda(resultSet.getInt("id_venda"));
                venda.setItens(resultSet.getString("itens"));
                venda.setId_cliente(resultSet.getString("id_cliente"));
                venda.setTotal(resultSet.getDouble("total"));
                resultado.add(venda);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            return new ArrayList<Venda>();
        }
        return resultado;
    }
}
