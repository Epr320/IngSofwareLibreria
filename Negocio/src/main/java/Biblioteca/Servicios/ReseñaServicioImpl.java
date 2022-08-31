package Biblioteca.Servicios;

import Biblioteca.Repositorios.LibroRepo;
import Biblioteca.Repositorios.ReseñaRepo;
import Biblioteca.entidades.Reseña;
import Biblioteca.Interfaces.ReseñaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReseñaServicioImpl implements ReseñaServicio {

    @Autowired
    private ReseñaRepo reseñaRepo;

    @Autowired
    private LibroRepo libroRepo;

    @Override
    public Reseña agregarReseña(String libroIsbn, String contenido) throws Exception {

        Reseña reseña = new Reseña();

        reseña.setReseña(contenido);
        reseña.setLibro(libroRepo.getById(libroIsbn));

        return reseñaRepo.save(reseña);
    }
}
