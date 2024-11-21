package criptoWalletBLU.PRUEBAS;

import javax.swing.*;
import java.awt.*;

public class EjemploGridBagLayout {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo GridBagLayout");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configurar el GridBagLayout
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Botón 1 (posición 0,0)
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1.0; // Espacio adicional horizontal
        gbc.weighty = 1.0; // Espacio adicional vertical
        gbc.fill = GridBagConstraints.BOTH; // Expandir en ambas direcciones
        frame.add(new JButton("Botón 1"), gbc);

        // Botón 2 (posición 1,0)
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Ocupa 2 columnas
        gbc.gridheight = 1;
        frame.add(new JButton("Botón 2"), gbc);

        // Botón 3 (posición 0,1)
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 2; // Ocupa 2 filas
        frame.add(new JButton("Botón 3"), gbc);

        // Botón 4 (posición 1,1)
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        frame.add(new JButton("Botón 4"), gbc);

        // Botón 5 (posición 2,1)
        gbc.gridx = 2;
        gbc.gridy = 1;
        frame.add(new JButton("Botón 5"), gbc);

        // Botón 6 (posición 1,2)
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2; // Ocupa 2 columnas
        frame.add(new JButton("Botón 6"), gbc);

        frame.setVisible(true);
    }
}

