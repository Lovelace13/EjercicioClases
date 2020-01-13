/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author CltControl
 */
public class Vertex<E> {
    private E data;
    private List<Edge<E>> edges;
    
    public Vertex(E data){
        this.data = data;
        this.edges = new LinkedList<>();
    }

    public void setData(E data) {
        this.data = data;
    }

    public void setEdges(List<Edge<E>> edges) {
        this.edges = edges;
    }
    
    public E getData() {
        return data;
    }

    public List<Edge<E>> getEdges() {
        return edges;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vertex<?> other = (Vertex<?>) obj;
        return Objects.equals(this.data, other.data);
    }

    @Override
    public String toString() {
        return "Vertex{" + "data=" + data + ", edges=" + edges + '}';
    }
    
    
}
