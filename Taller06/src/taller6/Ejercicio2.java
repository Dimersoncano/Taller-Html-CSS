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
public class Ejercicio2 extends JFrame {
    JTextField txtX1, txtY1, txtX2, txtY2;
    JButton btnCalcular;

    public Ejercicio2() {
        setTitle("Distancia entre puntos");
        setLayout(null);
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        txtX1 = new JTextField();
        txtX1.setBounds(30, 30, 70, 30);
        add(txtX1);

        txtY1 = new JTextField();
        txtY1.setBounds(110, 30, 70, 30);
        add(txtY1);

        txtX2 = new JTextField();
        txtX2.setBounds(190, 30, 70, 30);
        add(txtX2);

        txtY2 = new JTextField();
        txtY2.setBounds(270, 30, 70, 30);
        add(txtY2);

        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(140, 80, 100, 30);
        add(btnCalcular);

        btnCalcular.addActionListener(e -> {
            try {
                double x1 = Double.parseDouble(txtX1.getText());
                double y1 = Double.parseDouble(txtY1.getText());
                double x2 = Double.parseDouble(txtX2.getText());
                double y2 = Double.parseDouble(txtY2.getText());

                double distancia = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
                JOptionPane.showMessageDialog(this, "Distancia: " + distancia);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Ocurrió un error: " + ex.getClass().getName() + "\nMensaje: " + ex.getMessage());
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Ejercicio2();
    }
}
