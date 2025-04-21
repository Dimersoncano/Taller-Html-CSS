package taller1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 
 * @author zDhim
 */
public class Ejercicio5 extends JFrame {
    JLabel labelPal1, labelPal2, labelPal3, labelPal4, labelOcultar;

    public Ejercicio5() {
        setLayout(null);
        setTitle("Ejercicio 5");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear etiquetas
        labelPal1 = new JLabel("Palabra 1");
        labelPal2 = new JLabel("Palabra 2");
        labelPal3 = new JLabel("Palabra 3");
        labelPal4 = new JLabel("Palabra 4");
        labelOcultar = new JLabel("Ocultar", SwingConstants.CENTER);

        // Configuración de las posiciones de las etiquetas
        labelPal1.setBounds(50, 50, 100, 30);
        labelPal2.setBounds(150, 50, 100, 30);
        labelPal3.setBounds(50, 100, 100, 30);
        labelPal4.setBounds(150, 100, 100, 30);
        labelOcultar.setBounds(100, 180, 200, 50);
        
        // Estilo de la etiqueta "Ocultar"
        labelOcultar.setOpaque(true);
        labelOcultar.setBackground(Color.LIGHT_GRAY);
        labelOcultar.setFont(new Font("Arial", Font.BOLD, 16));

        // Añadir las etiquetas a la ventana
        add(labelPal1);
        add(labelPal2);
        add(labelPal3);
        add(labelPal4);
        add(labelOcultar);

        // Evento de ocultar y mostrar las palabras al interactuar con "Ocultar"
        labelOcultar.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                labelPal1.setVisible(false);
                labelPal2.setVisible(false);
                labelPal3.setVisible(false);
                labelPal4.setVisible(false);
            }

            public void mouseExited(MouseEvent e) {
                labelPal1.setVisible(true);
                labelPal2.setVisible(true);
                labelPal3.setVisible(true);
                labelPal4.setVisible(true);
            }
        });

        // Hacer visible la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ejercicio5();
    }
}
