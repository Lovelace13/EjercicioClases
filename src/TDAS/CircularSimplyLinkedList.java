/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAS;
import Interfaces.List;
import Nodos.Node;

/**
 *
 * @author CltControl
 */
//public class CircularSimplyLinkedList<E> implements List<E> {
//    private Node<E> first;
//    private Node<E> last;
//    private int efectivo;
//    
//    @Override
//    public boolean addFirst(E element) {
//        Node<E> node= new Node<>(element);
//        Node<E> temp = this.getPrevious(first);
//        if(element==null)
//            return false;
//        else if(isEmpty())            
//            this.first = node;         
//        else{           
//            node.setNext(first);
//            temp.setNext(node);            
//        }
//        efectivo++;
//        return true;
//    }
//
//    @Override
//    public boolean addLast(E element) {
//                        
//        if(isEmpty()){
//            if(element != null){
//                Node<E> nodo = new Node<>(element);
//                this.last = nodo;
//                this.last.setNext(last);
//                return true;
//            }
//        }
//        else if(){
//            if (last == NULL) 
//     return addToEmpty(last, data); 
//  
//   Creating a node dynamically. 
//  struct Node *temp =  
//        (struct Node *)malloc(sizeof(struct Node)); 
//    
//   Assigning the data. 
//  temp -> data = data; 
//  
////   Adjusting the links. 
//  temp -> next = last -> next; 
//  last -> next = temp; 
//  last = temp; 
//    
//  return last;
//        }
//        return false;
//
//    }
//
//    @Override
//    public boolean removeFirst() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public boolean removeLast() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public boolean isEmpty() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public E getFirst() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public E getLast() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public int size() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public boolean contains(E element) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public E get(int index) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<E> slicing(int start, int end) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void reverse() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public boolean set(int index, E element) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public boolean insert(int index, E element) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public boolean remove(int index) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    
//    /**
//     * Me devuelve el nodo anterior al del parametro
//     * @param p
//     * @return Node
//     */
//    private Node<E> getPrevious(Node<E> p){
//        if(p != null){                
//            Node<E> w = this.first;
//            
//            for(int i = 0; i < this.efectivo; i++){
//                
//                w = w.getNext();
//            }
//            
//            for(Node<E> q = this.first; q!= p; q = q.getNext()){
//                if(q.getNext() == p)
//                    return q;
//            }    
//        }
//        return null;      
//    }
//    
//}
