package taller1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 
 * @author zDhim
 */
public class Ejercicio2 extends JFrame {
    JTextField txtTexto;
    JLabel labelTexto1, labelTexto2;
    JButton btnTransferir1, btnTransferir2;

    public Ejercicio2() {
        setLayout(new BorderLayout());
        setTitle("Ejercicio 2");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel principal con un layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));
        add(panel, BorderLayout.CENTER);

        // Campo de texto
        txtTexto = new JTextField();
        panel.add(txtTexto);

        // Etiquetas de texto
        labelTexto1 = new JLabel("", SwingConstants.CENTER);
        labelTexto1.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(labelTexto1);

        labelTexto2 = new JLabel("", SwingConstants.CENTER);
        labelTexto2.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(labelTexto2);

        // Botones para traspasar el texto
        JPanel botonesPanel = new JPanel();
        botonesPanel.setLayout(new GridLayout(1, 2, 10, 0));

        btnTransferir1 = new JButton("Traspasa 1");
        btnTransferir1.addActionListener(e -> labelTexto1.setText(txtTexto.getText()));

        btnTransferir2 = new JButton("Traspasa 2");
        btnTransferir2.addActionListener(e -> labelTexto2.setText(txtTexto.getText()));

        botonesPanel.add(btnTransferir1);
        botonesPanel.add(btnTransferir2);

        add(botonesPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new Ejercicio2().setVisible(true);
    }
}

