package sistemaAutogestion;

import java.util.Date;

public interface IListaReserva {
    
    public boolean esVacia();
    public void agregarInicio(int codMedico, int ciPaciente, Date fecha);
    public void borrarElemento(int codMedico, int ciPaciente);
    public void listar();
    public int cantidad();

}
