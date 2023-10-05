package sistemaAutogestion;

public interface IListaPaciente {
    public boolean esVacia();
    public void agregarInicio(String nombre, int CI, String direccion);
    public void borrarElemento(int CI);
    public void listar();
    public int cantidad();
}
