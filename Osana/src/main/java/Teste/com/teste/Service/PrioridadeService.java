package Teste.com.teste.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Teste.com.teste.DTO.PrioridadeDTO;
import Teste.com.teste.Model.Prioridade;
import Teste.com.teste.Repository.PrioridadeRepository;

@Service
public class PrioridadeService {
	
	@Autowired
	private PrioridadeRepository repository;
	
	public List<PrioridadeDTO> findAll() {
		List<Prioridade> result = repository.findAll();
		return result.stream().map(x -> new
		PrioridadeDTO(x)).collect(Collectors.toList());
	}
	
	public Prioridade findById(Long id) {
		Optional<Prioridade> v = repository.findById(id);
		return v.get();
	}
	
	public Prioridade findByName(String name) {
		Optional<Prioridade> v = repository.findByName(name);
		return v.get();
	}
	
	public Prioridade save(Prioridade Prioridade) {
		Prioridade v = repository.save(Prioridade);
		return v;
	}
	
	@Transactional
	public Prioridade update(Long id,Prioridade Prioridade) {
		Prioridade v = repository.getById(id);
		v.setId(id); 
		v.setName(Prioridade.getName());
		Prioridade vendpt = repository.save(v);
		return vendpt;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
