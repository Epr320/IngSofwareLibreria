package Biblioteca.Bean;

import Biblioteca.Interfaces.CalificacionServicio;
import Biblioteca.Interfaces.LibroServicio;
import Biblioteca.Interfaces.ReseñaServicio;
import Biblioteca.entidades.Calificacion;
import Biblioteca.entidades.Libro;
import Biblioteca.entidades.Reseña;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class DetalleLibroBean implements Serializable {
    @Getter @Setter
    private String  busqueda ="2";
    @Value("#{param['hotel']}")
    private String libroParam;


    @Autowired
    LibroServicio libroServicio;

    @Autowired
    ReseñaServicio reseniaServicio;

    @Autowired
    CalificacionServicio calificacionServicio;

    @Getter @Setter
    private Libro libro;

    @Setter @Getter
    List<Reseña> resenias;

    @Setter @Getter
    List<Calificacion> calificacions;

    @Setter @Getter
    private Reseña resenia;

    @Setter @Getter
    private Calificacion calificacion;

    @Setter @Getter
    private String califica;
    @Setter @Getter
    private double promedio;

    @PostConstruct
    public void inicializar() {
        if(libroParam!=null && !libroParam.isEmpty()) {
            try {
                resenia=new Reseña();
                calificacion=new Calificacion();
                libro=  libroServicio.buscarLibroPorIsbn(libroParam);
                libro.setCalificaciones(libroServicio.buscarCalificacionLibro(libro.getIsbn()));
                resenias=libro.getReseñas();
                promedio=sacarPromedio(libro.getCalificaciones());
             //Inicializar los demás elementos, objetos, lista, imágenes, comentario etc. necesarios que se quieran mostrar en la página del detalle. Hacerlo por medio de servicios.
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private double sacarPromedio(List<Calificacion> calificaciones) {
        List<Integer>cals=new ArrayList<>();
        double prom=0;
        for(int i =0;i<calificaciones.size();i++){
            cals.add(Integer.parseInt(calificaciones.get(i).getCalificacion()));
        }
        for(int i =0;i<cals.size();i++){
            prom=prom+cals.get(i);
        }
        prom=prom/cals.size();
        return prom;
    }

    public void crearComentario(){
        try {
            resenia.setLibro(libro);
            calificacion.setLibro(libro);
            //calificacion.setId(libro.getCalificaciones().size()+1);
            reseniaServicio.agregarReseña(resenia);

            calificacionServicio.agregarCalificacion(calificacion);
            resenias.add(resenia);
            resenia = new Reseña();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
