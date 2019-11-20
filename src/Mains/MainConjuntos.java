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
         * Conjunto de numeros pares menores que 10
         */
        ListSet<Integer> ConjuntoNumPares = new ListSet<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer t1, Integer t2) {
                return Integer.compare(t1, t2);
            }
            
        });
        
        ConjuntoNumPares.add(2);
        ConjuntoNumPares.add(8);
        ConjuntoNumPares.add(4);
        
        System.out.println(ConjuntoNumPares.toString());
        
    }
}
