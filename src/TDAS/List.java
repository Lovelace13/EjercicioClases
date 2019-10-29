/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAS;

/**
 *
 * @author CltControl
 * @param <E>
 */

public interface List <E> {
    boolean addFirst(E element);
    boolean addLast(E element);
    boolean removeFirst();
    boolean removeLast();
    boolean isEmpty();
//    E getFirst();
//    E getLast();
    int size();
    boolean contains(E element);
//    boolean set(int index, E element);
//    E get(int index);
    List<E> slicing(int start, int end);
    void reverse();
    boolean set(int index, E element);
    boolean insert(int index, E element); //Agrega el element en index desplazando los elementos que se encuentran a la derecha de index
    boolean remove(int index); //Remueve el elemento de index y compacta el arreglo
}
