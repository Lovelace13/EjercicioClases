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
        Nodo<E> nuevo = new Nodo<>(element);
        if(element == null)
            return false;
        else if(this.isEmpty())
            this.first = this.last = nuevo;
        else 
        {
            this.first.setPrevious(null);
            this.last.setNext(null);
            this.last.setNext(nuevo);
            nuevo.setPrevious(this.last);
            nuevo.setNext(this.first);
            this.first.setPrevious(nuevo);
            this.last = nuevo;
        }
        efectivo++;
        return true;
    }

    @Override
    public boolean removeFirst() {
                
        if(this.isEmpty())
            return false;
        else if( first == last){
            first.setData(null);
            first = last = null;
        }else{
            Nodo<E> temp = first;
            this.first = this.first.getNext();
            this.first.setPrevious(null);
            temp.setNext(null);
        }
        efectivo--; 
        return true;
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
        if(isEmpty())
            return null;
        return this.first.getData();
    }

    @Override
    public E getLast() {
        if(isEmpty())
            return null;
        return this.last.getData();
    }

    @Override
    public int size() {
        return this.efectivo;
    }

    @Override
    public boolean contains(E element) {
        if(isEmpty())
            return false;
        for(Nodo<E> p = this.first; p != null; p.getNext()){
            if( p.getData().equals(element))
                return true;
        }
        return false;
    }

    /**
     * Divide la lista enlazada desde la posición que se le indique. Esta 
     * posición puede empezar desde cero hasta el size de la lista.
     * @param start
     * @param end
     * @return List
     */
    @Override
    public List<E> slicing(int start, int end) {
        
        List<E> lista;
        lista = new SimpleLinkedList<E>();
               
        if(start >= 0 && end <= this.efectivo){
            int contador = 0;
            for(Nodo<E> p = this.first; p != null; p.getNext()){
                if ( contador == start && contador < end){
                    lista.addLast(p.getData());
                }
            }
            return lista;   
        }       
        
        return null;
    
    }

    /**
     * Invierte el orde de los elementos de la lista doblemente enlazada
     */
    @Override
    public void reverse() {
        Nodo<E> temp;
        Nodo<E> viajero = this.first;
        
        while( viajero != null){
            temp = viajero.getPrevious();
            viajero.setPrevious(viajero.getNext());
            viajero.setNext(temp);
            viajero = viajero.getPrevious();
        }
    }

    @Override
    public boolean set(int index, E element) {
        if(index == 0 && isEmpty()){
            this.first.setData(element);
            return true;
        }else if (index == this.efectivo)
            this.last.setData(element);
        else if(!isEmpty() && index > 0 && index < this.efectivo)
        {
            int indice = 0;
            
            for(Nodo<E> nodo = this.first; nodo != null; nodo = nodo.getNext()){
                if( indice == index){
                    nodo.setData(element);
                    return true;
                }
                indice++;
            }
        }
        return false;   
    }

    @Override
    public boolean insert(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * remueve un elemento de la lista indicado por la ubicación
     * @param index
     * @return boolean
     */
    @Override
    public boolean remove(int index) {
        if( index == 0 && !this.isEmpty()){
            this.removeFirst();
            return true;
        }else if (index == this.efectivo){
            this.removeLast();
            return true;
        }else if(!this.isEmpty() && index > 0 && index < this.efectivo){
            int indice = 0;
            Nodo<E> siguiente, anterior; //Un temporal que va a ser para el nodo anterior del que sera removido y para para el nodo siguiente
            for(Nodo<E> nodo = this.first; nodo != null; nodo = nodo.getNext()){
                if( indice == index){
                    anterior = nodo.getPrevious();
                    siguiente = nodo.getNext();
                    nodo.setData(null);
                    nodo.setNext(null);
                    nodo.setPrevious(null);
                    anterior.setNext(siguiente);
                    this.efectivo--;
                    return true;
                }
                indice++;
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean intercambiarExtremos(){
        Nodo sig;
        Nodo temp, ant;
        
        if(this.isEmpty())
            return false;
        if(this.first == this.last)
            return true;
        else{
            sig = this.first.getNext();
            sig.setPrevious(null);
            this.first.setNext(null);
            
            ant = this.last.getPrevious();
            ant.setNext(null);
            
            this.last.setNext(null);
            this.first.setPrevious(null);
            
            temp = this.last;
            this.last = this.first;
            this.first = temp;
            
            sig.setPrevious(this.first);
            this.first.setNext(sig);
            this.first.setPrevious(this.last);
            
            ant.setNext(this.last);
            this.last.setPrevious(ant);     
            this.last.setNext(this.first);
                     
        }
        return true;        
    }

    @Override
    public String toString() {
        String s = "[";
        int con = 0;
        Nodo<E> p =this.first;
        while(con < efectivo){
            if ( p != this.last)
                s+= p.getData().toString() + ",";
            else
                s+= p.getData().toString();
            p = p.getNext();
            con++;
        }
        s+="]";
        return s;
        
    }

}
