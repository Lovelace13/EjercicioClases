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
        else if(parent != null){
            if(searchNodo(child) == null){
                NodoArbol<E> nodoPadre = searchNodo(parent);
                if (nodoPadre == null || (nodoPadre.getLeft() != null && nodoPadre.getRight() != null))
                    return false;
                else if(nodoPadre.getLeft() == null)
                    nodoPadre.setLeft(nodo);
                else
                    nodoPadre.setRight(nodo);
            }
            return true;
        }
        return false;
    }
    
    public int alturaArbol()
    {
        return alturaArbol(this.root);
    }
    
    public int alturaArbol(NodoArbol<E> raiz){
        if( raiz == null)
            return 0;
        else
            return 1 + Math.max(alturaArbol(raiz.getLeft()), alturaArbol(raiz.getRight()));
    }
    
    private NodoArbol<E> searchNodo(E data){
        return searchNodo(data, root);
    }
    
    private NodoArbol<E> searchNodo(E data, NodoArbol<E> raiz){
        
        if(raiz == null)
            return raiz;
        else if(raiz.getData().equals(data))
            return raiz;
        else{
            NodoArbol<E> l = searchNodo(data, raiz.getLeft());
//            NodoArbol<E> r = searchNodo(data, raiz.getRight());
//            
//            if( l != null)
//                return l;
//            return r;
            return (l != null) ? l: searchNodo(data, raiz.getRight());
        }   
    }
}
