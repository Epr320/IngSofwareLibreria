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
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class BusquedaBean implements Serializable {

    @Getter @Setter
    private String busqueda;
    @Getter @Setter
    private String libro;
    @Getter @Setter
    private String autor;
    @Getter @Setter
    private String isbn;

    @Value("#{param['busqueda']}")
    private String busquedaParam;

    @Value("#{param['autor']}")
    private String autorParam;

    @Value("#{param['isbn']}")
    private String isbnParam;
    @Autowired
    private LibroServicio libroServicio;

    @Getter @Setter
    private List<Libro> libros=new ArrayList<>();

    @Getter @Setter
    private List<Libro> librosN;


    @PostConstruct
    public void inicializar() throws Exception {
        if( busquedaParam!=null ) {
            libros = libroServicio.buscarLibroPorNombre(busquedaParam);
        }
        if(autorParam!=null&& !autorParam.isEmpty()){
            libros.addAll(libroServicio.buscarLibroPorAutor(autorParam));
        }
        if(isbnParam!=null && !isbnParam.isEmpty()) {
            Libro libro1=libroServicio.buscarLibroPorIsbn(isbnParam);
            if(libro1!=null){
                libros.add(libro1);
            }

        }
        librosN=validarDuplicados(libros);
    }

    private List<Libro> validarDuplicados(List<Libro> libros) {
        List<Libro> libros2 =new ArrayList<>();

        for(Libro i:libros){
            if(libros2.contains(i)){

            }else{
                libros2.add(i);
            }
        }

        return libros2;
    }

    public String buscar() throws Exception {
         return "resultados_busqueda?faces-redirect=true&amp;busqueda="+busqueda+"&amp;autor="+autor+"&amp;isbn="+isbn;
    }
    public String buscarAvanzado() throws Exception {
         return "resultados_busqueda?faces-redirect=true&amp;libro="+libro+";Autor="+autor+";isbn="+isbn;

    }
    public String irAlDetalle(String id) {
        return "/detalleLibro?faces-redirect=true&amp;hotel="+id;
    }

}
