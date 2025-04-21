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
public class Ejercicio2 extends JFrame {
    JTextField txtDNI;
    JLabel etiDNI;
    JButton btnPrepararDNI;

    public Ejercicio2() {
        setTitle("Preparar DNI");
        setLayout(null);
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        txtDNI = new JTextField();
        txtDNI.setBounds(30, 30, 300, 30);
        add(txtDNI);

        btnPrepararDNI = new JButton("Preparar DNI");
        btnPrepararDNI.setBounds(120, 70, 150, 30);
        add(btnPrepararDNI);

        etiDNI = new JLabel("DNI: ");
        etiDNI.setBounds(30, 120, 300, 30);
        add(etiDNI);

        btnPrepararDNI.addActionListener(e -> {
            String dni = txtDNI.getText();
            if (dni.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor introduzca un DNI.");
                return;
            }

            String dniPreparado = dni.replaceAll("[^a-zA-Z0-9]", "");
            etiDNI.setText("DNI: " + dniPreparado);
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Ejercicio2();
    }
}
