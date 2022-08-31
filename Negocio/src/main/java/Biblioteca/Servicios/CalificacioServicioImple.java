package Biblioteca.Servicios;

import Biblioteca.Repositorios.CalificacionRepo;
import Biblioteca.Repositorios.LibroRepo;
import Biblioteca.entidades.Calificacion;
import Biblioteca.Interfaces.CalificacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

@Service
public class CalificacioServicioImple implements CalificacionServicio {
    @Autowired
    private CalificacionRepo calificacionRepo;

    @Autowired
    private LibroRepo libroRepo;



    @Override
    public Calificacion agregarCalificacion(String libroIsbn, Integer calificacion) throws Exception {


        Calificacion calificacion1 = new Calificacion();
        calificacion1.setCalificacion(calificacion);
        calificacion1.setLibro(libroRepo.getById(libroIsbn));
        return calificacionRepo.save(calificacion1);
    }
}
