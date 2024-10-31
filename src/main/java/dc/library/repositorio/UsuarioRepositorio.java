package dc.library.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import dc.library.modelo.Usuario;

//En la interfas se indica el tipo de clase (usuario) y el tipo de la llave primaria (Integer)
//Permita que java se comunique con la entidad
public interface UsuarioRepositorio extends JpaRepository<Usuario,Integer> {
    
}
