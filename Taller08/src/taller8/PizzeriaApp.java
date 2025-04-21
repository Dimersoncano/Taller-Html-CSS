/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller8;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author zDhim
 */
public class PizzeriaApp extends JFrame {
    private JCheckBox chkBacon, chkAnchoas, chkCebolla, chkPimiento;
    private JRadioButton optPequenia, optMediana, optFamiliar;
    private JButton btnTotal;
    private JLabel etiResultado;
    private ButtonGroup sizeGroup;

    public PizzeriaApp() {
        // Configuración de la ventana principal
        setTitle("Pizzería Java");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // Panel de ingredientes
        JPanel panelIngredientes = new JPanel();
        panelIngredientes.setBorder(BorderFactory.createTitledBorder("Ingredientes"));
        panelIngredientes.setLayout(new BoxLayout(panelIngredientes, BoxLayout.Y_AXIS));

        chkBacon = new JCheckBox("Bacon");
        chkAnchoas = new JCheckBox("Anchoas");
        chkCebolla = new JCheckBox("Cebolla");
        chkPimiento = new JCheckBox("Pimiento");

        panelIngredientes.add(chkBacon);
        panelIngredientes.add(chkAnchoas);
        panelIngredientes.add(chkCebolla);
        panelIngredientes.add(chkPimiento);

        // Panel de tamaño
        JPanel panelTamaño = new JPanel();
        panelTamaño.setBorder(BorderFactory.createTitledBorder("Tamaño"));
        panelTamaño.setLayout(new BoxLayout(panelTamaño, BoxLayout.Y_AXIS));

        optPequenia = new JRadioButton("Pequeña");
        optMediana = new JRadioButton("Mediana");
        optFamiliar = new JRadioButton("Familiar", true);  // Opción por defecto: Familiar

        sizeGroup = new ButtonGroup();
        sizeGroup.add(optPequenia);
        sizeGroup.add(optMediana);
        sizeGroup.add(optFamiliar);

        panelTamaño.add(optPequenia);
        panelTamaño.add(optMediana);
        panelTamaño.add(optFamiliar);

        // Botón Total
        btnTotal = new JButton("Total");

        // Etiqueta Resultado
        etiResultado = new JLabel("Precio: ");
        etiResultado.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Añadir componentes al JFrame
        add(panelIngredientes);
        add(panelTamaño);
        add(btnTotal);
        add(etiResultado);

        // Acción del botón Total
        btnTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double total = 0;

                // Determinar el precio base de la pizza
                if (optPequenia.isSelected()) {
                    total = 7;
                } else if (optMediana.isSelected()) {
                    total = 9;
                } else if (optFamiliar.isSelected()) {
                    total = 11;
                }

                // Añadir precio de los ingredientes seleccionados
                if (chkBacon.isSelected()) {
                    total += 1.50;
                }
                if (chkAnchoas.isSelected()) {
                    total += 1.80;
                }
                if (chkCebolla.isSelected()) {
                    total += 1.00;
                }
                if (chkPimiento.isSelected()) {
                    total += 1.20;
                }

                // Mostrar el resultado en la etiqueta
                etiResultado.setText("Precio: " + total + " €");
            }
        });

        // Configuración inicial del cuadro de diálogo de bienvenida
        JOptionPane.showMessageDialog(this, "Pizzería Java\nProgramador: Tu Nombre");

        // Confirmar al cerrar el programa
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent we) {
                int opcion = JOptionPane.showConfirmDialog(null, "¿Desea salir del programa?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PizzeriaApp().setVisible(true);
            }
        });
    }
}
