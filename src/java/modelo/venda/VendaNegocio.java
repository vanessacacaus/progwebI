/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.venda;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author vanes
 */
public class VendaNegocio {
    public boolean novaVenda(String id_cliente, String itens, double total){
        VendaDAO vendaDAO = new VendaDAO();
        return vendaDAO.inserirVenda(itens, id_cliente, total);   
    }
    
    public boolean cancelarVenda(int id_venda){
        VendaDAO vendaDAO = new VendaDAO();
        return vendaDAO.excluirVenda(id_venda);
    }
    
    public Venda obterVenda(int id_venda){
        VendaDAO vendaDAO = new VendaDAO();
        return vendaDAO.obterVenda(id_venda);
    }
    
    public List<Venda> obterVendas(){
        VendaDAO vendaDao = new VendaDAO();
        return vendaDao.obterTodos();
    }
    
    public List<Venda> obterVendasUsuarioX(String id_cliente){
        VendaDAO vendaDao = new VendaDAO();
        return vendaDao.obterTodosUsuarioX(id_cliente);
    }
}
