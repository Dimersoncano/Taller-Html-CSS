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
public class Ejercicio6 extends JFrame {
    JTextField txt1 = new JTextField();
    JTextField txt2 = new JTextField();
    JLabel etiTexto = new JLabel("Texto:");
    JButton btnConcatena = new JButton("Concatena");

    public Ejercicio6() {
        setLayout(null);
        setTitle("Ejercicio 6");
        setSize(300, 200);

        txt1.setBounds(20, 20, 100, 25);
        txt2.setBounds(20, 60, 100, 25);
        btnConcatena.setBounds(20, 100, 100, 25);
        etiTexto.setBounds(20, 140, 200, 20);

        add(txt1);
        add(txt2);
        add(btnConcatena);
        add(etiTexto);

        btnConcatena.addActionListener(e -> {
            etiTexto.setText("Texto: " + txt1.getText() + txt2.getText());
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
