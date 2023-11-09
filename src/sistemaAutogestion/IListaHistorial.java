package sistemaAutogestion;

import java.util.Date;

public interface IListaHistorial {
    public boolean esVacia();
    public void agregarInicio(String detalles, int codMedico, Date fecha);
    public void listar();
    public int cantidad();
}
