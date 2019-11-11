/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;


/**
 *
 * @author CltControl
 */
public class Estudiante {
    private String Nombre;
    private int edad;
    
    public Estudiante(String name, int age){
        this.Nombre = name;
        this.edad = age;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "Nombre=" + Nombre + ", edad=" + edad + '}';
    }
    
    

}
