/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author zDhim
 */
public class Ejercicio3 extends JFrame {
    JTextField txtRadio = new JTextField();
    JLabel etiArea = new JLabel("Área:");
    JLabel etiPerimetro = new JLabel("Perímetro:");

    public Ejercicio3() {
        setLayout(null);
        setTitle("Ejercicio 3");
        setSize(300, 200);

        txtRadio.setBounds(20, 20, 100, 25);
        etiArea.setBounds(20, 60, 200, 20);
        etiPerimetro.setBounds(20, 90, 200, 20);

        add(txtRadio);
        add(etiArea);
        add(etiPerimetro);

        txtRadio.addActionListener(e -> {
            double r = Double.parseDouble(txtRadio.getText());
            if (r < 0) {
                etiArea.setText("Área: Error");
                etiPerimetro.setText("Perímetro: Error");
                etiArea.setForeground(Color.RED);
                etiPerimetro.setForeground(Color.RED);
            } else {
                double area = Math.PI * r * r;
                double perimetro = 2 * Math.PI * r;
                etiArea.setText("Área: " + area);
                etiPerimetro.setText("Perímetro: " + perimetro);
                etiArea.setForeground(Color.BLACK);
                etiPerimetro.setForeground(Color.BLACK);
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}

