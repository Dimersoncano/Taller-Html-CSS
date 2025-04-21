package taller1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author zDhim
 */
public class Ejercicio1 extends JFrame {
    JLabel labelNombre, labelCiudad;
    JButton btnToggleNombre, btnToggleCiudad;
    JPanel panel;

    public Ejercicio1() {
        setLayout(new BorderLayout());
        setTitle("Ejercicio 1");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel principal con un layout
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));
        add(panel, BorderLayout.CENTER);

        // Nombre
        labelNombre = new JLabel("Tu Nombre", SwingConstants.CENTER);
        labelNombre.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(labelNombre);

        // Ciudad
        labelCiudad = new JLabel("Tu Ciudad", SwingConstants.CENTER);
        labelCiudad.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(labelCiudad);

        // Botones para mostrar u ocultar
        JPanel botonesPanel = new JPanel();
        botonesPanel.setLayout(new GridLayout(1, 2, 10, 0));

        btnToggleNombre = new JButton("Mostrar/Ocultar Nombre");
        btnToggleNombre.addActionListener(e -> toggleVisibility(labelNombre));

        btnToggleCiudad = new JButton("Mostrar/Ocultar Ciudad");
        btnToggleCiudad.addActionListener(e -> toggleVisibility(labelCiudad));

        botonesPanel.add(btnToggleNombre);
        botonesPanel.add(btnToggleCiudad);

        add(botonesPanel, BorderLayout.SOUTH);
    }

    // Método para alternar la visibilidad de los componentes
    private void toggleVisibility(JLabel label) {
        label.setVisible(!label.isVisible());
    }

    public static void main(String[] args) {
        new Ejercicio1().setVisible(true);
    }
}
