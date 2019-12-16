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
}
