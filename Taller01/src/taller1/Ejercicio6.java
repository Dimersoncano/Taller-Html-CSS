package taller1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 
 * @author zDhim
 */
public class Ejercicio6 extends JFrame implements ActionListener, MouseListener {
    JLabel etiNombre;
    JButton btnEsquina, btnCentro, btnAgrandar, btnAchicar;
    int etiquetaAncho = 100, etiquetaAlto = 30;

    public Ejercicio6() {
        setTitle("Ejercicio 6");
        setSize(400, 400);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Configuración de la etiqueta
        etiNombre = new JLabel("Tu Nombre", SwingConstants.CENTER);
        etiNombre.setOpaque(true);
        etiNombre.setBackground(Color.CYAN);
        etiNombre.setBounds(150, 150, etiquetaAncho, etiquetaAlto);

        // Crear botones
        btnEsquina = new JButton("Esquina");
        btnCentro = new JButton("Centro");
        btnAgrandar = new JButton("Agrandar");
        btnAchicar = new JButton("Achicar");

        // Posicionar botones
        btnEsquina.setBounds(20, 300, 100, 30);
        btnCentro.setBounds(130, 300, 100, 30);
        btnAgrandar.setBounds(240, 300, 100, 30);
        btnAchicar.setBounds(130, 340, 100, 30);

        // Añadir componentes a la ventana
        add(etiNombre);
        add(btnEsquina);
        add(btnCentro);
        add(btnAgrandar);
        add(btnAchicar);

        // Añadir listeners a los botones
        btnEsquina.addActionListener(this);
        btnCentro.addActionListener(this);
        btnAgrandar.addActionListener(this);
        btnAchicar.addActionListener(this);

        // Añadir listeners a los botones para cambiar su tamaño al pasar el mouse
        btnEsquina.addMouseListener(this);
        btnCentro.addMouseListener(this);
        btnAgrandar.addMouseListener(this);
        btnAchicar.addMouseListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnEsquina) {
            etiNombre.setLocation(0, 0);
        } else if (e.getSource() == btnCentro) {
            etiNombre.setLocation(getWidth() / 2 - etiquetaAncho / 2, getHeight() / 2 - etiquetaAlto / 2 - 50);
        } else if (e.getSource() == btnAgrandar) {
            etiquetaAncho += 20;
            etiquetaAlto += 10;
            etiNombre.setSize(etiquetaAncho, etiquetaAlto);
        } else if (e.getSource() == btnAchicar) {
            etiquetaAncho = Math.max(40, etiquetaAncho - 20);
            etiquetaAlto = Math.max(20, etiquetaAlto - 10);
            etiNombre.setSize(etiquetaAncho, etiquetaAlto);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JButton btn = (JButton) e.getSource();
        btn.setSize(120, 40);  // Cambiar tamaño del botón al entrar el mouse
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JButton btn = (JButton) e.getSource();
        btn.setSize(100, 30);  // Restaurar tamaño del botón al salir el mouse
    }

    @Override public void mouseClicked(MouseEvent e) {}
    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}

    public static void main(String[] args) {
        new Ejercicio6();
    }
}
