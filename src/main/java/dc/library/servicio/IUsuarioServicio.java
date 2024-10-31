package dc.library.servicio;

import java.util.List;

import dc.library.modelo.Usuario;

public interface IUsuarioServicio {

    public List<Usuario> listarUsuarios();
    public Usuario buscarUsuarioId(Integer idUsuario);
    public Usuario guardarUsuario(Usuario usuario);//Inserta o actualiza con base si es null el usuario
}
