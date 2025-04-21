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
public class Ejercicio5 extends JFrame {
    JTextField txtNumero = new JTextField();
    JLabel etiRaiz = new JLabel("Raíz:");

    public Ejercicio5() {
        setLayout(null);
        setTitle("Ejercicio 5");
        setSize(300, 150);

        txtNumero.setBounds(20, 20, 100, 25);
        etiRaiz.setBounds(20, 60, 200, 20);

        add(txtNumero);
        add(etiRaiz);

        txtNumero.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                try {
                    double num = Double.parseDouble(txtNumero.getText());
                    etiRaiz.setText("Raíz: " + Math.sqrt(num));
                } catch (Exception ex) {
                    etiRaiz.setText("Raíz: Error");
                }
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
