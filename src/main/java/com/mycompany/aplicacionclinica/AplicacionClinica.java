/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.aplicacionclinica;
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
                    //menu registrar persona   
                         //condicional para  validar cupos disponibles
                   try{
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
                    
                    //opcion regresar
                    if (opR == 0){ break;}
                    if(opR > cuposDisponibles){
                        throw new IllegalArgumentException(" ");
                    }
                   
                   } catch(IllegalArgumentException e){
                        System.out.println("\n----No hay cupos suficientes para registrar " + opR+ " paciente/s.----");
                        System.out.println("****Cupos disponibles: " + cuposDisponibles+"/4****");
                        op = 5;
                    }
     
                    // ciclo for para  solicitar datos a la cantidad de pacientea registrar
                    for( int i=0; i<opR; i++){
                      
                        System.out.println("\n***** Registro de paciente #%s ****\n".formatted((i+1)));
                        
                        //nombre
                        String nombre = Funciones.solicitarInfo(sc, "\n>>>Por favor ingrese el nombre completo del paciente.\n ");  
                        
                        //documento
                        String documento = Funciones.solicitarInfo(sc,"\n>>>Por favor ingrese el documento del paciente.\n");
                        
                        //validar edad  que no sea negativa ni mayor de 130años                                 
                        int edad = Funciones.validacion(1, 130, "\n>>>Por favor ingrese la edad del paciente:\n");

                        //motivo de consulta
                        String motivoConsulta = Funciones.solicitarInfo(sc,"\n>>>Por favor ingrese el motivo de consulta del paciente.\n");

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
                        
                        //Logica para registrar en el primer cupo disponible 
                        if (p1 == null) {
                            p1 = Funciones.registrarPaciente(p1, nombre, documento, edad, motivoConsulta, telefonos);
                            cuposDisponibles = Funciones.cuposDisponibles(p1, cuposDisponibles); 

                        } else if (p2 == null) {
                            p2 = Funciones.registrarPaciente(p2, nombre, documento, edad, motivoConsulta, telefonos);
                            cuposDisponibles = Funciones.cuposDisponibles(p2, cuposDisponibles); 

                        } else if (p3 == null) {
                            p3 = Funciones.registrarPaciente(p3, nombre, documento, edad, motivoConsulta, telefonos);
                            cuposDisponibles = Funciones.cuposDisponibles(p3, cuposDisponibles); 

                        } else if (p4 == null) {
                            p4 = Funciones.registrarPaciente(p4, nombre, documento, edad, motivoConsulta, telefonos);
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
                case 5 -> { System.out.println("**** Cupos disponibles: " + cuposDisponibles + "/4 ****");} 

            }    
        
        } while (op!=6);

        System.out.println("\nGracias por salvar al mundo, hasta pronto <3");
    }   


    
}
