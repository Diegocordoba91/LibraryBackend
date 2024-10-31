package dc.library.servicio;

import java.util.List;

import dc.library.modelo.Libro;

public interface ILibroServicio {

    public List<Libro> listaLibros();
    public Libro guardarLibro(Libro libro) ;
    public Libro buscarLibroID(Integer idLibro);
    
        
}
