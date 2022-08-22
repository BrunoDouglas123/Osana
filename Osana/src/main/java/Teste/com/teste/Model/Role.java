package Teste.com.teste.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "role")
public class Role implements Serializable {
	private static final long serialVersionUID = 5026421928716602048L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_role", nullable = false)
	private Long id;
	
	@Column(name = "name", length = 45, nullable = false)
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "role")
	private List<Usuario> usuario = new ArrayList<>();
	
	public Role() {
	}

	public Role(Long id, String name) {
		this.id = id;
		this.name = name;
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

	public List<Usuario> getUsuario() {
		return usuario;
	}
}
