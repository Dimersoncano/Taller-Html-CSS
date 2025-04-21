/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller9;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author zDhim
 * 
 */
public class EnvioProductosApp extends JFrame {
    private JList<String> lstProductos;
    private JTextField txtUnidades;
    private JComboBox<String> cboDestino, cboTipoEnvio;
    private JButton btnCalcular;
    private JLabel etiResultado;

    public EnvioProductosApp() {
        // Configuración de la ventana principal
        setTitle("Calculadora de Envío");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // Lista de productos con sus precios
        String[] productos = {
            "Sistema de Localización - 120",
            "Centro de Control - 60",
            "Modem GSM - 45"
        };
        lstProductos = new JList<>(productos);
        lstProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(lstProductos);

        // Cuadro de texto para unidades
        txtUnidades = new JTextField(10);

        // Combo de destino
        String[] destinos = {"Península", "Canarias", "Extranjero"};
        cboDestino = new JComboBox<>(destinos);

        // Combo de tipo de envío
        String[] tiposEnvio = {"Normal", "Urgente"};
        cboTipoEnvio = new JComboBox<>(tiposEnvio);

        // Botón Calcular
        btnCalcular = new JButton("Calcular");

        // Etiqueta Resultado
        etiResultado = new JLabel("Total: ");
        etiResultado.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Añadir componentes al JFrame
        add(new JLabel("Productos"));
        add(scrollPane);
        add(new JLabel("Unidades"));
        add(txtUnidades);
        add(new JLabel("Destino"));
        add(cboDestino);
        add(new JLabel("Tipo de Envío"));
        add(cboTipoEnvio);
        add(btnCalcular);
        add(etiResultado);

        // Acción del botón Calcular
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el producto seleccionado
                String productoSeleccionado = lstProductos.getSelectedValue();
                if (productoSeleccionado == null) {
                    JOptionPane.showMessageDialog(null, "Por favor, seleccione un producto.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Obtener las unidades ingresadas
                int unidades;
                try {
                    unidades = Integer.parseInt(txtUnidades.getText());
                    if (unidades <= 0) {
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido de unidades.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Obtener el precio del producto seleccionado
                int precioProducto = 0;
                if (productoSeleccionado.contains("Sistema de Localización")) {
                    precioProducto = 120;
                } else if (productoSeleccionado.contains("Centro de Control")) {
                    precioProducto = 60;
                } else if (productoSeleccionado.contains("Modem GSM")) {
                    precioProducto = 45;
                }

                // Obtener el coste del destino seleccionado
                int costeDestino = 0;
                String destino = (String) cboDestino.getSelectedItem();
                if (destino.equals("Península")) {
                    costeDestino = 20;
                } else if (destino.equals("Canarias")) {
                    costeDestino = 25;
                } else if (destino.equals("Extranjero")) {
                    costeDestino = 30;
                }

                // Obtener el coste del tipo de envío seleccionado
                int costeTipoEnvio = 0;
                String tipoEnvio = (String) cboTipoEnvio.getSelectedItem();
                if (tipoEnvio.equals("Normal")) {
                    costeTipoEnvio = 3;
                } else if (tipoEnvio.equals("Urgente")) {
                    costeTipoEnvio = 10;
                }

                // Calcular el total
                double total = (unidades * precioProducto) + costeDestino + costeTipoEnvio;

                // Mostrar el resultado
                etiResultado.setText("Total: " + total + " €");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EnvioProductosApp().setVisible(true);
            }
        });
    }
}
