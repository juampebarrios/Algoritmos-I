package sistemaAutogestion;

import java.util.Date;

public class NodoReserva {
    int id;
    String estado;
    int codMedico;
    int ciPaciente;
    Date fecha;
    NodoReserva siguiente;
    
    // NODO RESERVA

    public NodoReserva(String estado, int codMedico, int ciPaciente, Date fecha, int id) {
        this.id = id;
        this.estado = estado;
        this.codMedico = codMedico;
        this.ciPaciente = ciPaciente;
        this.fecha = fecha;
        this.siguiente = null;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCodMedico() {
        return codMedico;
    }

    public void setCodMedico(int codMedico) {
        this.codMedico = codMedico;
    }

    public int getCiPaciente() {
        return ciPaciente;
    }

    public void setCiPaciente(int ciPaciente) {
        this.ciPaciente = ciPaciente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public NodoReserva getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoReserva siguiente) {
        this.siguiente = siguiente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
