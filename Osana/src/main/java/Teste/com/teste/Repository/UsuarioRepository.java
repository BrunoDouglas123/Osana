package Teste.com.teste.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Teste.com.teste.Model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Long> {

	Optional<Usuario> findByName(String name);

}
