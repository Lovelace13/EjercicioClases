/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAS;

/**
 *
 * @author CltControl
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> nombres = new ArrayList<String>();
        ArrayList<String> NuevosNombres = new ArrayList<String>();
        
        nombres.addLast("Juan");
        nombres.addLast("María");
        nombres.addLast("Jorge");
        nombres.addLast("Carmen");
        nombres.addLast("Guido");
        nombres.addLast("Hugo");
        nombres.addLast("Fabricio");
        
        System.out.println(nombres);
        NuevosNombres = (ArrayList) nombres.slicing(2,5);
        System.out.println(NuevosNombres);
        nombres.reverse();
        System.out.println(nombres);
        nombres.set(4, "Ericka");
        System.out.println(nombres);
        nombres.insert(4, "Joyce");
        nombres.insert(1, "Katiuska");
        System.out.println(nombres);
        nombres.remove(9);
        System.out.println(nombres);
    }
    
}
