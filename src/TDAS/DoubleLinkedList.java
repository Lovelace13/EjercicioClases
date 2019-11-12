/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAS;

import Interfaces.List;
import Nodos.Nodo;
/**
 *
 * @author ktiusk
 */
public class DoubleLinkedList<E> implements List<E> {
    private Nodo<E> first;
    private Nodo<E> last;
    private int efectivo;
    
    /**
     * Retorna verdadero si la lista esta vacía
     * @return
     */
    @Override
    public boolean isEmpty(){
        return first==null && last==null;
    }
    
    public boolean addFirst(E element){
        Nodo<E> nodo = new Nodo<> (element);
        if(element == null)
            return false;
        else if(this.isEmpty())
            this.first = this.last = nodo;
        else{
            Nodo<E> temp = this.first;
            nodo.setNext(this.first);
            this.first.setPrevious(temp);
            this.first = nodo;
        }  
        efectivo++;
        return true;
    }


    @Override
    public boolean addLast(E element) {
        if(this.isEmpty())
            return false;
        else if( this.first == this.last){
            this.first.setData(null);
            this.first = this.last.getNext();
        }else{
            this.last.setData(null);
            this.last = this.last.getPrevious();
            Nodo<E> temp = this.last.getNext();
            temp.setPrevious(null);
            last.setNext(null);
        }
        efectivo++;
        return true;
    }

    @Override
    public boolean removeFirst() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeLast() {
        
        if(this.isEmpty())
            return false;
        else if(this.first == this.last){
            this.first.setData(null);
            this.first = this.last = null;
        }else{
            this.last.setData(null);
            this.last = this.last.getPrevious();
            
            Nodo<E> temp = this.last.getNext();
            temp.setPrevious(null);
            last.setNext(null);
            
        }
        efectivo++;
        return true;
    }

    @Override
    public E getFirst() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E getLast() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<E> slicing(int start, int end) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reverse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
