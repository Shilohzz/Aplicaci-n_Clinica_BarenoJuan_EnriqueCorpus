/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionclinica;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;
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
                
                while (op < valorminimo || op > valormaximo) {        
                    System.out.println("\n----Opcion no valida, intente nuveamente.----");       
                    op = parseInt(new Scanner(System. in).nextLine()) ;
                    
                 }
                validar = true;
            } catch (NumberFormatException e) {
                System.out.println("\n----Error, solo se admiten números.----");
            }
        } while (validar == false);
        return op;
        
    }
    
    static void imprimirTelefono(String telefonos, int op){
        for(int i=0; i<op; i++){
        System.out.println("Telefono #" + (i+1) + ": "+ telefonos.split(",")[i].substring(0, telefonos.split(",")[i].length()-1)); 
        }
    }
            
}
