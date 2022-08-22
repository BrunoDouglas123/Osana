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

import Teste.com.teste.DTO.RoleDTO;
import Teste.com.teste.Model.Role;
import Teste.com.teste.Service.RoleService;

@RestController
@RequestMapping(value = "/roles")
public class RoleController {

	@Autowired
	private RoleService service;
	
	@GetMapping
	public ResponseEntity<List<RoleDTO>> findAll() throws Exception {
		try {
			System.out.println("List of Roles:");
			List<RoleDTO> list = service.findAll();
			return ResponseEntity.ok(list);
		}
		catch(Exception ex) {
			throw new Exception(ex);
			}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RoleDTO> findById(@PathVariable Long id) throws Exception {
		try {
			System.out.println("Role: " + id);
			RoleDTO v = new RoleDTO(service.findById(id));
			return ResponseEntity.ok(v);
	}
	catch(Exception ex) {
		throw new Exception(ex);
		}
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<RoleDTO> findByName(@PathVariable String name) throws Exception {
		try {
			System.out.println("Role: " + name);
			RoleDTO v = new RoleDTO(service.findByName(name));
			return ResponseEntity.ok(v);
		}
		catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	
	@PostMapping
	public ResponseEntity<Role> save(@RequestBody Role Role) throws Exception {
		try {
			Role save = service.save(Role);
			System.out.println("New Role Saved Sucessfully.");
			return new ResponseEntity<>(save, null, HttpStatus.CREATED);
		}
		catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Role> update(@PathVariable Long id,@RequestBody Role Role) throws Exception {
		try {
			System.out.println("Role " + id + " Updated Sucessfully.");
			return ResponseEntity.ok(service.update(id, Role));
		}
		catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
		try {
			System.out.println("Role " + id + " Deleted Sucessfully.");
			service.delete(id);
			return ResponseEntity.ok().build();
		}
		catch(Exception ex) {
			throw new Exception(ex);
		}
	}
}
