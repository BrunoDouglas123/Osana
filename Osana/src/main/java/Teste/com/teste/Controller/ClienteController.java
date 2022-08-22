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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Teste.com.teste.DTO.ClienteDTO;
import Teste.com.teste.Model.Cliente;
import Teste.com.teste.Service.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

	@Autowired
	private ClienteService service;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<ClienteDTO>> findAll() throws Exception {
		try {
			System.out.println("List of Prioridades:");
			List<ClienteDTO> list = service.findAll();
			return ResponseEntity.ok(list);
		}
		catch(Exception ex) {
			throw new Exception(ex);
			}
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{id}")
	public ResponseEntity<ClienteDTO> findById(@PathVariable Long id) throws Exception {
		try {
			System.out.println("Client: " + id);
			ClienteDTO v = new ClienteDTO(service.findById(id));
			return ResponseEntity.ok(v);
	}
	catch(Exception ex) {
		throw new Exception(ex);
		}
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/name/{name}")
	public ResponseEntity<ClienteDTO> findByName(@PathVariable String name) throws Exception {
		try {
			System.out.println("Client: " + name);
			ClienteDTO v = new ClienteDTO(service.findByName(name));
			return ResponseEntity.ok(v);
		}
		catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/contrato/{contrato}")
	public ResponseEntity<ClienteDTO> findByContract(@PathVariable String contract) throws Exception {
		try {
			System.out.println("Client with: " + contract);
			ClienteDTO v = new ClienteDTO(service.findByContract(contract));
			return ResponseEntity.ok(v);
		}
		catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Cliente> save(@RequestBody Cliente Cliente) throws Exception {
		try {
			Cliente save = service.save(Cliente);
			System.out.println("New Client Saved Sucessfully.");
			return new ResponseEntity<>(save, null, HttpStatus.CREATED);
		}
		catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> update(@PathVariable Long id,@RequestBody Cliente Cliente) throws Exception {
		try {
			System.out.println("Client " + id + " Updated Sucessfully.");
			return ResponseEntity.ok(service.update(id, Cliente));
		}
		catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
		try {
			System.out.println("Client " + id + " Deleted Sucessfully.");
			service.delete(id);
			return ResponseEntity.ok().build();
		}
		catch(Exception ex) {
			throw new Exception(ex);
		}
	}
}
