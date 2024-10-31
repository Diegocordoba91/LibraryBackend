package dc.library.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;

import dc.library.modelo.Reserva;


public interface ReservaRepositorio extends JpaRepository <Reserva, Integer>{
    
}
