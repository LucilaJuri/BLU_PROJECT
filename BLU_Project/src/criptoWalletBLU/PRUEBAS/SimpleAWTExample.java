package criptoWalletBLU.PRUEBAS;
import java.awt.*;
import java.awt.event.*;

// Clase principal que extiende Frame e implementa ActionListener para manejar eventos
public class SimpleAWTExample extends Frame {

    // Declaración de los componentes
    private TextField textField;
    private TextField textField2;
    private Button boton1;
    private Button boton2;

    // Constructor de la clase
    public SimpleAWTExample() {
        // Configuración del título de la ventana
        setTitle("Proyecto 1");
        
        // Configurar el diseño (FlowLayout coloca componentes en una línea horizontal)
        setLayout(new BorderLayout());

        // Crear el campo de texto y el botón
        textField = new TextField("Haz clic en el botón");
        textField.setEditable(false);
        textField2 = new TextField();
        boton1 = new Button("Cambiar Texto");
        boton2= new Button("Borrar Texto");

        
        // Añadir componentes al Frame
        add(boton1,BorderLayout.WEST);
        add(boton2,BorderLayout.EAST);
        add(textField2,BorderLayout.SOUTH);
        add(textField,BorderLayout.CENTER);

        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botón 1 fue presionado!");
                new POPUP();
            }
        });

        // Listener para el Botón 2
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botón 2 fue presionado!");
            }
        });

        // Configurar la ventana
        setSize(300, 150); // Ancho y alto de la ventana
        setVisible(true); // Hacer visible la ventana

        // Cerrar la aplicación al cerrar la ventana
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }


    // Método principal para ejecutar el programa
    public static void main(String[] args) {
        new SimpleAWTExample(); // Crear instancia de la clase
    }
}