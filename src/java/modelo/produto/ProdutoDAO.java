/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.produto;

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

public class ProdutoDAO {
        public List<Produto> obterTodosProdutos() {
        List<Produto> resultado = new ArrayList<Produto>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id_produto, nome_produto, preco_produto, id_categoria FROM produto");
            while (resultSet.next()) {
                Produto produto = new Produto();
                produto.setId_produto(resultSet.getString("id_produto"));
                produto.setNome_produto(resultSet.getString("nome_produto"));
                produto.setPreco_produto(resultSet.getDouble("preco_produto"));
                produto.setId_categoria(resultSet.getInt("id_categoria"));
                resultado.add(produto);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception ex) {
            return new ArrayList<Produto>();
        }
        return resultado;
    }
        
    
        public Produto obterProduto(int id_produto) {
        Produto produto = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareCall("SELECT nome_produto, preco_produto, id_categoria FROM produto WHERE id_produto = ?");
            preparedStatement.setInt(1, id_produto);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                produto = new Produto();
                produto.setNome_produto(resultSet.getString("nome_produto"));
                produto.setPreco_produto(resultSet.getDouble("preco_produto"));
                produto.setId_categoria(resultSet.getInt("id_categoria"));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            return null;
        }
        return produto;
    }
        
        
        public boolean inserirProduto(String nome_produto, double preco_produto, int id_categoria) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO produto (nome_produto, preco_produto, id_categoria) VALUES (?, ?, ?)");
            preparedStatement.setString(1, nome_produto);
            preparedStatement.setDouble(2, preco_produto);
            preparedStatement.setInt(3, id_categoria);
            resultado = (preparedStatement.executeUpdate() > 0);
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            return false;
        }
        return resultado;
    }
        
        public boolean alterarProduto(int id_produto, String nome_produto, double preco_produto, int id_categoria) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE produto SET nome_produto = ?, preco_produto = ?, id_categoria = ? WHERE id_produto = ?");
            preparedStatement.setString(1, nome_produto);
            preparedStatement.setDouble(2, preco_produto);
            preparedStatement.setDouble(3, id_categoria);
            preparedStatement.setDouble(4, id_produto);
            resultado = (preparedStatement.executeUpdate() > 0);
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            return false;
        }
        return resultado;
    }
        
        public boolean excluirProduto(int id_produto) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM produto WHERE id_produto = ?");
            preparedStatement.setInt(1, id_produto);
            resultado = (preparedStatement.executeUpdate() > 0);
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            return false;
        }
        return resultado;
    }
        
        
        
        
}
