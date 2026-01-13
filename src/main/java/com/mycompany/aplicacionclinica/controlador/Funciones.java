/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionclinica.controlador;

import com.mycompany.aplicacionclinica.modelado.Paciente;
import static java.lang.Integer.parseInt;
import java.util.Scanner;

/**
 *
 * @author kikecorpus
 */
public class Funciones {
    
    // logica principal
    static public void flujoDeTrabajo (){
            
        //inicializamos variables fuera del do - while
        Scanner sc = new Scanner(System.in);
        int op = 0; 
        int opTel = 0;
        Paciente p1 = null;
        Paciente p2= null;
        Paciente p3 = null;
        Paciente p4 = null;
        int cuposDisponibles = 4;
        
        
        // Hacemos do while para menu repetitivo
        do{
           // menu principal
           op = Funciones.validacion(1, 6, """
                               \n===========================================
                               BIENVENIDO A LA APP CLINICA DEV
                               ===========================================

                               Eliga la opcion: 

                               1-. Registrar paciente.
                               2-. Mostrar paciente registrados.
                               3-. Atender paciente.
                               4-. Eliminar paciente. 
                               5-. Consultar cupos disponibles                                                                 
                               6-. Salir.
                               ********************************************\n
                               """);
         
            int opR = 0 ; //opcion del menu registrar paciente
            // opciones del menu    
            switch (op) {
                // Registrar paciente 
                case 1 -> {
                
                     opR = Funciones.validacion(0,4, """
                                   ===========================================
                                   REGISTRAR PACIENTE
                                   ===========================================
                                   Cuantas personas desea registrar: 
                                              
                                   1-. 1
                                   2-. 2
                                   3-. 3
                                   4-. 4
                                   0-. Regresar                 
                                   ********************************************
                                   """);
                    
                     opR = Funciones.validarCupos(opR, cuposDisponibles);
                    //opcion regresar
                    if (opR == 0){ break;}
                    
     
                    // ciclo for para  solicitar datos a la cantidad de pacientea registrar
                    for( int i=0; i<opR; i++){

                        //Logica para registrar en el primer cupo disponible 
                        if (p1 == null) {
                            p1 = Funciones.registrarPaciente(sc,i);
                            cuposDisponibles = Funciones.cuposDisponibles(p1, cuposDisponibles); 

                        } else if (p2 == null) {
                            p2 = Funciones.registrarPaciente(sc,i);
                            cuposDisponibles = Funciones.cuposDisponibles(p2, cuposDisponibles); 

                        } else if (p3 == null) {
                            p3 = Funciones.registrarPaciente(sc,i);
                            cuposDisponibles = Funciones.cuposDisponibles(p3, cuposDisponibles); 

                        } else if (p4 == null) {
                            p4 = Funciones.registrarPaciente(sc,i);
                            cuposDisponibles = Funciones.cuposDisponibles(p4, cuposDisponibles); 

                        } else {
                            System.out.println("\nNo hay cupos disponibles para más pacientes.");
                        }
                    }
                }
                
                //mostrar Registrados
                case 2 -> {                         
                    int opC = Funciones.validacion(0, 5, """                                        
                                                ===========================================
                                                CONSULTAR PACIENTES REGISTRADOS
                                                ===========================================
                                                Seleccione el paciente que desea consultar: 
                                                
                                                1-. Paciente 1.
                                                2-. Paciente 2.
                                                3-. Paciente 3.
                                                4-. Paciente 4.
                                                5-. Todos.
                                                0-. Regresar.         
                                                ********************************************
                                               """);
                    //opciones de pacientes registrados
                    switch(opC){
                          
                        case 1 -> {
                                Funciones.mostrarPaciente(p1, opC, opTel);
                        }           

                        case 2 -> {
                                Funciones.mostrarPaciente(p2, opC, opTel);
                        }
                        
                        case 3 -> {
                                Funciones.mostrarPaciente(p3, opC, opTel);
                        }
                        case 4 -> {
                                Funciones.mostrarPaciente(p4, opC, opTel);
                                }
                    
                        case 5 -> {
                            Funciones.mostrarPaciente(p1, 1, opTel);
                            Funciones.mostrarPaciente(p2, 2, opTel);
                            Funciones.mostrarPaciente(p3, 3, opTel);
                            Funciones.mostrarPaciente(p4, 4, opTel);
                        }
                        case 0 -> {break;}
                
                    }
                }
                //Atender paciente
                case 3 -> {
                            int opA = Funciones.validacion(0, 4, """
                                               ===========================================
                                               ATENDER PACIENTE
                                               ===========================================
                                               
                                               Elija el paciente para atender: 
                                               
                                               1-. Paciente 1.
                                               2-. Paciente 2.
                                               3-. Paciente 3.
                                               4-. Paciente 4. 
                                               0-. Regresar.                  
                                               *******************************************
                                               """);
                            
                            switch (opA){
                                case 1 -> {p1 = Funciones.atenderPaciente(p1, opA);
                                }
                                
                                case 2 -> {p2 = Funciones.atenderPaciente(p2, opA);
                                }
                                
                                case 3 -> {p3 = Funciones.atenderPaciente(p3, opA);
                                }
                                
                                case 4 -> {p4 = Funciones.atenderPaciente(p4, opA);
                                } 
                                case 0 -> {break;}
                            }           
                } 
                //Eliminar paciente
                case 4 ->{
                    int opE= Funciones.validacion(0, 4, """
                                                        \n===========================================
                                                        ELIMINAR PACIENTE
                                                        ============================================
                                                        Selecciona el paciente que desea eliminar:
                                                        
                                                        1-. Paciente 1.
                                                        2-. Paciente 2.
                                                        3-. Paciente 3.
                                                        4-. Paciente 4.
                                                        0-. Regresar.
                                                        """);
                    switch(opE){
                        case 1 -> {
                            p1 = Funciones.eliminarpaciente(p1, cuposDisponibles);
                            cuposDisponibles = Funciones.cuposDisponibles(p1, cuposDisponibles);
                        }
                        case 2 -> {
                            p2 = Funciones.eliminarpaciente(p2, cuposDisponibles);
                            cuposDisponibles = Funciones.cuposDisponibles(p1, cuposDisponibles);
                        }
                        case 3 -> {
                            p3 = Funciones.eliminarpaciente(p3, cuposDisponibles);
                            cuposDisponibles = Funciones.cuposDisponibles(p1, cuposDisponibles);
                        }
                        case 4 -> {
                            p4 = Funciones.eliminarpaciente(p4, cuposDisponibles);
                            cuposDisponibles = Funciones.cuposDisponibles(p1, cuposDisponibles);
                        }
                        case 0 ->{break;}
                    }
                   
                }
                case 5 -> { System.out.println("\n**** Cupos disponibles: " + cuposDisponibles + "/4 ****");} 

            }    
        
        } while (op!=6);

        System.out.println("\nGracias por salvar al mundo, hasta pronto <3");
        }
    
