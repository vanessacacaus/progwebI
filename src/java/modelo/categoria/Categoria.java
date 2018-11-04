/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.categoria;

/**
 *
 * @author vanes
 */
public class Categoria {
    private int id_categoria;
    private String categoria_descricao;

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getCategoria_descricao() {
        return categoria_descricao;
    }

    public void setCategoria_descricao(String categoria_descricao) {
        this.categoria_descricao = categoria_descricao;
    }
}
