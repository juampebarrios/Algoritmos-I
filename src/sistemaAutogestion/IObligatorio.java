package sistemaAutogestion;

import java.util.Date;


public interface IObligatorio {
    
    /*
    **************** REGISTROS **************************************
    */
    
    //pre:      post:
    public Retorno crearSistemaDeAutogestion(int maxPacientesporMedico);
     //pre:      post:
    public Retorno registrarMedico(String nombre,int codMedico,int tel, int especialidad); 
     //pre:      post:
    public  Retorno eliminarMedico(int codMedico); 
     //pre:      post:
    public Retorno agregarPaciente(String nombre, int CI, String direccion); 
     //pre:      post:
    public Retorno eliminarPaciente(int CI); 

     /*
    **************** GESTIÓN DE CONSULTAS **************************************
    */
      
    public Retorno registrarDiaDeConsulta(int codMedico,Date fecha);
    //pre:      post:
    public Retorno reservaConsulta(int codMedico, int ciPaciente, Date fecha);
    //pre:      post:
    public Retorno cancelarReserva(int codMedico, int ciPaciente); 
    //pre:      post:
    public Retorno anunciaLlegada(int codMedico, int CIPaciente); 
    //pre:      post:
    public Retorno terminarConsultaMedicoPaciente(int CIPaciente, int codMedico, String detalleDeConsulta);   
    //pre:      post:
    public Retorno cerrarConsulta(int codMédico, int ciPaciente, Date fechaConsulta); 
    
 
      /*
    **************** LISTADO Y REPORTES **************************************
    */
    
    //pre:      post:
    public Retorno listarMédicos(); 
    //pre:      post:
    public Retorno listarPacientes();     
    //pre:      post:
    public Retorno listarConsultas(int codMedico); 
    //pre:      post:
    public Retorno listarPacientesEnEspera (int codMedico, Date fecha);    
    //pre:      post:
    public Retorno consultasPendientesPaciente(int CIPaciente);   
    //pre:      post:
    public Retorno historiaClínicaPaciente (int ci);    
    //pre:      post:
    public Retorno reporteDePacientesXFechaYEspecialidad(int mes, int año); 
    
    
    //    pre: existe al menos un médico registrado. No existen dos médicos con el mismo máximo de reservas								
    //post: Muestra el nombre del médico que tiene el máximo de reservas (en cualquiera de sus estados).								
    public Retorno medicoConMasReservas();    

//    pre: ci es un número entero > 0								
//    post: Muestra únicamente las consultas a las que "no asistió" el médico.								
    public Retorno listaConsultasNoAsistidas(int codMedico);								
}
