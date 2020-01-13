/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mains;
import Grafos.GraphLA;


/**
 *
 * @author CltControl
 */
public class MainGrafos {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GraphLA<Integer> grafo = new GraphLA<>(true);
        grafo.addVertex(5);
        grafo.addVertex(7);
        grafo.addVertex(9);
        
        grafo.addEdge(5, 7, 1);
        grafo.addEdge(5, 9, 5);
        grafo.addEdge(7, 9, 2);
        
        System.out.println(grafo.toString());
    }
    
}
