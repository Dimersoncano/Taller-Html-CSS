/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller2;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author zDhim
 */
public class Ejercicio2 extends JFrame {
    JTextField txt1 = new JTextField();
    JTextField txt2 = new JTextField();
    JTextField txt3 = new JTextField();
    JLabel etiNotaFinal = new JLabel("Nota Final:");
    JLabel etiResultado = new JLabel("Resultado:");
    JButton btnCalcular = new JButton("Calcular");

    public Ejercicio2() {
        setLayout(null);
        setTitle("Ejercicio 2");
        setSize(300, 250);

        txt1.setBounds(20, 20, 100, 25);
        txt2.setBounds(20, 60, 100, 25);
        txt3.setBounds(20, 100, 100, 25);
        btnCalcular.setBounds(20, 140, 100, 25);
        etiNotaFinal.setBounds(20, 170, 200, 20);
        etiResultado.setBounds(20, 190, 200, 20);

        add(txt1);
        add(txt2);
        add(txt3);
        add(btnCalcular);
        add(etiNotaFinal);
        add(etiResultado);

        btnCalcular.addActionListener(e -> {
            double n1 = Double.parseDouble(txt1.getText());
            double n2 = Double.parseDouble(txt2.getText());
            double n3 = Double.parseDouble(txt3.getText());
            double promedio = (n1 + n2 + n3) / 3;
            etiNotaFinal.setText("Nota Final: " + promedio);

            if (promedio < 5) {
                etiResultado.setText("SUSPENSO");
                etiNotaFinal.setForeground(Color.RED);
                etiResultado.setForeground(Color.RED);
            } else {
                etiResultado.setText("APROBADO");
                etiNotaFinal.setForeground(Color.BLACK);
                etiResultado.setForeground(Color.BLACK);
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
