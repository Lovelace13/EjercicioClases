/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAS;

import java.util.Comparator;
import java.util.ArrayList;

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
        if(!this.array.isEmpty()){
            E element = this.array.get(this.array.size()-1);
            this.array.remove(element);
            return element;
        }
        return null;
    }
    
    public boolean offer(E element){
        E temp;
        if (element == null)
            return false;
        if(this.array.isEmpty()){
            this.array.set(0, element);
            return true;
        }
        if(array.size() == 1){
            boolean c = f.compare(array.get(0), element) > 0;
            if(max && c)
                this.array.set(0,element);
            array.add(element);
            return true;
        }
        else{     
            this.array.add(element);
            int hijo = this.array.size() - 1;//9
            int Padre = padreN(hijo);//4
            if(!max){//heapmin            
                while(f.compare(array.get(Padre), array.get(hijo))>0){
                    temp = this.array.get(Padre);
                    array.set(Padre, element);
                    array.set(hijo, temp);
                    hijo = Padre;//4
                    Padre = this.padreN(hijo);//1
                }
            }
            else{//maxheap
                while(f.compare(array.get(Padre), array.get(hijo))<0){
                    temp = this.array.get(Padre);
                    array.set(Padre, element);
                    array.set(hijo, temp);
                    hijo = Padre;
                    Padre = this.padreN(hijo);
                }
            }
            return true;
        }
        
    }

    public E extractMin(){
        E result = array.get(0);
        int pos = array.size()-1;
        E tempU = array.get(pos);
        array.remove(pos);
        array.set(0, tempU);
        minHeapify();
        return result;
    }
    
    private boolean minHeapify() 
    { 
        int Padre = 0;
        int hijoD = 1;
        int hijoI = 2;
        boolean der = f.compare(array.get(Padre), array.get(hijoD)) > 0;
        boolean izq = f.compare(array.get(Padre), array.get(hijoI)) > 0;
        E temp;
        
        if(!der && !izq)
            return true;
        else if( der && !izq){
            temp = array.get(Padre);
            array.set(Padre, array.get(hijoD));
            array.set(hijoD, temp);
            return heapminfy(hijoD); //1
        }
        else if( izq && !der){
            temp = array.get(Padre);
            array.set(Padre, array.get(hijoI));
            array.set(hijoI, temp);
            return heapminfy(hijoI); //2
        }
        else{
            if(f.compare(array.get(hijoD),array.get(hijoI)) < 0){
                temp = array.get(Padre);
                array.set(Padre, array.get(hijoD));
                array.set(hijoD, temp);
                return heapminfy(hijoD); //1
            }
            else if(f.compare(array.get(hijoD),array.get(hijoI)) > 0){
                temp = array.get(Padre);
                array.set(Padre, array.get(hijoI));
                array.set(hijoI, temp);
                return heapminfy(hijoI); //2
            }            
        }
        
        return false;
    } 
    
    private boolean heapminfy(int pos){
        int Padre = pos;
        int hijoD = posDer(Padre);
        int hijoI = posIzq(Padre);
        boolean der = f.compare(array.get(Padre), array.get(hijoD)) < 0;
        boolean izq = f.compare(array.get(Padre), array.get(hijoI)) < 0;
        E temp;
        if(!der && !izq)
            return true;
        else if( der && !izq){
            temp = array.get(Padre);
            array.set(Padre, array.get(hijoD));
            array.set(hijoD, temp);
            return heapminfy(hijoD); //1
        }
        else if( izq && !der){
            temp = array.get(Padre);
            array.set(Padre, array.get(hijoI));
            array.set(hijoI, temp);
            return heapminfy(hijoI); //2
        }
        else{
            if(f.compare(array.get(hijoD),array.get(hijoI)) < 0){
                temp = array.get(Padre);
                array.set(Padre, array.get(hijoD));
                array.set(hijoD, temp);
                return heapminfy(hijoD); //1
            }
            else if(f.compare(array.get(hijoD),array.get(hijoI)) > 0){
                temp = array.get(Padre);
                array.set(Padre, array.get(hijoI));
                array.set(hijoI, temp);
                return heapminfy(hijoI); //2
            }            
        }
        
        return false;

    }
}
