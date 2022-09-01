package Biblioteca.Bean;

import Biblioteca.Interfaces.LibroServicio;
import Biblioteca.Interfaces.ReseñaServicio;
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

    @Getter @Setter
    private Libro libro;

    @Setter @Getter
    List<Reseña> resenias;

    @Setter @Getter
    private Reseña resenia;

    @PostConstruct
    public void inicializar() {
        if(libroParam!=null && !libroParam.isEmpty()) {
            try {
                resenia=new Reseña();
                libro=  libroServicio.buscarLibroPorIsbn(libroParam);
             //Inicializar los demás elementos, objetos, lista, imágenes, comentario etc. necesarios que se quieran mostrar en la página del detalle. Hacerlo por medio de servicios.
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void crearComentario(){
        try {
            resenia.setLibro(this.libro);
            reseniaServicio.agregarReseña(libroParam,resenia.getReseña());
            this.resenias.add(resenia);
            this.resenia = new Reseña();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
