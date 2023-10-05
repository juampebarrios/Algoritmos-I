package sistemaAutogestion;

public class NodoMedico {
    String nombre;
    int codMedico;
    int tel;
    int especialidad;
    ListaPaciente lp;
    NodoMedico siguiente;


    //NODO MEDICO
    public NodoMedico(String nombre, int codMedico, int tel, int especialidad) {
        this.nombre = nombre;
        this.codMedico = codMedico;
        this.tel = tel;
        this.especialidad = especialidad;
        this.lp = new ListaPaciente();
        this.siguiente = null;
    }

    //GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public int getCodMedico() {
        return codMedico;
    }

    public int getTel() {
        return tel;
    }

    public int getEspecialidad() {
        return especialidad;
    }

    public ListaPaciente getLp() {
        return lp;
    }

    public NodoMedico getSiguiente() {
        return siguiente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodMedico(int codMedico) {
        this.codMedico = codMedico;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public void setEspecialidad(int especialidad) {
        this.especialidad = especialidad;
    }

    public void setLp(ListaPaciente lp) {
        this.lp = lp;
    }

    public void setSiguiente(NodoMedico siguiente) {
        this.siguiente = siguiente;
    }

}
