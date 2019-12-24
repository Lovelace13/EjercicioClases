/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAS;

import Nodos.NodoArbol;
import java.util.Comparator;

/**
 *
 * @author ktiusk
 */
public class SBT <E>{
    
    private NodoArbol<E> root;
    private Comparator<E> f;
    
    public SBT(Comparator<E> fa) {
        this.f = fa;
        this.root = null;
    }
    
    public boolean isEmpty(){
        return root==null;
    }
 
    public int alturaArbol(){
        return alturaArbol(root);
    }
    
    private int alturaArbol(NodoArbol<E> n){
        if(n == null) 
            return 0;
        return 1 + Math.max(alturaArbol(n.getLeft()),alturaArbol(n.getRight()));
    }
    
    //contador de nodos------
    
    public int contarHojas(){
        return contarHojas(root);
    }
    private int contarHojas(NodoArbol<E> n){
        
        if(n == null) 
            return 0;
        else if(n.getLeft() == null && n.getRight() == null)
            return 1;
        else
            return contarHojas(n.getLeft())+ contarHojas(n.getRight());
    }
    
    public boolean add(E element){
        if(element==null)
            return false;
        
        this.root = add(element,root);
        return true;
    }
    
    private NodoArbol<E> add(E element, NodoArbol<E> n){
        if(n == null)
            n = new NodoArbol<>(element);
        else if(f.compare(element, n.getData())>0)
            n.setRight(add(element,n.getRight()));
        else if(f.compare(element, n.getData())<0)
            n.setLeft(add(element,n.getLeft()));
        return n;
    }
     
    public E max(){
        return max(root);
    }
    private E max(NodoArbol<E> n){
        if(n==null)
            return null;
        else if(n.getRight()==null)
            return n.getData();
        else
            return max(n.getRight());
    }
    
    public E min(){
        return min(root);
    }
    private E min(NodoArbol<E> n){
        if(n==null)return null;
        else if(n.getLeft()==null){
            return n.getData();
        }else
            return max(n.getLeft());
    }
    
    public boolean remove(E element){
        if(element==null|| isEmpty()) 
            return false;
        this.root = remove(element,root);
        return true;
    }
    
    private NodoArbol<E> remove(E element, NodoArbol<E> n){
        if(n == null) 
            return n;
        else if(f.compare(element, n.getData()) > 0)
            n.setRight(remove(element,n.getRight()));
        else if(f.compare(element, n.getData()) < 0)
            n.setLeft(remove(element,n.getLeft()));
        else if(n.getLeft() != null && n.getRight() != null){
            n.setData(max(n.getLeft()));
            n.setLeft(remove(n.getData(),n.getLeft()));
        }else
            n=(n.getLeft()!=null)? n.getLeft(): n.getRight();
        return n;
    }
    
    public boolean contains(E element){
        if(element==null|| isEmpty()) return false;
        return contains(element,root);
         
    }
    
    private boolean contains(E element, NodoArbol<E> n){
        if(n==null) return false;
        else if(f.compare(element, n.getData())>0){
            contains(element,n.getRight());
        }else if(f.compare(element, n.getData())<0){
            contains(element,n.getLeft());
        }return true;
    }

    public void posOrden(){
        posOrden(root);
    }
    private void posOrden(NodoArbol<E> n){
        if(n!=null){
            posOrden(n.getLeft());
            posOrden(n.getRight());
            System.out.println(n.getData());
        }
    }

    //preOrden--------
    public void preOrden(){
        preOrden(this.root);
    }
    
    private void preOrden(NodoArbol<E> nodo){
        
        if(nodo != null){
            System.out.print(nodo.getData() + ", ");
            preOrden(nodo.getLeft());
            preOrden(nodo.getRight());
        }
    }
    
    //enOrden-------
    public void enOrden(){
        enOrden(this.root);
    }
    
    private void enOrden(NodoArbol<E> nodo){
        
        if( nodo != null ){
            enOrden(nodo.getLeft());
            System.out.print(nodo.getData() + ", ");
            enOrden(nodo.getRight());
        }
    }
        
    //un arbol esta desequilibrado cuando el factor de equilibrio es 2 o -2
    //factor de equilibrio(arura derecha-altura izquierda)
    //a penas se detecta un 2 o -2 se reestructura el arbol
    //el signo indica de donde viene el desequilibrio, 
    //si es - hay mas peso en izq. entonces se hace una rotacion hacia la derecha (rotaccion izq izq/R. simple derecha)
    //si es + hay mas peso a la derecha, entonces se hace una rotacion hacia la izq(rotaccion der der/R. simple izq)
    //ROTACION ISQ IZQ7 DER DER
    // raiz desequilibrada=n, n1=el que tiene el sobrecargo
    //caso 1 (no imposibilita la rotacion): al detectar el desequilibrio n1 se vuelve en raiz y n se vueleve en el nodo donde hay menos nodos
    //caso 2(algun nodo impide rotar): n1 tiene hijo del mismo lado al que se va a rotar
                                     //entonces este hijo se lo pone en n(que ya no sera raiz) en el lado contrario al que estaba
    
    //ROTACION IZQUIERDA DERECHA
    //n=raiz, n1=izq, n2=dere
    //n2 pasa a ser raiz, n1 sera hijo izqu y n sera hijo dere
    //caso especial (n2 tiene hijo izquierdo): el hijo de n2 ahora sera hijoderecho de n1 
                   //(n2 tiene hijo derecho): el hijo de n2 ahora sera hijo izq de n1 
                  //(n2 tiene 2 hijos): 
    //ROTACION  DERECHA IZQUIERDA
    //n=raiz, n1=der n2=izq
    //n2 pasa a ser raiz, n1 sera hijo dere y n sera hijo izq
   //caso especial (n2 tiene hijo izquierdo): el hijo de n2 ahora sera hijoderecho de n1 
                   //(n2 tiene hijo derecho): el hijo de n2 ahora sera hijo izq de n1 
                  //(n2 tiene 2 hijos): 
}
