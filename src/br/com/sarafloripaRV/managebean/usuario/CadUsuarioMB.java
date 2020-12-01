package br.com.sarafloripaRV.managebean.usuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.sarafloripaRV.facade.TipoAcessoFacade;
import br.com.sarafloripaRV.facade.UsuarioFacade;
import br.com.sarafloripaRV.model.Tipoacesso;
import br.com.sarafloripaRV.model.Usuario;
import br.com.sarafloripaRV.util.Mensagem;

@Named
@ViewScoped
public class CadUsuarioMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private Tipoacesso tipoacesso;
	private List<Tipoacesso> listaAcesso;
	
	
	@PostConstruct
	public void init() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		usuario = (Usuario) session.getAttribute("usuario");
		session.removeAttribute("usuario");
		if (usuario == null) {
			usuario = new Usuario();
			usuario.setAcessogeral(true);
			usuario.setAtivo(true);
			usuario.setDescricaoativo("check");
		}else {
			tipoacesso = usuario.getTipoacesso();
		}
		listarAcesso();
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	public Tipoacesso getTipoacesso() {
		return tipoacesso;
	}


	public void setTipoacesso(Tipoacesso tipoacesso) {
		this.tipoacesso = tipoacesso;
	}


	public List<Tipoacesso> getListaAcesso() {
		return listaAcesso;
	}


	public void setListaAcesso(List<Tipoacesso> listaAcesso) {
		this.listaAcesso = listaAcesso;
	}


	public String salvar() {
		UsuarioFacade usuarioFacade = new UsuarioFacade();
		if (validarDados()) {
			if (usuario.getIdusuario() == null) {
				usuario.setSenha("t+lL5RPpboxFzSPRYideWhLr3pEApCXE683X+k3NiXw=");
				usuario.setTipoacesso(tipoacesso);
				usuario = usuarioFacade.salvar(usuario);
			} else {
				usuario = usuarioFacade.salvar(usuario);
			}
			return "consUsuario";
		}else {
			Mensagem.lancarMensagemInfo("Favor preencher todos os campos com *", "");
		}
		return "";
	}
	
	
	public boolean validarDados() {
		if (usuario.getLogin() == null) {
			return false;
		}
		if (usuario.getNome() == null) {
			return false;
		}
		if (tipoacesso == null) {
			return false;
		}
		return true;
	}
	
	
	public String cancelar() {
		return "consUsuario";
	}
	
	
	public void listarAcesso() {
		TipoAcessoFacade tipoAcessoFacade = new TipoAcessoFacade();
		listaAcesso = tipoAcessoFacade.listar("Select t From Tipoacesso t");
		if (listaAcesso == null) {
			listaAcesso = new ArrayList<Tipoacesso>();
		}
	}
	
	
	

}
