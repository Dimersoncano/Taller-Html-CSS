/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;

/**
 *
 * @author Dimerson
 */
public class Pez extends Animal {
    private String tipoDeAgua;

    public Pez(String especie, String tipoDeAgua) {
        super(especie); // Llama al constructor de la clase base
        this.tipoDeAgua = tipoDeAgua;
    }

    @Override
    public void mostrarEspecie() {
        super.mostrarEspecie(); // Llama al método de la clase base
        System.out.println("Vive en agua: " + tipoDeAgua);
    }
}