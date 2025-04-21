/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller7;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author zDhim
 */
public class Ejercicio1 extends JFrame {
    // Elementos de la interfaz
    private JTextField txtTitulo, txtPosicionX, txtPosicionY;
    private JButton btnCambiarTitulo, btnMaximizar, btnMinimizar, btnRestaurar, btnMover, btnCentrar;
    private JButton btnEstiloJava, btnEstiloWindows, btnRojo, btnVerde, btnAzul;
    
    public Ejercicio1() {
        setTitle("Programa de Ejercicio 1");
        setLayout(new FlowLayout());
        setSize(400, 300);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        // Solicitar contraseña al inicio
        String password = JOptionPane.showInputDialog("Ingrese la contraseña:");
        if (!password.equals("1234")) {  // Contraseña correcta: "1234"
            JOptionPane.showMessageDialog(this, "Contraseña incorrecta. El programa se cerrará.");
            System.exit(0);
        }
        
        // Inicialización de los componentes
        txtTitulo = new JTextField(20);
        add(txtTitulo);
        
        btnCambiarTitulo = new JButton("Cambiar Título");
        add(btnCambiarTitulo);
        
        btnMaximizar = new JButton("Maximizar");
        add(btnMaximizar);
        
        btnMinimizar = new JButton("Minimizar");
        add(btnMinimizar);
        
        btnRestaurar = new JButton("Restaurar");
        add(btnRestaurar);
        
        txtPosicionX = new JTextField(5);
        add(txtPosicionX);
        
        txtPosicionY = new JTextField(5);
        add(txtPosicionY);
        
        btnMover = new JButton("Mover");
        add(btnMover);
        
        btnCentrar = new JButton("Centrar");
        add(btnCentrar);
        
        btnEstiloJava = new JButton("Estilo Java");
        add(btnEstiloJava);
        
        btnEstiloWindows = new JButton("Estilo Windows");
        add(btnEstiloWindows);
        
        btnRojo = new JButton("Rojo");
        add(btnRojo);
        
        btnVerde = new JButton("Verde");
        add(btnVerde);
        
        btnAzul = new JButton("Azul");
        add(btnAzul);
        
        // Acción de los botones
        btnCambiarTitulo.addActionListener(e -> {
            setTitle(txtTitulo.getText());
        });
        
        btnMaximizar.addActionListener(e -> setExtendedState(JFrame.MAXIMIZED_BOTH));
        
        btnMinimizar.addActionListener(e -> setState(JFrame.ICONIFIED));
        
        btnRestaurar.addActionListener(e -> setExtendedState(JFrame.NORMAL));
        
        btnMover.addActionListener(e -> {
            try {
                int x = Integer.parseInt(txtPosicionX.getText());
                int y = Integer.parseInt(txtPosicionY.getText());
                setLocation(x, y);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Las posiciones deben ser números válidos.");
            }
        });
        
        btnCentrar.addActionListener(e -> setLocationRelativeTo(null));
        
        btnEstiloJava.addActionListener(e -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Ejercicio1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(Ejercicio1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Ejercicio1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(Ejercicio1.class.getName()).log(Level.SEVERE, null, ex);
            }
            SwingUtilities.updateComponentTreeUI(this);
        });
        
        btnEstiloWindows.addActionListener(e -> {
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                SwingUtilities.updateComponentTreeUI(this);
            } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                JOptionPane.showMessageDialog(this, "No se pudo aplicar el estilo Windows.");
            }
        });
        
        btnRojo.addActionListener(e -> getContentPane().setBackground(Color.RED));
        
        btnVerde.addActionListener(e -> getContentPane().setBackground(Color.GREEN));
        
        btnAzul.addActionListener(e -> getContentPane().setBackground(Color.BLUE));
        
        // Confirmación al salir del programa
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                int option = JOptionPane.showConfirmDialog(null, "¿Desea salir del programa?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ejercicio1();
    }
}
