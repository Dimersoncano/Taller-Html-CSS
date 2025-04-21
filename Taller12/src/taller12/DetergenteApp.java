/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller12;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
/**
 *
 * @author zDhim
 */
public class DetergenteApp extends JFrame {

    // Componentes de la interfaz
    private JSlider deslizadorLitros, deslizadorCalidad, deslizadorDensidad;
    private JLabel etiLitros, etiCalidad, etiDensidad, etiLitrosAgua, etiSales;
    
    public DetergenteApp() {
        // Configuración de la ventana principal
        setTitle("Calculadora de Detergente");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(7, 2, 5, 5));
        
        // Crear los deslizadores (JSlider)
        deslizadorLitros = new JSlider(1, 100, 50);
        deslizadorCalidad = new JSlider(0, 10, 5);
        deslizadorDensidad = new JSlider(50, 200, 100);
        
        // Configuración de los deslizadores
        deslizadorLitros.setMajorTickSpacing(10);
        deslizadorLitros.setMinorTickSpacing(1);
        deslizadorLitros.setPaintTicks(true);
        deslizadorLitros.setPaintLabels(true);
        
        deslizadorCalidad.setMajorTickSpacing(1);
        deslizadorCalidad.setMinorTickSpacing(1);
        deslizadorCalidad.setPaintTicks(true);
        deslizadorCalidad.setPaintLabels(true);
        
        deslizadorDensidad.setMajorTickSpacing(50);
        deslizadorDensidad.setMinorTickSpacing(10);
        deslizadorDensidad.setPaintTicks(true);
        deslizadorDensidad.setPaintLabels(true);

        // Crear las etiquetas
        etiLitros = new JLabel("Litros a fabricar: 50");
        etiCalidad = new JLabel("Calidad: 5");
        etiDensidad = new JLabel("Densidad: 100");
        etiLitrosAgua = new JLabel("Litros de Agua: 0.0");
        etiSales = new JLabel("Sales: 0.0");
        
        // Añadir los componentes a la ventana
        add(new JLabel("Litros a Fabricar:"));
        add(deslizadorLitros);
        add(etiLitros);
        
        add(new JLabel("Calidad:"));
        add(deslizadorCalidad);
        add(etiCalidad);
        
        add(new JLabel("Densidad Deseada:"));
        add(deslizadorDensidad);
        add(etiDensidad);
        
        add(new JLabel("Litros de Agua:"));
        add(etiLitrosAgua);
        
        add(new JLabel("Sales:"));
        add(etiSales);
        
        // Escuchadores de cambios en los deslizadores
        deslizadorLitros.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                actualizarValores();
            }
        });
        
        deslizadorCalidad.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                actualizarValores();
            }
        });
        
        deslizadorDensidad.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                actualizarValores();
            }
        });
    }

    private void actualizarValores() {
        // Obtener los valores de los deslizadores
        int litros = deslizadorLitros.getValue();
        int calidad = deslizadorCalidad.getValue();
        int densidad = deslizadorDensidad.getValue();
        
        // Actualizar las etiquetas con los valores actuales
        etiLitros.setText("Litros a fabricar: " + litros);
        etiCalidad.setText("Calidad: " + calidad);
        etiDensidad.setText("Densidad: " + densidad);
        
        // Calcular los valores de agua y sales
        double litrosAgua = 2 * litros + (double) calidad / densidad;
        double sales = (double) (calidad * litros) / (100 * densidad);
        
        // Mostrar los resultados en las etiquetas correspondientes
        etiLitrosAgua.setText("Litros de Agua: " + String.format("%.2f", litrosAgua));
        etiSales.setText("Sales: " + String.format("%.2f", sales));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DetergenteApp().setVisible(true);
            }
        });
    }
}
