/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAS;
import Nodos.Nodo;

/**
 *
 * @author CltControl
 */
public class CircularDoublyLinkedList<E> {
    private Nodo<E> first;
    private Nodo<E> last;
    private int efectivo;     
    
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
            nodo.setNext(this.first);
            this.first.setPrevious(nodo);
            this.last.setNext(null);
            this.first = nodo;
            this.first.setPrevious(this.last);
            this.last.setNext(this.first);
        }  
        efectivo++;
        return true;
    }
    
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
