package taller1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author zDhim
 */
public class Ejercicio7 extends JFrame implements ActionListener {

    JLabel etiTexto;
    JButton btnAzul, btnRojo, btnVerde;
    JButton btnFondoAzul, btnFondoRojo, btnFondoVerde;
    JButton btnTransparente, btnOpaca;

    public Ejercicio7() {
        setTitle("Ejercicio 7 - Colores y Opacidad");
        setSize(450, 300);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Etiqueta de ejemplo
        etiTexto = new JLabel("Texto de ejemplo");
        etiTexto.setBounds(100, 20, 250, 30);
        etiTexto.setOpaque(true);
        etiTexto.setHorizontalAlignment(SwingConstants.CENTER);
        add(etiTexto);

        // Botones para cambiar color del texto
        btnAzul = new JButton("Azul");
        btnAzul.setBounds(20, 70, 100, 30);
        btnAzul.addActionListener(this);
        add(btnAzul);

        btnRojo = new JButton("Rojo");
        btnRojo.setBounds(140, 70, 100, 30);
        btnRojo.addActionListener(this);
        add(btnRojo);

        btnVerde = new JButton("Verde");
        btnVerde.setBounds(260, 70, 100, 30);
        btnVerde.addActionListener(this);
        add(btnVerde);

        // Botones para cambiar color de fondo
        btnFondoAzul = new JButton("Fondo Azul");
        btnFondoAzul.setBounds(20, 120, 120, 30);
        btnFondoAzul.addActionListener(this);
        add(btnFondoAzul);

        btnFondoRojo = new JButton("Fondo Rojo");
        btnFondoRojo.setBounds(150, 120, 120, 30);
        btnFondoRojo.addActionListener(this);
        add(btnFondoRojo);

        btnFondoVerde = new JButton("Fondo Verde");
        btnFondoVerde.setBounds(280, 120, 130, 30);
        btnFondoVerde.addActionListener(this);
        add(btnFondoVerde);

        // Botones para transparencia/opacidad
        btnTransparente = new JButton("Transparente");
        btnTransparente.setBounds(80, 180, 120, 30);
        btnTransparente.addActionListener(this);
        add(btnTransparente);

        btnOpaca = new JButton("Opaca");
        btnOpaca.setBounds(220, 180, 100, 30);
        btnOpaca.addActionListener(this);
        add(btnOpaca);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        // Cambiar color del texto
        if (src == btnAzul) {
            etiTexto.setForeground(Color.BLUE);
        } else if (src == btnRojo) {
            etiTexto.setForeground(Color.RED);
        } else if (src == btnVerde) {
            etiTexto.setForeground(Color.GREEN);

        // Cambiar color de fondo
        } else if (src == btnFondoAzul) {
            etiTexto.setBackground(Color.BLUE);
        } else if (src == btnFondoRojo) {
            etiTexto.setBackground(Color.RED);
        } else if (src == btnFondoVerde) {
            etiTexto.setBackground(Color.GREEN);

        // Cambiar opacidad
        } else if (src == btnTransparente) {
            etiTexto.setOpaque(false);
            etiTexto.repaint();  // Redibuja la etiqueta para aplicar el cambio
        } else if (src == btnOpaca) {
            etiTexto.setOpaque(true);
            etiTexto.repaint();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Ejercicio7().setVisible(true);
        });
    }
}
