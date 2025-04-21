/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller3;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author anton
 */
public class CalculoIMC extends JFrame {
    JTextField txtPeso = new JTextField();
    JTextField txtTalla = new JTextField();
    JLabel etiIMC = new JLabel("IMC:");
    JButton btnCalcular = new JButton("Calcular");
    JButton btnLimpiar = new JButton("Limpiar");

    public CalculoIMC() {
        setLayout(null);
        setTitle("Cálculo IMC");
        setSize(300, 300);

        txtPeso.setBounds(50, 30, 200, 25);
        txtTalla.setBounds(50, 60, 200, 25);
        btnCalcular.setBounds(50, 100, 90, 30);
        btnLimpiar.setBounds(160, 100, 90, 30);
        etiIMC.setBounds(50, 150, 200, 30);

        add(txtPeso);
        add(txtTalla);
        add(btnCalcular);
        add(btnLimpiar);
        add(etiIMC);

        btnCalcular.addActionListener(e -> {
            try {
                double peso = Double.parseDouble(txtPeso.getText());
                double talla = Double.parseDouble(txtTalla.getText());
                double imc = peso / (talla * talla);
                etiIMC.setText("IMC: " + String.format("%.2f", imc));

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

        btnLimpiar.addActionListener(e -> {
            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea borrar los datos?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                txtPeso.setText("");
                txtTalla.setText("");
                etiIMC.setText("IMC:");
            }
        });
    }

    public static void main(String[] args) {
        new CalculoIMC().setVisible(true);
    }
}
