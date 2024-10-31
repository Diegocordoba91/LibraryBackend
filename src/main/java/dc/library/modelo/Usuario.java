package dc.library.modelo;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//Se declara la entidad para creación automatica de la tabla
@Entity
@Table(name="usuario")
@Data//lombok crea de forma automatica los metodos get - set
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;//idUsuario

    @Column(name = "nombre")
    String nombre;//nombre

    @Column(name = "apellido")
    String apellido;//apellido

    @Column(name = "documento")
    Integer documento;//numeroDocumento

    @Column(name = "direccion")
    String direccion;//direccion

    @Column(name = "telefono")
    String telefono;//telefonoUsuario
    
}
