/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mains;

import Objetos.Estudiante;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/**
 *
 * @author ktiusk
 */
public class MainHash {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Set<Estudiante> est1 = new HashSet<>();
        Set<Estudiante> est2 = new HashSet<>();
        
        Estudiante student1 = new Estudiante("jimenez", 19);
        Estudiante student2 = new Estudiante("Garcia", 20);
        Estudiante student3 = new Estudiante("Ortega", 15);
        Estudiante student4 = new Estudiante("Ramírez", 15);
        
        est1.add(student1); //jimenez
        est1.add(student2); //Garcoa
        est1.add(student4); //Ramirez
        System.out.println(est1);
        
        //Union
        est2.add(student3); //Ortega
        System.out.println(est2);
        est2.addAll(est1); // Ramirez, jimenez, garcia, Ortega      
        System.out.println(est2);
        est1.remove(student1); //Garcia ramirez
        
        //Interseccion
        est2.retainAll(est1); // Ramirez garcia
        System.out.println(est2);
        
        Iterator<Estudiante> it = est1.iterator();
        while(it.hasNext()){
            Estudiante e = it.next();
            System.out.println(e);
        }
        
        Map<String, Estudiante> mapa = new HashMap<>();
        mapa.put("2012", student1);
        mapa.put("2013", student2);
        mapa.put("2012", student3);
        mapa.put("2010", student4);
        
        System.out.println("\nHashMap");
        System.out.println(mapa.get("2010"));
        
        System.out.println("\niterador con while");
        Iterator<String> itMap = mapa.keySet().iterator();
        while(itMap.hasNext()){
            String matricula = itMap.next();
            Estudiante student = mapa.get(matricula);
            System.out.println(matricula+ ": " + student.getNombre());
        }
        
        System.out.println("\nUso de For");
        for(String matricula: mapa.keySet()){
            Estudiante student = mapa.get(matricula);
            System.out.println(matricula+ ": " + student.getNombre());
        }
    }
}
