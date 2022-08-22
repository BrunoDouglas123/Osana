package Teste.com.teste.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Teste.com.teste.Model.Status;

@Repository
public interface StatusRepository extends JpaRepository <Status, Long> {

	Optional<Status> findByName(String name);

}
