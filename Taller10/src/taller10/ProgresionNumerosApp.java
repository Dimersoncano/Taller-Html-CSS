/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller10;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author zDhim
 */
public class ProgresionNumerosApp extends JFrame {
    private JComboBox<Integer> cboProgresion;
    private JTextField txtInicio, txtFin, txtIntervalo;
    private JButton btnRellenar, btnVaciar;
    private JLabel etiResultado;

    public ProgresionNumerosApp() {
        // Configuración de la ventana principal
        setTitle("Progresión de Números");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // Componentes
        cboProgresion = new JComboBox<>();
        txtInicio = new JTextField(10);
        txtFin = new JTextField(10);
        txtIntervalo = new JTextField(10);
        btnRellenar = new JButton("Rellenar");
        btnVaciar = new JButton("Vaciar");
        etiResultado = new JLabel("Resultado: ");
        etiResultado.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Añadir componentes a la ventana
        add(new JLabel("Inicio:"));
        add(txtInicio);
        add(new JLabel("Fin:"));
        add(txtFin);
        add(new JLabel("Intervalo:"));
        add(txtIntervalo);
        add(btnRellenar);
        add(btnVaciar);
        add(cboProgresion);
        add(etiResultado);

        // Acción para el botón Rellenar
        btnRellenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int inicio = Integer.parseInt(txtInicio.getText());
                    int fin = Integer.parseInt(txtFin.getText());
                    int intervalo = Integer.parseInt(txtIntervalo.getText());

                    // Verificar si los valores son válidos
                    if (inicio >= fin) {
                        JOptionPane.showMessageDialog(null, "El número inicial debe ser menor que el número final.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Llenar el combo con los números en la progresión
                    DefaultComboBoxModel<Integer> model = new DefaultComboBoxModel<>();
                    for (int i = inicio; i <= fin; i += intervalo) {
                        model.addElement(i);
                    }
                    cboProgresion.setModel(model);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese números válidos en los cuadros de texto.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Acción para el botón Vaciar
        btnVaciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cboProgresion.setModel(new DefaultComboBoxModel<>());
                txtInicio.setText("");
                txtFin.setText("");
                txtIntervalo.setText("");
                etiResultado.setText("Resultado: ");
            }
        });

        // Acción para seleccionar un número de la progresión
        cboProgresion.addActionListener(e -> {
            Integer seleccionado = (Integer) cboProgresion.getSelectedItem();
            if (seleccionado != null) {
                etiResultado.setText("Resultado: " + seleccionado);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProgresionNumerosApp().setVisible(true);
            }
        });
    }
}
