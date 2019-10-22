/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

import java.io.File;
import java.util.Arrays;

/**
 *
 * @author ktiusk
 */
public class Operaciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] arreglo = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
        
        System.out.println(factorial(5));
        dibujarRegla(2, 2);
        System.out.println(busquedaBinaria(arreglo, 14, 1, 18));
        //"G:/NetbeansProjects/Operaciones/
        System.out.println(diskUsage(new File("Tarea1.pdf")));
        System.out.println(linearSum(arreglo, 10));
        reverseArray(arreglo, 0, 17);
        System.out.println(Arrays.toString(arreglo));
        System.out.println(power(2,2));
        System.out.println(potencia(2,2));
        System.out.println(sumaBinaria(arreglo, 1, 10));       
    }
    
    //Función Factorial
    public static int factorial(int n) throws IllegalArgumentException {
        if(n < 0)
            throw new IllegalArgumentException();
        else if ( n == 0)
            return 1;
        else 
            return n*factorial(n-1);
    }
    
    public static void dibujarRegla(int nInches, int majorLength) { 
        dibujarLinea(majorLength, 0); // draw inch 0 line and label
        
        for (int j = 1; j <= nInches; j++) {
            dibujarIntervalo(majorLength - 1); // draw interior ticks for inch
            dibujarLinea(majorLength, j); // draw inch j line and label
        }
    } 
    
    private static void dibujarIntervalo(int centralLength) { 
        if (centralLength >= 1) { // otherwise, do nothing
            dibujarIntervalo(centralLength - 1); // recursively draw top interval
            dibujarLinea(centralLength); // draw center tick line (without label)
            dibujarIntervalo(centralLength - 1); // recursively draw bottom interval
        } 
    } 
    
    private static void dibujarLinea(int tickLength, int tickLabel) {
        for (int j = 0; j < tickLength; j++)
            System.out.print("-");
        
        if (tickLabel >= 0)
            System.out.print(" " + tickLabel);

        System.out.print("\n");
    } 
    
    /** Draws a line with the given tick length (but no label). */
    private static void dibujarLinea(int tickLength) { 
        dibujarLinea(tickLength, -1);
    }
    /**
     * Función que busca un numero en un arreglo de numeros
     * @param arreglo
     * @param target
     * @param minimo
     * @param maximo
     * @return boolean
     */
    public static boolean busquedaBinaria(int[ ] arreglo, int target, int minimo, int maximo) { 
        if (minimo > maximo)
            return false; // interval empty; no match
        else { 
            int mitad = (minimo + maximo) / 2;
            if (target == arreglo[mitad])
                return true; // found a match
            else if (target < arreglo[mitad])
                return busquedaBinaria(arreglo, target, minimo, mitad - 1); // recur left of the middle
            else
                return busquedaBinaria(arreglo, target, mitad + 1, maximo); // recur right of the middle
        }   
    }
    //"G:/NetbeansProjects/Operaciones/
    public static long diskUsage(File root) { 
        long total = root.length( ); // start with direct disk usage
        if (root.isDirectory()) { // and if this is a directory,
            for (String childname : root.list( )) { // then for each child
                File child = new File(root, childname); // compose full path to child
                total += diskUsage(child); // add child’s usage to total
            }
        } 
        System.out.println(total + "\t" + root); // descriptive output
        return total; // return the grand total
    }
    
    public static int linearSum(int[ ] arreglo, int n) { 
        if (n == 0)
            return 0;
        else
            return linearSum(arreglo, n-1) + arreglo[n-1];
    }
    
    public static void reverseArray(int[ ] arreglo, int minimo, int maximo) { 
        if (minimo < maximo) { // if at least two elements in subarray
            int temp = arreglo[minimo]; // swap data[low] and data[high]
            arreglo[minimo] = arreglo[maximo];
            arreglo[maximo] = temp;
            reverseArray(arreglo, minimo + 1, maximo - 1); // recur on the rest
        }
    }
    
    public static double power(double x, int n) { 
        if (n == 0)
            return 1;
        else
            return x * power(x, n-1);
    }
    
    public static double potencia(double x, int n) { 
        if (n == 0)
            return 1;
        else { 
            double partial = potencia(x, n/2); // rely on truncated division of n
            double result = partial * partial;
            if (n % 2 == 1) // if n odd, include extra factor of x
                result *= x;
            return result;
        } 
    }
    
    public static int sumaBinaria(int[ ] arreglo, int minimo, int maximo) { 
        if (minimo > maximo) // zero elements in subarray
            return 0;
        else if (minimo == maximo) // one element in subarray
            return arreglo[minimo];
        else {
            int mitad = (minimo + maximo) / 2;
            return sumaBinaria(arreglo, minimo, mitad) + sumaBinaria(arreglo, mitad+1, maximo);
        } 
    }
    
    
}
