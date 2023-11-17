package sistemaAutogestion;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Sistema s = new Sistema();
        Prueba p = new Prueba();
        juegodeprueba(s, p);
    }

        public static void juegodeprueba(Sistema o, Prueba p) {

        //juegos de prueba:
        //crearSistemaDeAutogestion
        System.out.println("------------------------");
        System.out.println("CREACION DEL SISTEMA ");
        System.out.println("------------------------");
        p.ver(o.crearSistemaDeAutogestion(2).resultado, Retorno.Resultado.OK, "crearSistemaDeAutogestion(3) = Se pudo inicializar el sistema correctamente."); //CUMPLE CONDICION
        p.ver(o.crearSistemaDeAutogestion(20).resultado, Retorno.Resultado.ERROR_1, "crearSistemaDeAutogestion(20) = La cantidad maxima de pacientes no puede ser <=0 o > 15"); //NO CUMPLE CONDICION
        p.ver(o.crearSistemaDeAutogestion(-1).resultado, Retorno.Resultado.ERROR_1, "crearSistemaDeAutogestion(-1) = La cantidad maxima de pacientes no puede ser <=0 o > 15"); //NO CUMPLE CONDICION

        //registrarMedico
        
        System.out.println("------------------------");
        System.out.println("REGISTRAR MEDICO ");
        System.out.println("------------------------");
        
//CASOS OK
        p.ver(o.registrarMedico("Juan", 12, 1234, 2).resultado, Retorno.Resultado.OK, "registrarMedico(Juan, 12,1234,2) = Se pudo registrar el medico"); //PUEDE REGISTRARSE
        p.ver(o.listarMédicos().resultado, Retorno.Resultado.OK, "listarmedicos() = " + o.listarMédicos().valorString);

        p.ver(o.registrarMedico("Marcelo", 4, 8907, 10).resultado, Retorno.Resultado.OK, "registrarMedico(Marcelo,4,8907,10) = Se pudo registrar el medico"); //PUEDE REGISTRARSE
        p.ver(o.listarMédicos().resultado, Retorno.Resultado.OK, "listarmedicos() = " + o.listarMédicos().valorString);

        p.ver(o.registrarMedico("Luis", 10, 2453, 12).resultado, Retorno.Resultado.OK, "registrarMedico(Luis,10,2453,12) = Se pudo registrar el medico"); //PUEDE REGISTRARSE
        p.ver(o.listarMédicos().resultado, Retorno.Resultado.OK, "listarmedicos() = " + o.listarMédicos().valorString);

        p.ver(o.registrarMedico("Arnau", 17, 2267, 19).resultado, Retorno.Resultado.OK, "registrarMedico(Arnau,17,2267,19) = Se pudo registrar el medico"); //PUEDE REGISTRARSE
        p.ver(o.listarMédicos().resultado, Retorno.Resultado.OK, "listarmedicos() = " + o.listarMédicos().valorString);

        p.ver(o.registrarMedico("Andres", 5, 3675, 18).resultado, Retorno.Resultado.OK, "registrarMedico(Andres,5,3675,18) = Se pudo registrar el medico"); //PUEDE REGISTRARSE
        p.ver(o.listarMédicos().resultado, Retorno.Resultado.OK, "listarmedicos() = " + o.listarMédicos().valorString);

// CASOS DE ERROR        
        p.ver(o.registrarMedico("Juan", 12, 1234, 2).resultado, Retorno.Resultado.ERROR_1, "registrarMedico(Juan, 12,1234,2) = Ya existe un medico con igual codigo"); //YA EXISTE EL MEDICO
        p.ver(o.listarMédicos().resultado, Retorno.Resultado.OK, "listarmedicos() = " + o.listarMédicos().valorString);

        p.ver(o.registrarMedico("Martin", 34, 6578, 0).resultado, Retorno.Resultado.ERROR_2, "registrarMedico(Martin, 34,6578,0) = La especialidad debe ser mayor >=1 o <=20"); //ESPECIALIDAD NO VALIDA
        p.ver(o.listarMédicos().resultado, Retorno.Resultado.OK, "listarmedicos() = " + o.listarMédicos().valorString);

        System.out.println("------------------------");
        System.out.println("ELIMINAR MEDICO ");
        System.out.println("------------------------");       
        
        //eliminarMedico
        
        //CASOS OK DE ELIMINACION
        p.ver(o.eliminarMedico(12).resultado, Retorno.Resultado.OK, "eliminarMedico(12) = Se pudo eliminar el medico."); //ELIMINA MEDICO CON 0 PACIENTES
        p.ver(o.eliminarMedico(5).resultado, Retorno.Resultado.OK, "eliminarMedico(5) = Se pudo eliminar el medico."); //ELIMINA MEDICO CON 0 PACIENTES
             
        //CASOS ERROR 1 ELIMINACION
        p.ver(o.eliminarMedico(45).resultado, Retorno.Resultado.ERROR_1, "eliminarMedico(45) = No existe un medico con ese codigo."); //NO ENCUENTRA MEDICO
 
 
        System.out.println("listado de medicos luego de eliminar medico 12, 5 y 45 ");
        p.ver(o.listarMédicos().resultado, Retorno.Resultado.OK, "listarmedicos() = " + o.listarMédicos().valorString);

        System.out.println("------------------------");
        System.out.println("REGISTRAR PACIENTE ");
        System.out.println("------------------------");        
        
        //agregarPaciente
        // CASOS OK
        p.ver(o.agregarPaciente("Jose", 52956338, "Bv Artigas").resultado, Retorno.Resultado.OK, "agregarPaciente(Jose, 52956338, Bv Artigas) = Se pudo crear el paciente"); //PUEDE AGREGAR PACIENTE
        p.ver(o.agregarPaciente("Carlos", 12300874, "Minas").resultado, Retorno.Resultado.OK, "agregarPaciente(Carlos, 12300874, Minas) = Se pudo crear el paciente"); //PUEDE AGREGAR PACIENTE
        p.ver(o.agregarPaciente("Roberto", 12312378, "Salterain").resultado, Retorno.Resultado.OK, "agregarPaciente(Roberto, 12312378, Salterain) = Se pudo crear el paciente"); //PUEDE AGREGAR PACIENTE
        p.ver(o.agregarPaciente("Abel", 23232323, "Cerro Largo").resultado, Retorno.Resultado.OK, "agregarPaciente(Abel, 23232323, Cerro Largo) = Se pudo crear el paciente"); //PUEDE AGREGAR PACIENTE
        p.ver(o.agregarPaciente("Franco", 79797979, "Lafinur").resultado, Retorno.Resultado.OK, "agregarPaciente(Franco, 79797979, Lafinur) = Se pudo crear el paciente"); //PUEDE AGREGAR PACIENTE
        p.ver(o.agregarPaciente("Manuel", 34343434, "Union").resultado, Retorno.Resultado.OK, "agregarPaciente(Manuel, 34343434, Union) = Se pudo crear el paciente"); //PUEDE AGREGAR PACIENTE
        p.ver(o.agregarPaciente("Luka", 12348765, "Cochabamba").resultado, Retorno.Resultado.OK, "agregarPaciente(Luka, 12348765, Cochabamba) = Se pudo crear el paciente"); //PUEDE AGREGAR PACIENTE

        //CASOS ERROR_1
        p.ver(o.agregarPaciente("Jose", 52956338, "Bv Artigas").resultado, Retorno.Resultado.ERROR_1, "agregarPaciente(Jose, 52956338, Bv Artigas) = Ya existe un paciente con igual CI"); //NO PUEDE AGREGARSE

        //LISTAOO LUEGO DE AGREBGAR
        System.out.println("Listado de pacientes luego de agregar");
        p.ver(o.listarPacientes().resultado, Retorno.Resultado.OK, "listarPacientes() = " + o.listarPacientes().valorString);

        //eliminarPaciente
        p.ver(o.eliminarPaciente(52956338).resultado, Retorno.Resultado.OK, "eliminarPaciente(52956338) = Se pudo eliminar el paciente.");  //ELIMINA PACIENTE CON 0 CONSULTAS
        p.ver(o.listarPacientes().resultado, Retorno.Resultado.OK, "listarPacientes() = " + o.listarPacientes().valorString);

        p.ver(o.eliminarPaciente(12345678).resultado, Retorno.Resultado.ERROR_1, "eliminarPaciente(12345678) = No existe un paciente con ese CI");  //NO ENCUENTRA EL PACIENTE
        p.ver(o.listarPacientes().resultado, Retorno.Resultado.OK, "listarPacientes() = " + o.listarPacientes().valorString);

        Date fecha = new Date(123, 9, 18);
        Date fecha2 = new Date(123, 9, 19); //LOS MESES EMPIEZAN EN 0 (OCTUBRE)
        Date fecha3 = new Date(123, 9, 17);
        Date fecha4 = new Date(123, 9, 1);
        
        

        p.ver(o.registrarDiaDeConsulta(89, fecha).resultado, Retorno.Resultado.ERROR_1, "registrarDiaDeConsulta(89, 18/10/2023)= No existe medico con ese codigo"); //se registra el dia de la consulta

        p.ver(o.registrarDiaDeConsulta(10, fecha).resultado, Retorno.Resultado.OK, "registrarDiaDeConsulta(10, 18/10/2023)= Se pudo registrar el dia de la consulta"); //se registra el dia de la consulta

        p.ver(o.registrarDiaDeConsulta(10, fecha).resultado, Retorno.Resultado.ERROR_2, "registrarDiaDeConsulta(10, 18/10/2023)= ya existe registrada esa fecha para ese medico"); //ya existe la fecha para el medico

        p.ver(o.registrarDiaDeConsulta(10, fecha2).resultado, Retorno.Resultado.OK, "registrarDiaDeConsulta(10, 19/10/2023)= Se pudo registrar el dia de la consulta"); //se registra el dia de la consulta

        p.ver(o.registrarDiaDeConsulta(10, fecha3).resultado, Retorno.Resultado.OK, "registrarDiaDeConsulta(10, 17/10/2023)= Se pudo registrar el dia de la consulta"); //se registra el dia de la consulta

        p.ver(o.registrarDiaDeConsulta(17, fecha3).resultado, Retorno.Resultado.OK, "registrarDiaDeConsulta(17, 17/10/2023)= Se pudo registrar el dia de la consulta"); //se registra el dia de la consulta

        p.ver(o.registrarDiaDeConsulta(17, fecha4).resultado, Retorno.Resultado.OK, "registrarDiaDeConsulta(17, 01/10/2023)= Se pudo registrar el dia de la consulta"); //se registra el dia de la consulta

        p.ver(o.reservaConsulta(89, 12300874, fecha).resultado, Retorno.Resultado.ERROR_2, "reservaConsulta(89, 12300874, 18/10/2023)= No existe medico con ese codigo"); //no existe ese medico
        p.ver(o.listarConsultas(89).resultado, Retorno.Resultado.ERROR_1, "listarConsultas(89) = No existe medico con ese codigo");

        p.ver(o.reservaConsulta(10, 12345678, fecha).resultado, Retorno.Resultado.ERROR_1, "reservaConsulta(10, 12345678, 18/10/2023)= No existe paciente con esa CI"); //no existe ese paciente
        p.ver(o.listarConsultas(10).resultado, Retorno.Resultado.OK, "listarConsultas(10) = " + o.listarConsultas(10).valorString);
        p.ver(o.listarPacientesEnEspera(10, fecha).resultado, Retorno.Resultado.ERROR_1, "listarPacientesEnEspera(10,18/10/2023) = El medico no tiene consultas en esa fecha"); //no hay pacientes en esa fecha

        p.ver(o.reservaConsulta(10, 12300874, fecha4).resultado, Retorno.Resultado.ERROR_4, "reservaConsulta(10, 12300874, 01/10/2023)= El medico no tiene registrada esa fecha"); //la fecha no fue registada a ese medeico

        p.ver(o.reservaConsulta(10, 12300874, fecha).resultado, Retorno.Resultado.OK, "reservaConsulta(10, 12300874, 18/10/2023)= Se realiza la apertura del pedido correctamente"); //se agrega paciente en fecha nueva
        p.ver(o.listarConsultas(10).resultado, Retorno.Resultado.OK, "listarConsultas(10) = " + o.listarConsultas(10).valorString);

        p.ver(o.listarPacientesEnEspera(10, fecha).resultado, Retorno.Resultado.OK, "listarPacientesEnEspera(10,18/10/2023) = " + o.listarPacientesEnEspera(10, fecha).valorString); //no hay ningun paciente en espera

        p.ver(o.reservaConsulta(10, 12300874, fecha).resultado, Retorno.Resultado.ERROR_3, "reservaConsulta(10, 12300874, 18/10/2023)= El medico ya tiene una consulta con ese paciente"); //ya esta el paciente en esa fecha
        p.ver(o.listarConsultas(10).resultado, Retorno.Resultado.OK, "listarConsultas(10) = " + o.listarConsultas(10).valorString);

        p.ver(o.anunciaLlegada(10, 12312378).resultado, Retorno.Resultado.ERROR_2, "anunciaLlegada(10, 12312378)= El paciente no tiene registrada una consulta");  //el paciente no tiene consulta registrada

        p.ver(o.reservaConsulta(10, 12312378, fecha).resultado, Retorno.Resultado.OK, "reservaConsulta(10, 12312378, 18/10/2023)= Se realiza la apertura del pedido correctamente ");  //se agrega paciente en misma fecha
        p.ver(o.listarConsultas(10).resultado, Retorno.Resultado.OK, "listarConsultas(10) = " + o.listarConsultas(10).valorString);

        p.ver(o.anunciaLlegada(10, 56565656).resultado, Retorno.Resultado.ERROR_1, "anunciaLlegada(10, 56565656)= No existe la ci del paciente ");  //no existe el paciente

        p.ver(o.anunciaLlegada(10, 12312378).resultado, Retorno.Resultado.OK, "anunciaLlegada(10, 12312378)= El paciente pudo anunciar su llegada ");  //el paciente llega en esa fecha
        p.ver(o.listarPacientesEnEspera(10, fecha).resultado, Retorno.Resultado.OK, "listarPacientesEnEspera(10,18/10/2023) = " + o.listarPacientesEnEspera(10, fecha).valorString); //lista pacientes en espera
        p.ver(o.listarConsultas(10).resultado, Retorno.Resultado.OK, "listarConsultas(10) = " + o.listarConsultas(10).valorString);

        p.ver(o.reservaConsulta(10, 34343434, fecha).resultado, Retorno.Resultado.OK, "reservaConsulta(10, 34343434, 18/10/2023)= Se agrega paciente en lista de espera ");  //agregar otro paciente en lista de espera, excede tope
        p.ver(o.listarConsultas(10).resultado, Retorno.Resultado.OK, "listarConsultas(10) = " + o.listarConsultas(10).valorString);

        p.ver(o.reservaConsulta(10, 23232323, fecha2).resultado, Retorno.Resultado.OK, "reservaConsulta(10, 23232323, 19/10/2023)= Se realiza la apertura del pedido correctamente");  //agregar otro paciente en fecha despues
        p.ver(o.listarConsultas(10).resultado, Retorno.Resultado.OK, "listarConsultas(10) = " + o.listarConsultas(10).valorString);

        p.ver(o.consultasPendientesPaciente(98765432).resultado, Retorno.Resultado.ERROR_1, "consultasPendientesPaciente(98765432) = No existe la ci del paciente");

        p.ver(o.consultasPendientesPaciente(79797979).resultado, Retorno.Resultado.OK, "consultasPendientesPaciente(79797979) = " + o.consultasPendientesPaciente(79797979).valorString);
        
        p.ver(o.reservaConsulta(10, 79797979, fecha3).resultado, Retorno.Resultado.OK, "reservaConsulta(10, 23232323, 17/10/2023)= Se realiza la apertura del pedido correctamente");  //agregar otro paciente en fecha anterior
        p.ver(o.listarConsultas(10).resultado, Retorno.Resultado.OK, "listarConsultas(10) = " + o.listarConsultas(10).valorString);

        p.ver(o.cancelarReserva(10, 56565656).resultado, Retorno.Resultado.ERROR_1, "cancelarReserva(10,56565656)= No existe paciente con esa ci");  //no existe paciente con esa ci

        p.ver(o.cancelarReserva(89, 12300874).resultado, Retorno.Resultado.ERROR_2, "cancelarReserva(89,12300874)= No existe el codigo del medico");  //no existe medico con ese codigo

        p.ver(o.cancelarReserva(10, 12312378).resultado, Retorno.Resultado.ERROR_4, "cancelarReserva(10,12312378)= la reserva de ese paciente no esta en estado pendeinte");  //consulta no en estado pendiente

        p.ver(o.cancelarReserva(10, 12348765).resultado, Retorno.Resultado.ERROR_3, "cancelarReserva(10,12348765)= el paciente no tiene una reserva con el medico");  //el paciente no tiene una consulta con el medico

        p.ver(o.cancelarReserva(10, 12300874).resultado, Retorno.Resultado.OK, "cancelarReserva(10,12300874)= se puedo cancelar la reserva del paciente");  //consulta no en estado pendiente
        p.ver(o.listarConsultas(10).resultado, Retorno.Resultado.OK, "listarConsultas(10) = " + o.listarConsultas(10).valorString);

        p.ver(o.reservaConsulta(17, 79797979, fecha3).resultado, Retorno.Resultado.OK, "reservaConsulta(17, 79797979, 17/10/2023)= Se realiza la apertura del pedido correctamente");  //agregar otro paciente en fecha anterior
        p.ver(o.listarConsultas(17).resultado, Retorno.Resultado.OK, "listarConsultas(17) = " + o.listarConsultas(17).valorString);

        p.ver(o.consultasPendientesPaciente(79797979).resultado, Retorno.Resultado.OK, "consultasPendientesPaciente(79797979) = " + o.consultasPendientesPaciente(79797979).valorString);
        
        
        p.ver(o.reservaConsulta(17, 23232323, fecha3).resultado, Retorno.Resultado.OK, "reservaConsulta(17, 23232323, 17/10/2023)= Se realiza la apertura del pedido correctamente");  //agregar otro paciente en fecha anterior
        p.ver(o.listarConsultas(17).resultado, Retorno.Resultado.OK, "listarConsultas(17) = " + o.listarConsultas(17).valorString);

        p.ver(o.reservaConsulta(17, 12312378, fecha3).resultado, Retorno.Resultado.OK, "reservaConsulta(17, 12312378, 17/10/2023)= Se agrega paciente en lista de espera");  //agregar otro paciente en lista de espera, excede tope
        p.ver(o.listarConsultas(17).resultado, Retorno.Resultado.OK, "listarConsultas(17) = " + o.listarConsultas(17).valorString);

        p.ver(o.terminarConsultaMedicoPaciente(98765432, 17, "traumatismo de pierna").resultado, Retorno.Resultado.ERROR_1, "terminarConsultaMedicoPaciente(98765432,17,traumatismo de pierna)= No existe la ci del paciente");  //no existe la ci del paciente

        p.ver(o.terminarConsultaMedicoPaciente(23232323, 17, "traumatismo de pierna").resultado, Retorno.Resultado.ERROR_2, "terminarConsultaMedicoPaciente(23232323,17,traumatismo de pierna)= paciente no tiene una consulta en espera en ese dia con ese medico");  //el paciente no tiene una consulta en espera en ese dia con ese medico

        p.ver(o.anunciaLlegada(17, 23232323).resultado, Retorno.Resultado.OK, "anunciaLlegada(17, 23232323)= El paciente pudo anunciar su llegada ");  //el paciente llega en esa fecha
        p.ver(o.listarConsultas(17).resultado, Retorno.Resultado.OK, "listarConsultas(17) = " + o.listarConsultas(17).valorString);

        p.ver(o.terminarConsultaMedicoPaciente(23232323, 17, "traumatismo de pierna").resultado, Retorno.Resultado.OK, "terminarConsultaMedicoPaciente(23232323,17,traumatismo de pierna)= Se pudo cerrar correctamente la consulta del paciente");  //se cierra consulta correctamente
        p.ver(o.listarConsultas(17).resultado, Retorno.Resultado.OK, "listarConsultas(17) = " + o.listarConsultas(17).valorString);

        p.ver(o.historiaClínicaPaciente(23232323).resultado, Retorno.Resultado.OK, "historiaClinicaPaciente(98765432) = " + o.historiaClínicaPaciente(23232323).valorString);

        p.ver(o.historiaClínicaPaciente(98765432).resultado, Retorno.Resultado.ERROR_1, "historiaClinicaPaciente(98765432) = No existe la ci del paciente"); //no existe la ci del paciente

//        p.ver(o.cerrarConsulta(89, fecha3).resultado, Retorno.Resultado.ERROR_1, "cerrarConsulta(89, 17/10/2023)= No existe el codigo del medico");  //no existe el codigo del medico
//
//        p.ver(o.cerrarConsulta(17, fecha4).resultado, Retorno.Resultado.ERROR_2, "cerrarConsulta(17, 01/10/2023)= El medico no tiene consultas en esa fecha");  //el medico no tiene consultas en esa fecha
//
//        p.ver(o.cerrarConsulta(17, fecha3).resultado, Retorno.Resultado.OK, "cerrarConsulta(17, 17/10/2023)= Se pudo cerrar las consultas correctamente");  //se puden cerrar las consultas del dia
        p.ver(o.listarConsultas(17).resultado, Retorno.Resultado.OK, "listarConsultas(17) = " + o.listarConsultas(17).valorString);

        p.ver(o.historiaClínicaPaciente(79797979).resultado, Retorno.Resultado.OK, "historiaClinicaPaciente(79797979) = " + o.historiaClínicaPaciente(79797979).valorString);

        
        p.ver(o.reservaConsulta(17, 12300874, fecha4).resultado, Retorno.Resultado.OK, "reservaConsulta(17, 12300874, 01/10/2023)= Se realiza la apertura del pedido correctamente");  //agregar otro paciente en fecha anterior
        p.ver(o.listarConsultas(17).resultado, Retorno.Resultado.OK, "listarConsultas(17) = " + o.listarConsultas(17).valorString);

        p.ver(o.anunciaLlegada(17, 12300874).resultado, Retorno.Resultado.OK, "anunciaLlegada(17, 12300874)= El paciente pudo anunciar su llegada ");  //el paciente llega en esa fecha

        p.ver(o.terminarConsultaMedicoPaciente(12300874, 17, "dolor de cabeza").resultado, Retorno.Resultado.OK, "terminarConsultaMedicoPaciente(12300874, 17,dolor de cabeza)= Se pudo cerrar correctamente la consulta del paciente");  //se cierra consulta correctamente
        p.ver(o.listarConsultas(17).resultado, Retorno.Resultado.OK, "listarConsultas(17) = " + o.listarConsultas(17).valorString);

        p.ver(o.historiaClínicaPaciente(12300874).resultado, Retorno.Resultado.OK, "historiaClinicaPaciente(12300874) = " + o.historiaClínicaPaciente(12300874).valorString);

        p.ver(o.reporteDePacientesXFechaYEspecialidad(13, 2021).resultado, Retorno.Resultado.ERROR_1,"reporteDePacientesXFechaYEspecialidad(13, 2021) = El mes debe ser <= 12 o mayor a 0" );
        
        p.ver(o.reporteDePacientesXFechaYEspecialidad(13, 2025).resultado, Retorno.Resultado.ERROR_1,"reporteDePacientesXFechaYEspecialidad(13, 2025) = El anio debe ser entre 2020 y 2023 " );

        p.ver(o.reporteDePacientesXFechaYEspecialidad(10, 2023).resultado, Retorno.Resultado.OK,"reporteDePacientesXFechaYEspecialidad(10, 2023) =  "+o.reporteDePacientesXFechaYEspecialidad(10, 2023).valorString);

        p.ver(o.eliminarMedico(10).resultado, Retorno.Resultado.ERROR_2, "eliminarMedico(10) = No se puede eliminar un medico con consultas."); //NO ELIMINA MEDICO POR QUE TIENE CONSULTAS
        p.ver(o.listarMédicos().resultado, Retorno.Resultado.OK, "listarmedicos() = " + o.listarMédicos().valorString);
        
        p.ver(o.eliminarPaciente(12300874).resultado, Retorno.Resultado.ERROR_2, "eliminarPaciente(12300874) = No se puede eliminar un paciente que esta registrado a una consulta.");  //NO ELIMINA PACIENTE PORQUE ESTA AGENDADO EN CONSULTA
        p.ver(o.listarPacientes().resultado, Retorno.Resultado.OK, "listarPacientes() = " + o.listarPacientes().valorString);

        //cantidad de pruebas con resultados
        p.imprimirResultadosPrueba();
        }
}
