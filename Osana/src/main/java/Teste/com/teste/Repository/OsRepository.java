package Teste.com.teste.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Teste.com.teste.Model.Os;

@Repository
public interface OsRepository extends JpaRepository <Os, Long> {

	Optional<Os> findByMotive(String motive);

}
