package dc.library.servicio;

import java.sql.Date;
import java.util.List;

import javax.swing.text.StyledEditorKit.BoldAction;

import dc.library.modelo.Libro;
import dc.library.modelo.Reserva;
import dc.library.modelo.RespuestaReserva;
import dc.library.modelo.Usuario;

public interface IReservaServicio  {

    
    
    public List<Reserva> listarReservas();

    public Reserva guardarReserva(Reserva reserva);

    public Reserva encontrarReservaID(Integer idReserva);

    public String usuarioReserva(Integer idUsuario);

    public String libroReserva(Integer idLibro);
    
}
