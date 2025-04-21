/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller2;
import javax.swing.*;
/**
 *
 * @author zDhim
 */
public class Ejercicio8 extends JFrame {
    JTextField txtA = new JTextField();
    JTextField txtB = new JTextField();
    JTextField txtC = new JTextField();
    JLabel etiResultado = new JLabel("Resultado:");
    JButton btnCalcular = new JButton("Calcular");

    public Ejercicio8() {
        setLayout(null);
        setTitle("Ejercicio 8");
        setSize(300, 250);

        txtA.setBounds(20, 20, 100, 25);
        txtB.setBounds(20, 60, 100, 25);
        txtC.setBounds(20, 100, 100, 25);
        btnCalcular.setBounds(20, 140, 100, 25);
        etiResultado.setBounds(20, 180, 250, 40);

        add(txtA);
        add(txtB);
        add(txtC);
        add(btnCalcular);
        add(etiResultado);

        btnCalcular.addActionListener(e -> {
            double a = Double.parseDouble(txtA.getText());
            double b = Double.parseDouble(txtB.getText());
            double c = Double.parseDouble(txtC.getText());
            double R = b * b - 4 * a * c;

            if (R < 0) {
                etiResultado.setText("No tiene solución real");
            } else if (R == 0) {
                double x = -b / (2 * a);
                etiResultado.setText("Una solución: x = " + x);
            } else {
                double x1 = (-b + Math.sqrt(R)) / (2 * a);
                double x2 = (-b - Math.sqrt(R)) / (2 * a);
                etiResultado.setText("<html>Dos soluciones:<br>x1 = " + x1 + "<br>x2 = " + x2 + "</html>");
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}

