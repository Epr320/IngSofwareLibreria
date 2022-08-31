package Biblioteca.Interfaces;

import Biblioteca.entidades.Libro;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface LibroServicio {


    List<Libro> buscarLibroPorNombre (String nombre) throws Exception;
    List<Libro> buscarLibroPorAutor (String nombre) throws Exception;
    List<Libro> buscarLibroPorIsbn (String nombre) throws Exception;

}
