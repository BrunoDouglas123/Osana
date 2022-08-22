package Teste.com.teste.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Teste.com.teste.Model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Long> {

	Optional<Cliente> findByName(String name);

	Optional<Cliente> findByContract(String contract);

}
