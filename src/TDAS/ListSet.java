/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAS;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * TDA Conjunto Ordenado
 * @author Marin
 * @param <E>
 */
public class ListSet<E> {
    private LinkedList<E> list;
    private Comparator<E> f;
    
    public ListSet(Comparator<E> compf){
        this.f = compf;
        list = new LinkedList<>();
    }
    
    public boolean add(E element){
        
        if( element == null)
            return false;
        else if(list.isEmpty() || (f.compare(element, list.getLast()) > 0))
            return list.add(element);
        else{
            ListIterator<E> lit = list.listIterator();
            while(lit.hasNext())
            {
                E data = lit.next();
                if(f.compare(data, element) == 0)
                    return false;
                if(f.compare(data, element) < 0)
                {
                    lit.add(element);
                    return true;
                }
            }
            
        }
        return true;
    }
    
    /**
     * Remueve un elemento del conjunto, si este consta en el
     * @param elemento
     * @return boolean
     */
    public boolean remove(E elemento){
        if(list.isEmpty())
            return false;
               
        ListIterator<E> lit = list.listIterator();
        while(lit.hasNext())
        {
            E data = lit.next();
            if( data  ==  elemento)
            {                
                lit.remove();
                return true;
            }
        }
        return false;
    }
    
    /**
     * Retorna True si el elemento consta en el conjunto caso contrario False
     * @param elemento
     * @return boolean
     */
    public boolean contains(E elemento){
        
        if(list.isEmpty())
            return false;
               
        ListIterator<E> lit = list.listIterator();
        while(lit.hasNext())
        {
            E data = lit.next();
            if( data  ==  elemento)
            {                
                return true;
            }
        }
        return false;
    }
    
    /**
     * Retorna True si el conjunto está vacío
     * @return boolean
     */
    public boolean isEmpty(){
        return list.isEmpty();
    }
    
    /**
     * Retorna un objeto ListSet con elementos que sean en común con el parámetro Conjunto
     * @param Conjunto
     * @return ListSet
     */
    public ListSet<E> interseccion(ListSet<E> Conjunto){
        ListSet<E> Intereseccion = new ListSet<E>(this.f);
        
        if(list.isEmpty())
            return null;
        
        ListIterator<E> lit = list.listIterator();
        while(lit.hasNext())
        {
            E data = lit.next();
            if(Conjunto.contains(data))
            {                
                Intereseccion.add(data);
            }
        }
        return Intereseccion;
    }

    /**
     * Retorna un objeto ListSet con los elementos que no se encuentran en la intersección con el Conjunto
     * @param Conjunto
     * @return ListSet
     */
    public ListSet<E> diferencia(ListSet<E> Conjunto){
        ListSet<E> Diferencia = new ListSet<E>(this.f);
        
        if(list.isEmpty())
            return null;
        
        ListIterator<E> lit = list.listIterator();
        while(lit.hasNext())
        {
            E data = lit.next();
            if(!Conjunto.contains(data))
            {                
                Diferencia.add(data);
            }
        }
        return Diferencia; 
    }
    
    /**
     * Retorna un Conjunto nuevo con todos los elementos de ambos conjuntos
     * @param Conjunto
     * @return ListSet
     */
    public ListSet<E> union(ListSet<E> Conjunto){
        ListSet<E> Union = new ListSet<E>(this.f);
        ListSet<E> Intersec = new ListSet<E>(this.f);
        
        ListIterator<E> lit = list.listIterator();
        while(lit.hasNext())
        {
            E data = lit.next();
            Union.add(data);
        }
        
        if(this.list.isEmpty() && Conjunto.isEmpty())
            return null;
        
        if(this.isEmpty())
            return Conjunto;
        else if(Conjunto.isEmpty())
            return this;
        else{
            Intersec = Union.interseccion(Conjunto);
            
            ListIterator<E> litC = Conjunto.list.listIterator();
            while(litC.hasNext())
            {
                E data = litC.next();
                if(!Intersec.contains(data))
                {                
                    Union.add(data);
                }
            }
            
            return Union;
        }        
    }
    
    /**
     * Retorna un valor de verdad si ambos Conjunto contienen los mismo elementos
     * @param other
     * @return boolean
     */    
    @Override
    public boolean equals(Object other){
        if(other == null || !(other instanceof ListSet))
            return false;
        
        ListSet<E> objeto = (ListSet) other;
        
        if(this.list.size() == objeto.list.size()){
            
            ListIterator<E> lit = this.list.listIterator();
            while(lit.hasNext())
            {
                E data = lit.next();
                if(!objeto.contains(data))
                {                
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        
        String s = "[";
        
        for(int i = 0; i<list.size(); i++){
            if ( i < list.size()-1 )
                s+= list.get(i) + "," ;
            else if ( i == list.size()-1)
                s+= list.get(i) + "]";
        } 
        if(list.size() == 0)
            return "";
        
        return s ;
    }
}
