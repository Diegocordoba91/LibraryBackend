package dc.library.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dc.library.modelo.Usuario;
import dc.library.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicio implements IUsuarioServicio {

    @Autowired//Inyecta la capa de repositorio para que se pueda comunicar con la entidad
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public Usuario buscarUsuarioId(Integer idUsuario) {
        
        Usuario usuario = this.usuarioRepositorio.findById(idUsuario).orElse(null);
        return usuario;
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        
        return this.usuarioRepositorio.save(usuario);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return this.usuarioRepositorio.findAll();
        
    }
    
    
}
