/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mains;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import Objetos.Estudiante;
import TDAS.ArrayList;
import TDAS.CircularDoublyLinkedList;
import TDAS.DoubleLinkedList;
import TDAS.SimpleLinkedList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Katiuska
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> nombres = new ArrayList<String>();
        ArrayList<String> NuevosNombres = new ArrayList<String>();
        SimpleLinkedList<String> ListaEquipos = new SimpleLinkedList<>();
        LinkedList<Integer> lista = new LinkedList<>();
        Comparator<Integer> comparador = (pa, pb) -> pa - pb;
        DoubleLinkedList<Integer> listadoble = new DoubleLinkedList<>(comparador);
        DoubleLinkedList<Integer> listdo = new DoubleLinkedList<>();
        CircularDoublyLinkedList<Integer> num = new CircularDoublyLinkedList<>();
        
        num.addFirst(1);
        num.addFirst(2);
        num.addFirst(3);
        num.addFirst(4);
//        System.out.println(num);

        listdo.addFirst(2);
        listdo.addLast(1);
        listdo.addFirst(9);
        listdo.addLast(0);
        System.out.println(listdo);
        listadoble.addFirst(1);
        listadoble.addLast(2);
        listadoble.addFirst(0);
        listadoble.addLast(9);
        System.out.println(listadoble);
        System.out.println(listadoble.isReverse(listdo));
//        System.out.println(listadoble);
//        listadoble.sortedInsert(3);
//        System.out.println(listadoble);
        
        
        lista.add(10);
        lista.add(100);
        lista.add(20);
        
        ListaEquipos.addFirst("Emelec");
        ListaEquipos.addLast("Barza");
        ListaEquipos.addLast("Friends");
        ListaEquipos.addLast("Champions");
        ListaEquipos.addLast("Auca");
        
//        Iterator<String> it = ListaEquipos.iteratorStep(0, 4);
//        while(it.hasNext()){
//            String data = it.next();
//            System.out.println(data);
//        }
        
//        System.out.println(ListaEquipos);
//        ListaEquipos.reverse();
//        ListaEquipos.removeLast();
//        System.out.println(ListaEquipos);
        
//        Iterator<String> it = ListaEquipos.iterator();
//        while(it.hasNext()){
//            String s = it.next();
//        }
//        
//        ListIterator<Integer> lit = lista.listIterator(lista.size());
//        while(lit.hasPrevious()){
//            Integer n = lit.previous();
//            System.out.println(n);
//        }
        
//        ListIterator<Integer> it2 =  lista.listIterator(1);
//        it2.remove();
//        System.out.println(lista);
        
        //Comparacion con expresion lambda
        lista.sort(Integer::compareTo);
//        System.out.println(lista);
        
        nombres.addLast("Juan");
        nombres.addLast("María");
        nombres.addLast("Jorge");
        nombres.addLast("Carmen");
        nombres.addLast("Guido");
        nombres.addLast("Hugo");
        nombres.addLast("Fabricio");
        
//        System.out.println(nombres);
//        NuevosNombres = (ArrayList) nombres.slicing(2,5);
//        System.out.println(NuevosNombres);
//        nombres.reverse();
//        System.out.println(nombres);
//        nombres.set(4, "Ericka");
//        System.out.println(nombres);
//        nombres.insert(4, "Joyce");
//        nombres.insert(1, "Katiuska");
//        System.out.println(nombres);
//        nombres.remove(9);
//        System.out.println(nombres);
        
        
        //COlas: Queue
        
        
        
//        Estudiante student1 = new Estudiante("jimenez", 19);
//        Estudiante student2 = new Estudiante("Garcia", 20);
//        Estudiante student3 = new Estudiante("Ortega", 15);
//        
        Queue<Estudiante> cola = new PriorityQueue<>((Estudiante e1, Estudiante e2) -> e1.getEdad() - e2.getEdad());
        
//        
//        cola.offer(student1);
//        cola.offer(student2);
//        cola.offer(student3);
        
//        System.out.println(cola);
        DoubleLinkedList<String> listaNona = new DoubleLinkedList<>();
        listaNona.addFirst("Juan");
        listaNona.addLast("María");
        listaNona.addLast("Jorge");
        listaNona.addLast("Carmen");
        listaNona.addLast("Guido");
        listaNona.addLast("Hugo");
        listaNona.addLast("Mateo");
//        System.out.println(listaNona.toString());
//        System.out.println(listaNona.intercambiarExtremos());
//        System.out.println(listaNona);
    }
     
    public static int posfix(String exp){
        Stack<Integer> pila = new Stack<>();
        String[] arr = exp.split(" ");
        
        for(int i = 0; i < arr.length; i++){
            if(isOperando(arr[i]))
                pila.push(Integer.parseInt(arr[i]));
            else{
                Integer n1 = pila.pop();
                Integer n2 = pila.pop();
                switch(arr[i]){
                    case "+":
                        pila.push(n1 + n2);
                        break;
                    case "-":
                        pila.push(n1 - n2);
                        break;
                    case "*":
                        pila.push(n1 * n2);
                        break;
                    case "/":
                        pila.push(n1 / n2);
                        break;
                    default:
                        pila.push(n1 * n2 - n1);
                        break;
                }
            }
        }
        return 0;
    }
        
    private static boolean isOperando(String a) {
        if(a!="+"||a!="-"||a!="*"||a!="/")
            return true;
        return false;
    }     
    
    /**
     * Método que elimina los k primeros elementos de un arreglo de enteros que:
     * Sean menores que el siguiente elemento
     * Que se conviertan en menor que el siguiente, producto de la eliminación de otro elemento
     * @param array
     * @param k
     * @return 
     */
    public static Stack<Integer> eliminarPrimeroK(int[] array, int k){
        Stack<Integer> pila = new Stack<>();
        int c=0;
        if(array!=null){                       
            for(int i=0; i<array.length;i++){
                while(!pila.empty()&&pila.peek()<array[i]&&c<k){
                    pila.pop();
                    c++;
                }
                pila.push(array[i]);                
            }
        }       
        return pila;
        //ejemplo
        //Entrada:  arr = [20,10,25,30,40]
        //Salidad:  arr = [25,30,40]
    }
}
