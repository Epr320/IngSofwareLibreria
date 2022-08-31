package Biblioteca.Repositorios;

import Biblioteca.entidades.Libro;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UsuarioRepo extends JpaRepository<Libro, String> {

}
