package taller3;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author zDhim
 */
public class SueldoTotal extends JFrame {

    JTextField txtSueldoBase = new JTextField();
    JTextField txtMeses = new JTextField();
    JButton btnCalcular = new JButton("Calcular Sueldo Total");
    JLabel etiResultado = new JLabel("Resultado: ");

    public SueldoTotal() {
        // Configuración del JFrame
        setTitle("💼 Sueldo Total");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(245, 245, 245)); // Fondo claro

        // Etiqueta título
        JLabel titulo = new JLabel("Calculadora de Sueldo Total", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        titulo.setBounds(50, 10, 300, 30);
        add(titulo);

        // Campos de entrada
        txtSueldoBase.setBounds(100, 60, 200, 30);
        txtMeses.setBounds(100, 100, 200, 30);
        stylizeTextField(txtSueldoBase);
        stylizeTextField(txtMeses);

        // Botón
        btnCalcular.setBounds(100, 150, 200, 35);
        btnCalcular.setBackground(new Color(33, 150, 243));
        btnCalcular.setForeground(Color.WHITE);
        btnCalcular.setFocusPainted(false);
        btnCalcular.setFont(new Font("Segoe UI", Font.BOLD, 14));

        // Etiqueta resultado
        etiResultado.setBounds(50, 200, 300, 30);
        etiResultado.setHorizontalAlignment(SwingConstants.CENTER);
        etiResultado.setFont(new Font("Segoe UI", Font.BOLD, 14));

        // Agregar componentes
        add(txtSueldoBase);
        add(txtMeses);
        add(btnCalcular);
        add(etiResultado);

        // Acción del botón
        btnCalcular.addActionListener(e -> {
            try {
                double sueldoBase = Double.parseDouble(txtSueldoBase.getText());
                int meses = Integer.parseInt(txtMeses.getText());

                if (sueldoBase <= 0 || meses <= 0) {
                    JOptionPane.showMessageDialog(null, "Ingrese valores positivos.");
                    return;
                }

                String pass = JOptionPane.showInputDialog("Ingrese la contraseña:");

                if (pass != null && pass.equals("1234")) {
                    double total = (sueldoBase - sueldoBase * 0.10) * meses;
                    etiResultado.setText("Resultado: $" + String.format("%.2f", total));
                } else {
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ingrese valores válidos");
            }
        });
    }

    // Método para estilizar los campos de texto
    private void stylizeTextField(JTextField textField) {
        textField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
        textField.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        textField.setBackground(Color.WHITE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SueldoTotal().setVisible(true);
        });
    }
}
