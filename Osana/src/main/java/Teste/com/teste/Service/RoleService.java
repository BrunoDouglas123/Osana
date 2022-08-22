package Teste.com.teste.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Teste.com.teste.DTO.RoleDTO;
import Teste.com.teste.Model.Role;
import Teste.com.teste.Repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository repository;
	
	public List<RoleDTO> findAll() {
		List<Role> result = repository.findAll();
		return result.stream().map(x -> new
		RoleDTO(x)).collect(Collectors.toList());
	}
	
	public Role findById(Long id) {
		Optional<Role> v = repository.findById(id);
		return v.get();
	}
	
	public Role findByName(String name) {
		Optional<Role> v = repository.findByName(name);
		return v.get();
	}
	
	public Role save(Role Role) {
		Role v = repository.save(Role);
		return v;
	}
	
	@Transactional
	public Role update(Long id,Role Role) {
		Role v = repository.getById(id);
		v.setId(id); 
		v.setName(Role.getName());
		Role vendpt = repository.save(v);
		return vendpt;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
