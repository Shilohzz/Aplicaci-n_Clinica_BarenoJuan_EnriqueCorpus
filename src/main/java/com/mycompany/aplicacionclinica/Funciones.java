/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionclinica;

import static java.lang.Integer.parseInt;
import java.util.Scanner;

/**
 *
 * @author kikecorpus
 */
public class Funciones {
    
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
    
    static void mostrarPaciente(Paciente paciente, int opC, int opTel) {
       //logica de mostrar solo registrado 
                                if((paciente != null) && (paciente.getEstado().equals("registrado"))) {                     
                                System.out.println("\n******* Paciente #" + opC+" *******");        
                                System.out.println("Nombre: " + paciente.getNombre());
                                System.out.println("Documento: " + paciente.getDocumento());
                                System.out.println("Edad: " + paciente.getEdad());
                                System.out.println("Motivo Consulta: " + paciente.getMotivoConsulta());                            
                                Funciones.imprimirTelefono(paciente.telefonos.toString(), opTel);  // funcion para imprimir telefonos en diferentes lineas con split
                                System.out.println("Tipo Paciente: " + paciente.getTipoPaciente());
                                System.out.println("Estado: " + paciente.getEstado());}
                                else if(paciente== null){
                                                            System.out.println("""
                                                                               ******* Paciente #%s *******
                                                                               El cupo del paciente " + opC +" no se encuentra registrado 
                                                                               """.formatted(opC));}
                                else {
                                      System.out.println("""
                                                         ******* Paciente #%s *******
                                                         El paciente ya fue atendido
                                                         """.formatted(opC));
                                }
 
    }
    
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
    
    static int cuposDisponibles(Paciente paciente,int cuposDisponibles){ 
        if (paciente != null){
            cuposDisponibles -=1;
        } else {cuposDisponibles +=1;
        }
        return cuposDisponibles;
    }
    
    static Paciente registrarPaciente(Paciente paciente, String nombre, String documento, int edad, String motivoConsulta, StringBuilder telefonos){
        paciente = new Paciente(nombre,documento,edad,motivoConsulta,telefonos.toString());
        System.out.println("\n****** Registro exitoso de " + paciente.getNombre() + " ******");  
        return paciente; 
    }
    
    static Paciente atenderPaciente(Paciente paciente, int opA){
    
        System.out.println("\n****Paciente #%s atendido correctamente*****".formatted(opA));
        paciente.setEstado("Atendido");
        return paciente;
    }
}
