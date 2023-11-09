package sistemaAutogestion;

import sistemaAutogestion.Prueba;
import sistemaAutogestion.Sistema;
import sistemaAutogestion.Retorno;

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

        //INGRESAR PACIENTES
        p.ver(s.agregarPaciente("German", 11111111, "Direccion 1").resultado, Retorno.Resultado.OK, "Se registra el paciente German con CI 1");
        p.ver(s.agregarPaciente("Lucia", 22222222, "Direccion 2").resultado, Retorno.Resultado.OK, "Se registra el paciente Lucia con CI 2");
        p.ver(s.agregarPaciente("Matias", 33333333, "Direccion 3").resultado, Retorno.Resultado.OK, "Se registra el paciente Matias con CI 3");
        p.ver(s.agregarPaciente("Andrea", 44444444, "Direccion 4").resultado, Retorno.Resultado.OK, "Se registra el paciente Andrea con CI 4");
        p.ver(s.agregarPaciente("Martin", 55555555, "Direccion 5").resultado, Retorno.Resultado.OK, "Se registra el paciente Martin con CI 5");

        //LISTAR PACIENTES
        p.ver(s.listarPacientes().resultado, Retorno.Resultado.OK, "Se listan los pacientes");

        //ELIMINAR MEDICOS
        p.ver(s.eliminarMedico(1).resultado, Retorno.Resultado.OK, "Se elimina el medico Juan");

        //ELIMINAR PACIENTES
        p.ver(s.eliminarPaciente(11111111).resultado, Retorno.Resultado.OK, "Se elimina el paciente German");

        //RESULTADO DE LA PRUEBA
        p.imprimirResultadosPrueba();

        //LISTAR CONSULTAS/RESERVAS

    }
}
