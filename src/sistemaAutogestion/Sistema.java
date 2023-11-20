package sistemaAutogestion;

import java.util.Date;

public class Sistema implements IObligatorio {
    ListaMedico lm;
    ListaPaciente lp;
    ListaReserva lr;
    public int maxPacientesporMedico;
    
    @Override
    //2.1
    public Retorno crearSistemaDeAutogestion(int maxPacientesporMedico) {
        if(maxPacientesporMedico > 15){
            return new Retorno(Retorno.Resultado.ERROR_1);
        }
        
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        lm = new ListaMedico();
        lp = new ListaPaciente();
        lr = new ListaReserva();
        this.maxPacientesporMedico = maxPacientesporMedico;
        return ret;
    }

    @Override
    //2.2
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
    //2.3
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
    //2.4
    public Retorno agregarPaciente(String nombre, int CI, String direccion) {
        NodoPaciente paciente = lp.obtenerPaciente(CI);

        if (paciente != null) {
            return new Retorno(Retorno.Resultado.ERROR_1);
        }

        lp.agregarInicio(nombre, CI, direccion);
        return new Retorno(Retorno.Resultado.OK);

    }

    @Override
    //2.5
    public Retorno eliminarPaciente(int CI) {
        NodoPaciente paciente = lp.obtenerPaciente(CI);

        if (paciente == null) {
            return new Retorno(Retorno.Resultado.ERROR_1);
        }

        // CAMBIA PARA SEGUNDA ENTREGA YA QUE AHORA CONTAMOS CON CLASE RESERVA
        if (lr.pacienteReservoAlgunaVez(CI)) {
            return new Retorno(Retorno.Resultado.ERROR_2);
        }

        lp.borrarElemento(CI);
        return new Retorno(Retorno.Resultado.OK);
    }

    @Override
    public Retorno registrarDiaDeConsulta(int codMedico,Date fecha){
        NodoMedico medico = lm.obtenerMedico(codMedico);
        if(medico == null){
           return new Retorno(Retorno.Resultado.ERROR_1); 
        }
        if(medico.getLf().tieneFecha(fecha)){
            return new Retorno(Retorno.Resultado.ERROR_2);
        }
        
        medico.getLf().agregarInicio(fecha);
        return new Retorno(Retorno.Resultado.OK);
    };
            
