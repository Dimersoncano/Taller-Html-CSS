package taller33;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentaForm extends JFrame {
    private JTextField txtProducto, txtUnidades, txtPrecio, txtFecha, txtFormaPago;
    private JComboBox<Cliente> comboClientes;
    private JComboBox<Comercial> comboComerciales;
    private JButton btnGuardar;

    public VentaForm() {
        setTitle("Formulario de Venta");
        setSize(500, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(245, 250, 255));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        Font fuente = new Font("Segoe UI", Font.PLAIN, 14);

        // Componentes
        JLabel lblProducto = new JLabel("Producto:");
        lblProducto.setFont(fuente);
        txtProducto = new JTextField(20);
        txtProducto.setFont(fuente);

        JLabel lblUnidades = new JLabel("Unidades:");
        lblUnidades.setFont(fuente);
        txtUnidades = new JTextField(20);
        txtUnidades.setFont(fuente);

        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setFont(fuente);
        txtPrecio = new JTextField(20);
        txtPrecio.setFont(fuente);

        JLabel lblFecha = new JLabel("Fecha:");
        lblFecha.setFont(fuente);
        txtFecha = new JTextField(20);
        txtFecha.setFont(fuente);

        JLabel lblFormaPago = new JLabel("Forma de pago:");
        lblFormaPago.setFont(fuente);
        txtFormaPago = new JTextField(20);
        txtFormaPago.setFont(fuente);

        JLabel lblCliente = new JLabel("Cliente:");
        lblCliente.setFont(fuente);
        comboClientes = new JComboBox<>(obtenerClientes());
        comboClientes.setFont(fuente);

        JLabel lblComercial = new JLabel("Comercial:");
        lblComercial.setFont(fuente);
        comboComerciales = new JComboBox<>(obtenerComerciales());
        comboComerciales.setFont(fuente);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(fuente);
        btnGuardar.setBackground(new Color(100, 149, 237));
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFocusPainted(false);

        // Agregar componentes con GridBagLayout
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.WEST;
        add(lblProducto, gbc); gbc.gridx = 1; add(txtProducto, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(lblUnidades, gbc); gbc.gridx = 1; add(txtUnidades, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(lblPrecio, gbc); gbc.gridx = 1; add(txtPrecio, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(lblFecha, gbc); gbc.gridx = 1; add(txtFecha, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(lblFormaPago, gbc); gbc.gridx = 1; add(txtFormaPago, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(lblCliente, gbc); gbc.gridx = 1; add(comboClientes, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(lblComercial, gbc); gbc.gridx = 1; add(comboComerciales, gbc);

        gbc.gridx = 0; gbc.gridy++; gbc.gridwidth = 2; gbc.anchor = GridBagConstraints.CENTER;
        add(btnGuardar, gbc);

        // Evento del botón
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Cliente cliente = (Cliente) comboClientes.getSelectedItem();
                Comercial comercial = (Comercial) comboComerciales.getSelectedItem();

                Venta venta = new Venta(0, txtProducto.getText(), 
                                        Integer.parseInt(txtUnidades.getText()), 
                                        Double.parseDouble(txtPrecio.getText()), 
                                        txtFecha.getText(), txtFormaPago.getText(), 
                                        cliente, comercial);

                venta.guardarVenta();
                JOptionPane.showMessageDialog(null, "Venta guardada correctamente");
            }
        });
    }

    private Cliente[] obtenerClientes() {
        return new Cliente[]{ new Cliente("CIF001", "Juan Perez", "Madrid", "123456789") };
    }

    private Comercial[] obtenerComerciales() {
        return new Comercial[]{ new Comercial(1, "Carlos", "Gómez", "987654321") };
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentaForm().setVisible(true));
    }
}
