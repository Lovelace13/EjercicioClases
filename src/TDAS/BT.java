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
   
    /**
     * Función auxiliar de "add"
     * Devuelve el nodo buscado
     * @param data
     * @return NodoArbol
     */
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
    
    //Contador de Nodos
    
    public int contarHojas(){
        return contarHojas(root);
    }
    private int contarHojas(NodoArbol<E> n){
        if(n == null)
            return 0;
        else if( n.getLeft()== null&& n.getRight() == null)
            return 1;
        else
            return contarHojas(n.getLeft())+ contarHojas(n.getRight());
    }
    
    public boolean eslleno(){
        if(isEmpty()) 
            return true;
        
        return eslleno(this.root);
    }
    
    private boolean eslleno(NodoArbol<E> n){
        if( n == null)
            return true;
        else if((n.getLeft() == null && n.getRight() != null)||(n.getLeft() != null && n.getRight() == null)){
            return false;
        }
        
        return eslleno(n.getLeft()) && eslleno(n.getRight()) && ( alturaArbol(n.getLeft()) == alturaArbol(n.getRight()) );
    }
    
    public void posOrden(){
        posOrden(root);
    }
    private void posOrden(NodoArbol<E> n){
        if(n!=null){
            posOrden(n.getLeft());
            posOrden(n.getRight());
            System.out.println(n.getData());
        }
    }
     
    //preOrden--------
    public void preOrden(){
        preOrden(this.root);
    }
    
    private void preOrden(NodoArbol<E> nodo){
        
        if(nodo != null){
            System.out.print(nodo.getData() + ", ");
            preOrden(nodo.getLeft());
            preOrden(nodo.getRight());
        }
    }
    
    //enOrden-------
    
    public void enOrden(){
        enOrden(this.root);
    }
    
    private void enOrden(NodoArbol<E> nodo){
        
        if( nodo != null ){
            enOrden(nodo.getLeft());
            System.out.print(nodo.getData() + ", ");
            enOrden(nodo.getRight());
        }
    }

}
