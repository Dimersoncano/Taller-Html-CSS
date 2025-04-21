package taller1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 
 * @author zDhim
 */
public class Ejercicio4 extends JFrame {
    JTextField txtNombre, txtCiudad;
    JLabel labelFrase;
    JButton btnAceptar, btnDesactivar, btnActivar;

    public Ejercicio4() {
        setLayout(new BorderLayout());
        setTitle("Ejercicio 4");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel principal con un layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));
        add(panel, BorderLayout.CENTER);

        // Campo de texto para el nombre
        txtNombre = new JTextField();
        panel.add(txtNombre);

        // Campo de texto para la ciudad
        txtCiudad = new JTextField();
        panel.add(txtCiudad);

        // Etiqueta para mostrar la frase
        labelFrase = new JLabel("", SwingConstants.CENTER);
        labelFrase.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(labelFrase);

        // Panel de botones
        JPanel botonesPanel = new JPanel();
        botonesPanel.setLayout(new GridLayout(1, 3, 10, 0));

        // Botones
        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(e -> {
            String nombre = txtNombre.getText();
            String ciudad = txtCiudad.getText();
            labelFrase.setText("Usted se llama " + nombre + " y vive en " + ciudad + ".");
        });

        btnDesactivar = new JButton("Desactivar");
        btnDesactivar.addActionListener(e -> {
            txtNombre.setEnabled(false);
            txtCiudad.setEnabled(false);
        });

        btnActivar = new JButton("Activar");
        btnActivar.addActionListener(e -> {
            txtNombre.setEnabled(true);
            txtCiudad.setEnabled(true);
        });

        botonesPanel.add(btnAceptar);
        botonesPanel.add(btnDesactivar);
        botonesPanel.add(btnActivar);

        add(botonesPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new Ejercicio4().setVisible(true);
    }
}
