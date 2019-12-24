/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodos;


/**
 *
 * @author CltControl
 */
public class NodoArbol <E> {
    private E data;
    private NodoArbol<E> left;
    private NodoArbol<E> right;

    public NodoArbol(E data){
        this.data = data;
        left = right = null;
    }
    
    public E getData() {
        return data;
    }
    
    public void setData(E data) {
        this.data = data;
    }
    
    public NodoArbol<E> getLeft() {
        return this.left;
    }
    
    public NodoArbol<E> getRight() {
        return this.right;
    }

    public void setLeft(NodoArbol<E> left) {
        this.left = left;
    }

    public void setRight(NodoArbol<E> right) {
        this.right = right;
    }
}
