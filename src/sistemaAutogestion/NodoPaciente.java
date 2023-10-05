package sistemaAutogestion;

public class NodoPaciente {
    String nombre;
    int CI;
    String direccion;
    NodoPaciente siguiente;

    //NODO PACIENTE
    public NodoPaciente(String nombre, int CI, String direccion) {
        this.nombre = nombre;
        this.CI = CI;
        this.direccion = direccion;
        this.siguiente = null;
    }

    //GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public int getCI() {
        return CI;
    }

    public String getDireccion() {
        return direccion;
    }

    public NodoPaciente getSiguiente() {
        return siguiente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCI(int CI) {
        this.CI = CI;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setSiguiente(NodoPaciente siguiente) {
        this.siguiente = siguiente;
    }

}