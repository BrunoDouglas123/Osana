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

import Teste.com.teste.DTO.StatusDTO;
import Teste.com.teste.Model.Status;
import Teste.com.teste.Service.StatusService;

@RestController
@RequestMapping(value = "/status")
public class StatusController {

	@Autowired
	private StatusService service;
	
	@GetMapping
	public ResponseEntity<List<StatusDTO>> findAll() throws Exception {
		try {
			System.out.println("List of Status:");
			List<StatusDTO> list = service.findAll();
			return ResponseEntity.ok(list);
		}
		catch(Exception ex) {
			throw new Exception(ex);
			}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StatusDTO> findById(@PathVariable Long id) throws Exception {
		try {
			System.out.println("Status: " + id);
			StatusDTO v = new StatusDTO(service.findById(id));
			return ResponseEntity.ok(v);
	}
	catch(Exception ex) {
		throw new Exception(ex);
		}
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<StatusDTO> findByName(@PathVariable String name) throws Exception {
		try {
			System.out.println("Status: " + name);
			StatusDTO v = new StatusDTO(service.findByName(name));
			return ResponseEntity.ok(v);
		}
		catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	
	@PostMapping
	public ResponseEntity<Status> save(@RequestBody Status Status) throws Exception {
		try {
			Status save = service.save(Status);
			System.out.println("New Status Saved Sucessfully.");
			return new ResponseEntity<>(save, null, HttpStatus.CREATED);
		}
		catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Status> update(@PathVariable Long id,@RequestBody Status Status) throws Exception {
		try {
			System.out.println("Status " + id + " Updated Sucessfully.");
			return ResponseEntity.ok(service.update(id, Status));
		}
		catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
		try {
			System.out.println("Status " + id + " Deleted Sucessfully.");
			service.delete(id);
			return ResponseEntity.ok().build();
		}
		catch(Exception ex) {
			throw new Exception(ex);
		}
	}
}