    // validaciones
    static int validacion(int valorminimo, int valormaximo, String mensaje) {
        
        boolean validar = false;
        int op = 0;
        do {
            try {
                System.out.println(mensaje);
                op = parseInt(new Scanner(System. in).nextLine()) ;
               
                //validar opcion correcta
                while (op < valorminimo || op > valormaximo) {        
                    System.out.println("\n----Opcion no valida, intente nuveamente.----");  
                    op = parseInt(new Scanner(System. in).nextLine()) ;
                      
                 }
                validar = true;

            } catch (NumberFormatException e) {
                System.out.println("\n----Error, solo se admiten números ----");
   
            } catch(Exception e){
                System.out.println("\n----Ocurrior un error, intente de nuevo----");
            } ;
                    
        } while (validar == false);
        return op;
        
    }
    static int validarCupos(int opR, int cuposDisponibles){
      //menu registrar persona  
      
                        //condicional para  validar cupos disponibles
                   try{
                    
                    if(opR > cuposDisponibles){
                        throw new IllegalArgumentException(" ");
                    }
                   
                   } catch(IllegalArgumentException e){
                        System.out.println("\n----No hay cupos suficientes para registrar " + opR+ " paciente/s.----");
                        System.out.println("****Cupos disponibles: " + cuposDisponibles+"/4****");
                        opR = 0;
                    }
                
                 return opR;
    
    
    }

