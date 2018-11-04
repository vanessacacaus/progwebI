/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.produto;

/**
 *
 * @author vanes
 */
public class ProdutoNegocio {
            
    
    public boolean inserirProduto(String nome_produto, double preco_produto, int id_categoria){
        ProdutoDAO dao = new ProdutoDAO();
        return dao.inserirProduto(nome_produto, preco_produto, id_categoria);
    }
    
    public boolean alterarProduto(int id_produto, String nome_produto, double preco_produto, int id_categoria){
        ProdutoDAO dao = new ProdutoDAO();
        return dao.alterarProduto(id_produto, nome_produto, preco_produto, id_categoria);
    }
    
    public boolean excluirProduto(int id_produto){
        ProdutoDAO dao = new ProdutoDAO();
        return dao.excluirProduto(id_produto);
    }
}
