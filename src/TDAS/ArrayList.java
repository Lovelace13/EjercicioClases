/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAS;

import Interfaces.List;
import java.util.Iterator;
import java.util.ListIterator;

/**
 *
 * @author ktiusk
 * @param <E>
 */
public class ArrayList<E> implements List<E>{
    
    /**
    *Es el arreglo contenedor de los elementos del ArrayList
    */
    private E[] array;
    /**
    *Representa la capacidad total de elementos que puede guardar el ArrayList
    */
    private int capacity = 10;
    /**
    *Guarda el número total de elementos del ArrayList
    */
    private int efectivo;
    
    public ArrayList(){
        array = (E[]) new Object[capacity];
        efectivo = 0;
    }
    
    public int size(){
        return efectivo;
    }
    
    @Override
    public boolean addLast(E element){
        if(element == null)
            return false;
        
        if (efectivo == capacity){
            addCapacity();
        }
        
        array[efectivo++] = element;
        return true;
    }
    
    private void addCapacity(){
        E[] temp = (E[]) new Object[capacity + (capacity*2/3)];
        
        for(int j = 0; j < capacity; j++)
            temp[j] = array[j];
                
        array = temp;
        capacity = capacity + (capacity*2/3);
    }
    
    @Override
    public boolean addFirst(E element){
        if(element == null)
            return false;
        
        if(efectivo == capacity)
            addCapacity();
        
        for(int i = efectivo; i > 0; i--)
            array[i] = array[i-1];
        
        this.array[0] = element;
        efectivo++;
        return true;
    }
    
    @Override
    public boolean isEmpty(){
        return efectivo == 0;
    }   
    
    @Override
    public boolean removeFirst(){
        if(isEmpty())
            return false;
        for(int i=0; i<efectivo-1;i++){
            array[i]=array[i+1];
        }
        array[--efectivo]=null;
        return false;
    }
    
    /**
     *Quita el último elemento del ArrayList
     * @return
     */
    @Override
    public boolean removeLast(){
        if(isEmpty())
            return false;
        array[--efectivo]=null;
        return true;
    }
    
    @Override
    public String toString(){
        StringBuilder sb= new StringBuilder();
        sb.append("[");
        for(int i=0; i<efectivo;i++){
            sb.append(array[i]+";");
        }
        sb.substring(0,sb.length()-1);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean contains(E element){
        if(element==null) 
            return false;
        for(int i=0; i<efectivo;i++ ){
            if(array[i].equals(element)); 
                return true;                   
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == obj || !(obj instanceof ArrayList)) 
           return false;
        ArrayList <E> other=(ArrayList <E>) obj;
        if(this.efectivo != other.efectivo)
            return false;
        for(int i=0; i<this.efectivo;i++){
            if(!this.array[i].equals(other.array[i]))
                return false;
        }
        return true;
    }
    
    @Override
    public List<E> slicing(int start, int end){
      
        List<E> l = new ArrayList<E>();     
        
        if(start == this.capacity)
            return l;
        
        if(start > end)
            return l;
        
        if(start >= 0 && start < efectivo){
            for(int i = start; i < end; i++){
                l.addLast(this.array[i]);
            }
        }        
        return l;
    }
    
    /**
     * Método que invierte el orden de los elementos de el ArrayList
     */
    @Override
    public void reverse() {
        
        E temp = (E) new Object();
        int recorrido;
        if(this.efectivo > 1){
            if(this.efectivo%2 == 0)
                recorrido = (this.efectivo)/2;
            else
                recorrido = (this.efectivo - 1)/ 2;
                
            for(int i = 0; i < recorrido; i ++){
                temp = array[i];
                this.array[i] = this.array[this.efectivo - i -1];
                this.array[this.efectivo - i -1] = temp;
            }
        }
    }
    
    private void reverse(int start, int end){
        if (start < end){
            E temp = this.array[end];
        }
    }
    
    /**
    *Remplaza el element que se encuentra en index
     * @param index
     * @param element
     * @return boolean
    */
    @Override
    public boolean set(int index, E element) 
    {
        if(isEmpty())
            return false;
        
        if(index > this.efectivo)
            return false;   
     
        this.array[index - 1] = element;
        return true;
    }

    /**
     * Agrega el element en index desplazando los elementos que se encuentran a la derecha de index
     * @param index
     * @param element
     * @return 
     */
    @Override
    public boolean insert(int index, E element) {
        
        if(index > this.efectivo)
            return false; 
        
        if(index <= 0)
            return false;
        
        this.array[++efectivo] = null;
        
        for(int i = this.efectivo - 1; i >= index ; i--){
            this.array[i] = this.array[i-1];
        }
        this.array[index - 1] = element;
        return true;
    }

    /**
     * Remueve el elemento de index y compacta el arreglo
     * @param index
     * @return 
     */
    @Override
    public boolean remove(int index) {
        if(index > this.efectivo)
            return false; 
        
        if(index <= 0)
            return false;
        
        --this.efectivo;
//        this.array[--this.efectivo] = null;
        
        for(int i = index - 1; i < this.efectivo ; i++){
            this.array[i] = this.array[i+1];
        }

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
    
    public Iterator<E> iterator(){
        Iterator<E> it = new Iterator<E>() {
            private int indice = 0;
            
            @Override
            public boolean hasNext() {
                return indice < efectivo && array[indice] != null;
            }

            @Override
            public E next() {
                return array[indice++];
            }
        };
                
        return it;
    }
    
    public ListIterator<E> listIterator(int index){
        ListIterator<E> lit = new ListIterator<E>(){
            @Override
            public boolean hasNext() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public E next() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean hasPrevious() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public E previous() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public int nextIndex() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public int previousIndex() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void set(E e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void add(E e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        };
        return lit;
    }

    @Override
    public E getPrevious() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

