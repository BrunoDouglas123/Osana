package Teste.com.teste.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Teste.com.teste.DTO.OsDTO;
import Teste.com.teste.Model.Os;
import Teste.com.teste.Model.Usuario;
import Teste.com.teste.Repository.OsRepository;
import Teste.com.teste.Repository.UsuarioRepository;

@Service
public class OsService {

	@Autowired
	private OsRepository repository;
	
	@Autowired
	private UsuarioRepository vendrepository;
	
	public List<OsDTO> findAll() {
		List<Os>result = repository.findAll();
		return result.stream().map(x -> new 
		OsDTO(x)).collect(Collectors.toList());
	}
	
	public Os findById(Long id) {
		Optional<Os> o = repository.findById(id);
		return o.get();
	}
	
	public Os findByMotive(String motive) {
		Optional<Os> o = repository.findByMotive(motive);
		return o.get();
	}
	
	public Os save(Os Os) {
		Usuario Usuario = vendrepository.findById
		(Os.getUsuario().getId()).get();
		Os.setUsuario(Usuario);
		Os o = repository.save(Os);
		return o;
	}
	
	@Transactional
	public Os update(Long id,Os Os) {
		Os o = repository.getById(id);
		o.setId(id);
		o.setMotive(Os.getMotive());
		o.setObs(Os.getObs());
		o.setDevolution(Os.getDevolution());
		o.setDateos(Os.getDateos());
		Os prod = repository.save(o);
		return prod;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
