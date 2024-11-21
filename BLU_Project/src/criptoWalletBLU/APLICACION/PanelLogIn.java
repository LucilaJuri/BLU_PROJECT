package criptoWalletBLU.APLICACION;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelLogIn extends JPanel {

	private JLabel labelBienvenidos;
	private JLabel labelEmail;
	private JLabel labelContrasena;
	private JLabel labelRegistrarse;
	
	private JTextField textoMail;
	
	private JPasswordField textoContrasena;
	
	private JButton botonMostrarContrasena;
	private JButton botonLogin;
	private JButton botonRegistrarse;
	
	public PanelLogIn() {
		new JPanel();
    	setBounds(0, 0, 450,300);
    	setLayout(null);
    	setBackground(new Color(40,40,40));
    	
    	labelBienvenidos = new JLabel("Bienvenidos a BLU PROJECT: CRIPTO WALLET");
		labelBienvenidos.setBounds(75, 10, 300, 30);
		labelBienvenidos.setFont(new Font("Arial", Font.BOLD, 13));
		labelBienvenidos.setForeground(Color.WHITE);
		add(labelBienvenidos);
    	
		labelEmail = new JLabel("E-Mail:");
		labelEmail.setBounds(80, 70, 100, 30);
		labelEmail.setFont(new Font("Arial", Font.BOLD, 13));
		labelEmail.setForeground(Color.WHITE);
		add(labelEmail);
    	
		labelContrasena = new JLabel("Contraseña:");
		labelContrasena.setBounds(80, 120, 100, 30);
		labelContrasena.setFont(new Font("Arial", Font.BOLD, 13));
		labelContrasena.setForeground(Color.WHITE);
		add(labelContrasena);
		
		textoMail = new JTextField();
		textoMail.setBounds(170, 70, 170, 30);
		textoMail.setFont(new Font("Arial", Font.PLAIN, 15));
		textoMail.setBorder(BorderFactory.createLineBorder(new Color(1,87,146), 3));
		add(textoMail);
		
		textoContrasena = new JPasswordField();
		textoContrasena.setBounds(170, 120, 170, 30);
		textoContrasena.setFont(new Font("Arial", Font.PLAIN, 15));
		textoContrasena.setBorder(BorderFactory.createLineBorder(new Color(1,87,146), 3));
		add(textoContrasena);
		
		botonMostrarContrasena = new JButton("●");
		botonMostrarContrasena.setBounds(350, 120, 30, 30);
		botonMostrarContrasena.setFont(new Font("Arial", Font.BOLD, 14));
		botonMostrarContrasena.setFocusPainted(false);
		botonMostrarContrasena.setBackground(new Color(1,87,146));
		botonMostrarContrasena.setForeground(Color.WHITE); 
		botonMostrarContrasena.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		add(botonMostrarContrasena);
		
		botonLogin = new JButton("Iniciar sesión");
		botonLogin.setBounds(150, 170, 140, 30);
		botonLogin.setFont(new Font("Arial", Font.PLAIN, 15));
		botonLogin.setMargin(new Insets(0, 0, 0, 0));
		botonLogin.setFocusPainted(false);
		botonLogin.setBackground(new Color(1,87,146));
		botonLogin.setForeground(Color.WHITE); 
		botonLogin.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		add(botonLogin);
		
		labelRegistrarse = new JLabel("¿No estás registrado?");
		labelRegistrarse.setBounds(100, 220, 200, 30);
		labelRegistrarse.setFont(new Font("Arial", Font.BOLD, 13));
		labelRegistrarse.setForeground(Color.WHITE);
		add(labelRegistrarse);
		
		botonRegistrarse = new JButton("Registrarse");
		botonRegistrarse.setBounds(240, 222, 100, 25);
		botonRegistrarse.setFont(new Font("Arial", Font.PLAIN, 13));
		botonRegistrarse.setMargin(new Insets(0, 0, 0, 0));
		botonRegistrarse.setFocusPainted(false);
		botonRegistrarse.setBackground(new Color(1,87,146));
		botonRegistrarse.setForeground(Color.WHITE); 
		botonRegistrarse.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		add(botonRegistrarse);
	}

	public JLabel getLabelBienvenidos() {
		return labelBienvenidos;
	}

	public JLabel getLabelEmail() {
		return labelEmail;
	}

	public JLabel getLabelContrasena() {
		return labelContrasena;
	}

	public JLabel getLabelRegistrarse() {
		return labelRegistrarse;
	}

	public JTextField getTextoMail() {
		return textoMail;
	}

	public JPasswordField getTextoContrasena() {
		return textoContrasena;
	}

	public JButton getBotonMostrarContrasena() {
		return botonMostrarContrasena;
	}

	public JButton getBotonLogin() {
		return botonLogin;
	}

	public JButton getBotonRegistrarse() {
		return botonRegistrarse;
	}
	
	
}
