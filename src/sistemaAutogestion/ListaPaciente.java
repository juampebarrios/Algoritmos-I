package sistemaAutogestion;

public class ListaPaciente implements IListaPaciente {
    NodoPaciente inicio;
    NodoPaciente ultimo;
    int cantNodos;

    //CONSTRUCTOR
    public ListaPaciente() {
        this.inicio = null;
        this.ultimo = null;
        this.cantNodos = 0;
    }

    //GETTERS Y SETTERS
    public NodoPaciente getInicio() {
        return inicio;
    }

    public void setInicio(NodoPaciente inicio) {
        this.inicio = inicio;
    }

    public NodoPaciente getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoPaciente ultimo) {
        this.ultimo = ultimo;
    }

    public int getCantNodos() {
        return cantNodos;
    }

    public void setCantNodos(int cantNodos) {
        this.cantNodos = cantNodos;
    }

    //METODOS
    @Override
    public boolean esVacia() {
        return (this.getInicio() == null);
    }

    @Override
    public void agregarInicio(String nombre, int CI, String direccion) {
        NodoPaciente nuevo = new NodoPaciente(nombre, CI, direccion);
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
    public void borrarElemento(int CI) {
        if (!this.esVacia()) {
            if (this.getInicio().getCI() == CI) {
                this.setInicio(this.getInicio().getSiguiente());
            } else {
                NodoPaciente aux = this.getInicio();
                while (aux.getSiguiente() != null && aux.getSiguiente().getCI() != CI) {
                    aux = aux.getSiguiente();
                }
                if (aux.getSiguiente() != null) {
                    aux.setSiguiente(aux.getSiguiente().getSiguiente());
                }
            }
            this.cantNodos--;
        }
    }

    @Override
    public void listar() {
        if (!this.esVacia()) {
            NodoPaciente aux = this.getInicio();
            while (aux != null) {
                System.out.println("Nombre: " + aux.getNombre() + " CI: " + aux.getCI() + " Direccion: " + aux.getDireccion());
                aux = aux.getSiguiente();
            }
        }
    }

    @Override
    public int cantidad() {
        return this.getCantNodos();
    }

    //METODOS AUX
    public NodoPaciente obtenerPaciente(int CI){
        NodoPaciente aux = this.getInicio();
        while(aux != null){
            if(aux.getCI() == CI){
                return aux;
            }
            aux = aux.getSiguiente();
        }
        return null;
    }
}
