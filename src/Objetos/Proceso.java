/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import Interfaces.List;
import TDAS.SimpleLinkedList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author CltControl
 */
public class Proceso {
    private String nombre;
    private int requiere;
    private int restante;
    private int ordenLlegada;
    private int terminado;
    
    public Proceso(){
        this.nombre = null;
        this.requiere = 0;
        this.restante = 0;
        this.ordenLlegada = 0;
        this.terminado = 0;
    }
    
    public static List<Proceso> readFromFile(String archivo){
        
        File file = new File(archivo);
        
        SimpleLinkedList<Proceso> ListaProcesos = new SimpleLinkedList<Proceso>();
        
        try {

            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                int i = 0;
                
                while ( i < linea.length()){
                    Proceso process = new Proceso();
                    String[] parts = linea.split("|");
                    process.ordenLlegada = Integer.parseInt(parts[0]); // 
                    process.nombre = parts[1]; // 654321
                    process.requiere = Integer.parseInt(parts[2]);
                    process.terminado = Integer.parseInt(parts[3]);
                    process.restante = process.requiere - process.terminado;
                    ListaProcesos.addLast(process);
                    i++;
                }               
                
                
            }
            sc.close();
            
            
            
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return ListaProcesos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getRequiere() {
        return requiere;
    }

    public int getRestante() {
        return restante;
    }

    public int getOrdenLlegada() {
        return ordenLlegada;
    }

    public int getTerminado() {
        return terminado;
    }
}
