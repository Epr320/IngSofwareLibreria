package Biblioteca.Repositorios;


import Biblioteca.entidades.Libro;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibroRepo extends JpaRepository<Libro, String> {

    @Query("select l from Libro l where upper(l.nombre) like concat ('%' , :nombre , '%')")
    List<Libro> buscarPorNombre(String nombre);

    @Query("select l from Libro l where upper(l.autor.nombre) like concat('%', :nombreAutor, '%')")
    List<Libro> buscarPorAutor(String nombreAutor);

    @Query("select l from Libro l where upper(l.isbn) = :isbn")
    Libro buscarPorIsbn(String isbn);


}
