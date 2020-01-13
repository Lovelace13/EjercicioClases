/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos;

/**
 *
 * @author CltControl
 */
public class Edge<E> {
    private Vertex<E> origen;
    private Vertex<E> destino;
    private int peso;
    
    /**
     * Se inicializa primero con el origen luego destino y finalmente peso
     * @param origen
     * @param destino
     * @param peso 
     */
    public Edge(Vertex<E> origen, Vertex<E> destino, int peso){
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }

    public Vertex<E> getOrigen() {
        return origen;
    }

    public Vertex<E> getDestino() {
        return destino;
    }

    public int getPeso() {
        return peso;
    }

    public void setOrigen(Vertex<E> origen) {
        this.origen = origen;
    }

    public void setDestino(Vertex<E> destino) {
        this.destino = destino;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
}

