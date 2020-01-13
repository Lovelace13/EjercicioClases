/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAS;

import java.util.Comparator;

/**
 *
 * @author CltControl
 * @param <E>
 */
public class Heap <E>{
    
    private ArrayList<E> array;
    private Comparator<E> f;
    private boolean max;
    
    public Heap(Comparator<E> f, boolean max){
        array = new ArrayList<>();
        this.f = f;
        this.max = max;
    }
    
    public boolean isIsMax() {
        return this.max;
    }

    public void setMax(boolean isMax) {
        this.max = isMax;
    }
    
    private int padreN(int i){
        return(i-1)/2;
    }
    
    private int posIzq(int i){
        return (2*i)+1;
    }
    
    private int posDer(int i){
        return(2*i)+2;
    }
     
    public E poll(){
        E element = this.array.getLast();
        if(!this.array.isEmpty()){
            this.array.removeLast();
            return element;
        }
        return null;
    }
    
    public boolean offer(E element){
        if(this.array.isEmpty()){
            this.array.addFirst(element);
            return true;
        }
        else{
            this.array.addLast(element);
//            int hijo = pos;
//            int padre = padreN(efectivo);
//            while(f.compare(this.array[hijo], this.array[padre])>0){
//                E tmp = this.arreglo[padre];
//                this.array[padre] = this.array[hijo];
//                this.array[hijo] = tmp;
//                hijo = padre;
//                padre = this.padreN(hijo);
//            }
            return true;
        }
    }

}
