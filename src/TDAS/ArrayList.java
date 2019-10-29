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
    
    @Override
    public List<E> slicing(int start, int end){
      
        List<E> l = new ArrayList<>();     
        
        if(start == this.capacity)
            return l;
        
        if(start >= 0 && start < efectivo){
            for(int i = start; i < end; i++){
                l.addLast(this.array[i]);
            }
        }        
        return l;
    }
    


    @Override
    public void reverse() {
        
        E temp = (E) new Object();
                
        for(int i = 0; i < capacity/2; i ++){
            temp = array[i];
            array[i] = array[array.length - i -1];
            array[array.length - i -1] = temp;
        }
    }
    
    private void reverse(int start, int end){
        if (start < end){
            E temp = this.array[end];
        }
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
}
