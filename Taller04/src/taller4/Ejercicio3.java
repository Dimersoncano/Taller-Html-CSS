package taller4;

import javax.swing.*;
import java.awt.*;

public class Ejercicio3 extends JFrame {
    JTextField txtFrase, txtPalabra1, txtPalabra2, txtPalabra3, txtPalabra4;
    JLabel lblIgual, lblEmpieza, lblTermina, lblContiene;
    JButton btnAnalizar;

    public Ejercicio3() {
        setTitle("Comparar Frase y Palabras");
        setSize(500, 420);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(240, 248, 255)); // Azul muy claro

        Font fuente = new Font("Segoe UI", Font.PLAIN, 14);

        txtFrase = new JTextField();
        txtFrase.setBounds(20, 20, 440, 30);
        txtFrase.setFont(fuente);
        add(txtFrase);

        txtPalabra1 = new JTextField();
        txtPalabra1.setBounds(20, 60, 200, 30);
        txtPalabra1.setFont(fuente);
        add(txtPalabra1);

        txtPalabra2 = new JTextField();
        txtPalabra2.setBounds(20, 100, 200, 30);
        txtPalabra2.setFont(fuente);
        add(txtPalabra2);

        txtPalabra3 = new JTextField();
        txtPalabra3.setBounds(20, 140, 200, 30);
        txtPalabra3.setFont(fuente);
        add(txtPalabra3);

        txtPalabra4 = new JTextField();
        txtPalabra4.setBounds(20, 180, 200, 30);
        txtPalabra4.setFont(fuente);
        add(txtPalabra4);

        btnAnalizar = new JButton("Analizar");
        btnAnalizar.setBounds(250, 100, 120, 35);
        btnAnalizar.setFont(fuente);
        btnAnalizar.setBackground(new Color(100, 149, 237));
        btnAnalizar.setForeground(Color.WHITE);
        btnAnalizar.setFocusPainted(false);
        add(btnAnalizar);

        lblIgual = new JLabel("¿Frase igual a palabra 1?");
        lblIgual.setBounds(20, 240, 450, 20);
        lblIgual.setFont(fuente);
        add(lblIgual);

        lblEmpieza = new JLabel("¿Frase empieza con palabra 2?");
        lblEmpieza.setBounds(20, 270, 450, 20);
        lblEmpieza.setFont(fuente);
        add(lblEmpieza);

        lblTermina = new JLabel("¿Frase termina con palabra 3?");
        lblTermina.setBounds(20, 300, 450, 20);
        lblTermina.setFont(fuente);
        add(lblTermina);

        lblContiene = new JLabel("¿Palabra 4 contenida? ");
        lblContiene.setBounds(20, 330, 450, 20);
        lblContiene.setFont(fuente);
        add(lblContiene);

        btnAnalizar.addActionListener(e -> {
            String frase = txtFrase.getText().trim();
            String p1 = txtPalabra1.getText().trim();
            String p2 = txtPalabra2.getText().trim();
            String p3 = txtPalabra3.getText().trim();
            String p4 = txtPalabra4.getText().trim();

            lblIgual.setText("¿Frase igual a palabra 1? " + frase.equals(p1));
            lblEmpieza.setText("¿Frase empieza con palabra 2? " + frase.startsWith(p2));
            lblTermina.setText("¿Frase termina con palabra 3? " + frase.endsWith(p3));

            if (frase.contains(p4)) {
                int pos = frase.indexOf(p4);
                lblContiene.setText("¿Palabra 4 contenida? Sí, en la posición " + pos);
            } else {
                lblContiene.setText("¿Palabra 4 contenida? No");
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ejercicio3();
    }
}
