/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAS;

/**
 *
 * @author CltControl
 */
public class LinkedList<E> implements List<E> {
    private Node<E> first;
    private Node<E> last;
    private int efectivo;
    

    public LinkedList() {
        first=null;
        last=null;
        efectivo=0;
    }
    
    public boolean isEmty(){
        return first==null && last==null;
    }
    
    public int size(){
        return efectivo;
    }
    
    public boolean addFirst(E element){
        Node<E> node= new Node<>(element);
        if(element==null)
            return false;
        else if(isEmty())            
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
        else if(isEmty())
            first=last=node; 
        else{           
            last.setNext(node);
            last=node;
        }
        efectivo++;
        return true;
    }
    
   
}
