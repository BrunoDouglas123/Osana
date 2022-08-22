package Teste.com.teste.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Teste.com.teste.Model.Prioridade;

@Repository
public interface PrioridadeRepository extends JpaRepository <Prioridade, Long> {

	Optional<Prioridade> findByName(String name);

}
