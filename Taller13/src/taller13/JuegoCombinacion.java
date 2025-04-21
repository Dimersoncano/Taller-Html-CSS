/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller13;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author zDhim
 */
public class JuegoCombinacion extends JFrame {

    // Componentes de la interfaz
    private JSpinner spiCentenas, spiDecenas, spiUnidades;
    private JButton btnAbrir;
    private JLabel etiResultado;

    public JuegoCombinacion() {
        // Configuración de la ventana principal
        setTitle("Juego de Combinación");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 5, 5));

        // Crear los JSpinners para centenas, decenas y unidades
        spiCentenas = new JSpinner(new SpinnerNumberModel(0, 0, 9, 1));
        spiDecenas = new JSpinner(new SpinnerNumberModel(0, 0, 9, 1));
        spiUnidades = new JSpinner(new SpinnerNumberModel(0, 0, 9, 1));

        // Crear el botón para abrir la caja
        btnAbrir = new JButton("Abrir");

        // Crear la etiqueta para mostrar el resultado
        etiResultado = new JLabel("Resultado: ", SwingConstants.CENTER);
        etiResultado.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Añadir los componentes a la ventana
        add(new JLabel("Centenas:"));
        add(spiCentenas);
        
        add(new JLabel("Decenas:"));
        add(spiDecenas);
        
        add(new JLabel("Unidades:"));
        add(spiUnidades);
        
        add(btnAbrir);
        add(etiResultado);

        // Agregar el ActionListener al botón
        btnAbrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirCaja();
            }
        });
    }

    // Método para verificar la combinación y mostrar el resultado
    private void abrirCaja() {
        // Obtener los valores de los JSpinners
        int centenas = Integer.parseInt(spiCentenas.getValue().toString());
        int decenas = Integer.parseInt(spiDecenas.getValue().toString());
        int unidades = Integer.parseInt(spiUnidades.getValue().toString());

        // Calcular el número
        int numero = centenas * 100 + decenas * 10 + unidades;

        // Comprobar la combinación
        if (numero == 246) {
            etiResultado.setText("Caja Abierta");
        } else if (numero < 246) {
            etiResultado.setText("El número secreto es mayor");
        } else {
            etiResultado.setText("El número secreto es menor");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JuegoCombinacion().setVisible(true);
            }
        });
    }
}
