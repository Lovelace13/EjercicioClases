/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAS;

/**
 *
 * @author ktiusk
 */
public class ArrayList<E> implements List<E>{
    private E[] array;
    private int capacity = 10;
    private int efectivo;
    
    public ArrayList(){
        array = (E[]) new Object[capacity];
        efectivo = 0;
    }
    
    public int size(){
        return efectivo;
    }
    
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
    
    public boolean addFirst(E element){
        if(element == null)
            return false;
        
        if(efectivo == capacity)
            addCapacity();
        
        for(int i = efectivo; i > 0; i--)
            array[i] = array[i-1];
        
        array[0] = element;
        efectivo++;
        return true;
    }
    
    public boolean isEmpty(){
        return efectivo == 0;
    }   
    
    public boolean removeFirst(){
        if(isEmpty())
            return false;
        for(int i=0; i<efectivo-1;i++){
            array[i]=array[i+1];
        }
        array[--efectivo]=null;
        return false;
    }
    
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
    
    public List<E> slicing(int start, int end){
        E[] temp = (E[]) new Object[efectivo];
        List<E> l = new ArrayList<>();     
        int count = 0;
        
        for(int i = 0; i < capacity; i++){
            if( i == start){
                l[count] = array[i];
            }
        }
    }
}
