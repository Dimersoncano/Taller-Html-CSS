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
public class TrimestresApp extends JFrame {
    private JList<String> lstMeses;
    private JButton btnRellenar, btnVaciar;
    private JRadioButton optTri1, optTri2, optTri3, optTri4;
    private JLabel etiMes;
    private ButtonGroup grupoTrimestres;

    public TrimestresApp() {
        // Configuración de la ventana principal
        setTitle("Seleccionar Trimestre");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // Cuadro de lista
        lstMeses = new JList<>();
        JScrollPane scrollPane = new JScrollPane(lstMeses);

        // Botones de opción (trimestres)
        optTri1 = new JRadioButton("Trimestre 1");
        optTri2 = new JRadioButton("Trimestre 2");
        optTri3 = new JRadioButton("Trimestre 3");
        optTri4 = new JRadioButton("Trimestre 4");

        // Agrupar los botones de opción
        grupoTrimestres = new ButtonGroup();
        grupoTrimestres.add(optTri1);
        grupoTrimestres.add(optTri2);
        grupoTrimestres.add(optTri3);
        grupoTrimestres.add(optTri4);

        // Panel para los botones de opción
        JPanel panelTrimestres = new JPanel();
        panelTrimestres.setLayout(new GridLayout(4, 1));
        panelTrimestres.add(optTri1);
        panelTrimestres.add(optTri2);
        panelTrimestres.add(optTri3);
        panelTrimestres.add(optTri4);

        // Botones Rellenar y Vaciar
        btnRellenar = new JButton("Rellenar");
        btnVaciar = new JButton("Vaciar");

        // Etiqueta para mostrar el mes seleccionado
        etiMes = new JLabel("Mes: ");
        etiMes.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Añadir componentes a la ventana
        add(new JLabel("Seleccione un Trimestre"));
        add(panelTrimestres);
        add(btnRellenar);
        add(btnVaciar);
        add(scrollPane);
        add(etiMes);

        // Acción para el botón Rellenar
        btnRellenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Verificar el trimestre seleccionado
                DefaultListModel<String> model = new DefaultListModel<>();
                if (optTri1.isSelected()) {
                    model.addElement("Enero");
                    model.addElement("Febrero");
                    model.addElement("Marzo");
                } else if (optTri2.isSelected()) {
                    model.addElement("Abril");
                    model.addElement("Mayo");
                    model.addElement("Junio");
                } else if (optTri3.isSelected()) {
                    model.addElement("Julio");
                    model.addElement("Agosto");
                    model.addElement("Septiembre");
                } else if (optTri4.isSelected()) {
                    model.addElement("Octubre");
                    model.addElement("Noviembre");
                    model.addElement("Diciembre");
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, seleccione un trimestre.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Rellenar la lista con los meses correspondientes
                lstMeses.setModel(model);
            }
        });

        // Acción para el botón Vaciar
        btnVaciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lstMeses.setModel(new DefaultListModel<>());
            }
        });

        // Acción para seleccionar un mes de la lista
        lstMeses.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String mesSeleccionado = lstMeses.getSelectedValue();
                if (mesSeleccionado != null) {
                    etiMes.setText("Mes: " + mesSeleccionado);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TrimestresApp().setVisible(true);
            }
        });
    }
}
