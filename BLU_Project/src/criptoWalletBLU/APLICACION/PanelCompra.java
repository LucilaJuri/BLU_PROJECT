package criptoWalletBLU.APLICACION;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import criptoWalletBLU.APLICACION.Controlador.TimerCompraListener;
import criptoWalletBLU.CLASES.Moneda;

@SuppressWarnings("serial")
public class PanelCompra extends JPanel {
	
	private JLabel labelStock;
	private JLabel labelCompra;
	private JLabel labelFiat;
	private JLabel labelCantidad;
	private JLabel labelMonto;
	private JLabel labelTimer;
	
	private JComboBox<String> boxFiat;
	
	private JTextField textoMonto;
	private JLabel labelEquivale;
	
	private String nomenclatura;
	
	private JButton botonCompra;
	private JButton botonAtras;
	
	private Timer timer;

	public PanelCompra() {
		new JPanel();
    	setBounds(0, 0, 600,400);
    	setLayout(null);
    	setBackground(new Color(40,40,40));
    	
    	labelStock = new JLabel();
    	labelStock.setBounds(30, 30, 500, 30);
    	labelStock.setFont(new Font("Arial", Font.BOLD, 20));
    	labelStock.setForeground(Color.WHITE);
		add(labelStock);
		
		labelCompra = new JLabel();
		labelCompra.setBounds(30, 80, 500, 30);
		labelCompra.setFont(new Font("Arial", Font.BOLD, 20));
		labelCompra.setForeground(Color.WHITE);
		add(labelCompra);
		
		labelFiat = new JLabel("Seleccione FIAT: ");
		labelFiat.setBounds(30, 130, 500, 30);
		labelFiat.setFont(new Font("Arial", Font.BOLD, 20));
		labelFiat.setForeground(Color.WHITE);
		add(labelFiat);
		
        boxFiat = new JComboBox<>();
        boxFiat.setBounds(200, 125, 70, 40);
        boxFiat.setFont(new Font("Arial", Font.BOLD, 20));
        add(boxFiat);
        
        labelCantidad = new JLabel();
        labelCantidad.setBounds(300, 130, 500, 30);
        labelCantidad.setFont(new Font("Arial", Font.BOLD, 20));
        labelCantidad.setForeground(Color.WHITE);
		add(labelCantidad);
		
		labelMonto = new JLabel("Cantidad a convertir: ");
		labelMonto.setBounds(30, 180, 500, 30);
		labelMonto.setFont(new Font("Arial", Font.BOLD, 20));
		labelMonto.setForeground(Color.WHITE);
		add(labelMonto);
		
		textoMonto = new JTextField();
		textoMonto.setBounds(315, 175, 150, 40);
		textoMonto.setFont(new Font("Arial", Font.PLAIN, 20));
		textoMonto.setBorder(BorderFactory.createLineBorder(new Color(1,87,146), 3));
		add(textoMonto);
		
		labelEquivale = new JLabel("Equivale a: ");
		labelEquivale.setBounds(30, 230, 500, 30);
		labelEquivale.setFont(new Font("Arial", Font.BOLD, 20));
		labelEquivale.setForeground(Color.WHITE);
		add(labelEquivale);
		
		labelTimer = new JLabel("Tiempo: 60");
		labelTimer.setBounds(450, 30, 500, 30);
		labelTimer.setFont(new Font("Arial", Font.BOLD, 20));
		labelTimer.setForeground(Color.WHITE);
		add(labelTimer);
		
		botonCompra = new JButton("Comprar");
		botonCompra.setBounds(50, 275, 200, 60);
		botonCompra.setFont(new Font("Arial", Font.BOLD, 20));
    	botonCompra.setFocusPainted(false);
    	botonCompra.setBackground(new Color(1,87,146));
    	botonCompra.setForeground(Color.WHITE); 
    	botonCompra.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		add(botonCompra);
		
		botonAtras = new JButton("Atras");
		botonAtras.setBounds(330, 275, 200, 60);
		botonAtras.setFont(new Font("Arial", Font.BOLD, 20));
		botonAtras.setFocusPainted(false);
		botonAtras.setBackground(new Color(1,87,146));
		botonAtras.setForeground(Color.WHITE); 
		botonAtras.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		add(botonAtras);
		
		
	}
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(1,87,146));
        g.fillRect(445, 20, 120, 50);
        g.setColor(Color.WHITE);
        g.drawRect(445, 20, 120, 50);
    }
	
	public JButton getBotonCompra() {
		return botonCompra;
	}

	public JButton getBotonAtras() {
		return botonAtras;
	}

	public void actualizarActivos(List<Moneda> activos) {
		List<String> lista = new ArrayList<String>();
		for (Moneda m : activos) {
			lista.add(m.getNomenclatura());
		}
		boxFiat.setModel(new DefaultComboBoxModel<>(lista.toArray(new String[0])));
	}
	
	public JLabel getLabelStock() {
		return labelStock;
	}
	
	public JLabel getLabelCompra() {
		return labelCompra;
	}
	
	public JComboBox<String> getBoxFiat() {
		return boxFiat;
	}
	
	public JLabel getLabelCantidad() {
		return labelCantidad;
	}
	
	public JLabel getLabelMonto() {
		return labelMonto;
	}
	
	public JLabel getLabelEquivale() {
		return labelEquivale;
	}
	
	public JTextField getTextoMonto() {
		return textoMonto;
	}

	public String getNomenclatura() {
		return nomenclatura;
	}

	public void setNomenclatura(String nomenclatura) {
		this.nomenclatura = nomenclatura;
	}

	public Timer getTimer() {
		return timer;
	}
	
	public JLabel getLabelTimer() {
		return labelTimer;
	}

	public void setTimer(TimerCompraListener timerCompraListener) {
		timer = new Timer(1000,timerCompraListener);
	}
	
}