/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller2;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author zDhim
 */
public class Ejercicio7 extends JFrame {
    JLabel[] etiquetas = new JLabel[10];
    JTextField txtNumero = new JTextField();
    JButton btnBorrar = new JButton("Borrar");

    public Ejercicio7() {
        setLayout(null);
        setTitle("Ejercicio 7");
        setSize(400, 250);

        for (int i = 0; i < 10; i++) {
            etiquetas[i] = new JLabel("" + i);
            etiquetas[i].setBounds(30 + i * 30, 20, 25, 25);
            int finalI = i;
            etiquetas[i].addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) {
                    txtNumero.setText(txtNumero.getText() + finalI);
                }
            });
            add(etiquetas[i]);
        }

        txtNumero.setBounds(20, 60, 200, 25);
        btnBorrar.setBounds(230, 60, 100, 25);

        add(txtNumero);
        add(btnBorrar);

        btnBorrar.addActionListener(e -> txtNumero.setText(""));

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
