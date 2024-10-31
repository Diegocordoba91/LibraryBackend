package dc.library.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import dc.library.modelo.Libro;
import dc.library.modelo.Reserva;

public interface LibroRepositorio extends JpaRepository <Libro, Integer>{
    
    
}


