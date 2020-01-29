/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos;

import java.util.ArrayList;

/**
 *
 * @author Katiuska
 * @param <E>
 */
public class GraphMA<E> {
    private ArrayList<E> vertexes;
    private int [][] matriz;
    private boolean directed;
    
    public GraphMA(boolean directed){
        this.directed = directed;
        this.vertexes = new ArrayList<>();
        this.matriz = new int[10][10];
    }
    
    public boolean isEmpty(){
        return vertexes.isEmpty();
    }
    
    public boolean addVertex(E data){
        if(data == null || this.vertexes.contains(data))
            return false;
        
        return this.vertexes.add(data);
    }
    
    public boolean addEdge(E origen, E destino, int peso){
        if(origen==null||destino==null) 
            return false;
        
        int indOrigen = this.vertexes.indexOf(origen);
        int indDestino = this.vertexes.indexOf(destino);
        
        if(indOrigen <0 ||indDestino <0) 
            return false;
        
        this.matriz[indOrigen][indDestino] = peso;
        if(!directed){
            this.matriz[indDestino][indOrigen]=peso;
        }
        return true;
    }
    
    public boolean removeEdge(E origen, E destino){
        if(origen==null || destino==null) 
            return false;
        
        int indOrigen = this.vertexes.indexOf(origen);
        int indDestino = this.vertexes.indexOf(destino);
        
        if(indOrigen<0 || indDestino<0 || this.matriz[indOrigen][indDestino] == 0) 
            return false;
        
        this.matriz[indOrigen][indDestino] = 0;
        if(!directed){
            this.matriz[indDestino][indOrigen]=0;
        }
        return true;
    }   
    
    public boolean removeVertex(E data){
        int indVertice = vertexes.indexOf(data);
        if(indVertice < 0) 
            return false;
        
        for(int i = indVertice; i < this.vertexes.size(); i++)
            this.matriz[i] = this.matriz[i+1];
        
        for(int j = indVertice; j < this.vertexes.size(); j++)
        for(int i = 0; i < this.vertexes.size(); i++)
            this.matriz[i][j] = this.matriz[i][j+1];
            vertexes.remove(indVertice);
            
        return true;
    }    
 
    public int inDegree(E data){
        int cont=0;       
        int indiceData=vertexes.indexOf(data);
        for(int i=0;i<vertexes.size();i++){
//            System.out.println(vertexes.indexOf(data));
           if( indiceData>-1 && (matriz[i][indiceData]!=0)){              
               cont+=1;
            }
        }
        return cont;
    }
    
    public GraphMA<E> reverse(){
        if(!this.directed || this.isEmpty()){
            return null;
        }
        GraphMA<E> grafo= new GraphMA<>(true);
        for(E data: this.vertexes) {
            grafo.addVertex(data);
        }        
        
        
        for(int fil=0; fil < 10; fil++){
            for(int col=0;col<10;col++){
                
                grafo.matriz[fil][col]= this.matriz[col][fil];
            }
        }
        return grafo;
    }

    public int outDegree(E data){       
        if(!directed)
            return inDegree(data);
        
        int cont=0;
        int indiceData = vertexes.indexOf(data);        
        for(int j=0;j<vertexes.size();j++){
           if(indiceData>-1 && (matriz[indiceData][j]!=0)){
               cont+=1;
            }
        }
        return cont;
    }
    
    @Override
    public String toString(){
        if(isEmpty()){
            return(" V = { } , E = { }");
        }
        StringBuilder vertice=new StringBuilder ();
        vertice.append("V{");
        for(int i=0; i<vertexes.size();i++){            
            vertice.append(vertexes.get(i));
            if(i<vertexes.size()-1){
                vertice.append(",");
            }
        }
        vertice.substring(0,vertice.length()-1);
        vertice.append("}");
        int h=vertexes.size();
        StringBuilder tupla=  new StringBuilder();
        tupla.append("; E{");
        for(int i = 0;i<h;i++){
            for(int j= 0; j<h;j++){
                if(matriz[i][j] != 0 ){
                    tupla.append("(" + vertexes.get(i) + ", "+ vertexes.get(j)+")"+",");                
                }
            }       
        }
        tupla.substring(0,tupla.length()-1);
        tupla.append("}");
        return vertice.toString() + tupla.toString();
    }        

}
