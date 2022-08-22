package Teste.com.teste.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Teste.com.teste.DTO.StatusDTO;
import Teste.com.teste.Model.Status;
import Teste.com.teste.Repository.StatusRepository;

@Service
public class StatusService {
	
	@Autowired
	private StatusRepository repository;
	
	public List<StatusDTO> findAll() {
		List<Status> result = repository.findAll();
		return result.stream().map(x -> new
		StatusDTO(x)).collect(Collectors.toList());
	}
	
	public Status findById(Long id) {
		Optional<Status> v = repository.findById(id);
		return v.get();
	}
	
	public Status findByName(String name) {
		Optional<Status> v = repository.findByName(name);
		return v.get();
	}
	
	public Status save(Status Status) {
		Status v = repository.save(Status);
		return v;
	}
	
	@Transactional
	public Status update(Long id,Status Status) {
		Status v = repository.getById(id);
		v.setId(id); 
		v.setName(Status.getName());
		Status vendpt = repository.save(v);
		return vendpt;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
