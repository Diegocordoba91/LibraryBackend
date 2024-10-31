package dc.library.servicio;

import java.lang.StackWalker.Option;
import java.sql.Date;
import java.util.List;
import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.classic.joran.action.LoggerAction;
import dc.library.modelo.Libro;
import dc.library.modelo.Reserva;
import dc.library.modelo.RespuestaReserva;
import dc.library.modelo.Usuario;
import dc.library.repositorio.LibroRepositorio;
import dc.library.repositorio.ReservaRepositorio;
import dc.library.repositorio.UsuarioRepositorio;

@Service
public class ReservaServicio implements IReservaServicio{
    private static final Logger logger = LoggerFactory.getLogger(ReservaServicio.class);
    
    @Autowired
    private ReservaRepositorio reservaRepositorio;

    @Autowired
    private LibroRepositorio libroRepositorio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    
    //metodo para guardar reservar

    @Override
    public Reserva guardarReserva(Reserva reserva) {
        
        Optional<Libro> libroReserva = this.libroRepositorio.findById(reserva.getIdlibro());
        //Reserva reservaExiste= reservaRepositorio.findById(reserva.getId()).orElse(null);
        if(reserva.getId()!=null){
            return this.reservaRepositorio.save(reserva);

        }else{
            List<Reserva> reservas = this.reservaRepositorio.findAll();
            var reservasLibro=0;
            
            for (Reserva reserva2 : reservas) {//1=Reservado --- 0=Devuelto
                if(reserva2.getIdlibro()==reserva.getIdlibro()&&reserva2.getEstadoreserva()==1)
                reservasLibro++;
            }   

            if(reservasLibro>=libroReserva.get().getExistencias()){
                    logger.info("Existencias del libro insuficientes");
                    return null;
            
            }else{
                    return this.reservaRepositorio.save(reserva);
                    
            }
        }

    }

    @Override
    public List<Reserva> listarReservas() {
        return this.reservaRepositorio.findAll();
    }

      
    @Override
    public Reserva encontrarReservaID(Integer idReserva) {
        var reserva = this.reservaRepositorio.findById(idReserva).orElse(null);
        return reserva;
    }

    @Override
    public String usuarioReserva(Integer idUsuario) {
        Optional<Usuario> usuario = this.usuarioRepositorio.findById(idUsuario);

        return usuario.get().getNombre() +" "+ usuario.get().getApellido();
        
    }

    @Override
    public String libroReserva(Integer idLibro) {
        Optional<Libro> libro = this.libroRepositorio.findById(idLibro);

        return libro.get().getTitulo();
    }

    
}
