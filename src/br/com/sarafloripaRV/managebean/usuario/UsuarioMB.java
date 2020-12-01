package br.com.sarafloripaRV.managebean.usuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.sarafloripaRV.facade.UsuarioFacade;
import br.com.sarafloripaRV.model.Usuario;

@Named
@ViewScoped
public class UsuarioMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Usuario> listaUsuario;
	
	
	@PostConstruct
	public void init() {
		listagemUsuario();
	}


	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}


	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}
	
	
	
	public void listagemUsuario() {
		UsuarioFacade usuarioFacade = new UsuarioFacade();
		listaUsuario = usuarioFacade.listar("Select u From Usuario u");
		if (listaUsuario == null) {
			listaUsuario = new ArrayList<Usuario>();
		}
	}
	
	public String editar(Usuario usuario) {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.setAttribute("usuario", usuario);
		return "cadUsuario";
	}
	
	public String novo() {
		return "cadUsuario";
	}
	
	
	public void ativarDesativarUsuario(Usuario usuario) {
		UsuarioFacade usuarioFacade = new UsuarioFacade();
		if (usuario.isAtivo()) {
			usuario.setAtivo(false);
			usuario.setDescricaoativo("x-circle");
		}else {
			usuario.setAtivo(true);
			usuario.setDescricaoativo("check");
		}
		usuarioFacade.salvar(usuario);
	}
	
	

}
