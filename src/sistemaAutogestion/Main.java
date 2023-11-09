package sistemaAutogestion;

import sistemaAutogestion.Prueba;
import sistemaAutogestion.Sistema;
import sistemaAutogestion.Retorno;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Sistema s = new Sistema();
        Prueba p = new Prueba();
        juegodeprueba(s, p);
    }

    public static void juegodeprueba(Sistema s, Prueba p) {
        p.ver(s.crearSistemaDeAutogestion(5).resultado, Retorno.Resultado.OK, "Se crea el sistema de autogestion con 5 especialidades");

        //INGRESAR MEDICOS
        p.ver(s.registrarMedico("Juan", 1, 91077651, 1).resultado, Retorno.Resultado.OK, "Se registra el medico Juan");
        p.ver(s.registrarMedico("Pedro", 2, 91077652, 2).resultado, Retorno.Resultado.OK, "Se registra el medico Pedro");
        p.ver(s.registrarMedico("Maria", 3, 91077653, 3).resultado, Retorno.Resultado.OK, "Se registra el medico Maria");
        p.ver(s.registrarMedico("Mateo", 4, 91077654, 4).resultado, Retorno.Resultado.OK, "Se registra el medico Mateo");
        p.ver(s.registrarMedico("Laura", 5, 97977655, 5).resultado, Retorno.Resultado.OK, "Se registra el medico Laura");

        //LISTAR MEDICOS
        p.ver(s.listarMédicos().resultado, Retorno.Resultado.OK, "Se listan los medicos");

        //ELIMINAR MEDICOS
        p.ver(s.eliminarMedico(1).resultado, Retorno.Resultado.OK, "Se elimina el medico Juan");

        //LISTAR MEDICOS LUEGO DE ELIMINAR
        p.ver(s.listarMédicos().resultado, Retorno.Resultado.OK, "Se listan los medicos luego de eliminar a Juan");

        //INGRESAR PACIENTES
        p.ver(s.agregarPaciente("German", 11111111, "Direccion 1").resultado, Retorno.Resultado.OK, "Se registra el paciente German con CI 1");
        p.ver(s.agregarPaciente("Lucia", 22222222, "Direccion 2").resultado, Retorno.Resultado.OK, "Se registra el paciente Lucia con CI 2");
        p.ver(s.agregarPaciente("Matias", 33333333, "Direccion 3").resultado, Retorno.Resultado.OK, "Se registra el paciente Matias con CI 3");
        p.ver(s.agregarPaciente("Andrea", 44444444, "Direccion 4").resultado, Retorno.Resultado.OK, "Se registra el paciente Andrea con CI 4");
        p.ver(s.agregarPaciente("Martin", 55555555, "Direccion 5").resultado, Retorno.Resultado.OK, "Se registra el paciente Martin con CI 5");

        //LISTAR PACIENTES
        p.ver(s.listarPacientes().resultado, Retorno.Resultado.OK, "Se listan los pacientes");

        //ELIMINAR PACIENTES
        p.ver(s.eliminarPaciente(11111111).resultado, Retorno.Resultado.OK, "Se elimina el paciente German");

        //LISTAR PACIENTES LUEGO DE ELIMINAR
        p.ver(s.listarPacientes().resultado, Retorno.Resultado.OK, "Se listan los pacientes luego de eliminar a German");

        //RESERVA DE CONSULTA
        p.ver(s.reservaConsulta(2, 22222222, new Date()).resultado, Retorno.Resultado.OK, "Se registra la consulta de Lucia con el medico Pedro");
        p.ver(s.reservaConsulta(2, 33333333, new Date()).resultado, Retorno.Resultado.OK, "Se registra la consulta de Matias con el medico Pedro");
        p.ver(s.reservaConsulta(2, 44444444, new Date()).resultado, Retorno.Resultado.OK, "Se registra la consulta de Andrea con el medico Pedro");
        p.ver(s.reservaConsulta(3, 22222222, new Date()).resultado, Retorno.Resultado.OK, "Se registra la consulta de Lucia con el medico Maria");
        p.ver(s.reservaConsulta(3, 55555555, new Date()).resultado, Retorno.Resultado.OK, "Se registra la consulta de Martin con el medico Maria");
        p.ver(s.reservaConsulta(4, 22222222, new Date()).resultado, Retorno.Resultado.OK, "Se registra la consulta de Lucia con el medico Mateo");

        //SE INTENTA ELIMINAR PACIENTE CON CONSULTA AGENDADA (DEBE DAR ERROR)
        p.ver(s.eliminarPaciente(22222222).resultado, Retorno.Resultado.OK, "Se intenta eliminar el paciente Lucia con una consulta agendada");

        //CANCELAR RESERVA
        p.ver(s.cancelarReserva(3, 55555555).resultado, Retorno.Resultado.OK, "Se cancela la reserva de Martin con el medico Maria");

        //ANUNCIAR LLEGADA DE PACIENTE EN TOTEM (EL ANTEULTIMO DEBE DAR ERROR)
        p.ver(s.anunciaLlegada(2, 22222222).resultado, Retorno.Resultado.OK, "Se anuncia la llegada de Lucia con el medico Pedro");
        p.ver(s.anunciaLlegada(2, 33333333).resultado, Retorno.Resultado.OK, "Se anuncia la llegada de Matias con el medico Pedro");
        p.ver(s.anunciaLlegada(2, 44444444).resultado, Retorno.Resultado.OK, "Se anuncia la llegada de Andrea con el medico Pedro");
        p.ver(s.anunciaLlegada(3, 55555555).resultado, Retorno.Resultado.OK, "Se anuncia la llegada de Martin con el medico Maria");
        p.ver(s.anunciaLlegada(4, 22222222).resultado, Retorno.Resultado.OK, "Se anuncia la llegada de Lucia con el medico Mateo");

        //TERMINAR CONSULTA MEDICO PACIENTE
        p.ver(s.terminarConsultaMedicoPaciente(22222222, 2, "Alergia a las frutillas").resultado, Retorno.Resultado.OK, "Se termina la consulta de Lucia con el medico Pedro");
        p.ver(s.terminarConsultaMedicoPaciente(33333333, 2, "Dolor de cabeza").resultado, Retorno.Resultado.OK, "Se termina la consulta de Matias con el medico Pedro");

        //CERRAR CONSULTA
        p.ver(s.cerrarConsulta(2, 44444444, new Date()).resultado, Retorno.Resultado.OK, "Se cierra la consulta de Andrea con el medico Pedro ya que no asistió");

        //LISTAR CONSULTAS
        p.ver(s.listarConsultas(2).resultado, Retorno.Resultado.OK, "Se listan las consultas del medico Pedro");

        //LISTAR PACIENTES EN ESPERA
        p.ver(s.listarPacientesEnEspera(4, new Date()).resultado, Retorno.Resultado.OK, "Se listan los pacientes en espera del medico Mateo");

        //LISTAR PACIENTES CON CONSULTAS PENDIENTES
        p.ver(s.consultasPendientesPaciente(22222222).resultado, Retorno.Resultado.OK, "Se listan las consultas pendientes del paciente Lucia");

        //HISTORIAL CLINICO DE PACIENTE
        p.ver(s.historiaClínicaPaciente(22222222).resultado, Retorno.Resultado.OK, "Se listan las consultas del paciente Lucia");
        p.ver(s.historiaClínicaPaciente(33333333).resultado, Retorno.Resultado.OK, "Se listan las consultas del paciente Matias");
        p.ver(s.historiaClínicaPaciente(44444444).resultado, Retorno.Resultado.OK, "Se listan las consultas del paciente Andrea");

        //RESULTADO DE LA PRUEBA
        p.imprimirResultadosPrueba();
    }
}
