package Biblioteca.Bean;

import Biblioteca.Interfaces.LibroServicio;
import Biblioteca.entidades.Libro;
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
public class BusquedaBean implements Serializable {

    @Getter @Setter
    private String busqueda;

    @Value("#{param['busqueda']}")
    private String busquedaParam;

    @Autowired
    private LibroServicio libroServicio;

    @Getter @Setter
    private List<Libro> libros;

    @Getter @Setter
    private List<String> librosN;


    @PostConstruct
    public void inicializar() throws Exception {
        if( busquedaParam!=null ) {
            libros = libroServicio.buscarLibroPorNombre(busquedaParam);

        }
    }
    public String buscar() throws Exception {
         return "resultados_busqueda?faces-redirect=true&amp;busqueda="+busqueda;

    }
    public String irAlDetalle(String id) {
        return "/detalleLibro?faces-redirect=true&amp;hotel="+id;
    }

}