    @Override
    //2.6
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
        if(!medico.getLf().tieneFecha(fecha)){
            return new Retorno(Retorno.Resultado.ERROR_4);
        }
        if(reserva != null){
            return new Retorno(Retorno.Resultado.ERROR_3);
        }
        
        
        lr.agregarInicio(codMedico, ciPaciente, fecha);
        return new Retorno(Retorno.Resultado.OK);
    }

    @Override
    //2.7
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
    //2.8
    public Retorno anunciaLlegada(int codMedico, int CIPaciente) {
        NodoPaciente paciente = lp.obtenerPaciente(CIPaciente);
        NodoMedico medico = lm.obtenerMedico(codMedico);
        
        if(paciente == null){
            return new Retorno(Retorno.Resultado.ERROR_1);
        }
        
        NodoReserva reserva = lr.obtenerReserva(codMedico, CIPaciente);
        if(reserva == null || !medico.getLf().tieneFecha(reserva.getFecha()) ){
            return new Retorno(Retorno.Resultado.ERROR_2);
        }
        
        System.out.println("Médico: " + medico.getNombre() + " - Numero de reserva: " + reserva.getId());
        reserva.setEstado("en espera");
        
        return new Retorno(Retorno.Resultado.OK);
    }

    @Override
    //2.9
    public Retorno terminarConsultaMedicoPaciente(int CIPaciente, int codMedico, String detalleDeConsulta) {
        NodoPaciente paciente = lp.obtenerPaciente(CIPaciente);
        NodoReserva reserva = lr.obtenerReserva(codMedico, CIPaciente);
        if(paciente == null){
            return new Retorno(Retorno.Resultado.ERROR_1);
        }
        if(reserva == null || !reserva.getEstado().equals("en espera")){
            return new Retorno(Retorno.Resultado.ERROR_2);
        }
        
        reserva.setEstado("terminada");
        paciente.lh.agregarInicio(detalleDeConsulta, codMedico, new Date());
        
        return new Retorno(Retorno.Resultado.OK);
    }

    @Override
    //2.10
    public Retorno cerrarConsulta(int codMedico, int ciPaciente, Date fechaConsulta) {
        NodoMedico medico = lm.obtenerMedico(codMedico);
        NodoReserva reserva = lr.obtenerReserva(codMedico, ciPaciente);
        
        if(medico == null){
            return new Retorno(Retorno.Resultado.ERROR_1);
        }
        if(reserva == null || !reserva.getFecha().toString().equals(fechaConsulta.toString())){
           return new Retorno(Retorno.Resultado.ERROR_2); 
        }
        
        reserva.setEstado("no asistio");
        lp.obtenerPaciente(ciPaciente).lh.agregarInicio("No asistio", codMedico, fechaConsulta);
        
        return new Retorno(Retorno.Resultado.OK); 
    }

    @Override
    //3.1
    public Retorno listarMédicos() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        lm.listar();
        ret.setValorString("Lista de médicos generada con éxito.");
        return ret;
    }

    @Override
    //3.2
    public Retorno listarPacientes() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        lp.listar();
        ret.setValorString("Lista de pacientes generada con éxito.");
        return ret;
    }

    @Override
    //3.3
    public Retorno listarConsultas(int codMedico) {
        if (lm.obtenerMedico(codMedico) == null) {
            return new Retorno(Retorno.Resultado.ERROR_1);
        }
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        lr.listar();
        ret.setValorString("Lista de consultas generada con éxito.");
        return ret;
    }
    
    @Override
    //3.4
    public Retorno listarPacientesEnEspera(int codMedico, Date fecha) {
        boolean isEmpty = lr.listarEnEspera(codMedico, fecha);
        if(isEmpty){
           return new Retorno(Retorno.Resultado.ERROR_1); 
        }
        
        return new Retorno(Retorno.Resultado.OK);
    }

    @Override
    //3.5
    public Retorno consultasPendientesPaciente(int CIPaciente) {
        NodoPaciente p = lp.obtenerPaciente(CIPaciente);
        if (p == null) {
            return new Retorno(Retorno.Resultado.ERROR_1);
        }

        lr.listarPendientesPaciente(CIPaciente);
        return new Retorno(Retorno.Resultado.OK);
    }

    @Override
    //3.6
    public Retorno historiaClínicaPaciente(int ci) {
        NodoPaciente paciente = lp.obtenerPaciente(ci);
        if(paciente == null){
            return new Retorno(Retorno.Resultado.ERROR_1); 
        }
        
        paciente.lh.listarRecursivo(paciente.lh.getInicio());
        return new Retorno(Retorno.Resultado.OK); 

    }

    @Override
    public Retorno reporteDePacientesXFechaYEspecialidad(int mes, int año) {
       if (mes < 1 || mes > 12 ) {
           return new Retorno(Retorno.Resultado.ERROR_1);
       }
       
       if (año < 2020 || año > 2023) {
           return new Retorno(Retorno.Resultado.ERROR_1);
       }

        for (int i = 1; i <= 31; i++) {
            for (int j = 1; j < 20; j++) {
                System.out.print("Dia " + i + "/" + mes + " - Especialidad " + j + ":"+ "\t");
                System.out.print(lr.obtenerCantidadPacienteXDia(i, año, j, lm) + "\t");
            }
            System.out.println();
        }

        return new Retorno(Retorno.Resultado.OK);
    }

    @Override
    public Retorno medicoConMasReservas() {
        NodoMedico medicoMasReservas = null;
        int cantidad = 0;
        
        if(!lm.esVacia()){
            NodoMedico aux = lm.getInicio();
            while (aux != null){
                int cantidadAux = lr.obtenerCantidadReservas(aux.getCodMedico());
                if(cantidadAux > cantidad){
                    medicoMasReservas = aux;
                    cantidad = cantidadAux;
                }
                aux = aux.getSiguiente();
            }
            System.out.println("El medico con mas reservas es: " + aux.getNombre() + " con la cantidad: " + cantidad);
        }
        
        return new Retorno(Retorno.Resultado.OK);
    }

    @Override
    public Retorno listaConsultasNoAsistidas(int codMedico) {
        lr.obtenerConsultasNoAsistidas(codMedico);
        
        return new Retorno(Retorno.Resultado.OK);
    }

                                                          

}
