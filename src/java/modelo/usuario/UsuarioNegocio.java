/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.usuario;

/**
 *
 * @author Leonardo Oliveira Moreira
 * 
 * Classe de negócio que encapsula as regras de negócio dos usuários
 */
public class UsuarioNegocio {

    /**
     * Método que verifica se o login e senha de um usuário é válido
     * 
     * @param login
     * @param senha
     * @return 
     */
    //faz o login atraves dos parametros login e senha
    public boolean efetuarLogin(String login, String senha) {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = dao.obterUsuario(login);
        return (usuario != null && usuario.getSenha().equals(senha));
    }
    
    public boolean testeUsuario(String login){
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = dao.obterUsuario(login);
        return (usuario!=null);
    }
    
    public Usuario lerUsuario(String login){
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = dao.obterUsuario(login);
        return usuario;
    }
    
    public boolean inserirUsuario(String nome, String login, String senha){
        UsuarioDAO dao = new UsuarioDAO();
        return dao.inserirUsuario(nome, login, senha);
    }
    
    public boolean alterarUsuario(String nome, String login,String senha){
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = new Usuario();
        usuario = dao.obterUsuario(login);
        if(usuario != null && usuario.getSenha().equals(senha)){
            return dao.alterarUsuario(nome, login, senha);
        } else {
            return false;
        }
    }
    
    public boolean excluirUsuario(String login, String senha){
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = new Usuario();
        usuario = dao.obterUsuario(login);
        if(usuario != null && usuario.getSenha().equals(senha)){
            return (dao.excluirUsuario(login));
        } else {
            return false;
        }
    }
    
    public boolean excluirUsuarioFuncionario(String login){
        UsuarioDAO dao = new UsuarioDAO();
        return dao.excluirUsuario(login);
    }
    
    public Usuario obterUsuario(String login){
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = new Usuario();
        usuario = dao.obterUsuario(login);
        return usuario;
    }
    
}
