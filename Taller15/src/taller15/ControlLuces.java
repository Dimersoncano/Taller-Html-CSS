/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller15;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author zDhim
 */
public class ControlLuces extends JFrame {
    // Checkboxes para luces
    JCheckBox[][] luces = new JCheckBox[3][3]; // [oficina][tipo luz]
    String[] tipos = {"Principal", "Secundaria", "Seguridad"};

    public ControlLuces() {
        setTitle("Control de Luces de Oficinas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1, 3));

        // Paneles por oficina
        for (int i = 0; i < 3; i++) {
            JPanel panel = new JPanel();
            panel.setBorder(BorderFactory.createTitledBorder("Oficina " + (i + 1)));
            panel.setLayout(new GridLayout(3, 1));

            for (int j = 0; j < 3; j++) {
                luces[i][j] = new JCheckBox(tipos[j]);
                panel.add(luces[i][j]);
            }
            add(panel);
        }

        crearMenu();

        setVisible(true);
    }

    private void crearMenu() {
        JMenuBar barra = new JMenuBar();

        JMenu menuActivacion = new JMenu("Activación");
        JMenu menuInfo = new JMenu("Info");

        // Activar/Desactivar todas
        JMenuItem encenderTodas = new JMenuItem("Encender Todas");
        JMenuItem apagarTodas = new JMenuItem("Apagar Todas");
        encenderTodas.addActionListener(e -> cambiarTodas(true));
        apagarTodas.addActionListener(e -> cambiarTodas(false));
        menuActivacion.add(encenderTodas);
        menuActivacion.add(apagarTodas);

        // Día
        JMenu menuDia = new JMenu("Día");
        for (int i = 0; i < 3; i++) {
            int oficina = i;
            JMenuItem diaOficina = new JMenuItem("Oficina " + (oficina + 1));
            diaOficina.addActionListener(e -> activarDia(oficina));
            menuDia.add(diaOficina);
        }
        JMenuItem diaTodas = new JMenuItem("Todas");
        diaTodas.addActionListener(e -> {
            for (int i = 0; i < 3; i++) activarDia(i);
        });
        menuDia.add(diaTodas);
        menuActivacion.add(menuDia);

        // Noche
        JMenu menuNoche = new JMenu("Noche");
        for (int i = 0; i < 3; i++) {
            int oficina = i;
            JMenuItem nocheOficina = new JMenuItem("Oficina " + (oficina + 1));
            nocheOficina.addActionListener(e -> activarNoche(oficina));
            menuNoche.add(nocheOficina);
        }
        JMenuItem nocheTodas = new JMenuItem("Todas");
        nocheTodas.addActionListener(e -> {
            for (int i = 0; i < 3; i++) activarNoche(i);
        });
        menuNoche.add(nocheTodas);
        menuActivacion.add(menuNoche);

        // Salir
        JMenuItem salir = new JMenuItem("Salir");
        salir.addActionListener(e -> System.exit(0));
        menuActivacion.add(salir);

        // Info
        JMenuItem infoPrincipal = new JMenuItem("Principales");
        infoPrincipal.addActionListener(e -> mostrarInfo(0));
        JMenuItem infoSecundaria = new JMenuItem("Secundarias");
        infoSecundaria.addActionListener(e -> mostrarInfo(1));
        JMenuItem infoSeguridad = new JMenuItem("Seguridad");
        infoSeguridad.addActionListener(e -> mostrarInfo(2));
        JMenuItem acerca = new JMenuItem("Acerca de...");
        acerca.addActionListener(e -> JOptionPane.showMessageDialog(this,
                "Control de Luces v1.0\nProgramado por TuNombre"));

        menuInfo.add(infoPrincipal);
        menuInfo.add(infoSecundaria);
        menuInfo.add(infoSeguridad);
        menuInfo.add(acerca);

        barra.add(menuActivacion);
        barra.add(menuInfo);
        setJMenuBar(barra);
    }

    private void cambiarTodas(boolean estado) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                luces[i][j].setSelected(estado);
    }

    private void activarDia(int oficina) {
        luces[oficina][0].setSelected(true);  // Principal
        luces[oficina][1].setSelected(true);  // Secundaria
        luces[oficina][2].setSelected(false); // Seguridad
    }

    private void activarNoche(int oficina) {
        luces[oficina][0].setSelected(false);
        luces[oficina][1].setSelected(false);
        luces[oficina][2].setSelected(true);
    }

    private void mostrarInfo(int tipo) {
        int encendidas = 0;
        int apagadas = 0;
        for (int i = 0; i < 3; i++) {
            if (luces[i][tipo].isSelected()) encendidas++;
            else apagadas++;
        }
        JOptionPane.showMessageDialog(this,
                tipos[tipo] + " encendidas: " + encendidas + "\n" +
                        tipos[tipo] + " apagadas: " + apagadas);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ControlLuces());
    }
}
