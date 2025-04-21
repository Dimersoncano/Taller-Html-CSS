package taller1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 
 * @author zDhim
 */
public class Ejercicio3 extends JFrame {
    JTextField txtTexto;
    JLabel labelTexto;
    JButton btnVaciar;

    public Ejercicio3() {
        setLayout(new BorderLayout());
        setTitle("Ejercicio 3");
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

        // Etiqueta de texto
        labelTexto = new JLabel("", SwingConstants.CENTER);
        labelTexto.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(labelTexto);

        // Botón para vaciar los campos
        btnVaciar = new JButton("Vaciar");
        btnVaciar.addActionListener(e -> {
            txtTexto.setText("");
            labelTexto.setText("");
        });
        add(btnVaciar, BorderLayout.SOUTH);

        // KeyListener para actualizar el texto de la etiqueta
        txtTexto.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                labelTexto.setText(txtTexto.getText());
            }
        });
    }

    public static void main(String[] args) {
        new Ejercicio3().setVisible(true);
    }
}
