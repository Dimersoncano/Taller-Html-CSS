package taller4;

import javax.swing.*;
import java.awt.*;

public class Ejercicio1 extends JFrame {

    JTextField txtFrase;
    JLabel lblMayusculas, lblMinusculas, lblCaracteres, lblSinEspacios;
    JButton btnAnalizar;

    public Ejercicio1() {
        setTitle("🔍 Analizador de Frase");
        setSize(450, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(240, 248, 255)); // Color suave

        // Etiqueta de título
        JLabel lblTitulo = new JLabel("Ingrese una frase para analizarla", JLabel.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTitulo.setBounds(50, 10, 350, 30);
        add(lblTitulo);

        // Campo de texto
        txtFrase = new JTextField();
        txtFrase.setBounds(50, 50, 340, 30);
        txtFrase.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtFrase.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        add(txtFrase);

        // Botón
        btnAnalizar = new JButton("Analizar");
        btnAnalizar.setBounds(160, 95, 120, 35);
        btnAnalizar.setBackground(new Color(70, 130, 180));
        btnAnalizar.setForeground(Color.WHITE);
        btnAnalizar.setFocusPainted(false);
        btnAnalizar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        add(btnAnalizar);

        // Resultados
        lblMayusculas = new JLabel("Mayúsculas: ");
        lblMinusculas = new JLabel("Minúsculas: ");
        lblCaracteres = new JLabel("Caracteres: ");
        lblSinEspacios = new JLabel("Sin espacios: ");

        JLabel[] etiquetas = {lblMayusculas, lblMinusculas, lblCaracteres, lblSinEspacios};
        int y = 150;
        for (JLabel lbl : etiquetas) {
            lbl.setBounds(50, y, 340, 25);
            lbl.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            add(lbl);
            y += 30;
        }

        // Acción del botón
        btnAnalizar.addActionListener(e -> {
            String frase = txtFrase.getText().trim();
            if (frase.isEmpty()) {
                JOptionPane.showMessageDialog(this, "⚠️ Por favor, ingrese una frase.");
                return;
            }
            lblMayusculas.setText("Mayúsculas: " + frase.toUpperCase());
            lblMinusculas.setText("Minúsculas: " + frase.toLowerCase());
            lblCaracteres.setText("Caracteres: " + frase.length());
            lblSinEspacios.setText("Sin espacios: " + frase.replace(" ", "").length());
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ejercicio1().setVisible(true));
    }
}
