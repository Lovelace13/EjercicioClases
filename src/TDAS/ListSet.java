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
 * @author kmmarin
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
     * Remueve un elemento de la lista según el índice
     * @param index
     * @return boolean
     */
    public boolean suprimir(E elemento){
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
        return true;
    }
    
    @Override
    public String toString() {
        
        String s = "[";
        
        for( int i = 0; i<list.size(); i++){
            if ( i < list.size()-1 )
                s+= list.get(i) + "," ;
            else if ( i == list.size()-1)
                s+= list.get(i) + "]";
        } 
        
        return s ;
    }
}
