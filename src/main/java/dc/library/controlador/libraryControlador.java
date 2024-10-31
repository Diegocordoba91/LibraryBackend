package dc.library.controlador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import javax.swing.LookAndFeel;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.log4j2.WhitespaceThrowablePatternConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dc.library.modelo.Libro;
import dc.library.modelo.Reserva;
import dc.library.modelo.RespuestaReserva;
import dc.library.modelo.Usuario;
import dc.library.servicio.LibroServicio;
import dc.library.servicio.ReservaServicio;
import dc.library.servicio.UsuarioServicio;

@RestController
@RequestMapping("libraryAppDev")//http://localhost:8080/libraryAppDev/
@CrossOrigin(value = "http://localhost:4200")
public class libraryControlador {
    //Código para imprimir mensajes en consola
    private static final Logger logger = LoggerFactory.getLogger(libraryControlador.class);

    @Autowired
    private UsuarioServicio usuarioServicio;
    
    @Autowired
    private LibroServicio libroServicio;

    @Autowired
    private ReservaServicio reservaServicio;

    @GetMapping("/GetUsuarios")
    public List<Usuario> obtenerUsuario(){
        List<Usuario> usuarios = this.usuarioServicio.listarUsuarios();
        logger.info("Usuarios obtenidos: ");
        usuarios.forEach((usuario ->logger.info(usuario.toString())));
        return usuarios;
    };

    @GetMapping("/GetUsuarios/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioId(@PathVariable int id){
        Usuario usuario= this.usuarioServicio.buscarUsuarioId(id);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/PostUsuarios")
    public Usuario agregarUsuario(@RequestBody Usuario usuario){
        logger.info("El usuario a agregar es: " + usuario);
        return this.usuarioServicio.guardarUsuario(usuario);

    }

    @GetMapping("/GetLibros")
    public List<Libro> obtenerLibros(){
        
        List<Libro> libros = this.libroServicio.listaLibros();
        logger.info("Libros obtenidos: ");
        libros.forEach((libro -> logger.info(libro.toString())));
        return libros;
    }

    @GetMapping("/GetLibros/{id}")
    public ResponseEntity<Libro> obtenerLibroId(@PathVariable int id){
        Libro libro = this.libroServicio.buscarLibroID(id);
        return ResponseEntity.ok(libro);
    }

    @PostMapping("/PostLibros")
    public Libro agregarLibro(@RequestBody Libro libro){
        logger.info("El libro agregado es: ");
        return this.libroServicio.guardarLibro(libro);

    }


    @GetMapping("GetReservas")
    public List<RespuestaReserva> obtenerReservas() {

        List<Reserva> reservas = this.reservaServicio.listarReservas();
        List<RespuestaReserva> respuestaReservas = new ArrayList<>();
        
        int index = 1;
        for (Reserva reserva : reservas) {
            RespuestaReserva respuestaReserva = new RespuestaReserva();
            respuestaReserva.setReserva(reserva);
            respuestaReserva.setExitoso(true);
            respuestaReserva.setMensaje("Reserva "+ index);
            respuestaReserva.setPersona(reservaServicio.usuarioReserva(reserva.getIdpersona()));
            respuestaReserva.setLibro(reservaServicio.libroReserva(reserva.getIdlibro()));
            respuestaReservas.add(respuestaReserva);
            index++;
        }
        return respuestaReservas;
        
    }

    @PostMapping("PostGuardarReserva")
    public ResponseEntity<RespuestaReserva> guardarReserva(@RequestBody Reserva reserva){
        RespuestaReserva respuesta = new RespuestaReserva();
        Reserva reservaGuardar = this.reservaServicio.guardarReserva(reserva);
        logger.info("La reserva a guardar es: "+reserva);
        
        if(reservaGuardar!=null){
            if (reservaGuardar.getFechadevolucion()==null) {
                    this.reservaServicio.guardarReserva(reserva);
                    respuesta.setExitoso(true);
                    respuesta.setMensaje("Se ha realizado la reserva existosamente");
                    respuesta.setReserva(reserva);
                    respuesta.setPersona(reservaServicio.usuarioReserva(reserva.getIdpersona()));
                    respuesta.setLibro(reservaServicio.libroReserva(reserva.getIdlibro()));
    
                
                }else if (reservaGuardar.getFechadevolucion()!=null) {
                    this.reservaServicio.guardarReserva(reserva);
                    respuesta.setExitoso(true);
                    respuesta.setMensaje("Se ha devuelto el libro existosamente");
                    respuesta.setReserva(reserva);
                    respuesta.setPersona(reservaServicio.usuarioReserva(reserva.getIdpersona()));
                    respuesta.setLibro(reservaServicio.libroReserva(reserva.getIdlibro()));
                }
        
        
        } else {
            respuesta.setExitoso(false);
            respuesta.setMensaje("Existencias del libro insuficientes");
            respuesta.setPersona(null);
            respuesta.setLibro(null);
        }
        return ResponseEntity.ok(respuesta);

    }

    @GetMapping("/GetReservas/{id}")
    public ResponseEntity<RespuestaReserva>obtenerReservaID(@PathVariable int id){
        Reserva reserva =this.reservaServicio.encontrarReservaID(id);
        RespuestaReserva respuestaReserva=new RespuestaReserva();
        respuestaReserva.setMensaje("Reserva encontrada");
        respuestaReserva.setExitoso(true);
        respuestaReserva.setReserva(reserva);
        respuestaReserva.setLibro(this.reservaServicio.libroReserva(reserva.getIdlibro()));
        respuestaReserva.setPersona(this.reservaServicio.usuarioReserva(reserva.getIdpersona()));
        
        return ResponseEntity.ok(respuestaReserva);

    }

    
}



