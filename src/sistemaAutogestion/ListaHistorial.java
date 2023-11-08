package sistemaAutogestion;

import java.util.Date;

public class ListaHistorial implements IListaHistorial{
    NodoHistorial inicio;
    NodoHistorial ultimo;
    int cantNodos;
    
    // CONSTRUCTOR
    public ListaHistorial(){
        this.inicio = null;
        this.ultimo = null;
        this.cantNodos = 0;
    }
    
    // GETTER Y SETTERS

    public NodoHistorial getInicio() {
        return inicio;
    }

    public void setInicio(NodoHistorial inicio) {
        this.inicio = inicio;
    }

    public NodoHistorial getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoHistorial ultimo) {
        this.ultimo = ultimo;
    }

    public int getCantNodos() {
        return cantNodos;
    }

    public void setCantNodos(int cantNodos) {
        this.cantNodos = cantNodos;
    }
    
    
    @Override
    public boolean esVacia() {
        return (this.getInicio() == null);
    }

    @Override
    public void agregarInicio(String detalles, int codMedico, Date fecha) {
        NodoHistorial nuevo = new NodoHistorial(detalles, codMedico, fecha, this.cantNodos);
        if (this.esVacia()) {
            this.setInicio(nuevo);
            this.setUltimo(nuevo);
        } else {
            nuevo.setSiguiente(this.getInicio());
            this.setInicio(nuevo);
        }
        this.cantNodos++;
    }

    @Override
    public void listar() {
    if (!this.esVacia()) {
            NodoHistorial aux = this.getInicio();
            while (aux != null) {
                System.out.println("Medico: " + aux.getCodMedico() + " Detalles: " + aux.getDetalles() + " Fecha: " + aux.getFecha());
                aux = aux.getSiguiente();
            }
        }
    }

    @Override
    public int cantidad() {
        return this.cantNodos;
    }
    
}
