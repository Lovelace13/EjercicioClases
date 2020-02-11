/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAS;

import Interfaces.List;
import Nodos.Nodo;
import java.util.Comparator;
import java.util.Queue;
/**
 *
 * @author ktiusk
 */
public class DoubleLinkedList<E> implements List<E> {
    private Nodo<E> first;
    private Nodo<E> last;
    private int efectivo;
    private Comparator<E> f;

    public DoubleLinkedList(Comparator<E> f) {
        this.f = f;
    }

    public DoubleLinkedList() {
//        this.efectivo = 0;
    }
    
    
    @Override
    public boolean isEmpty(){
        return first==null && last==null;
    }
    
    @Override
    public boolean addFirst(E element){
        Nodo<E> nodo = new Nodo<> (element);
        if(element == null)
            return false;
        else if(this.isEmpty())
            this.first = this.last = nodo;
        else{
            nodo.setNext(this.first);
            this.first.setPrevious(nodo);
            this.first = nodo;
        }  
        efectivo++;
        return true;
    }

    @Override
    public boolean addLast(E element) {
        Nodo<E> nuevo = new Nodo<>(element);
        Nodo<E> temp = this.last;
        if(element == null)
            return false;
        else if(this.isEmpty())
            this.first = this.last = nuevo;
        else 
        {
            nuevo.setPrevious(this.last);
            this.last.setNext(nuevo);
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
    
    //f.compare(e1,e2) retorna >0 si e1 es mayor que e2, <0 si e1 es menor que e2
    public boolean sortedInsert(E element){
        Nodo<E> nuevo = new Nodo<>(element);
        
        if(f.compare(this.first.getData(), element) > 0)
        {
            this.first.setPrevious(nuevo);
            nuevo.setNext(this.first);
            this.first = nuevo;
            return true;
        }
        else if(f.compare(this.last.getData(), element) < 0){
            this.last.setNext(nuevo);
            nuevo.setPrevious(this.last);
            this.last = nuevo;
            return true;
        }
        else{
            for(Nodo<E> p = this.first; p != null; p = p.getNext()){
                if(p.getData() == element){
                    return true;
                }
                else if(f.compare(p.getData(), element) < 0 && f.compare(p.getNext().getData(), element)>0){
                    nuevo.setNext(p.getNext());
                    nuevo.setPrevious(p);
                    p.getNext().setPrevious(nuevo);
                    p.setNext(nuevo);
                    this.efectivo++;
                    return true;
                }            
            }
        }

        return false;
    }
    
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
    //Aplica a la circuladoblylinkedlist
    public boolean intercambiarExtremos(){
        Nodo sig;
        Nodo temp, ant;
        
        if(this.isEmpty())
            return false;
        if(this.first == this.last)
            return true;
        else{
            //desconecto el primer nodo con la lista
            sig = this.first.getNext();
            sig.setPrevious(null);
            this.first.setNext(null);
            //desconecto el ultimo nodo con la lista
            ant = this.last.getPrevious();
            ant.setNext(null);
            this.last.setPrevious(null);
            //desconecto los nodos primero y final
            this.last.setNext(null);
            this.first.setPrevious(null);
            //hago el intercambio
            temp = this.last;
            this.last = this.first;
            this.first = temp;
            //conecto el primer nodo que antes era ultimo
            sig.setPrevious(this.first);
            this.first.setNext(sig);
            this.first.setPrevious(this.last);
            //conecto el ultimo nodo que antes era primero
            ant.setNext(this.last);
            this.last.setPrevious(ant);     
            this.last.setNext(this.first);
                     
        }
        return true;        
    }
    
    //Me dice si una lista es el reverso de otra
    public boolean isReverse(DoubleLinkedList<E> l){
        if(this.size() == 0 && l.size() == 0)
            return true;
        if(l.isEmpty())
            return false;
        if(l.size() == this.size()){
            DoubleLinkedList<E> l1 = l;
            DoubleLinkedList<E> l2 = this;
            if(l1.getFirst() == l2.getLast()){
                l1.removeFirst();
                l2.removeLast();
                return isReverse(l1, l2);    
            }
        }
        return false;
    }
    
    public boolean isReverse(DoubleLinkedList<E> listaExterna, DoubleLinkedList<E> lista){
        DoubleLinkedList<E> l1 = listaExterna;
        DoubleLinkedList<E> l2 = lista;
        
        
        if(l1.getFirst() == l2.getLast()){
            l1.removeFirst();
            l2.removeLast();
            if(l1.isEmpty() && l2.isEmpty())
                return true;
            return isReverse(l1, l2);
        }
        return false;
    }

    @Override
    public String toString() {
        String s = "[";
        for(Nodo<E> p = this.first; p != null; p = p.getNext())
            if ( p != this.last)
                s+= p.getData() + ",";
            else
                s+= p.getData();
        s+="]";
        return s;
        
    }

}
