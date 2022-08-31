package Biblioteca;

import Biblioteca.Repositorios.AutorRepo;
import Biblioteca.Repositorios.LibroRepo;
import Biblioteca.entidades.Autor;
import Biblioteca.entidades.Libro;
import Biblioteca.Interfaces.LibroServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration
public class LibroServicioTest {

    @Autowired
    LibroRepo libroRepo;

    @Autowired
    AutorRepo autorRepo;

    @Autowired
    LibroServicio libroServicio;

    Libro libro;

    Autor autor;

    List<Libro> libros = new ArrayList<>();

    void crearLibro() {
        autor.setNombre("Raul g");
        autor.setCedula("1000551");
        autorRepo.save(autor);
        libro = new Libro();
        libro.setNombre("Pottor");
        libro.setAutor(autor);
        libro.setDescri("es un lib");
        libro.setIsbn("152215");
        libroRepo.save(libro);
    }
    void listaLibros(){
        autorRepo.save(autor);
        libros.add(new Libro("105","edgar","es un lib",autor));
        libros.add(new Libro("106","Harry","es un lib",autor));
        libroRepo.saveAll(libros);
    }

    @Test
    public void buscarLibroPorNombreTest(){
        crearLibro();
        listaLibros();
        try {
            System.out.println(libroServicio.buscarLibroPorNombre(libro.getNombre()));
            Assertions.assertEquals(1,libroServicio.buscarLibroPorNombre(libro.getNombre()).size());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void sumar(){
        System.out.println(2+2);
    }
}
