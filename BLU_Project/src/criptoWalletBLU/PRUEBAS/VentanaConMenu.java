package criptoWalletBLU.PRUEBAS;

import java.awt.*;

import javax.swing.*;

public class VentanaConMenu {
    public static void main(String[] args) {
        // Crear la ventana
        JFrame frame = new JFrame("Ventana con Menú");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear la barra de menú
        JMenuBar menuBar = new JMenuBar();

        // Crear un menú y elementos del menú
        JMenu menuArchivo = new JMenu("Archivo");
        JMenu botonPrueba = new JMenu("Boton Prueba");
        JMenuItem itemAbrir = new JMenuItem("Abrir");
        JMenuItem itemSalir = new JMenuItem("Salir");

        // Agregar acción al elemento "Salir"
        itemSalir.addActionListener(e -> System.exit(0));

        // Agregar los elementos al menú
        menuArchivo.add(itemAbrir);
        menuArchivo.add(itemSalir);

        // Agregar el menú a la barra de menú
        menuBar.add(menuArchivo);
        menuBar.add(botonPrueba);

        // Agregar la barra de menú a la ventana
        frame.setJMenuBar(menuBar);
        
     // Crear un JPanel (contenedor)
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout()); // Establecer un layout (opcional)

        // Agregar componentes al JPanel
        JLabel etiqueta = new JLabel("Nombre:");
        JTextField campoTexto = new JTextField(15);
        JButton boton = new JButton("Enviar");

        panel.add(etiqueta);
        panel.add(campoTexto);
        panel.add(boton);

        // Agregar el JPanel al JFrame
        frame.add(panel);

        // Hacer visible la ventana
        frame.setVisible(true);
    }
}
