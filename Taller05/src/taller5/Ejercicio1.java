/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller5;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author zDhim
 */
public class Ejercicio1 extends JFrame {
    JTextField txtFrase;
    JLabel lblA, lblE, lblI, lblO, lblU;
    JButton btnAnalizar;

    public Ejercicio1() {
        setTitle("Contador de Vocales");
        setLayout(null);
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        txtFrase = new JTextField();
        txtFrase.setBounds(30, 30, 300, 30);
        add(txtFrase);

        btnAnalizar = new JButton("Analizar");
        btnAnalizar.setBounds(140, 70, 100, 30);
        add(btnAnalizar);

        lblA = new JLabel("A: 0");
        lblA.setBounds(30, 120, 100, 30);
        add(lblA);

        lblE = new JLabel("E: 0");
        lblE.setBounds(30, 150, 100, 30);
        add(lblE);

        lblI = new JLabel("I: 0");
        lblI.setBounds(150, 120, 100, 30);
        add(lblI);

        lblO = new JLabel("O: 0");
        lblO.setBounds(150, 150, 100, 30);
        add(lblO);

        lblU = new JLabel("U: 0");
        lblU.setBounds(270, 135, 100, 30);
        add(lblU);

        btnAnalizar.addActionListener(e -> {
            String frase = txtFrase.getText();
            if (frase.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor ingrese una frase.");
                return;
            }

            int a = 0, e1 = 0, i = 0, o = 0, u = 0;
            for (char c : frase.toLowerCase().toCharArray()) {
                switch (c) {
                    case 'a' -> a++;
                    case 'e' -> e1++;
                    case 'i' -> i++;
                    case 'o' -> o++;
                    case 'u' -> u++;
                }
            }

            lblA.setText("A: " + a);
            lblE.setText("E: " + e1);
            lblI.setText("I: " + i);
            lblO.setText("O: " + o);
            lblU.setText("U: " + u);
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Ejercicio1();
    }
}
