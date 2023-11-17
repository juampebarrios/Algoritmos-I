package sistemaAutogestion;

import java.util.Date;

public class NodoFecha {
    Date fecha;
    NodoFecha siguiente;

    public NodoFecha(Date fecha) {
        this.fecha = fecha;
        this.siguiente = null;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public NodoFecha getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoFecha siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
