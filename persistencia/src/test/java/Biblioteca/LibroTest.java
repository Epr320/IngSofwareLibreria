package Biblioteca;

import Biblioteca.Repositorios.LibroRepo;
import Biblioteca.entidades.Libro;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LibroTest {

    @Autowired
    private LibroRepo usuarioRepo;

    @Test
    public Libro validarLibro(){
     return null;
    }

    @Test
    public void listarUsuariosTest(){
    //Obtenemos la lista de todos los usuarios
        List<Libro> lista = usuarioRepo.findAll();
    //Imprimimos la lista
        System.out.println(lista);
    }

}
