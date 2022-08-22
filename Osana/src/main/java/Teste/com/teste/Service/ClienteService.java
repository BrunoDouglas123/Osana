package Teste.com.teste.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Teste.com.teste.DTO.ClienteDTO;
import Teste.com.teste.Model.Cliente;
import Teste.com.teste.Repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public List<ClienteDTO> findAll() {
		List<Cliente> result = repository.findAll();
		return result.stream().map(x -> new
		ClienteDTO(x)).collect(Collectors.toList());
	}
	
	public Cliente findById(Long id) {
		Optional<Cliente> v = repository.findById(id);
		return v.get();
	}
	
	public Cliente findByName(String name) {
		Optional<Cliente> v = repository.findByName(name);
		return v.get();
	}
	
	public Cliente findByContract(String contract) {
		Optional<Cliente> v = repository.findByContract(contract);
		return v.get();
	}
	
	public Cliente save(Cliente Cliente) {
		Cliente v = repository.save(Cliente);
		return v;
	}
	
	@Transactional
	public Cliente update(Long id,Cliente Cliente) {
		Cliente v = repository.getById(id);
		v.setId(id); 
		v.setName(Cliente.getName());
		v.setContract(Cliente.getContract());
		v.setCnpj(Cliente.getCnpj());
		Cliente vendpt = repository.save(v);
		return vendpt;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
