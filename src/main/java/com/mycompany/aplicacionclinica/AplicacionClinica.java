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
        /*
        Paciente p3 = new Paciente("enrique","12234",20,"fafa","310258963","registrado");
          System.out.println("""
                            Nombre: %s
                            Documento: %s
                            Edad: %s
                            Motivo Consulta: %s
                            Telefono/s: %s
                            Tipo Paciente: %s
                            Estado: %s
                            """.formatted(p3.getNombre(), p3.getDocumento(), p3.getEdad(), p3.getMotivoConsulta(), p3.getTelefonos(), p3.getTipoPaciente(), p3.getEstado()));*/

        int op; //inicializamos variables fuera del do - while
                Paciente p1;
                Paciente p2;
                Paciente p3;
                Paciente p4;
        // hacemos do while para menu repetitivo
        do{
           // menu principal 
            System.out.println("""
                               ===========================================
                               BIENVENIDO A LA APP CLINICA DEV
                               ===========================================

                               Eliga la opcion: 

                               1-. Registrar paciente.
                               2-. Mostrar paciente registrados.
                               3-. Atender paciente.
                               4-. Salir.
                               ********************************************\n
                               """);  

            Scanner sc = new Scanner(System.in);
            op = sc.nextInt(); 
            
            int opR ;
            switch (op) {
                // Creacion de Personas 
                
               
                case 1 -> {System.out.println("""
                                   ===========================================
                                   REGISTRAR PERSONA
                                   ===========================================
                                   Cuantas personas desea registrar: 
                                   1-. 1
                                   2-. 2
                                   3-. 3
                                   4-. 4 
                                   """);  
                    opR = sc.nextInt();
                    
                    for( int i=0; i<opR; i++){
                        
                        System.out.println("\n***** Registro De paciente #%s\n".formatted(i+1));
                        
                        System.out.println("\n>>>Por favor ingrese el nombre completo del paciente.\n ");               
                        String nombre = sc.next();
                        
                        System.out.println("\n>>>Por favor ingrese el documento del paciente.\n");               
                        String documento = sc.next();
                        sc.next();
                        
                        System.out.println("\n>>>Por favor ingrese la edad del paciente.\n");                                      
                        int edad = sc.nextInt();
                        
                        
                        System.out.println("\n>>>Por favor ingrese el motivo de consulta del paciente.\n");                                       
                        String motivoConsulta = sc.next();    
                        
                        System.out.println("\n>>>Por favor ingrese el telefono/s del paciente.\n");               
                        String telefonos = sc.next();
                        
                        switch(i){
                            case 1 -> {p1 = new Paciente(nombre,documento,edad,motivoConsulta,telefonos);
                                        System.out.println("Registro exitoso de" + p1.getNombre());}
                            
                            case 2 -> {p2 = new Paciente(nombre,documento,edad,motivoConsulta,telefonos);
                                        System.out.println("Registro exitoso de" + p2.getNombre());}
                            
                            case 3 -> {p3 = new Paciente(nombre,documento,edad,motivoConsulta,telefonos);
                                       System.out.println("Registro exitoso de" + p3.getNombre());}
                            
                            case 4 -> {p4 = new Paciente(nombre,documento,edad,motivoConsulta,telefonos);
                                       System.out.println("Registro exitoso de" + p4.getNombre());}
                        }
                      
                    }

                   
                }
            }
        } while (op<1 || op >4);
    }
}
