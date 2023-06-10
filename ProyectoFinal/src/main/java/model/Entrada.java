package model;

import java.util.Scanner;

/**
 *
 * @author Jorman Noriega, Julio Rios, Andres Contreras, Sergio Arango
 */
public class Entrada {

    //ATRIBUTOS
    private static Scanner entrada = new Scanner(System.in);

    //METODO LEER STRING
    public static String leerString(String label) {
        System.out.print(label);
        return entrada.next();
    }

    //METODO LEER DOUBLE
    public static double leerDouble(String label) {
        System.out.print(label);
        return entrada.nextDouble();
    }

    //METODO LEER CHAR
    public static char leerChar(String label) {
        System.out.print(label);
        return entrada.next().charAt(0);
    }

    //METODO LEER ENTERO
    public static int leerInt(String label) {
        System.out.print(label);
        return entrada.nextInt();
    }
}
