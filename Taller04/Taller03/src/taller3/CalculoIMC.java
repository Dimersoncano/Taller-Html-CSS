package taller3;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author zDhim
 */
public class CalculoIMC extends JFrame {

    // Componentes de la interfaz
    JTextField txtPeso = new JTextField();
    JTextField txtTalla = new JTextField();
    JLabel etiIMC = new JLabel("IMC:");
    JButton btnCalcular = new JButton("Calcular");
    JButton btnLimpiar = new JButton("Limpiar");

    public CalculoIMC() {
        // Configuración de la ventana
        setLayout(null);
        setTitle("Cálculo IMC");
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Posición de los componentes
        txtPeso.setBounds(50, 30, 200, 25);     // Peso en kg
        txtTalla.setBounds(50, 60, 200, 25);    // Talla en metros
        btnCalcular.setBounds(50, 100, 90, 30); // Botón para calcular
        btnLimpiar.setBounds(160, 100, 90, 30); // Botón para limpiar
        etiIMC.setBounds(50, 150, 200, 30);     // Muestra el resultado del IMC

        // Agregamos los componentes al JFrame
        add(txtPeso);
        add(txtTalla);
        add(btnCalcular);
        add(btnLimpiar);
        add(etiIMC);

        // Acción del botón Calcular
        btnCalcular.addActionListener(e -> {
            try {
                double peso = Double.parseDouble(txtPeso.getText());
                double talla = Double.parseDouble(txtTalla.getText());
                double imc = peso / (talla * talla); // Fórmula del IMC
                etiIMC.setText("IMC: " + String.format("%.2f", imc));

                // Clasificación del IMC
                String conclusion;
                if (imc < 18) conclusion = "Anorexia";
                else if (imc < 20) conclusion = "Delgadez";
                else if (imc < 27) conclusion = "Normalidad";
                else if (imc < 30) conclusion = "Obesidad (grado 1)";
                else if (imc < 35) conclusion = "Obesidad (grado 2)";
                else if (imc < 40) conclusion = "Obesidad (grado 3)";
                else conclusion = "Obesidad mórbida";

                JOptionPane.showMessageDialog(null, "Su IMC indica que tiene " + conclusion);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ingrese valores válidos");
            }
        });

        // Acción del botón Limpiar
        btnLimpiar.addActionListener(e -> {
            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea borrar los datos?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                txtPeso.setText("");
                txtTalla.setText("");
                etiIMC.setText("IMC:");
            }
        });
    }

    // Método principal
    public static void main(String[] args) {
        new CalculoIMC().setVisible(true);
    }
}
