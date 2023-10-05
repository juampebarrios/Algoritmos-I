package sistemaAutogestion;

public interface IListaMedico {
    public boolean esVacia();
    public void agregarInicio(String nombre, int codMedico, int tel, int especialidad);
    public void borrarElemento(int codMedico);
    public void listar();
    public int cantidad();

}
