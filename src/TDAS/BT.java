/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAS;

import Nodos.NodoArbol;

/**
 *
 * @author ktiusk
 */
public class BT <E>{
    private NodoArbol<E> root;
    
    public BT(){
        this.root = null;
    }
    
    /**
     * Si el árbol está vacío devuelve el valor de verdad
     * @return boolean
     */
    public boolean isEmpty(){
        return this.root == null;
    }
    
    /**
     * Agrega un nuevo elemento al árbol. Ubica este elemento de acuerdo al parent
     * Si el parent es null, el elemento es el root del árbol
     * @param child
     * @param parent
     * @return boolean
     */
    public boolean add(E child, E parent){
        
        NodoArbol<E> nodo = new NodoArbol<>(child);
        
        if( child != null)
            return false;
        else if ( parent == null && isEmpty()){
            this.root = nodo;
            return true;
        }
        return false;
    }
    
    private NodoArbol<E> find(E data){
        return new NodoArbol<>(data);
    }
}
