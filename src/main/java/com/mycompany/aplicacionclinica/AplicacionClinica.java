/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.aplicacionclinica;
import static java.lang.Integer.parseInt;
import java.util.Scanner;

/**
 *
 * @author kikecorpus
 */
public class AplicacionClinica {
    
    

    public static void main(String[] args) {
        
        //inicializamos variables fuera del do - while
        Scanner sc = new Scanner(System.in);
        int op = 0; 
        int opTel = 0;
        Paciente p1 = null;
        Paciente p2= null;
        Paciente p3 = null;
        Paciente p4 = null;
        int cuposDisponibles = 4;
        StringBuilder telefonos = new StringBuilder();
        
        // Hacemos do while para menu repetitivo
        do{
           // menu principal
           
           op = Funciones.validacion(1, 4, """
                               \n===========================================
                               BIENVENIDO A LA APP CLINICA DEV
                               ===========================================

                               Eliga la opcion: 

                               1-. Registrar paciente.
                               2-. Mostrar paciente registrados.
                               3-. Atender paciente.
                               4-. Eliminar paciente.                                                      
                               5-. Salir.
                               ********************************************\n
                               """);

            int opR ;
            // opciones del menu    
            switch (op) {
                // Registrar paciente 
                case 1 -> {
                 //menu registrar persona   
                opR = Funciones.validacion(1,4, """
                                   ===========================================
                                   REGISTRAR PACIENTE
                                   ===========================================
                                   Cuantas personas desea registrar: 
                                              
                                   1-. 1
                                   2-. 2
                                   3-. 3
                                   4-. 4
                                   ********************************************
                                   """);
                    //condicional para  validar cupos disponibles
                    if (opR > cuposDisponibles) {
                        System.out.println("\n No hay cupos suficientes para registrar " + opR + " paciente/s.");
                        System.out.println("Cupos disponibles: " + cuposDisponibles+"/4");
                        break;
                        } 
                    // ciclo for para  solicitar datos a la cantidad de pacientea registrar
                    for( int i=0; i<opR; i++){
                      
                        System.out.println("\n***** Registro de paciente #%s ****\n".formatted((i+1)));
                        //nombre
                        System.out.println("\n>>>Por favor ingrese el nombre completo del paciente.\n ");               
                        String nombre = sc.nextLine();  
                        
                        //validad documento que no quede vacio
                        String documento = " ";
                        do {
                            System.out.println("\n>>>Por favor ingrese el documento del paciente.\n");               
                            documento = sc.nextLine();

                            if (documento.isBlank()) {
                                System.out.println("El documento no puede estar vacío.");
                            }

                        } while (documento.isBlank());
                        
                        // validar edad  que no sea negativa ni mayor de 130años                                 
                        int edad = -1;

                        do {
                            System.out.print("\n>>>Por favor ingrese la edad del paciente:\n");
                            String entrada = sc.nextLine();

                            try {
                                
                                edad = Integer.parseInt(entrada);

                                if (edad <= 0 || edad > 130) {
                                    System.out.println("La edad debe estar entre 1 y 130.");
                                    edad = -1;
                                }

                            } catch (NumberFormatException e) {
                                System.out.println("En la edad solo se puede ingresar numeros");
                                edad = -1; 
                            }

                        } while (edad == -1);
    
                       
                        System.out.println("\n>>>Por favor ingrese el motivo de consulta del paciente.\n");
                        String motivoConsulta = sc.nextLine();

                        opTel = Funciones.validacion(1, 3, """
                                                   \n>>>A continuacion registrara el telefono/s del paciente
                                                   por favor indique que cantidad de telefonos desea registrar
                                                           
                                                   1-. 1
                                                   2-. 2
                                                   3-. 3
                                                   """);
                        // ciclo for para registrar cantidad de telefonos
                        for(int j = 0; j<opTel; j ++){
                            System.out.println("\n>>>Por favor ingrese el telefono #%s del paciente".formatted((j+1)));
                            telefonos = telefonos.append(sc.nextLine()).append(",");
                            System.out.println("*****Telefono #"+(j+1) + " registrado con exito******");
                        }
                        //   Logica para registrar en el primer cupo disponible 
                        if (p1 == null) {
                            p1 = new Paciente(nombre,documento,edad,motivoConsulta,telefonos.toString());
                            System.out.println("\n****** Registro exitoso de " + p1.getNombre() + " ******");
                            cuposDisponibles -=1; 

                        } else if (p2 == null) {
                            p2 = new Paciente(nombre,documento,edad,motivoConsulta,telefonos.toString());
                            System.out.println("\n****** Registro exitoso de " + p2.getNombre() + " ******");
                            cuposDisponibles -=1; 

                        } else if (p3 == null) {
                            p3 = new Paciente(nombre,documento,edad,motivoConsulta,telefonos.toString());
                            System.out.println("\n****** Registro exitoso de " + p3.getNombre() + " ******");
                            cuposDisponibles -=1; 

                        } else if (p4 == null) {
                            p4 = new Paciente(nombre,documento,edad,motivoConsulta,telefonos.toString());
                            System.out.println("\n****** Registro exitoso de " + p4.getNombre() + " ******");
                            cuposDisponibles -=1; 

                        } else {
                            System.out.println("\nNo hay cupos disponibles para más pacientes.");
                        }

                    }
                }
                //mostrar Registrados
                case 2 -> {                         
                    int opC = Funciones.validacion(1, 5, """                                        
                                                ===========================================
                                                CONSULTAR PACIENTES REGISTRADOS
                                                ===========================================
                                                Seleccione el paciente que desea consultar: 
                                                
                                                1-. Paciente 1.
                                                2-. Paciente 2.
                                                3-. Paciente 3.
                                                4-. Paciente 4.
                                                5-. Todos.
                                                ********************************************
                                               """);
                    //opciones de pacientes registrados
                    switch(opC){
                          
                        case 1 -> {
                                //logica de mostrar solo registrado 
                                if((p1 != null) && (p1.getEstado().equals("registrado"))) {                     
                                System.out.println("\n******* Paciente #" + opC+"*******");        
                                System.out.println("Nombre: " + p1.getNombre());
                                System.out.println("Documento: " + p1.getDocumento());
                                System.out.println("Edad: " + p1.getEdad());
                                System.out.println("Motivo Consulta: " + p1.getMotivoConsulta());                            
                                Funciones.imprimirTelefono(p1.telefonos.toString(), opTel);  // funcion para imprimir telefonos en diferentes lineas con split
                                System.out.println("Tipo Paciente: " + p1.getTipoPaciente());
                                System.out.println("Estado: " + p1.getEstado());}
                                else if(p1== null){System.out.println("El cupo del paciente no se encuentre registrado");}
                                else {
                                      System.out.println("El paciente ya fue atendido");
                                }
                        }           

                        case 2 -> {
                            if((p2 != null) && (p2.getEstado().equals("registrado"))){ 
                                System.out.println("\n******* Paciente #" + opC+"*******"); 
                                System.out.println("Nombre: " + p2.getNombre());
                                System.out.println("Documento: " + p2.getDocumento());
                                System.out.println("Edad: " + p2.getEdad());
                                System.out.println("Motivo Consulta: " + p2.getMotivoConsulta());                            
                                Funciones.imprimirTelefono(p2.telefonos.toString(), opTel);                            
                                System.out.println("Tipo Paciente: " + p2.getTipoPaciente());
                                System.out.println("Estado: " + p2.getEstado());}
                            else if(p1== null){System.out.println("El cupo del paciente no se encuentre registrado");}
                            else {
                                      System.out.println("El paciente ya fue atendido");
                                }
                        }
                        
                        case 3 -> {
                            if((p3 != null) && (p3.getEstado().equals("registrado"))) {
                                System.out.println("\n******* Paciente #" + opC+"*******"); 
                                System.out.println("Nombre: " + p3.getNombre());
                                System.out.println("Documento: " + p3.getDocumento());
                                System.out.println("Edad: " + p3.getEdad());
                                System.out.println("Motivo Consulta: " + p3.getMotivoConsulta());
                                Funciones.imprimirTelefono(p3.telefonos.toString(), opTel);
                                System.out.println("Tipo Paciente: " + p3.getTipoPaciente());
                                System.out.println("Estado: " + p3.getEstado()); }    
                            else if(p1== null){System.out.println("El cupo del paciente no se encuentre registrado");}
                            else {
                                System.out.println("El paciente ya fue atendido");
                                }

                        }
                        case 4 -> {
                            if((p4 != null) && (p4.getEstado().equals("registrado")))  { 
                                System.out.println("\n******* Paciente #" + opC+"*******"); 
                                System.out.println("Nombre: " + p2.getNombre());
                                System.out.println("Documento: " + p2.getDocumento());
                                System.out.println("Edad: " + p2.getEdad());
                                System.out.println("Motivo Consulta: " + p2.getMotivoConsulta());
                                Funciones.imprimirTelefono(p4.telefonos.toString(), opTel);
                                System.out.println("Tipo Paciente: " + p2.getTipoPaciente());
                                System.out.println("Estado: " + p2.getEstado());}
                            else if(p1== null){System.out.println("El cupo del paciente no se encuentre registrado");}
                            else {
                                System.out.println("El paciente ya fue atendido");
                                }

                    }  
                        case 5 ->{
                            if((p1 != null) && (p1.getEstado().equals("registrado"))) {                     
                                System.out.println("\n******* Paciente #1 *******");        
                                System.out.println("Nombre: " + p1.getNombre());
                                System.out.println("Documento: " + p1.getDocumento());
                                System.out.println("Edad: " + p1.getEdad());
                                System.out.println("Motivo Consulta: " + p1.getMotivoConsulta());                            
                                Funciones.imprimirTelefono(p1.telefonos.toString(), opTel);  // funcion para imprimir telefonos en diferentes lineas con split
                                System.out.println("Tipo Paciente: " + p1.getTipoPaciente());
                                System.out.println("Estado: " + p1.getEstado());}
                                else if(p1== null){System.out.println("El cupo del paciente #1  no se encuentre registrado");}
                                else {
                                      System.out.println("El paciente #1 ya fue atendido");
                                }
                            if((p2 != null) && (p2.getEstado().equals("registrado"))){ 
                                System.out.println("\n******* Paciente #2*******"); 
                                System.out.println("Nombre: " + p2.getNombre());
                                System.out.println("Documento: " + p2.getDocumento());
                                System.out.println("Edad: " + p2.getEdad());
                                System.out.println("Motivo Consulta: " + p2.getMotivoConsulta());                            
                                Funciones.imprimirTelefono(p2.telefonos.toString(), opTel);                            
                                System.out.println("Tipo Paciente: " + p2.getTipoPaciente());
                                System.out.println("Estado: " + p2.getEstado());}
                            else if(p1== null){System.out.println("El cupo del paciente #2 no se encuentre registrado");}
                            else {
                                      System.out.println("El paciente #2 ya fue atendido");
                                }
                            if((p3 != null) && (p3.getEstado().equals("registrado"))) {
                                System.out.println("\n******* Paciente #3*******"); 
                                System.out.println("Nombre: " + p3.getNombre());
                                System.out.println("Documento: " + p3.getDocumento());
                                System.out.println("Edad: " + p3.getEdad());
                                System.out.println("Motivo Consulta: " + p3.getMotivoConsulta());
                                Funciones.imprimirTelefono(p3.telefonos.toString(), opTel);
                                System.out.println("Tipo Paciente: " + p3.getTipoPaciente());
                                System.out.println("Estado: " + p3.getEstado()); }    
                            else if(p1== null){System.out.println("El cupo del paciente #3 no se encuentre registrado");}
                            else {
                                System.out.println("El paciente #3 ya fue atendido");
                                }
                              if((p4 != null) && (p4.getEstado().equals("registrado")))  { 
                                System.out.println("\n******* Paciente #4*******"); 
                                System.out.println("Nombre: " + p2.getNombre());
                                System.out.println("Documento: " + p2.getDocumento());
                                System.out.println("Edad: " + p2.getEdad());
                                System.out.println("Motivo Consulta: " + p2.getMotivoConsulta());
                                Funciones.imprimirTelefono(p4.telefonos.toString(), opTel);
                                System.out.println("Tipo Paciente: " + p2.getTipoPaciente());
                                System.out.println("Estado: " + p2.getEstado());}
                            else if(p1== null){System.out.println("El cupo del paciente #4 no se encuentre registrado");}
                            else {
                                System.out.println("El paciente  #4 ya fue atendido");
                                }
                            
                        }
                
                    }
                }
                //Atender paciente
                case 3 -> {
                            int opA = Funciones.validacion(1, 4, """
                                               ===========================================
                                               ATENDER PACIENTE
                                               ===========================================
                                               
                                               Elija el paciente para atender: 
                                               
                                               1-. Paciente 1.
                                               2-. Paciente 2.
                                               3-. Paciente 3.
                                               4-. Paciente 4. 
                                               *******************************************
                                               """);
                            
                            switch (opA){
                                case 1 -> {System.out.println("\n****Paciente #1 atendido correctamente*****");
                                           p1.setEstado("Atendido");
                                }
                                
                                case 2 -> {System.out.println("\nPaciente #2 atendido correctamente");
                                           p2.setEstado("Atendido");
                                }
                                
                                case 3 -> {System.out.println("\nPaciente #3 atendido correctamente");
                                           p3.setEstado("Atendido");
                                }
                                
                                case 4 -> {
                                            System.out.println("\nPaciente #4 atendido correctamente");
                                            p4.setEstado("Atendido");
                                }           
                            }           
                } 
                //Eliminar paciente
                case 4 ->{
                    int opE= Funciones.validacion(1, 4, """
                                                        \n===========================================
                                                        ELIMINAR PACIENTE
                                                        ============================================
                                                        Selecciona el paciente que desea eliminar:
                                                        
                                                        1-. Paciente 1.
                                                        2-. Paciente 2.
                                                        3-. Paciente 3.
                                                        4-. Paciente 4.
                                                        """);
                    switch(opE){
                        case 1 -> {
                            if(p1 != null){
                                p1 = null;
                                cuposDisponibles += 1 ;
                                System.out.println("\n****Paciente #1 eliminado exitosamente****");
                            }else{
                                System.out.println("\n****El paciente #1 aun no se encuentra registrado****");
                            }
                        }
                        case 2 -> {
                            if(p2 != null){
                                p2 = null;
                                cuposDisponibles += 1 ;
                                System.out.println("\n****Paciente #2 eliminado exitosamente****");
                            }else{
                                System.out.println("\n****El paciente #2 aun no se encuentra registrado****");
                            }
                        }
                        case 3 -> {
                            if(p3 != null){
                                p3 = null;
                                cuposDisponibles += 1 ;
                                System.out.println("\n****Paciente #3 eliminado exitosamente****");
                            }else{
                                System.out.println("\n****El paciente #3 aun no se encuentra registrado****");
                            }
                        }
                        case 4 -> {
                            if(p4 != null){
                                p4 = null;
                                cuposDisponibles += 1 ;
                                System.out.println("\n****Paciente #4 eliminado exitosamente****");
                            }else{
                                System.out.println("\n****El paciente #4 aun no se encuentra registrado****");
                            }
                        }
                    }
                }
            
            }    
        
        } while (op!=5);

        System.out.println("\nGracias por salvar al mundo, hasta pronto <3");
    }   


    
}
