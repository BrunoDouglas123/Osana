package Teste.com.teste.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 3083765634771531893L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user", nullable = false)
	private Long id;
	
	@Column(name = "name", length = 45, nullable = false)
	private String name;
	
	@Column(name = "username", length = 45, nullable = false)
	private String username;
	
	@Column(name = "contact", length = 45, nullable = false)
	private String contact;
	
	@Column(name = "password", length = 45, nullable = false)
	private String password;
	
	@OneToMany(mappedBy = "usuario")
	private List<Os> os = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "id_role")
	private Role role;
	
	public Usuario() {		
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Os> getOs() {
		return os;
	}
}
