/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Scanner;

/**
 *
 * @author Jairo F
 */
public class Entrada {
    
    private static Scanner entrada = new Scanner(System.in);
   
    
    public static String leerString(String label){
        System.out.print(label);
        return entrada.next();
    }
    
    public static double leerDouble(String label){
        System.out.print(label);
        return entrada.nextDouble();
    }
    
    public static char leerChar(String label){
        System.out.print(label);
        return entrada.next().charAt(0);
    }
    
    public static int leerInt(String label){
        System.out.print(label);
        return entrada.nextInt();
    }
}
