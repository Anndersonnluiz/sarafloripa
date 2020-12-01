package br.com.sarafloripaRV.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name =  "usuario")
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusuario")
    private Integer idusuario;
    @Column(name = "login")
    private String login;
    @Column(name = "nome")
    private String nome;
    @Column(name = "email")
    private String email;
    @Column(name = "senha")
    private String senha;
    @Column(name = "ativo")
    private boolean ativo;
	@Column(name = "acessogeral")
	private boolean acessogeral;
	@Column(name = "descricaoativo")
	private String descricaoativo;
	@JoinColumn(name = "tipoacesso_idtipoacesso", referencedColumnName = "idtipoacesso")
	@ManyToOne(optional = false)
	private Tipoacesso tipoacesso;
    
    
    public Usuario() {
		
	}
    
    
	public Integer getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}


	public boolean isAtivo() {
		return ativo;
	}


	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}


	public boolean isAcessogeral() {
		return acessogeral;
	}


	public void setAcessogeral(boolean acessogeral) {
		this.acessogeral = acessogeral;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getDescricaoativo() {
		return descricaoativo;
	}


	public void setDescricaoativo(String descricaoativo) {
		this.descricaoativo = descricaoativo;
	}


	public Tipoacesso getTipoacesso() {
		return tipoacesso;
	}


	public void setTipoacesso(Tipoacesso tipoacesso) {
		this.tipoacesso = tipoacesso;
	}


	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idusuario != null ? idusuario.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		//
		if (!(object instanceof Usuario)) {
			return false;
		}
		Usuario other = (Usuario) object;
		if ((this.idusuario == null && other.idusuario != null)
				|| (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.sarafloripaRV.model.Usuario[ idusuario=" + idusuario + " ]";
	}
}
