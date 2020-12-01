package br.com.sarafloripaRV.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.sarafloripaRV.model.Usuario;
import br.com.sarafloripaRV.util.ConectionFactory;


public class UsuarioDao {

	public Usuario salvar(Usuario usuario) throws SQLException{
    	EntityManager manager;
        manager = ConectionFactory.getInstance();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
        usuario = manager.merge(usuario);
        tx.commit();
        
        return usuario;
    }
    
    public Usuario consultar(int idUsuario) throws SQLException{
    	EntityManager manager;
        manager = ConectionFactory.getInstance();
        Usuario usuario = manager.find(Usuario.class, idUsuario);
        
        return usuario; 
    }
    
    public Usuario consultar(String login, String senha) throws SQLException{
    	EntityManager manager;
        manager = ConectionFactory.getInstance();
	    Query q = manager.createQuery("select u from Usuario u where u.login='" + login + "' and u.senha='" + senha + "'"
	    		+ " and u.ativo=true  order by u.nome");
        Usuario usuario = null;
        if (q.getResultList().size()>0){
            usuario = (Usuario) q.getResultList().get(0);
        }
        return usuario;
    }
    
    @SuppressWarnings("unchecked")
	public List<Usuario> listaUsuario() throws SQLException{
    	EntityManager manager;
        manager = ConectionFactory.getInstance();
        Query q = manager.createQuery("select u from Usuario u order by u.nome");
        List<Usuario> lista = q.getResultList();
        
        return lista;
    }
    
     @SuppressWarnings("unchecked")
	public List<Usuario> listar(String sql) throws SQLException{
    	EntityManager manager;
        manager = ConectionFactory.getInstance();
        Query q = manager.createQuery(sql);
        List<Usuario> lista = q.getResultList();
        
        return lista;
    }
    
    @SuppressWarnings("unchecked")
	public List<Usuario> listaUsuario(String nome) throws SQLException{
    	EntityManager manager;
        manager = ConectionFactory.getInstance();
        Query q = manager.createQuery("select u from Usuario u where u.nome like '%" + nome + "%' order by u.nome" );
        List<Usuario> lista = q.getResultList();
        
        return lista;
    }
    
    @SuppressWarnings("unchecked")
	public List<Usuario> consultar(String sql) throws SQLException{
    	EntityManager manager;
        manager = ConectionFactory.getInstance();
        Query q = manager.createQuery(sql);
        List<Usuario> lista = q.getResultList();
        
        return lista;
    }
}
