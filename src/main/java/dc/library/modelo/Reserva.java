package dc.library.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@Table(name="reservas")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    Integer idpersona;
    Integer idlibro;
    Date fechareserva;
    Integer estadoreserva;
    Date fechadevolucion;

}


