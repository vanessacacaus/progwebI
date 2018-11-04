/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.categoria;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vanes
 */
public class CategoriaNegocio {

    public boolean inserirCategoria(String descricao_categoria){
        CategoriaDAO dao = new CategoriaDAO();
        return dao.inserirCategoria(descricao_categoria);
    }

    public boolean alterarCategoria(String descricao_categoria, int id_categoria){
        CategoriaDAO dao = new CategoriaDAO();
        return dao.alterarCategoria(descricao_categoria, id_categoria);
    }
    
    public boolean excluirCategoria(int id_categoria){
        CategoriaDAO dao = new CategoriaDAO();
        return dao.excluirCategoria(id_categoria);
    }   
    
}
