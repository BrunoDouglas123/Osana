package Teste.com.teste.DTO;

import Teste.com.teste.Model.Usuario;

public class UsuarioDTO {

	private Long id;
	private String name;
	private String username;
	private String contact;
	private String password;
	
	private RoleDTO role;
	
	public UsuarioDTO() {		
	}

	public UsuarioDTO(Long id, String name, String username, String contact, String password, RoleDTO role) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.contact = contact;
		this.password = password;
		this.role = role;
	}
	
	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.name = usuario.getName();
		this.username = usuario.getUsername();
		this.contact = usuario.getContact();
		this.password = usuario.getPassword();
		this.role = new RoleDTO(usuario.getRole());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RoleDTO getRole() {
		return role;
	}

	public void setRole(RoleDTO role) {
		this.role = role;
	}
}
