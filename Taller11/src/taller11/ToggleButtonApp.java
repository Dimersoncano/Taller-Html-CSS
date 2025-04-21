/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller11;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author zDhim
 */
public class ToggleButtonApp extends JFrame {
    private JToggleButton botonUno, botonDos, botonTres, botonCuatro, botonCinco, botonSeis;
    private JButton btnDesactivarTodos, btnActivarTodos, btnTotal;
    private JLabel etiResultado;

    public ToggleButtonApp() {
        // Configuración de la ventana principal
        setTitle("Toggle Buttons y Acciones");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // Crear los botones JToggleButton numerados
        botonUno = new JToggleButton("1");
        botonDos = new JToggleButton("2");
        botonTres = new JToggleButton("3");
        botonCuatro = new JToggleButton("4");
        botonCinco = new JToggleButton("5");
        botonSeis = new JToggleButton("6");

        // Crear los botones normales
        btnDesactivarTodos = new JButton("Desactivar Todos");
        btnActivarTodos = new JButton("Activar Todos");
        btnTotal = new JButton("Total");

        // Crear la etiqueta con borde
        etiResultado = new JLabel("Resultado: 0");
        etiResultado.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Añadir los componentes a la ventana
        add(botonUno);
        add(botonDos);
        add(botonTres);
        add(botonCuatro);
        add(botonCinco);
        add(botonSeis);
        add(btnDesactivarTodos);
        add(btnActivarTodos);
        add(btnTotal);
        add(etiResultado);

        // Acción para el botón "Total"
        btnTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int suma = 0;

                // Verificar qué botones están seleccionados y sumar sus valores
                if (botonUno.isSelected()) suma += 1;
                if (botonDos.isSelected()) suma += 2;
                if (botonTres.isSelected()) suma += 3;
                if (botonCuatro.isSelected()) suma += 4;
                if (botonCinco.isSelected()) suma += 5;
                if (botonSeis.isSelected()) suma += 6;

                // Mostrar la suma en la etiqueta
                etiResultado.setText("Resultado: " + suma);
            }
        });

        // Acción para el botón "Desactivar Todos"
        btnDesactivarTodos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Desactivar todos los botones
                botonUno.setSelected(false);
                botonDos.setSelected(false);
                botonTres.setSelected(false);
                botonCuatro.setSelected(false);
                botonCinco.setSelected(false);
                botonSeis.setSelected(false);
            }
        });

        // Acción para el botón "Activar Todos"
        btnActivarTodos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Activar todos los botones
                botonUno.setSelected(true);
                botonDos.setSelected(true);
                botonTres.setSelected(true);
                botonCuatro.setSelected(true);
                botonCinco.setSelected(true);
                botonSeis.setSelected(true);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ToggleButtonApp().setVisible(true);
            }
        });
    }
}
