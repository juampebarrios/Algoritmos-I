package sistemaAutogestion;

import java.util.Date;

public class NodoHistorial {
    int id;
    String detalles;
    int codMedico;
    Date fecha;
    NodoHistorial siguiente;
    
    public NodoHistorial(String detalles, int codMedico, Date fecha, int id) {
        this.id = id;
        this.detalles = detalles;
        this.codMedico = codMedico;
        this.fecha = fecha;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public int getCodMedico() {
        return codMedico;
    }

    public void setCodMedico(int codMedico) {
        this.codMedico = codMedico;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NodoHistorial getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoHistorial siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
