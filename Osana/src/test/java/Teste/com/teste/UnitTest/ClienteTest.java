package Teste.com.teste.UnitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import Teste.com.teste.Model.Cliente;
import Teste.com.teste.Repository.ClienteRepository;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(
		connection = EmbeddedDatabaseConnection.H2)
public class ClienteTest {
	
	@Mock
	@Autowired
	private ClienteRepository repository;
	
	@Test
	@DisplayName("Teste da requisição POST")
	public void saveClient() throws Exception {
		Cliente Cliente = new Cliente(1L, "Ana Carolina", "true", "12345678");
		repository.save(Cliente);
		assertNotNull(Cliente);
	}
	
	@Test
	@DisplayName("Teste da requisição GET")
	public void findByClient () {
		Cliente Cliente1 = new Cliente
		(1L, "Ana Carolina", "true", "12345678");
		Cliente Cliente2 = new Cliente
		(1L, "Bruno Douglas", "true", "12345678");
		List<Cliente> Clientes = new ArrayList<>();
		Clientes.add(Cliente1);
		Clientes.add(Cliente2);
	}
	
	@Test
	@DisplayName("Teste da requisição UPDATE")
	public void updateClient () {
		String name = "Ana Carolina";
		Cliente Membro = new Cliente(1L, "Ana Carolina", "true", "12345678");
		repository.save(Membro);
		Cliente cliente = repository.findById(1L).get();
		cliente.setName(name);
		Cliente liga = repository.save(cliente);
		assertEquals(liga.getName(),name);
	}
	
	@Test
	@DisplayName("Teste da requisição DELETE")
	public void deleteClient (){
		Cliente Cliente = new Cliente(1L, "Ana Carolina", "true", "12345678");
		repository.save(Cliente);
		Long id = Cliente .getId();
		boolean cli1 = repository.findById(id).isPresent();
		repository.deleteById(id);
		boolean cli2 = repository.findById(id).isPresent();
		assertTrue(cli1);
		assertFalse(cli2);
	}
}
