package Biblioteca.Servicios;

import Biblioteca.Repositorios.LibroRepo;
import Biblioteca.entidades.Libro;
import Biblioteca.Interfaces.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServicioImpl implements LibroServicio {

    @Autowired
    private LibroRepo libroRepo;



    @Override
    public List<Libro> buscarLibroPorNombre(String nombre) throws Exception {
        return libroRepo.buscarPorNombre(nombre.toUpperCase());

    }

    @Override
    public List<Libro> buscarLibroPorAutor(String nombre) throws Exception {
        return libroRepo.buscarPorAutor(nombre.toUpperCase());
    }

    @Override
    public List<Libro> buscarLibroPorIsbn(String nombre) throws Exception {
        return libroRepo.buscarPorIsbn(nombre.toUpperCase());
    }
}
