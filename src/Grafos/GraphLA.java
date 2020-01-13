/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos;

import java.util.LinkedList;
import java.util.List;

/**
 * Clase grafo no es multi-edge
 * @author CltControl
 */
public class GraphLA<E> {
    /**
     * Lista de adyacencia de vertices del grafo
     */
    private List<Vertex<E>> vertexes; 
    private boolean directed;
    
    public GraphLA(boolean directed){
        this.vertexes = new LinkedList<>();
        this.directed = directed;
    }
    
    /**
     * Agrega un vertice a la lista de adyacencia
     * @param data
     * @return boolean
     */
    public boolean addVertex(E data){
        if ( data == null) 
            return false;
        
        Vertex<E> V = new Vertex<>(data);
        if(this.vertexes.contains(V))
            return false;
       
        return vertexes.add(V); //Se puede simplicar con ternaria
    }
    
    /**
     * Agrega un arco entre un vertice y otro con data 'origen', 'destino' y 'peso'
     * @param origen
     * @param destino
     * @param peso
     * @return 
     */
    public boolean addEdge(E origen, E destino, int peso){
        if( origen == null || destino == null) return false;
        
        Vertex<E> verOrigen = this.buscarVertice(origen);
        Vertex<E> verDestino = this.buscarVertice(destino);
        if( verOrigen == null || verDestino == null) return false;
        
        Edge<E> arco = new Edge<>(verOrigen, verDestino, peso);    
        if( verOrigen.getEdges().contains(arco)) return false;
        verOrigen.getEdges().add(arco);
        
        if(!directed){
            arco = new Edge<>(verDestino, verOrigen, peso);
            verDestino.getEdges().add(arco);
        }
        
        return true;
    }
    
    /**
     * Retorna 'Vertex' si existe un vértice del grafo 
     * @param data
     * @return Vertex
     */
    private Vertex<E> buscarVertice(E data){
        for(Vertex<E> v : this.vertexes){
            if(v.getData().equals(data))
                return v;
        }
        return null;
    }
    
    //TALLER
    
    /**
     * Número de Arcos que apuntan o llegan a este vertices.
     * Retorna -1 si el parametro data es null
     * Retorna 0 si no tiene arcos que lleguen a este vertice o el vertice no existe
     * Retorna un entero mayor a cero si existe más de un arco
     * @param data
     * @return int
     */
    public int indegree(E data){//Numero de arcos que entran
        if(data==null) return -1; //Valida que la data ingresada sea valida
        
        Vertex<E> vertice = this.buscarVertice(data); //Valida que exista un vertice con esa data
        if(vertice==null) return 0;
        
        int contVertices = 0;
        for(Vertex<E> v: this.vertexes){
            for(Edge<E> e: v.getEdges()){
                if(e.getDestino().getData().equals(data)){
                    contVertices++;
                }
            }
        }
        return contVertices;

    }
    
    /**
     * Número de Arcos que apuntan o llegan a este vertices.
     * Retorna -1 si el parametro data es null
     * Retorna 0 si no tiene arcos que lleguen a este vertice
     * Retorna un entero mayor a cero si existe más de un arco
     * @param data
     * @return int
     */
    public int outdegree(E data){//Numero de arcos que salen
        if(data==null) return -1;
        
        Vertex<E> vertice = this.buscarVertice(data);
        if(vertice==null) return 0;
        
        int contVertices = 0;
        for(Edge<E> e : vertice.getEdges()){
            if(e.getOrigen().equals(data))
                contVertices++;
        }
        return contVertices;
    }
    
    /**
     * Remueve un arco según el vertice de origen y destino
     * @param origen
     * @param destino
     * @return boolean
     */
    public boolean removeEdge(E origen, E destino){
        if(origen==null || destino==null) return false;
        
        Vertex<E> verOrigen = buscarVertice(origen);
        Vertex<E> verDestino = buscarVertice(destino);
        if(verOrigen==null || verDestino ==null) return false;
        
        return verOrigen.getEdges().remove(verDestino);     
    }
    
    /**
     * Remueve el vertice que contenga la data
     * @param data
     * @return 
     */
    public boolean removeVertex(E data){
        if(data==null || buscarVertice(data)==null) return false;
        
        Vertex<E> vertex = buscarVertice(data);
        LinkedList<Edge<E>> arcos = (LinkedList<Edge<E>>) vertex.getEdges();
        while(!arcos.isEmpty()){
            arcos.remove();
        }
        return true;
    }
    
    /**
     * Devuelve una impresión por consola del grafo
     * @return String
     */
    public String toString(){
        StringBuilder salida = new StringBuilder();
        salida.append("vertices ={");
        for(Vertex<E> v: this.vertexes){
            salida.append(v.getData().toString());
            salida.append(",");
        }
        salida.append("}\naracos = {");
        for(Vertex<E> v: this.vertexes){
            for(Edge<E> edge:v.getEdges()){
                salida.append("(");
                salida.append(edge.getOrigen().getData().toString());
                salida.append(",");
                salida.append(edge.getDestino().getData().toString());
                salida.append(",");
                salida.append(edge.getPeso());
                salida.append("),");
            }
        }
        salida.append("}");
        
        return salida.toString();
    }
    
}
