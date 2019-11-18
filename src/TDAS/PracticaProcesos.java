/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAS;

import Objetos.Proceso;
//import static Objetos.Proceso.readFromFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author CltControl
 */
public class PracticaProcesos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Proceso procesos = new Proceso();
        LinkedList lista = new LinkedList<>();

        lista = (LinkedList) procesos.readFromFile("procesos.txt");
       
        System.out.println(lista);
    }
}
