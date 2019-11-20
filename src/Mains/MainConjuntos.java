/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mains;
import TDAS.ListSet;
import java.util.Comparator;
/**
 *
 * @author ktiusk
 */
public class MainConjuntos {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /**
         * Comparador de enteros.
         */
        Comparator<Integer> Enteros = new Comparator<Integer>(){
            @Override
            public int compare(Integer t1, Integer t2) {
                return Integer.compare(t1, t2);
            }           
        };
        
        /**
         * Conjunto de numeros pares menores que 10
         */
        ListSet<Integer> ConjuntoNumPares = new ListSet<Integer>(Enteros);
        
        ListSet<Integer> ConjuntoNumeros = new ListSet<Integer>(Enteros);
        ListSet<Integer> ConjuntoIntersecion;
        ListSet<Integer> DiferenciaConjunto;
        ListSet<Integer> ConjuntoUnion;
                
        ConjuntoNumPares.add(2);
        ConjuntoNumPares.add(8);
        ConjuntoNumPares.add(4);
        ConjuntoNumPares.add(6);
        
        System.out.print("Conjunto NumerosPares: ");
        System.out.println(ConjuntoNumPares.toString());

        ConjuntoNumPares.remove(2);
        System.out.print("Conjunto NumerosPares sin el elemento '2': ");
        System.out.println(ConjuntoNumPares.toString());
             
        ConjuntoNumeros.add(1);
        ConjuntoNumeros.add(3);
        ConjuntoNumeros.add(4);
        ConjuntoNumeros.add(8);
        
        ListSet<Integer> ConjuntoEspejo = ConjuntoNumeros;
        
        System.out.print("Conjunto Numeros: ");
        System.out.println(ConjuntoNumeros.toString());
        
        ConjuntoIntersecion = ConjuntoNumPares.interseccion(ConjuntoNumeros);
        System.out.print("Interseccion entre Conjunto Numeros y NumerosPares: ");
        System.out.println(ConjuntoIntersecion.toString());
        
        DiferenciaConjunto = ConjuntoNumeros.diferencia(ConjuntoNumPares);
        System.out.print("Diferencia entre Conjunto Numeros y NumerosPares: ");
        System.out.println(DiferenciaConjunto.toString());
        
        ConjuntoUnion = ConjuntoNumeros.union(ConjuntoNumPares);
        System.out.print("Union entre Conjunto Numeros y NumerosPares: ");
        System.out.println(ConjuntoUnion.toString());
        
        ConjuntoNumPares.add(2);
        
        System.out.print("Compara dos conjuntos: ");
        System.out.println(ConjuntoNumeros.equals(ConjuntoEspejo));
        System.out.println(ConjuntoNumeros.equals(ConjuntoUnion));
        System.out.println(ConjuntoIntersecion.equals(DiferenciaConjunto));
    }
}
