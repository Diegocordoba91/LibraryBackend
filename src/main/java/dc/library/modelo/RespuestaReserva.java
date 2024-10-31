package dc.library.modelo;

public class RespuestaReserva {
    
    private boolean exitoso;
    private String mensaje;
    private Reserva reserva;
    private String persona;
    private String libro;   
    
    public String getPersona() {
        return persona;
    }
    public void setPersona(String persona) {
        this.persona = persona;
    }
    public String getLibro() {
        return libro;
    }
    public void setLibro(String libro) {
        this.libro = libro;
    }
    public boolean isExitoso() {
        return exitoso;
    }
    public void setExitoso(boolean exitoso) {
        this.exitoso = exitoso;
    }
    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public Reserva getReserva() {
        return reserva;
    }
    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
    @Override
    public String toString() {
        return "RespuestaReserva [exitoso=" + exitoso + ", mensaje=" + mensaje + ", reserva=" + reserva + ", persona="
                + persona + ", libro=" + libro + "]";
    }
    
    

        

}
