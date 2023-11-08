package sistemaAutogestion;

import java.util.Date;

public class Sistema implements IObligatorio {
    ListaMedico lm;
    ListaPaciente lp;
    ListaReserva lr;
    
    @Override
    public Retorno crearSistemaDeAutogestion(int maxPacientesporMedico) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        lm = new ListaMedico();
        lp = new ListaPaciente();
        lr = new ListaReserva();
        return ret;
    }

    @Override
    public Retorno registrarMedico(String nombre, int codMedico, int tel, int especialidad) {
        if (especialidad < 1 || especialidad > 20) {
            return new Retorno(Retorno.Resultado.ERROR_2);
        }

        NodoMedico medico = lm.obtenerMedico(codMedico);

        if (medico != null) {
            return new Retorno(Retorno.Resultado.ERROR_1);
        }

        lm.agregarInicio(nombre, codMedico, tel, especialidad);
        return new Retorno(Retorno.Resultado.OK);
    }

    @Override
    public Retorno eliminarMedico(int codMedico) {
        NodoMedico medico = lm.obtenerMedico(codMedico);

        if (medico == null) {
            return new Retorno(Retorno.Resultado.ERROR_1);
        }

        if (!medico.getLp().esVacia()) {
            return new Retorno(Retorno.Resultado.ERROR_2);
        }

        lm.borrarElemento(codMedico);
        return new Retorno(Retorno.Resultado.OK);
    }

    @Override
    public Retorno agregarPaciente(String nombre, int CI, String direccion) {
        NodoPaciente paciente = lp.obtenerPaciente(CI);

        if (paciente != null) {
            return new Retorno(Retorno.Resultado.ERROR_1);
        }

        lp.agregarInicio(nombre, CI, direccion);
        return new Retorno(Retorno.Resultado.OK);

    }

    @Override
    public Retorno eliminarPaciente(int CI) {
        NodoPaciente paciente = lp.obtenerPaciente(CI);

        if (paciente == null) {
            return new Retorno(Retorno.Resultado.ERROR_1);
        }

        if (lm.existePacienteEnListaMedico(CI)) {
            return new Retorno(Retorno.Resultado.ERROR_2);
        }

        lp.borrarElemento(CI);
        return new Retorno(Retorno.Resultado.OK);
    }

    @Override
    public Retorno reservaConsulta(int codMedico, int ciPaciente, Date fecha) {
        NodoPaciente paciente = lp.obtenerPaciente(ciPaciente);
        NodoMedico medico = lm.obtenerMedico(codMedico);
        NodoReserva reserva = lr.obtenerReserva(codMedico, ciPaciente);

        if(paciente == null){
            return new Retorno(Retorno.Resultado.ERROR_1);
        }
        if(medico == null){
            return new Retorno(Retorno.Resultado.ERROR_2);
        }
        if(reserva != null){
            return new Retorno(Retorno.Resultado.ERROR_3);
        }
        
        lr.agregarInicio(codMedico, ciPaciente, fecha);
        return new Retorno(Retorno.Resultado.OK);
    }

    @Override
    public Retorno cancelarReserva(int codMedico, int ciPaciente) {
        NodoPaciente paciente = lp.obtenerPaciente(ciPaciente);
        NodoMedico medico = lm.obtenerMedico(codMedico);
        NodoReserva reserva = lr.obtenerReserva(codMedico, ciPaciente);

        if(paciente == null){
            return new Retorno(Retorno.Resultado.ERROR_1);
        }
        if(medico == null){
            return new Retorno(Retorno.Resultado.ERROR_2);
        }
        if(reserva == null){
            return new Retorno(Retorno.Resultado.ERROR_3);
        }
        if(!reserva.getEstado().equals("pendiente")){
            return new Retorno(Retorno.Resultado.ERROR_4);
        }
    
        lr.borrarElemento(codMedico, ciPaciente);
        return new Retorno(Retorno.Resultado.OK);
    }

    @Override
    public Retorno anunciaLlegada(int codMedico, int CIPaciente) {
        Date today = new Date();
        NodoPaciente paciente = lp.obtenerPaciente(CIPaciente);
        NodoMedico medico = lm.obtenerMedico(codMedico);
        
        if(paciente == null){
            return new Retorno(Retorno.Resultado.ERROR_1);
        }
        
        NodoReserva reserva = lr.obtenerReserva(codMedico, CIPaciente);
        if(reserva == null || (reserva != null && !reserva.getFecha().equals(today))){
            return new Retorno(Retorno.Resultado.ERROR_2);
        }
        
        System.out.println("Medico: " + medico.getNombre() + " Numero reserva: " + reserva.getId());
        reserva.setEstado("en espera");
        
        return new Retorno(Retorno.Resultado.OK);
    }

    @Override
    public Retorno terminarConsultaMedicoPaciente(int CIPaciente, int codMedico, String detalleDeConsulta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Retorno cerrarConsulta(String codMédico, Date fechaConsulta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Retorno listarMédicos() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        lm.listar();
        return ret;
    }

    @Override
    public Retorno listarPacientes() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        lp.listar();
        return ret;
    }

    @Override
    public Retorno listarConsultas(int codMédico) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Retorno listarPacientesEnEspera(String codMédico, Date fecha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Retorno consultasPendientesPaciente(int CIPaciente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Retorno historiaClínicaPaciente(int ci) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Retorno reporteDePacientesXFechaYEspecialidad(int mes, int año) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    

}
