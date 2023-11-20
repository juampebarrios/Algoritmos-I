package sistemaAutogestion;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Sistema s = new Sistema();
        Prueba p = new Prueba();
        juegodeprueba(s, p);
    }

      public static void juegodeprueba (Sistema s,Prueba p){
        
          // CREAR SISTEMA
        p.ver(s.crearSistemaDeAutogestion(12).resultado, Retorno.Resultado.OK, "Se crea sistema correctamente con " + s.maxPacientesporMedico + " pacientes por medico ");

        // NO SE CREA SISTEMA MAX DE PACIENTES POR MEDICO ES 12
        p.ver(s.crearSistemaDeAutogestion(18).resultado, Retorno.Resultado.ERROR_1, "No se crea sitema con mas de 15 pacientes , se ingreso :  " + s.crearSistemaDeAutogestion(18).valorEntero);

        // REGISTRAR MEDICO
        p.ver(s.registrarMedico("Jorge Rodirguez", 1, 27002397, 1).resultado, Retorno.Resultado.OK, "Se registra medico cod 1");
        p.ver(s.registrarMedico("Zavier Gonzalez", 2, 29002375, 2).resultado, Retorno.Resultado.OK, "Se registra medico cod 2");
        p.ver(s.registrarMedico("Juan Perez", 3, 24081508, 1).resultado, Retorno.Resultado.OK, "Se registra medico cod 3 ");
        p.ver(s.registrarMedico("Jorge Iglesias", 4, 24841235, 4).resultado, Retorno.Resultado.OK, "Se registra medico cod 4");
        p.ver(s.registrarMedico("Marcelo Tecehera", 5, 22923604, 5).resultado, Retorno.Resultado.OK, "Se registra medico cod 5 ");
        p.ver(s.registrarMedico("Graciela Mendez", 6, 23641517, 4).resultado, Retorno.Resultado.OK, "Se registra medico cod 6");
        p.ver(s.registrarMedico("Ana Lopez", 7, 47325442, 3).resultado, Retorno.Resultado.OK, "Se registra medico cod 7");
        p.ver(s.registrarMedico("Anabelle Camarda", 8, 26007048, 6).resultado, Retorno.Resultado.OK, "Se registra medico cod 8");
        p.ver(s.registrarMedico("Valentina Velazquez", 9, 22883704, 2).resultado, Retorno.Resultado.OK, "Se registra medico cod 9");
        p.ver(s.registrarMedico("Raquel Sanchez", 10, 25112907, 2).resultado, Retorno.Resultado.OK, "Se registra medico cod 10");

        // No se registra medico mismo codigo
        p.ver(s.registrarMedico("Raquel Sanchez", 10, 25112907, 2).resultado, Retorno.Resultado.ERROR_1, "No se registra medico por mismo codigo, ya existe");
        // No se registra medico codigo especialidad <1 o > 20
        p.ver(s.registrarMedico("Luis Diaz", 11, 25112907, 25).resultado, Retorno.Resultado.ERROR_2, "No se registra medico cod especialiad mayor 20");
        p.ver(s.registrarMedico("Luis Diaz", 12, 25112907, 0).resultado, Retorno.Resultado.ERROR_2, "No se registra medico cod especialiad menor 1");

        // LISTAR MEDICOS ORDENADOS POR NOMBRE
        p.ver(s.listarMédicos().resultado, Retorno.Resultado.OK, "Lista medicos");

        // AGREGAR PACIENTE
        p.ver(s.agregarPaciente("Ramon Gonzalez", 39401257, "Rivera 1234").resultado, Retorno.Resultado.OK, "Se agrego paciente 39401257 ");
        p.ver(s.agregarPaciente("Alicia Rodriguez", 16087234, "18 de Julio 3506").resultado, Retorno.Resultado.OK, "Se agrego paciente 16087234");
        p.ver(s.agregarPaciente("Graciela Fernandez", 26085154, "Pernas 2708").resultado, Retorno.Resultado.OK, "Se agrego paciente 26085154");
        p.ver(s.agregarPaciente("Gabriel Hernandez", 30081253, "Piovene 978").resultado, Retorno.Resultado.OK, "Se agrego paciente 30081253 ");
        p.ver(s.agregarPaciente("Mariana Gutierrez", 55243662, "Uruguay 1079").resultado, Retorno.Resultado.OK, "Se agrego paciente 55243662");
        p.ver(s.agregarPaciente("Zully Almada", 14241115, "Lieja 975").resultado, Retorno.Resultado.OK, "Se agrego paciente 14241115");
        p.ver(s.agregarPaciente("Tatiana Morales", 63457890, "Colonia 1209").resultado, Retorno.Resultado.OK, "Se agrego paciente 63457890");
        p.ver(s.agregarPaciente("Andres Benites", 47251872, "Andes 1503").resultado, Retorno.Resultado.OK, "Se agrego paciente 47251872");
        p.ver(s.agregarPaciente("Paola Torres", 47081392, "Cuareim 1225").resultado, Retorno.Resultado.OK, "Se agrego paciente 47081392");
        p.ver(s.agregarPaciente("Daniel Mareco", 27391573, "Artigas 1101").resultado, Retorno.Resultado.OK, "Se agrego paciente 27391573");
        p.ver(s.agregarPaciente("Viginia Fleitas", 17391556, "25 de Mayo 1080").resultado, Retorno.Resultado.OK, "Se agrego paciente 17391556");
        p.ver(s.agregarPaciente("Marcos Perez", 57391569, "Canelones 911").resultado, Retorno.Resultado.OK, "Se agrego paciente 57391569");
        p.ver(s.agregarPaciente("Guillermo  Hernandez", 45481322, "Lieja 2504").resultado, Retorno.Resultado.OK, "Se agrego paciente 45481322");
        p.ver(s.agregarPaciente("Elsa Romero", 6793111, "Luis A de Herrera 2532").resultado, Retorno.Resultado.OK, "Se agrego paciente 6793111");
        p.ver(s.agregarPaciente("Daniela Castro", 47147254, "G.Viana 2504").resultado, Retorno.Resultado.OK, "Se agrego paciente 47147254");
        p.ver(s.agregarPaciente("Julieta Alamda", 53239885, "Comercio 3694").resultado, Retorno.Resultado.OK, "Se agrego paciente 53239885");
        p.ver(s.agregarPaciente("Nicolas Cozzo", 47365401, "Comercio 3694").resultado, Retorno.Resultado.OK, "Se agrego paciente 47365401");
        p.ver(s.agregarPaciente("Patricia Perez", 39600572, "Comercio 3694").resultado, Retorno.Resultado.OK, "Se agrego paciente 39600572");
        //No se agrega Paciente misma CI
        p.ver(s.agregarPaciente("Manuel Gomez", 27391573, "25 de Agosto 1220").resultado, Retorno.Resultado.ERROR_1, "No se agrego paciente, ya existe en la lista");

        //LISTAMOS PACIENTES         
        p.ver(s.listarPacientes().resultado, Retorno.Resultado.OK, "Lista Pacientes");

        // ELIMINAR MEDICO
        p.ver(s.eliminarMedico(3).resultado, Retorno.Resultado.OK, " Se elimina medico nro 3");

        //NO SE ELIMINA MEDICO, NO EXISTE CODIGO MEDICO
        p.ver(s.eliminarMedico(12).resultado, Retorno.Resultado.ERROR_1, " No se puede eliminar Medico con codigo 12, no existe en la lista");

        //LISTAMOS MEDICOS
        p.ver(s.listarMédicos().resultado, Retorno.Resultado.OK, "Lista medicos");

        // ELIMINAR PACIENTE
        p.ver(s.eliminarPaciente(30081253).resultado, Retorno.Resultado.OK, " Se elimina paciente cedula 30081253");

        //NO SE ELIMINA PACIENTE , NO EXISTE EN LA LISTA
        p.ver(s.eliminarPaciente(11111111).resultado, Retorno.Resultado.ERROR_1, " No se elimina paciente de cedula 11111111, no existe en la lista");

        //LISTAMOS PACIENTES         
        p.ver(s.listarPacientes().resultado, Retorno.Resultado.OK, "Lista Pacientes");

        //REGISTRAMOS DIAS DE CONSULTAS PARA LOS MEDICOS         
        p.ver(s.registrarDiaDeConsulta(1, new Date(2023, 11, 1)).resultado, Retorno.Resultado.OK, "Se agrega fecha de consulta para medico");
        p.ver(s.registrarDiaDeConsulta(2, new Date(2023, 11, 2)).resultado, Retorno.Resultado.OK, "Se agrega fecha de consulta para medico");
        p.ver(s.registrarDiaDeConsulta(1, new Date(2023, 9, 21)).resultado, Retorno.Resultado.OK, "Se agrega fecha de consulta para medico");
        p.ver(s.registrarDiaDeConsulta(1, new Date(2023, 11, 1)).resultado, Retorno.Resultado.ERROR_2, "Ya existe esa fecha para es codmedico");
        p.ver(s.registrarDiaDeConsulta(13, new Date(2023, 11, 1)).resultado, Retorno.Resultado.ERROR_1, "Error No existe medico con codigo 13");
        p.ver(s.registrarDiaDeConsulta(7, new Date(2023, 11, 3)).resultado, Retorno.Resultado.OK, "Se agrega fecha de consulta para medico");

        //RESERVAMOS LAS CONSULTAS PARA LOS PACIENTES
        p.ver(s.reservaConsulta(1, 47365401, new Date(2023, 11, 1)).resultado, Retorno.Resultado.OK, "Se reservo paciente 47365401 ");
        p.ver(s.reservaConsulta(7, 39401257, new Date(2023, 11, 3)).resultado, Retorno.Resultado.OK, "Se reservo paciente 39401257 C/MED 7");
        p.ver(s.reservaConsulta(1, 39401257, new Date(2023, 11, 1)).resultado, Retorno.Resultado.OK, "Se reservo paciente 39401257  ");
        p.ver(s.reservaConsulta(1, 26085154, new Date(2023, 11, 1)).resultado, Retorno.Resultado.OK, "Se reservo paciente 26085154");
        p.ver(s.reservaConsulta(1, 63457890, new Date(2023, 11, 1)).resultado, Retorno.Resultado.OK, "Se reservo paciente 63457890");
        p.ver(s.reservaConsulta(1, 27391573, new Date(2023, 11, 1)).resultado, Retorno.Resultado.OK, "Se reservo paciente 27391573");
        p.ver(s.reservaConsulta(1, 47081392, new Date(2023, 11, 1)).resultado, Retorno.Resultado.OK, "Se reservo paciente 47081392");
        p.ver(s.reservaConsulta(1, 47251872, new Date(2023, 11, 1)).resultado, Retorno.Resultado.OK, "Se reservo paciente 47251872");
        p.ver(s.reservaConsulta(1, 14241115, new Date(2023, 11, 1)).resultado, Retorno.Resultado.OK, "Se reservo paciente 14241115");
        p.ver(s.reservaConsulta(1, 55243662, new Date(2023, 11, 1)).resultado, Retorno.Resultado.OK, "Se reservo paciente 55243662");
        p.ver(s.reservaConsulta(1, 16087234, new Date(2023, 11, 1)).resultado, Retorno.Resultado.OK, "Se reservo paciente 16087234");
        p.ver(s.reservaConsulta(1, 17391556, new Date(2023, 11, 1)).resultado, Retorno.Resultado.OK, "Se reservo paciente 17391556");
        p.ver(s.reservaConsulta(1, 6793111, new Date(2023, 11, 1)).resultado, Retorno.Resultado.OK, "Se reservo paciente 6793111");
        p.ver(s.reservaConsulta(1, 57391569, new Date(2023, 11, 1)).resultado, Retorno.Resultado.OK, "Se reservo paciente 57391569 ");
        p.ver(s.reservaConsulta(1, 39600572, new Date(2023, 11, 1)).resultado, Retorno.Resultado.OK, "Se reservo paciente 39600572");
        p.ver(s.reservaConsulta(2, 39401257, new Date(2023, 11, 2)).resultado, Retorno.Resultado.OK, "Se reservo paciente 39401257 COD MED 2");

       // Intentamos hacer resevar probado errores
        p.ver(s.reservaConsulta(3, 22222222, new Date(2023, 11, 15)).resultado, Retorno.Resultado.ERROR_1, " No se reservo no existe paciente de ci 22222222");
        p.ver(s.reservaConsulta(24, 26085154, new Date(2023, 11, 1)).resultado, Retorno.Resultado.ERROR_2, "No se reservo no existe medico de codigo 24");
        p.ver(s.reservaConsulta(1, 27391573, new Date(2023, 11, 15)).resultado, Retorno.Resultado.ERROR_4, " No se reservo paciente 27391573, no hay fecha para esemedico");
        p.ver(s.reservaConsulta(1, 26085154, new Date(2023, 11, 1)).resultado, Retorno.Resultado.ERROR_3, "No se pudo agregar consulta, paciente ya tiene consulta con ese medico");


        //SE PRUEBA ELIMINAR PACIENTE QUE TIENE RESERVA   
        p.ver(s.eliminarPaciente(26085154).resultado, Retorno.Resultado.ERROR_2, "No se elimina paciente tiene reserva");

        //LISTAMOS PACIENTES         
        p.ver(s.listarPacientes().resultado, Retorno.Resultado.OK, "Lista Pacientes");


        //LISTAMOS LAS RESERVAS DE CONSULTAS PARA MEDICO codigo 1
        p.ver(s.listarConsultas(1).resultado, Retorno.Resultado.OK, "Lista Reservas para Medico cod 1");

        //LISTAMOS LAS RESERVAS DE CONSULTAS PARA MEDICO codiog 2
        p.ver(s.listarConsultas(2).resultado, Retorno.Resultado.OK, "Lista Reservas para Medico cod 2");

        //LISTAMOS LAS RESERVAS DE CONSULTAS PARA MEDICO codiog 7
        p.ver(s.listarConsultas(7).resultado, Retorno.Resultado.OK, "Lista Reservas para Medico cod 7");

        //CANCELAMOS UNA RESERVA
        p.ver(s.cancelarReserva(1, 47081392).resultado, Retorno.Resultado.OK, "Se cancelo reserva para el paciente 47081392");
               

        //ANUCIAMOS LLEGADA A TOTEM
        p.ver(s.anunciaLlegada(1, 14241115).resultado, Retorno.Resultado.OK, "Paciente : " + 14241115 + "anuncio llegada");
        p.ver(s.anunciaLlegada(1, 47365401).resultado, Retorno.Resultado.OK, "Paciente : " + 47365401 + "anuncio llegada");
        p.ver(s.anunciaLlegada(2, 39401257).resultado, Retorno.Resultado.OK, "Paciente : " + 39401257 + "anuncio llegada");

        //LISTAMOS PACIENTES EN ESPERA PAR EL MEDICO 1
        p.ver(s.listarPacientesEnEspera(1, new Date(2023, 11, 1)).resultado, Retorno.Resultado.OK, "Lista consultas en espera para codmedico 1");

        //TERMINAMOS LA CONSULTA
        p.ver(s.terminarConsultaMedicoPaciente(14241115, 1, "Asistio").resultado, Retorno.Resultado.OK, "Cerrado correctamnente para el paciente 14241115");
        p.ver(s.terminarConsultaMedicoPaciente(47365401, 1, "Asistio").resultado, Retorno.Resultado.OK, "Cerrado correctamnente para el paciente 47365401");
        p.ver(s.terminarConsultaMedicoPaciente(39401257, 2, "Asistio").resultado, Retorno.Resultado.OK, "Cerrado correctamnente para el paciente 39401257");

        //CERRAMOS LA CONSULTAS PACIENTES QUE NO ASISTIERON PARA EL MEDICO 1
//        p.ver(s.cerrarConsulta(1, new Date(123, 11, 1)).resultado, Retorno.Resultado.OK, "Consultas Cerradas(Pacientes que no asistieron) para medico 1 ");

        //LISTAMOS CONSULTAS PENDIENTES PARA EL PACIENTE
        p.ver(s.consultasPendientesPaciente(39401257).resultado, Retorno.Resultado.OK, "Consulta pendiente para paciente 39401257 ");

        //MOSTRAMOS HISTORIA CLINICA DEL PACIENTE
        p.ver(s.historiaClínicaPaciente(39401257).resultado, Retorno.Resultado.OK, "Historia Clinica de Paciente ci 39401257 ");

        //MATRIZ REPORTE DE PACIENTE POR ESPECIALIDAD Y FECHA
        p.ver(s.reporteDePacientesXFechaYEspecialidad(11, 2023).resultado, Retorno.Resultado.OK, "Matriz REPORTE DE PACIENTE POR ESPECIALIDAD Y FECHA");
        
  
        p.imprimirResultadosPrueba();
    }
    
    
}
