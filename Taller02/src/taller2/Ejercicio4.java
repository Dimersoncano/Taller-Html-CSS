/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller2;
import javax.swing.*;
/**
 *
 * @author zDhim
 */
public class Ejercicio4 extends JFrame {
    JTextField txtBase = new JTextField();
    JTextField txtExponente = new JTextField();
    JLabel etiResultado = new JLabel("Resultado:");
    JButton btnCalcular = new JButton("Calcular");

    public Ejercicio4() {
        setLayout(null);
        setTitle("Ejercicio 4");
        setSize(300, 200);

        txtBase.setBounds(20, 20, 100, 25);
        txtExponente.setBounds(20, 60, 100, 25);
        btnCalcular.setBounds(20, 100, 100, 25);
        etiResultado.setBounds(20, 140, 200, 20);

        add(txtBase);
        add(txtExponente);
        add(btnCalcular);
        add(etiResultado);

        btnCalcular.addActionListener(e -> {
            double base = Double.parseDouble(txtBase.getText());
            double exp = Double.parseDouble(txtExponente.getText());
            double res = Math.pow(base, exp);
            etiResultado.setText("Resultado: " + res);
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
