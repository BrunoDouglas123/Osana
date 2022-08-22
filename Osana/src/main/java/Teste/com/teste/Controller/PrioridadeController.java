package Teste.com.teste.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Teste.com.teste.DTO.PrioridadeDTO;
import Teste.com.teste.Model.Prioridade;
import Teste.com.teste.Service.PrioridadeService;

@RestController
@RequestMapping(value = "/prioridades")
public class PrioridadeController {

	@Autowired
	private PrioridadeService service;
	
	@GetMapping
	public ResponseEntity<List<PrioridadeDTO>> findAll() throws Exception {
		try {
			System.out.println("List of Prioridades:");
			List<PrioridadeDTO> list = service.findAll();
			return ResponseEntity.ok(list);
		}
		catch(Exception ex) {
			throw new Exception(ex);
			}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PrioridadeDTO> findById(@PathVariable Long id) throws Exception {
		try {
			System.out.println("Prioridade: " + id);
			PrioridadeDTO v = new PrioridadeDTO(service.findById(id));
			return ResponseEntity.ok(v);
	}
	catch(Exception ex) {
		throw new Exception(ex);
		}
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<PrioridadeDTO> findByName(@PathVariable String name) throws Exception {
		try {
			System.out.println("Prioridade: " + name);
			PrioridadeDTO v = new PrioridadeDTO(service.findByName(name));
			return ResponseEntity.ok(v);
		}
		catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	
	@PostMapping
	public ResponseEntity<Prioridade> save(@RequestBody Prioridade Prioridade) throws Exception {
		try {
			Prioridade save = service.save(Prioridade);
			System.out.println("New Prioridade Saved Sucessfully.");
			return new ResponseEntity<>(save, null, HttpStatus.CREATED);
		}
		catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Prioridade> update(@PathVariable Long id,@RequestBody Prioridade Prioridade) throws Exception {
		try {
			System.out.println("Prioridade " + id + " Updated Sucessfully.");
			return ResponseEntity.ok(service.update(id, Prioridade));
		}
		catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
		try {
			System.out.println("Prioridade " + id + " Deleted Sucessfully.");
			service.delete(id);
			return ResponseEntity.ok().build();
		}
		catch(Exception ex) {
			throw new Exception(ex);
		}
	}
}
