package Biblioteca.Interfaces;

import Biblioteca.entidades.Calificacion;
import org.springframework.stereotype.Component;

@Component
public interface CalificacionServicio {

    Calificacion agregarCalificacion (Calificacion calificacion) throws Exception;
}
