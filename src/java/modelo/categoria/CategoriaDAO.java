/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.categoria;
import static config.Configuracao.JDBC_SENHA;
import static config.Configuracao.JDBC_URL;
import static config.Configuracao.JDBC_USUARIO;
import static java.lang.Integer.parseInt;
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
public class CategoriaDAO {
    
    
    public List<Categoria> obterTodasCategorias() {
        List<Categoria> resultado = new ArrayList<Categoria>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id_categoria, descricao_categoria FROM categoria");
            while (resultSet.next()) {
                Categoria categoria = new Categoria();

                categoria.setId_categoria(resultSet.getInt("id_categoria"));
                categoria.setCategoria_descricao(resultSet.getString("descricao_categoria"));
                //usuario.setLogin(resultSet.getString("login_usuario"));

                resultado.add(categoria);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception ex) {
            return new ArrayList<Categoria>();
        }
        return resultado;
    }
    
    
    public Categoria obterCategoria(int id_categoria) {
        Categoria categoria = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareCall("SELECT id_categoria, descricao_categoria FROM categoria WHERE id_categoria = ?");
            preparedStatement.setInt(1, id_categoria);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                categoria = new Categoria();
                categoria.setId_categoria(id_categoria);
                categoria.setCategoria_descricao(resultSet.getString("descricao_categoria"));
                //usuario.setLogin(resultSet.getString("login_usuario"));

            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            return null;
        }
        return categoria;
    }
    
    
        public boolean inserirCategoria(String descricao_categoria) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO categoria (descricao_categoria) VALUES (?)");
            preparedStatement.setString(1, descricao_categoria);
            resultado = (preparedStatement.executeUpdate() > 0);
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            return false;
        }
        return resultado;
    }
        
        
        public boolean alterarCategoria(String descricao_categoria, int id_categoria) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE categoria SET descricao_categoria = ? WHERE id_categoria = ?");
            preparedStatement.setString(1, descricao_categoria);
            preparedStatement.setInt(2, id_categoria);
            resultado = (preparedStatement.executeUpdate() > 0);
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            return false;
        }
        return resultado;
    }
    
        public boolean excluirCategoria(int id_categoria) {
        boolean resultado = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM categoria WHERE id_categoria = ?");
            preparedStatement.setInt(1, id_categoria);
            resultado = (preparedStatement.executeUpdate() > 0);
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            return false;
        }
        return resultado;
    }
}
