package sistemaAutogestion;

import java.util.Date;

public class ListaFecha implements IListaFecha {
    NodoFecha inicio;
    NodoFecha ultimo;
    int cantNodos;
    
    public ListaFecha(){
        this.inicio = null;
        this.ultimo = null;
        this.cantNodos = 0;
    }

    public NodoFecha getInicio() {
        return inicio;
    }

    public void setInicio(NodoFecha inicio) {
        this.inicio = inicio;
    }

    public NodoFecha getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoFecha ultimo) {
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
    public void agregarInicio(Date fecha) {
        NodoFecha nuevo = new NodoFecha(fecha);
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
            NodoFecha aux = this.getInicio();
            while (aux != null) {
                System.out.println("Fecha: " + aux.getFecha());
                aux = aux.getSiguiente();
            }
        }
    }

    @Override
    public int cantidad() {
        return this.getCantNodos();
    }
    
    public boolean tieneFecha(Date fecha){        
        NodoFecha aux = this.getInicio();
        while(aux != null){
            if(aux.getFecha().equals(fecha)){
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }
    
}
