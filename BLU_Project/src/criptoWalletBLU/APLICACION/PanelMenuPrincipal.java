package criptoWalletBLU.APLICACION;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class PanelMenuPrincipal extends JPanel {

	private JScrollPane scrollActivos;
	private JTable tableActivos;
	
	private JLabel labelLetrasFoto;
	private JLabel labelNombre;
	private JLabel labelMail;
	private JLabel labelSaldo;
	
	private JButton botonPerfil;
	private JButton botonLogOut;
	
	public PanelMenuPrincipal() {
		new JPanel();
    	setBounds(0, 0, 1000,600);
    	setLayout(null);
    	setBackground(new Color(40,40,40));
    	
    	DefaultTableModel modeloActivos = new DefaultTableModel() {
    		
            @Override
            public Class<?> getColumnClass(int columna) {
                switch (columna) {
                    case 0: return ImageIcon.class;
                    case 1: return String.class;
                    case 2: return String.class;
                    case 3: return Double.class;
                    case 4: return Double.class;
                    default: return Object.class;
                }
            }
            
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        
    	modeloActivos.addColumn("ICONO");
    	modeloActivos.addColumn("NOMENCLATURA");
    	modeloActivos.addColumn("NOMBRE");
    	modeloActivos.addColumn("CANTIDAD");
    	modeloActivos.addColumn("SALDO");
    	
    	tableActivos = new JTable(modeloActivos);
    	tableActivos.setTableHeader(null);
    	scrollActivos = new JScrollPane(tableActivos);
    	scrollActivos.setBounds(410, 0, 400, 200);
    	add(scrollActivos);
    	
    	labelLetrasFoto=new JLabel();
    	labelLetrasFoto.setBounds(19, 10, 75, 75);
    	labelLetrasFoto.setFont(new Font("Arial", Font.BOLD, 40));
    	labelLetrasFoto.setForeground(Color.WHITE);
    	add(labelLetrasFoto);
    	
    	labelNombre=new JLabel();
    	labelNombre.setBounds(95, 35, 300, 23);
    	labelNombre.setFont(new Font("Arial", Font.BOLD, 23));
    	labelNombre.setForeground(Color.WHITE);
    	add(labelNombre);
    	
    	labelMail=new JLabel();
    	labelMail.setBounds(95, 65, 300, 23);
    	labelMail.setFont(new Font("Arial", Font.PLAIN, 18));
    	labelMail.setForeground(Color.WHITE);
    	add(labelMail);
    	
    	labelSaldo=new JLabel();
    	labelSaldo.setBounds(80, 180, 400, 40);
    	labelSaldo.setFont(new Font("Arial", Font.PLAIN, 35));
    	labelSaldo.setForeground(Color.WHITE);
    	add(labelSaldo);
    	
    	botonPerfil = new JButton("Ver perfil");
    	botonPerfil.setBounds(100, 110, 200, 40);
    	botonPerfil.setFont(new Font("Arial", Font.BOLD, 20));
    	botonPerfil.setFocusPainted(false);
    	botonPerfil.setBackground(new Color(1,87,146));
    	botonPerfil.setForeground(Color.WHITE); 
    	botonPerfil.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		add(botonPerfil);
		
		
		botonLogOut = new JButton("Cerrar sesión");
		botonLogOut.setBounds(100, 500, 200, 40);
		botonLogOut.setFont(new Font("Arial", Font.BOLD, 20));
		botonLogOut.setFocusPainted(false);
		botonLogOut.setBackground(new Color(241,47,74));
		botonLogOut.setForeground(Color.WHITE); 
		botonLogOut.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
		add(botonLogOut);
    	
    	
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(241,47,74));
        g.fillOval(10, 10, 75, 75);
        g.setColor(new Color(1,87,146));
        g.fillRect(400, 0, 5, 600);
        g.setColor(Color.WHITE);
        g.drawRect(400, 0, 5, 600);
        g.setColor(new Color(85, 219, 68));
        g.fillRoundRect(800, 70, 100, 40, 20, 20);
    }

	public JLabel getLabelLetrasFoto() {
		return labelLetrasFoto;
	}
	
	public JLabel getLabelNombre() {
		return labelNombre;
	}
	
	public JLabel getLabelMail() {
		return labelMail;
	}
	
	public JLabel getLabelSaldo() {
		return labelSaldo;
	}
	
	public JButton getBotonLogOut() {
		return botonLogOut;
	}
}
