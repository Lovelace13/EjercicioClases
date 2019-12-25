/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mains;

import TDAS.SBT;

/**
 *
 * @author CltControl
 */
public class MainArbol {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SBT<Integer> arbol2 = new SBT<>((Integer n1, Integer n2) -> n1 = n2);
        arbol2.add(25);
        arbol2.add(18);
        arbol2.add(6);
        arbol2.add(20);
        arbol2.add(50);
        arbol2.add(28);
        arbol2.add(100);
        
         arbol2.preOrden();
         arbol2.posOrden();
         arbol2.enOrden();
    }
}
