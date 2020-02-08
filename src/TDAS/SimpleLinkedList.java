/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAS;

import Interfaces.List;
import Nodos.Node;
import java.util.Iterator;

/**
 *
 * @author CltControl
 */
public class SimpleLinkedList<E> implements List<E> {
    private Node<E> first;
    private Node<E> last;
    private int efectivo;
    

    public SimpleLinkedList() {
        first=null;
        last=null;
    }
    
    @Override
    public boolean isEmpty(){
        return first==null && last==null;
    }
    
    @Override
    public int size(){
        return efectivo;
    }
    
    @Override
    public boolean addFirst(E element){
        Node<E> node= new Node<>(element);
        if(element==null)
            return false;
        else if(isEmpty())            
            first=last=node;         
        else{           
            node.setNext(first);
            first=node;
        }
        efectivo++;
        return true;
    }
    
    public boolean addLast(E element){
        Node<E> node= new Node<>(element);
        if(element==null)
            return false;
        else if(isEmpty())
            first=last=node; 
        else{           
            last.setNext(node);
            last=node;
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
            Node<E> temp = first;
            first = first.getNext();
            temp.setNext(null);
        }
        efectivo--; 
        return true;
        
    }

    @Override
    public boolean removeLast() {        
        if(this.isEmpty())
            return false;
        else if (this.first == this.last)
            this.first = this.last = null;
        else{
            last.setData(null);
            this.last = this.getPrevious(this.last);
            this.last.setNext(null);
        }
        this.efectivo--;
        return true;
    }

    /**
     * Devuelve "true" si contiene dicho elemento en la lista enlazada
     * @param element
     * @return boolean
     */
    @Override
    public boolean contains(E element) {
        if(isEmpty() && element == null)
            return false;
        else{
            for (Node<E> p = this.first; p != null; p = p.getNext()){
                if (p.getData().equals(element))
                    return true;
            } 
        }    

        return false;
    }

    @Override
    public List<E> slicing(int start, int end) {
        int cont = 0;
        List<E> lit = new SimpleLinkedList<>();
        
        for(Node<E> p = this.first ; p != null; p = p.getNext()){
            
            if ( start <= cont && end <= cont) {
                
                lit.addFirst(p.getData());
                
            }
            cont++;
        }
            
        return lit;
    }

    /**
     * Reasigna el enlace de la lista intercambiando las posiciones
     */
    @Override
    public void reverse() {
        
        Node<E> nodo_viajero = this.first;
        Node<E> siguiente = null;
        Node<E> anterior  = null;
        
        while( nodo_viajero != null){
            siguiente = nodo_viajero.getNext();
            nodo_viajero.setNext(anterior);
            anterior = nodo_viajero;
            nodo_viajero = siguiente;
        }
        
        this.first = anterior;
 
    }

    /**
     * Inserta un elemento en el index indicado en el método
     * @param index
     * @param element
     * @return 
     */
    @Override
    public boolean set(int index, E element) {
        if(index == 0 && isEmpty()){
            this.first.setData(element);
            return true;
        }else if (index == this.efectivo)
            this.last.setData(element);
        else if(!isEmpty() && index >= 0 && index <= this.efectivo)
        {
            int indice = 0;
            Node<E> remplazo; //Un temporal que va a ser para el nodo anterior del que sera removido y para para el nodo siguiente
            for(Node<E> nodo = this.first; nodo != null; nodo = nodo.getNext()){
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
            Node<E> siguiente, anterior; //Un temporal que va a ser para el nodo anterior del que sera removido y para para el nodo siguiente
            for(Node<E> nodo = this.first; nodo != null; nodo = nodo.getNext()){
                if( indice == index){
                    anterior = this.getPrevious(nodo);
                    siguiente = nodo.getNext();
                    nodo.setNext(null);
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
    public String toString() {
        String s = "[";
        int acum =0;
        for(Node<E> p = this.first; p != null; p = p.getNext())
            if ( p.getNext() != this.getLast()){
                s+= p.getData() + ","; 
            }else{
                s+= p.getData();
            }s+="]";
        return s;
        
    }

    @Override
    public E getFirst() {
        if(this.isEmpty())
            return null;
        return this.first.getData();
    }

    @Override
    public E getLast() {
        if(this.isEmpty())
            return null;
        return this.last.getData();
    }
    
    @Override
    public boolean equals(Object other)    {
        if(other == null || !(other instanceof SimpleLinkedList))
            return false;
        
        SimpleLinkedList<E> objeto = (SimpleLinkedList) other;
        
        if(this.size() != objeto.size())
            return false;
        
        Node<E> p = this.first;
        Node<E> q = objeto.first;
        
        while( p != null){
            if( !p.getData().equals(q.getData()))
                return false;
            
            p = p.getNext();
            q = q.getNext();
        }
        return true;        
    }
    
    public Iterator<E> iterator(){
        Iterator<E> it = new Iterator<E>() {
            
            private Node<E> p = first;
            @Override
            public boolean hasNext() {
                return p != null;
            }

            @Override
            public E next() {
                E temp = p.getData();
                p = p.getNext();
                return temp;
            }
        };
                
        return it;
    }
    
    public Iterator<E> iteratorStep(int s, int sp){
        
        Iterator<E> it = new Iterator<E>(){
            private int start = s;
            private int step = sp;
            private Node<E> p = first;
            
            @Override
            public boolean hasNext() {
                int cont = 1; boolean f = false;
                if(start != 0 ){
                    for(Node<E> t = p; t != null; t = t.getNext()){
                        if(cont == start){
                            f = t != null;
                            t = last;
                        }
                        cont++;
                    }
                    return p != null && f;
                }
                else
                    return p!=null;                
                
            }

            @Override
            public E next() {
                E temp;
                int cont = 1;
                if(start != 0 && start !=1){
                    while(cont < start){
                        p = p.getNext();
                        cont++;
                    }
                }
                else if(start == 1)
                    p = p.getNext();
                
                temp = p.getData();
                start = step;
                p = p.getNext();
                return temp;
            }  
        };
        return it;
    }

    private Node<E> getPrevious(Node<E> p){
        if(p != this.first){
            for(Node<E> q = this.first; q!= null; q = q.getNext()){
                if(q.getNext() == p)
                    return q;
            }    
        }
        return null;      
    }

    @Override
    public E get(int index) {
        
        if(isEmpty() || index < 0 || index > this.efectivo)
            return null;
        else if(index == this.efectivo)
            return this.last.getData();
        
        int cont = 0;
        Node<E> p = this.first;
        while(index != cont){
            p = p.getNext();
            cont++;
        }
        return p.getData();
        
    }


            
   
}
