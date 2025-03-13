/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;

/**
 *
 * @author Dimerson
 */
public class Animal {
    protected String especie;

    public Animal(String especie) {
        this.especie = especie;
    }

    public void mostrarEspecie() {
        System.out.println("Especie: " + especie);
    }
}