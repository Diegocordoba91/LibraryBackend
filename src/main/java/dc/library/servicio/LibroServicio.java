package dc.library.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dc.library.modelo.Libro;
import dc.library.repositorio.LibroRepositorio;

@Service
public class LibroServicio implements ILibroServicio{
    
    @Autowired
    private LibroRepositorio libroRepositorio;

    @Override
    public List<Libro> listaLibros() {
        return this.libroRepositorio.findAll(); 
        
    }

    @Override
    public Libro guardarLibro(Libro libro) {
        
        return this.libroRepositorio.save(libro);

    }

    @Override
    public Libro buscarLibroID(Integer idLibro) {
        Libro libro = this.libroRepositorio.findById(idLibro).orElse(null);
        return libro;
    }


    
}
