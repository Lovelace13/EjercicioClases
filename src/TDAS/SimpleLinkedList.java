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
public class SimpleLinkedList<E> implements List<E> {
    private Node<E> first;
    private Node<E> last;
    private int efectivo;
    

    public SimpleLinkedList() {
        first=null;
        last=null;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<E> slicing(int start, int end) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reverse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
}