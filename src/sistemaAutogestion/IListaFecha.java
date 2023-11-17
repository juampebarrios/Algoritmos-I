package sistemaAutogestion;

import java.util.Date;

public interface IListaFecha {
    public boolean esVacia();
    public void agregarInicio(Date fecha);
    public void listar();
    public int cantidad();
}
