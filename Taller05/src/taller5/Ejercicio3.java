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
public class Ejercicio3 extends JFrame {
    JTextField txtPalabra;
    JLabel[] etiquetas = new JLabel[12];
    JButton btnDeclinar;

    public Ejercicio3() {
        setTitle("Declinación Latina");
        setLayout(null);
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        txtPalabra = new JTextField();
        txtPalabra.setBounds(30, 30, 300, 30);
        add(txtPalabra);

        btnDeclinar = new JButton("Declinar");
        btnDeclinar.setBounds(340, 30, 100, 30);
        add(btnDeclinar);

        String[] casos = {
            "NOMINATIVO SINGULAR: ", "NOMINATIVO PLURAL: ",
            "VOCATIVO SINGULAR: ", "VOCATIVO PLURAL: ",
            "ACUSATIVO SINGULAR: ", "ACUSATIVO PLURAL: ",
            "GENITIVO SINGULAR: ", "GENITIVO PLURAL: ",
            "DATIVO SINGULAR: ", "DATIVO PLURAL: ",
            "ABLATIVO SINGULAR: ", "ABLATIVO PLURAL: "
        };

        for (int i = 0; i < etiquetas.length; i++) {
            etiquetas[i] = new JLabel(casos[i]);
            etiquetas[i].setBounds(30, 70 + (i * 25), 400, 25);
            add(etiquetas[i]);
        }

        btnDeclinar.addActionListener(e -> {
            String palabra = txtPalabra.getText();
            if (palabra.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor introduzca una palabra.");
                return;
            }

            if (!palabra.toLowerCase().endsWith("a")) {
                JOptionPane.showMessageDialog(this, "La palabra debe terminar en 'a'.");
                return;
            }

            String base = palabra.substring(0, palabra.length() - 1);
            String mayus = palabra.substring(0, 1).toUpperCase() + palabra.substring(1).toLowerCase();

            etiquetas[0].setText("NOMINATIVO SINGULAR: " + mayus);
            etiquetas[1].setText("NOMINATIVO PLURAL: " + base + "ae");

            etiquetas[2].setText("VOCATIVO SINGULAR: " + mayus);
            etiquetas[3].setText("VOCATIVO PLURAL: " + base + "ae");

            etiquetas[4].setText("ACUSATIVO SINGULAR: " + base + "am");
            etiquetas[5].setText("ACUSATIVO PLURAL: " + base + "as");

            etiquetas[6].setText("GENITIVO SINGULAR: " + base + "ae");
            etiquetas[7].setText("GENITIVO PLURAL: " + base + "arum");

            etiquetas[8].setText("DATIVO SINGULAR: " + base + "ae");
            etiquetas[9].setText("DATIVO PLURAL: " + base + "is");

            etiquetas[10].setText("ABLATIVO SINGULAR: " + mayus);
            etiquetas[11].setText("ABLATIVO PLURAL: " + base + "is");
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Ejercicio3();
    }
}