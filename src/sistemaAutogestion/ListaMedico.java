package sistemaAutogestion;

public class ListaMedico implements IListaMedico {
    NodoMedico inicio;
    NodoMedico ultimo;
    int cantNodos;

    //CONSTRUCTOR
    public ListaMedico() {
        this.inicio = null;
        this.ultimo = null;
        this.cantNodos = 0;
    }

    //GETTERS Y SETTERS
    public NodoMedico getInicio() {
        return inicio;
    }

    public void setInicio(NodoMedico inicio) {
        this.inicio = inicio;
    }

    public NodoMedico getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoMedico ultimo) {
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
    public void agregarInicio(String nombre, int codMedico, int tel, int especialidad) {
        NodoMedico nuevo = new NodoMedico(nombre, codMedico, tel, especialidad);
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
    public void borrarElemento(int codMedico) {
        if (!this.esVacia()) {
            NodoMedico aux = this.getInicio();
            if (aux.getCodMedico() == codMedico) {
                this.setInicio(this.getInicio().getSiguiente());
            } else {
                while (aux.siguiente != null) {
                    if (aux.siguiente.getCodMedico() == codMedico) {
                        aux.siguiente = aux.siguiente.siguiente;
                        break;
                    }
                    aux = aux.siguiente;
                }
            }
            this.cantNodos--;
        }
    }

    @Override
    public void listar() {
        NodoMedico aux = this.getInicio();
        while(aux != null){
            System.out.println(aux.getNombre() + " - " + aux.getCodMedico());
            aux = aux.getSiguiente();
        }
    }

    @Override
    public int cantidad() {
        return this.getCantNodos();
    }

    //METODOS AUX
    public NodoMedico obtenerMedico(int codMedico){
        NodoMedico aux = this.getInicio();
        while(aux != null){
            if(aux.getCodMedico() == codMedico){
                return aux;
            }
            aux = aux.getSiguiente();
        }
        return null;
    }

    // YA NO SE USA, SE HABIA HECHO ASI PARA ENTREGA 1.
    public boolean existePacienteEnListaMedico(int CI) {
        NodoMedico aux = this.getInicio();
        while (aux != null) {
            NodoPaciente aux2 = aux.getLp().obtenerPaciente(CI);
            if (aux2 != null) {
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }
    
    
                        
    public NodoMedico obtenerMedicoPorEspecialidad(int especialidad) {
        NodoMedico aux = this.getInicio();
        while (aux != null) {
            if (aux.getEspecialidad() == especialidad) {
                return aux;
            }
            aux = aux.getSiguiente();
        }
        return null;
    }
    
    public ListaMedico obtenerMedicosPorEspecialidad(int especialidad){
        ListaMedico lista = new ListaMedico();
        
        NodoMedico aux = this.getInicio();
        while (aux != null){
            if(aux.getEspecialidad() == especialidad){
                lista.agregarInicio(aux.getNombre(), aux.getCodMedico(), aux.getTel(), especialidad);
            }
            aux = aux.getSiguiente();
        }
        
        return lista;
    }

}
