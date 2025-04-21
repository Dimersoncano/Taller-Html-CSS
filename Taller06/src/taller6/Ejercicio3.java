/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller6;
import javax.swing.*;
/**
 *
 * @author zDhim
 */
public class Ejercicio3 extends JFrame {
    JTextField txtNum1, txtNum2;
    JButton btnCalcular;

    public Ejercicio3() {
        setTitle("División y Resto");
        setLayout(null);
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        txtNum1 = new JTextField();
        txtNum1.setBounds(30, 30, 150, 30);
        add(txtNum1);

        txtNum2 = new JTextField();
        txtNum2.setBounds(200, 30, 150, 30);
        add(txtNum2);

        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(130, 80, 120, 30);
        add(btnCalcular);

        btnCalcular.addActionListener(e -> {
            try {
                int num1 = Integer.parseInt(txtNum1.getText());
                int num2 = Integer.parseInt(txtNum2.getText());

                if (num1 < 0 || num1 > 100 || num2 < 0 || num2 > 100) {
                    throw new FueraDeRangoException("Los números deben estar entre 0 y 100.");
                }

                int mayor = Math.max(num1, num2);
                int menor = Math.min(num1, num2);

                if (menor == 0) {
                    throw new ArithmeticException("No se puede dividir por cero.");
                }

                int division = mayor / menor;
                int resto = mayor % menor;

                JOptionPane.showMessageDialog(this, "División: " + division + "\nResto: " + resto);

            } catch (FueraDeRangoException ex) {
                JOptionPane.showMessageDialog(this, "Excepción propia: " + ex.getMessage());
            } catch (ArithmeticException ex) {
                JOptionPane.showMessageDialog(this, "Error aritmético: " + ex.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getClass().getName() + "\nMensaje: " + ex.getMessage());
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Ejercicio3();
    }
}

// Clase personalizada de excepción
class FueraDeRangoException extends Exception {
    public FueraDeRangoException(String mensaje) {
        super(mensaje);
    }
}
