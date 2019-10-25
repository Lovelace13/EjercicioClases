/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAS;

import java.util.List;

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
    
    @Override
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
        
        for(int i = 0; i < capacity; i++)
            temp[i] = array[i];
                
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

}