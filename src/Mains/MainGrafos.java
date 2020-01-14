/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mains;
import Grafos.GraphLA;
import Grafos.GraphMA;


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
        
        //GRAPHMA
        System.out.println("\nGRAFO MA");
        GraphMA<Integer> grafoMA = new GraphMA<>(true);
        grafoMA.addVertex(1);
        grafoMA.addVertex(2);
        grafoMA.addVertex(3);
        grafoMA.addVertex(4);
        grafoMA.addVertex(5);
        grafoMA.addEdge(2,1,6);
        grafoMA.addEdge(5,1,6);
        grafoMA.addEdge(2,4,6);
        grafoMA.addEdge(4,2,6);
        grafoMA.addEdge(2,3,6);
        grafoMA.addEdge(4,6,2);
        grafoMA.addEdge(3,1,1);
        grafoMA.addEdge(10,5,3);
        grafoMA.toString();
    }
    
}
