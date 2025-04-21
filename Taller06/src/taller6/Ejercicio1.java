/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller6;
import javax.swing.*;
/**
 *
 * @author zDhim
 */
public class Ejercicio1 extends JFrame {
    JTextField txtFrase, txtPosIni, txtPosFin;
    JLabel etiSubcadena;
    JButton btnAnalizar;

    public Ejercicio1() {
        setTitle("Subcadena");
        setLayout(null);
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        txtFrase = new JTextField();
        txtFrase.setBounds(30, 30, 300, 30);
        add(txtFrase);

        txtPosIni = new JTextField();
        txtPosIni.setBounds(30, 70, 100, 30);
        add(txtPosIni);

        txtPosFin = new JTextField();
        txtPosFin.setBounds(140, 70, 100, 30);
        add(txtPosFin);

        btnAnalizar = new JButton("Analizar");
        btnAnalizar.setBounds(250, 70, 100, 30);
        add(btnAnalizar);

        etiSubcadena = new JLabel("Resultado: ");
        etiSubcadena.setBounds(30, 120, 350, 30);
        add(etiSubcadena);

        btnAnalizar.addActionListener(e -> {
            try {
                String frase = txtFrase.getText();
                if (frase.isEmpty()) {
                    throw new Exception("La frase no puede estar vacía.");
                }

                int posIni = Integer.parseInt(txtPosIni.getText());
                int posFin = Integer.parseInt(txtPosFin.getText());

                if (posIni < 0 || posFin > frase.length() || posIni >= posFin) {
                    throw new Exception("Las posiciones deben ser válidas y dentro del rango.");
                }

                String sub = frase.substring(posIni, posFin);
                etiSubcadena.setText("Resultado: " + sub);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Debe ingresar números válidos en las posiciones.\nError: " + ex.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Ejercicio1();
    }
}
