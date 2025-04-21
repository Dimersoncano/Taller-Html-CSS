package taller4;

import javax.swing.*;
import java.awt.*;

public class Ejercicio2 extends JFrame {

    JTextField txtFrase, txtSubcadena;
    JLabel lblInicio, lblFin, lblAntes, lblDespues;
    JButton btnAnalizar;

    public Ejercicio2() {
        setTitle("🔍 Analizador de Subcadena");
        setSize(550, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(250, 250, 255));

        JLabel lblTitulo = new JLabel("Análisis de una subcadena dentro de una frase", JLabel.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTitulo.setBounds(30, 10, 480, 30);
        add(lblTitulo);

        // Campo para frase
        txtFrase = new JTextField();
        txtFrase.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtFrase.setBounds(30, 50, 480, 30);
        txtFrase.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        add(txtFrase);

        // Campo para subcadena
        txtSubcadena = new JTextField();
        txtSubcadena.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtSubcadena.setBounds(30, 95, 200, 30);
        txtSubcadena.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        add(txtSubcadena);

        // Botón
        btnAnalizar = new JButton("Analizar");
        btnAnalizar.setBounds(250, 95, 120, 30);
        btnAnalizar.setBackground(new Color(100, 149, 237));
        btnAnalizar.setForeground(Color.WHITE);
        btnAnalizar.setFocusPainted(false);
        btnAnalizar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        add(btnAnalizar);

        // Etiquetas de resultado
        lblInicio = new JLabel("Posición inicial: ");
        lblFin = new JLabel("Posición final: ");
        lblAntes = new JLabel("Texto anterior: ");
        lblDespues = new JLabel("Texto posterior: ");

        JLabel[] etiquetas = {lblInicio, lblFin, lblAntes, lblDespues};
        int y = 150;
        for (JLabel lbl : etiquetas) {
            lbl.setBounds(30, y, 480, 30);
            lbl.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            add(lbl);
            y += 35;
        }

        btnAnalizar.addActionListener(e -> {
            String frase = txtFrase.getText().trim();
            String palabra = txtSubcadena.getText().trim();

            if (frase.isEmpty() || palabra.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, complete ambos campos.");
                return;
            }

            int inicio = frase.indexOf(palabra);
            int fin = frase.lastIndexOf(palabra);

            if (inicio == -1) {
                JOptionPane.showMessageDialog(this, "❌ La subcadena no se encuentra en la frase.");
                lblInicio.setText("Posición inicial: ");
                lblFin.setText("Posición final: ");
                lblAntes.setText("Texto anterior: ");
                lblDespues.setText("Texto posterior: ");
            } else {
                lblInicio.setText("Posición inicial: " + inicio);
                lblFin.setText("Posición final: " + fin);
                lblAntes.setText("Texto anterior: " + frase.substring(0, inicio));
                lblDespues.setText("Texto posterior: " + frase.substring(fin + palabra.length()));
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ejercicio2().setVisible(true));
    }
}