    // case 1
    static Paciente registrarPaciente(Scanner sc, int i){
        StringBuilder telefonos = new StringBuilder();
        
        System.out.println("\n***** Registro de paciente #%s ****\n".formatted((i+1)));
                        
        //nombre
        String nombre = Funciones.solicitarInfo(sc, "\n>>>Por favor ingrese el nombre completo del paciente.\n ");  

        //documento
        String documento = Funciones.solicitarInfo(sc,"\n>>>Por favor ingrese el documento del paciente.\n");

        //validar edad  que no sea negativa ni mayor de 130años                                 
        int edad = Funciones.validacion(1, 130, "\n>>>Por favor ingrese la edad del paciente:\n");

        //motivo de consulta
        String motivoConsulta = Funciones.solicitarInfo(sc,"\n>>>Por favor ingrese el motivo de consulta del paciente.\n");

        int opTel = Funciones.validacion(1, 3, """
                                   \n>>>A continuacion registrara el telefono/s del paciente
                                   por favor indique que cantidad de telefonos desea registrar

                                   1-. 1
                                   2-. 2
                                   3-. 3
                                   """);
        
        // registrar cantidad de telefonos
        telefonos = Funciones.registrarTelefono(opTel, telefonos, sc);
        
        Paciente paciente = new Paciente(nombre,documento,edad,motivoConsulta,telefonos.toString());
        System.out.println("\n****** Registro exitoso de " + paciente.getNombre() + " ******");  
        
        return paciente; 
    }
    
        //solicitar Data
        static void imprimirTelefono(String telefonos, int op){
        for(int i=0; i<op; i++){
        System.out.println("Telefono #" + (i+1) + ": "+ telefonos.split(",")[i].substring(0, telefonos.split(",")[i].length()-1)); 
        }
    }
    
        static String solicitarInfo(Scanner sc, String mensaje) {
        
        String variable = " ";
        
        do{
            
            System.out.println(mensaje);               
            variable = sc.nextLine(); 

            if (variable.isBlank()) {System.out.println("La respuesta no puede estar vacía.");}
            
        } while(variable.isBlank()); //validar que documento que no quede vacio
        
        return variable;
    }
        
        static StringBuilder registrarTelefono(int opTel, StringBuilder telefonos, Scanner sc){
                            for(int j = 0; j<opTel; j ++){
                            System.out.println("\n>>>Por favor ingrese el telefono #%s del paciente".formatted((j+1)));
                            telefonos = telefonos.append(sc.nextLine()).append(",");
                            System.out.println("*****Telefono #"+(j+1) + " registrado con exito******");
                           
                        }
                        return telefonos;
      }
        
       
    // case 2
    static void mostrarPaciente(Paciente paciente, int opC, int opTel) {
       //logica de mostrar solo registrado 
                                if((paciente != null) && (paciente.getEstado().equals("registrado"))) {                     
                                System.out.println("\n******* Paciente #" + opC+" *******");        
                                System.out.println("Nombre: " + paciente.getNombre());
                                System.out.println("Documento: " + paciente.getDocumento());
                                System.out.println("Edad: " + paciente.getEdad());
                                System.out.println("Motivo Consulta: " + paciente.getMotivoConsulta());                            
                                Funciones.imprimirTelefono(paciente.getTelefonos().toString(), opTel);  // funcion para imprimir telefonos en diferentes lineas con split
                                System.out.println("Tipo Paciente: " + paciente.getTipoPaciente());
                                System.out.println("Estado: " + paciente.getEstado());}
                                else if(paciente== null){
                                                            System.out.println("""
                                                                               ******* Paciente #%s *******
                                                                               El cupo del paciente %s no se encuentra registrado 
                                                                               """.formatted(opC, opC));}
                                else {
                                      System.out.println("""
                                                         ******* Paciente #%s *******
                                                         El paciente ya fue atendido
                                                         """.formatted(opC, opC));
                                }
 
    }
    
    // case 3
    static Paciente eliminarpaciente(Paciente paciente, int cuposDisponibles){
         if(paciente != null){
                                paciente = null;
                                System.out.println("\n****Paciente eliminado exitosamente****");
                                System.out.println("\n****Cupos diponibles actualizado %s /4 ****".formatted((cuposDisponibles +1)));
                                
                            }else{
                                System.out.println("\n****El paciente aun no se encuentra registrado****");
                            }
         return paciente;
    }
     
    // case 4
    static Paciente atenderPaciente(Paciente paciente, int opA){
    
        System.out.println("\n****Paciente #%s atendido correctamente*****".formatted(opA));
        paciente.setEstado("Atendido");
        return paciente;
    }
    
    // case 5
    static int cuposDisponibles(Paciente paciente,int cuposDisponibles){ 
        if (paciente != null){
            cuposDisponibles -=1;
        } else {cuposDisponibles +=1;
        }
        return cuposDisponibles;
    }
  
}


