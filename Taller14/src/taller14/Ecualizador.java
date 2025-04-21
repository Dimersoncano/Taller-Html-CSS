/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller14;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author zDhim
 */
public class Ecualizador extends JFrame {
    
    // Componentes
    private JSlider desFrecuencia1, desFrecuencia2, desFrecuencia3, desFrecuencia4, desFrecuencia5;
    private JCheckBox chkFrecuencia1, chkFrecuencia2, chkFrecuencia3, chkFrecuencia4, chkFrecuencia5;
    private JLabel etiFrecuencia1, etiFrecuencia2, etiFrecuencia3, etiFrecuencia4, etiFrecuencia5;
    private JRadioButton optPelicula, optConcierto, optPlano;
    private ButtonGroup grupoEcualizacion;
    
    public Ecualizador() {
        // Configuración de la ventana
        setTitle("Ecualizador");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8, 2, 10, 10));
        
        // Inicialización de los componentes
        etiFrecuencia1 = new JLabel("Frecuencia 1: 5");
        etiFrecuencia2 = new JLabel("Frecuencia 2: 5");
        etiFrecuencia3 = new JLabel("Frecuencia 3: 5");
        etiFrecuencia4 = new JLabel("Frecuencia 4: 5");
        etiFrecuencia5 = new JLabel("Frecuencia 5: 5");
        
        desFrecuencia1 = createSlider();
        desFrecuencia2 = createSlider();
        desFrecuencia3 = createSlider();
        desFrecuencia4 = createSlider();
        desFrecuencia5 = createSlider();
        
        chkFrecuencia1 = createCheckBox(desFrecuencia1);
        chkFrecuencia2 = createCheckBox(desFrecuencia2);
        chkFrecuencia3 = createCheckBox(desFrecuencia3);
        chkFrecuencia4 = createCheckBox(desFrecuencia4);
        chkFrecuencia5 = createCheckBox(desFrecuencia5);
        
        grupoEcualizacion = new ButtonGroup();
        optPelicula = new JRadioButton("Película");
        optConcierto = new JRadioButton("Concierto");
        optPlano = new JRadioButton("Plano", true);  // Por defecto, Plano activado
        
        grupoEcualizacion.add(optPelicula);
        grupoEcualizacion.add(optConcierto);
        grupoEcualizacion.add(optPlano);
        
        // Configuración del panel de ecualización
        JPanel panelEcualizacion = new JPanel();
        panelEcualizacion.setBorder(BorderFactory.createTitledBorder("Ecualización Predefinida"));
        panelEcualizacion.add(optPelicula);
        panelEcualizacion.add(optConcierto);
        panelEcualizacion.add(optPlano);
        
        // Agregar componentes a la ventana
        add(etiFrecuencia1);
        add(desFrecuencia1);
        add(chkFrecuencia1);
        
        add(etiFrecuencia2);
        add(desFrecuencia2);
        add(chkFrecuencia2);
        
        add(etiFrecuencia3);
        add(desFrecuencia3);
        add(chkFrecuencia3);
        
        add(etiFrecuencia4);
        add(desFrecuencia4);
        add(chkFrecuencia4);
        
        add(etiFrecuencia5);
        add(desFrecuencia5);
        add(chkFrecuencia5);
        
        add(panelEcualizacion);
        
        // Acción cuando se selecciona una opción de ecualización
        optPelicula.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                desFrecuencia1.setValue(2);
                desFrecuencia2.setValue(5);
                desFrecuencia3.setValue(8);
                desFrecuencia4.setValue(5);
                desFrecuencia5.setValue(2);
            }
        });
        
        optConcierto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                desFrecuencia1.setValue(9);
                desFrecuencia2.setValue(5);
                desFrecuencia3.setValue(1);
                desFrecuencia4.setValue(5);
                desFrecuencia5.setValue(9);
            }
        });
        
        optPlano.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                desFrecuencia1.setValue(5);
                desFrecuencia2.setValue(5);
                desFrecuencia3.setValue(5);
                desFrecuencia4.setValue(5);
                desFrecuencia5.setValue(5);
            }
        });
        
        // Configurar valores iniciales
        desFrecuencia1.setValue(5);
        desFrecuencia2.setValue(5);
        desFrecuencia3.setValue(5);
        desFrecuencia4.setValue(5);
        desFrecuencia5.setValue(5);
    }
    
    private JSlider createSlider() {
        JSlider slider = new JSlider(0, 10, 5);
        slider.setMajorTickSpacing(2);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        
        slider.addChangeListener(e -> {
            JSlider source = (JSlider) e.getSource();
            int value = source.getValue();
            if (source == desFrecuencia1) {
                etiFrecuencia1.setText("Frecuencia 1: " + value);
            } else if (source == desFrecuencia2) {
                etiFrecuencia2.setText("Frecuencia 2: " + value);
            } else if (source == desFrecuencia3) {
                etiFrecuencia3.setText("Frecuencia 3: " + value);
            } else if (source == desFrecuencia4) {
                etiFrecuencia4.setText("Frecuencia 4: " + value);
            } else if (source == desFrecuencia5) {
                etiFrecuencia5.setText("Frecuencia 5: " + value);
            }
        });
        
        return slider;
    }
    
    private JCheckBox createCheckBox(JSlider slider) {
        JCheckBox checkBox = new JCheckBox("Bloquear");
        checkBox.addActionListener(e -> {
            slider.setEnabled(!checkBox.isSelected());
        });
        return checkBox;
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Ecualizador().setVisible(true);
        });
    }
}
