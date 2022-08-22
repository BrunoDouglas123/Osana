package Teste.com.teste.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Teste.com.teste.DTO.UsuarioDTO;
import Teste.com.teste.Model.Role;
import Teste.com.teste.Model.Usuario;
import Teste.com.teste.Repository.RoleRepository;
import Teste.com.teste.Repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private RoleRepository vendrepository;
	
	public List<UsuarioDTO> findAll() {
		List<Usuario>result = repository.findAll();
		return result.stream().map(x -> new 
		UsuarioDTO(x)).collect(Collectors.toList());
	}
	
	public Usuario findById(Long id) {
		Optional<Usuario> u = repository.findById(id);
		return u.get();
	}
	
	public Usuario save(Usuario Usuario) {
		Role Role = vendrepository.findById
		(Usuario.getRole().getId()).get();
		Usuario.setRole(Role);
		Usuario u = repository.save(Usuario);
		return u;
	}
	
	@Transactional
	public Usuario update(Long id,Usuario Usuario) {
		Usuario u = repository.getById(id);
		u.setId(id);
		u.setName(Usuario.getName());
		u.setUsername(Usuario.getUsername());
		u.setContact(Usuario.getContact());
		u.setPassword(Usuario.getPassword());
		Usuario prod = repository.save(u);
		return prod;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
