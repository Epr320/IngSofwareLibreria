package Biblioteca.entidades;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Autor implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @NotBlank
    @Length(min=10, max=10,message ="La cedula debe tener 10 caracteres.")
    private String cedula;

    @Column(nullable = false)
    @Length(min=3, max=15,message ="El nombre debe tener entre 3 y 15 caracteres.")
    @NotBlank
    private String nombre;


    @OneToMany(mappedBy = "autor")
    private List<Libro> libros;

    @Override
    public String toString() {
        return "Autor{" +
                "cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
