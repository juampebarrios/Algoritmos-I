package sistemaAutogestion;
import java.util.Calendar;
import java.util.Date;

public class ListaReserva implements IListaReserva{
    NodoReserva inicio;
    NodoReserva ultimo;
    int cantidadNodos;

    // CONSTRUCTOR
    public ListaReserva() {
        this.inicio = null;
        this.ultimo = null;
        this.cantidadNodos = 0;
    }
    
    // GETTER Y SETTERS
    public NodoReserva getInicio() {
        return inicio;
    }
    public void setInicio(NodoReserva inicio) {
        this.inicio = inicio;
    }
    public NodoReserva getUltimo() {
        return ultimo;
    }
    public void setUltimo(NodoReserva ultimo) {
        this.ultimo = ultimo;
    }
    public int getCantidadNodos() {
        return cantidadNodos;
    }
    public void setCantidadNodos(int cantidadNodos) {
        this.cantidadNodos = cantidadNodos;
    }
    
    
    @Override
    public boolean esVacia() {
        return (this.getInicio() == null);
    }

    @Override
    public void agregarInicio(int codMedico, int ciPaciente, Date fecha) {
        this.cantidadNodos++;
        NodoReserva nuevo = new NodoReserva("pendiente", codMedico, ciPaciente, fecha, this.cantidadNodos);
        if (this.esVacia()) {
            this.setInicio(nuevo);
            this.setUltimo(nuevo);
        } else {
            nuevo.setSiguiente(this.getInicio());
            this.setInicio(nuevo);
        }
            }

    @Override
    public void borrarElemento(int codMedico, int ciPaciente) {
        if (!this.esVacia()) {
            if (this.getInicio().getCodMedico() == codMedico 
                    && this.getInicio().getCiPaciente() == ciPaciente
                    && !this.getInicio().getEstado().equals("cerrada")) {
                this.setInicio(this.getInicio().getSiguiente());
            } else {
                NodoReserva aux = this.getInicio();
                while (aux.getSiguiente() != null 
                        && aux.getSiguiente().getCodMedico() != codMedico 
                        && aux.getSiguiente().getCiPaciente() != ciPaciente
                        && !aux.getSiguiente().getEstado().equals("cerrada")) {
                    aux = aux.getSiguiente();
                }
                if (aux.getSiguiente() != null) {
                    aux.setSiguiente(aux.getSiguiente().getSiguiente());
                }
            }
            this.cantidadNodos--;
        }
    }

    @Override
    public void listar() {
        if (!this.esVacia()) {
            NodoReserva aux = this.getInicio();
            while (aux != null) {
                System.out.println("Medico: " + aux.getCodMedico() + " Paciente: " + aux.getCiPaciente() + " Fecha: " + aux.getFecha());
                aux = aux.getSiguiente();
            }
        }
    }

    @Override
    public int cantidad() {
        return this.getCantidadNodos();
    }
    
    // METODOS AUX
    public NodoReserva obtenerReserva(int codMedico, int ciPaciente){
        NodoReserva aux = this.getInicio();
        while(aux != null){
            if(aux.getCodMedico() == codMedico 
                    && aux.getCiPaciente() == ciPaciente
                    && !aux.getEstado().equals("cerrada")){
                return aux;
            }
            aux = aux.getSiguiente();
        }
        return null;
    }
    
    public boolean listarEnEspera(int codMedico, Date fecha){
        boolean isEmpty = true;
        if (!this.esVacia()) {
            NodoReserva aux = this.getInicio();
            while (aux != null) {
                if(aux.getCodMedico() == codMedico && aux.getFecha().toString().equals(fecha.toString()) && aux.getEstado().equals("en espera")){
                    System.out.println("Paciente: " + aux.getCiPaciente() + " Medico: " + aux.getCodMedico());
                    isEmpty = false;
                }
                aux = aux.getSiguiente();
            }
        }
        return isEmpty;
    }

    public void listarPendientesPaciente(int ciPaciente){
        if (!this.esVacia()) {
            NodoReserva aux = this.getInicio();
            while (aux != null) {
                if(aux.getCiPaciente() == ciPaciente && aux.getEstado().equals("pendiente")){
                    System.out.println("Medico: " + aux.getCodMedico() + " Fecha: " + aux.getFecha());
                }
                aux = aux.getSiguiente();
            }
        }
    }

    public boolean pacienteReservoAlgunaVez (int ciPaciente){
        if (!this.esVacia()) {
            NodoReserva aux = this.getInicio();
            while (aux != null) {
                if(aux.getCiPaciente() == ciPaciente){
                    return true;
                }
                aux = aux.getSiguiente();
            }
        }
        return false;
    }
    
    public int obtenerCantidadPacienteXDia(int dia, int año, int codEspecialidad, ListaMedico medicos) {
        int cantidadReservas = 0;
        ListaMedico medicosEspecialidad = medicos.obtenerMedicosPorEspecialidad(codEspecialidad);
        
        if (!this.esVacia()) {
            NodoReserva aux = this.getInicio();
            Calendar calendar = Calendar.getInstance();

            while (aux != null) {
                // Configurar el calendario con la fecha de la reserva actual
                calendar.setTime(aux.getFecha());

                // Obtener el año y el día de la reserva actual
                int añoReserva = calendar.get(Calendar.YEAR);
                int diaReserva = calendar.get(Calendar.DAY_OF_MONTH);
                
                // Verificar si la reserva es del año y día especificados
                if (añoReserva == año && diaReserva == dia && medicosEspecialidad.obtenerMedico(aux.getCodMedico()) != null) {
                    cantidadReservas++;
                }

                aux = aux.getSiguiente();
            }
        }
        
        return cantidadReservas;
    }

    public int obtenerCantidadReservas(int codMedico){
        int cantidad = 0;
        NodoReserva aux = this.getInicio();
        while(aux != null){
            if(aux.getCodMedico() == codMedico){
                cantidad++;
            }
            aux = aux.getSiguiente();
        }
        
        return cantidad;
    }

    public void obtenerConsultasNoAsistidas(int codMedico){
        NodoReserva aux = this.getInicio();
        while(aux != null){
            if(aux.getCodMedico() == codMedico && aux.getEstado().equals("no asistio")){
                System.out.println("Paciente: " + aux.getCiPaciente() + " Fecha: " + aux.getFecha());
            }
            aux = aux.getSiguiente();
        }
    }
}
