/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller16;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author zDhim
 */
public class ControlLuces extends JFrame {
    JCheckBox[][] luces = new JCheckBox[3][3];
    String[] tipos = {"Principal", "Secundaria", "Seguridad"};

    public ControlLuces() {
        setTitle("Control de Luces de Oficinas");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel de oficinas
        JPanel panelCentral = new JPanel(new GridLayout(1, 3));
        for (int i = 0; i < 3; i++) {
            JPanel panel = new JPanel(new GridLayout(3, 1));
            panel.setBorder(BorderFactory.createTitledBorder("Oficina " + (i + 1)));
            for (int j = 0; j < 3; j++) {
                luces[i][j] = new JCheckBox(tipos[j]);
                panel.add(luces[i][j]);
            }
            panelCentral.add(panel);
        }
        add(panelCentral, BorderLayout.CENTER);

        crearMenu();
        crearBarraDeHerramientas();

        setVisible(true);
    }

    private void crearMenu() {
        JMenuBar barra = new JMenuBar();

        JMenu menuActivacion = new JMenu("Activación");
        JMenu menuInfo = new JMenu("Info");

        JMenuItem encenderTodas = new JMenuItem("Encender Todas");
        encenderTodas.addActionListener(e -> cambiarTodas(true));

        JMenuItem apagarTodas = new JMenuItem("Apagar Todas");
        apagarTodas.addActionListener(e -> cambiarTodas(false));

        menuActivacion.add(encenderTodas);
        menuActivacion.add(apagarTodas);

        // Submenús Día
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

        // Submenús Noche
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
                "Control de Luces v2.0\nProgramado por TuNombre"));

        menuInfo.add(infoPrincipal);
        menuInfo.add(infoSecundaria);
        menuInfo.add(infoSeguridad);
        menuInfo.add(acerca);

        barra.add(menuActivacion);
        barra.add(menuInfo);
        setJMenuBar(barra);
    }

    private void crearBarraDeHerramientas() {
        JToolBar barraHerramientas = new JToolBar();

        JButton btnApagar = new JButton("Apagar Todas");
        btnApagar.addActionListener(e -> cambiarTodas(false));
        barraHerramientas.add(btnApagar);

        JButton btnEncender = new JButton("Encender Todas");
        btnEncender.addActionListener(e -> cambiarTodas(true));
        barraHerramientas.add(btnEncender);

        JButton btnDia = new JButton("Día Todas");
        btnDia.addActionListener(e -> {
            for (int i = 0; i < 3; i++) activarDia(i);
        });
        barraHerramientas.add(btnDia);

        JButton btnNoche = new JButton("Noche Todas");
        btnNoche.addActionListener(e -> {
            for (int i = 0; i < 3; i++) activarNoche(i);
        });
        barraHerramientas.add(btnNoche);

        JButton btnInfoPrincipal = new JButton("Info Principal");
        btnInfoPrincipal.addActionListener(e -> mostrarInfo(0));
        barraHerramientas.add(btnInfoPrincipal);

        JButton btnInfoSecundaria = new JButton("Info Secundaria");
        btnInfoSecundaria.addActionListener(e -> mostrarInfo(1));
        barraHerramientas.add(btnInfoSecundaria);

        JButton btnInfoSeguridad = new JButton("Info Seguridad");
        btnInfoSeguridad.addActionListener(e -> mostrarInfo(2));
        barraHerramientas.add(btnInfoSeguridad);

        add(barraHerramientas, BorderLayout.NORTH);
    }

    private void cambiarTodas(boolean estado) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                luces[i][j].setSelected(estado);
    }

    private void activarDia(int oficina) {
        luces[oficina][0].setSelected(true);   // Principal
        luces[oficina][1].setSelected(true);   // Secundaria
        luces[oficina][2].setSelected(false);  // Seguridad
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
        SwingUtilities.invokeLater(ControlLuces::new);
    }
}
