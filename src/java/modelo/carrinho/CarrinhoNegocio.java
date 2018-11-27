/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.carrinho;

import java.util.ArrayList;
import java.util.List;
import modelo.produto.ProdutoNegocio;

/**
 *
 * @author vanes
 */
public final class CarrinhoNegocio {
    private static final String SEPARADOR_REGISTRO = "SEPREG";
    private static final String SEPARADOR_CAMPOS = "SEPFI";
    
    public static boolean existeProduto(String cookieValor, int id_produto){
        if(cookieValor == null || cookieValor.trim().length() == 0) {
            return false;
        }
        
        String[] produtos = cookieValor.split(SEPARADOR_REGISTRO);
        if(produtos == null || produtos.length == 0){
            produtos = new String[]{cookieValor};
        } //captura todos os registros através do cookie, separando 
        
        for(String p : produtos){
            String[] produto = p.split(SEPARADOR_CAMPOS);
            if(Integer.parseInt(produto[0])== id_produto){
                return true;
            }
        }
        return false;     
    }
    
    public static List<CarrinhoComprasItem> obterCarrinhoCompras(String cookieValor){
        if (cookieValor == null || cookieValor.trim().length() == 0) {
            return new ArrayList<CarrinhoComprasItem>();
        }
        
        List<CarrinhoComprasItem> resultado = new ArrayList<CarrinhoComprasItem>(); //cria um novo arraylist do tipo carrinho compras item chamado resultado
        
        String[] produtos = cookieValor.split(SEPARADOR_REGISTRO); // separa os registros e coloca dentro de um vetor
        if(produtos == null || produtos.length == 0){
            produtos = new String[]{cookieValor};
        }
        
        ProdutoNegocio produtoNegocio = new ProdutoNegocio();
        for(String p: produtos){
            String[] produto = p.split(SEPARADOR_CAMPOS);
            CarrinhoComprasItem carrinhoComprasItem = new CarrinhoComprasItem();
            carrinhoComprasItem.setProduto(produtoNegocio.obterProduto(Integer.parseInt(produto[0])));
            carrinhoComprasItem.setQuantidade(Integer.parseInt(produto[1]));
            resultado.add(carrinhoComprasItem);
        }
        return resultado;
    }
    
    //cookieValor é uma string que guarda todas as quantidades de produtos, separados por registros e campos
    public static String salvarProduto(String cookieValor, int produtoId, int quantidade){
        if(cookieValor == null || cookieValor.trim().length() == 0){ //trim tira os espaços, se o cookieValor for nulo, ou seja, ainda não tem nada salvo, ele cria o cookie, com um elemento, com aquela dada quantidade, apenas com o separador de campo
            return produtoId + SEPARADOR_CAMPOS + quantidade;  
        }
        if(existeProduto(cookieValor, produtoId)){
            if(!cookieValor.contains(SEPARADOR_REGISTRO)){ //ele não contem o separador de registro, só possui um produto
                cookieValor = produtoId + SEPARADOR_CAMPOS + quantidade;
            } else { // mais de um produto
                String[] produtos = cookieValor.split(SEPARADOR_REGISTRO);
                cookieValor = "";
                
                for(String p: produtos){
                    String[] produto = p.split(SEPARADOR_CAMPOS);
                    if(cookieValor.trim().length() > 0){ // ele só adiciona o separador de registro, se tiver mais de um registro
                        cookieValor = cookieValor + SEPARADOR_REGISTRO;
                    }
                    if(Integer.parseInt(produto[0]) == produtoId){
                        cookieValor = cookieValor + (produtoId + SEPARADOR_CAMPOS + quantidade);
                    }else{
                        cookieValor = cookieValor + (Integer.parseInt(produto[0]) + SEPARADOR_CAMPOS + Integer.parseInt(produto[1]));
                    }
                }
            }
        } else {
            cookieValor = cookieValor + SEPARADOR_REGISTRO + (produtoId + SEPARADOR_CAMPOS + quantidade);
        }
        return cookieValor;
    }
    
    public static String removerProduto(String cookieValor, int id_produto){
        if(cookieValor == null || cookieValor.trim().length() == 0){
            return "";
        }
        if(existeProduto(cookieValor, id_produto)){
            if (!cookieValor.contains(SEPARADOR_REGISTRO)) { // só existe um produto
                cookieValor = "";
            } else {
                String[] produtos = cookieValor.split(SEPARADOR_REGISTRO);
                cookieValor = "";

                for(String p: produtos){
                    String[] produto = p.split(SEPARADOR_CAMPOS);
                    if(cookieValor.trim().length() > 0){
                        cookieValor = cookieValor + SEPARADOR_REGISTRO;
                    }
                    if(Integer.parseInt(produto[0]) != id_produto){
                        cookieValor = cookieValor + (Integer.parseInt(produto[0]) + SEPARADOR_CAMPOS + Integer.parseInt(produto[1]));
                    }
                }
        }
        
        }
        return cookieValor;
    }

}
