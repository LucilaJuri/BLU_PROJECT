package criptoWalletBLU.APLICACION;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PanelSignUp extends JPanel {
	
	private JLabel labelTitulo;
	private JLabel labelNombre;
	private JLabel labelApellido;
	private JLabel labelEmail;
	private	JLabel labelContrasena;
	private JLabel labelTerminos;
	
	private JTextField textoNombre;
	private JTextField textoApellido;
	private JTextField textoMail;
	private JPasswordField textoContrasena;
	
	private JCheckBox checkTerminos;
	
	private JPopupMenu popupTerminos;
	
	private JButton botonAtras;
	private JButton botonRegistrar;
	private JButton botonMostrarContrasena;
	
	private String nombre;
    private String apellido;
    private String mail;
    private String contrasena;
    
    private boolean terminos;

	public PanelSignUp() {
		new JPanel();
    	setBounds(0, 0, 450,400);
    	setLayout(null);
    	setBackground(new Color(40,40,40));
    	
    	labelTitulo = new JLabel("Ingrese los datos de la nueva cuenta:");
		labelTitulo.setBounds(110, 10, 300, 30);
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 13));
		labelTitulo.setForeground(Color.WHITE);
		add(labelTitulo);
		
		labelNombre = new JLabel("Nombre:");
		labelNombre.setBounds(80, 70, 100, 30);
		labelNombre.setFont(new Font("Arial", Font.BOLD, 13));
		labelNombre.setForeground(Color.WHITE);
		add(labelNombre);
		
		textoNombre = new JTextField();
		textoNombre.setBounds(170, 70, 170, 30);
		textoNombre.setFont(new Font("Arial", Font.PLAIN, 15));
		textoNombre.setBorder(BorderFactory.createLineBorder(new Color(1,87,146), 3));
		add(textoNombre);
		
		labelApellido = new JLabel("Apellido:");
		labelApellido.setBounds(80, 120, 100, 30);
		labelApellido.setFont(new Font("Arial", Font.BOLD, 13));
		labelApellido.setForeground(Color.WHITE);
		add(labelApellido);
		
		textoApellido = new JTextField();
		textoApellido.setBounds(170, 120, 170, 30);
		textoApellido.setFont(new Font("Arial", Font.PLAIN, 15));
		textoApellido.setBorder(BorderFactory.createLineBorder(new Color(1,87,146), 3));
		add(textoApellido);
		
		labelEmail = new JLabel("E-Mail:");
		labelEmail.setBounds(80, 170, 100, 30);
		labelEmail.setFont(new Font("Arial", Font.BOLD, 13));
		labelEmail.setForeground(Color.WHITE);
		add(labelEmail);
		
		textoMail = new JTextField();
		textoMail.setBounds(170, 170, 170, 30);
		textoMail.setFont(new Font("Arial", Font.PLAIN, 15));
		textoMail.setBorder(BorderFactory.createLineBorder(new Color(1,87,146), 3));
		add(textoMail);
		
		labelContrasena = new JLabel("Contraseña:");
		labelContrasena.setBounds(80, 220, 100, 30);
		labelContrasena.setFont(new Font("Arial", Font.BOLD, 13));
		labelContrasena.setForeground(Color.WHITE);
		add(labelContrasena);
		
		textoContrasena = new JPasswordField();
		textoContrasena.setBounds(170, 220, 170, 30);
		textoContrasena.setFont(new Font("Arial", Font.PLAIN, 15));
		textoContrasena.setBorder(BorderFactory.createLineBorder(new Color(1,87,146), 3));
		add(textoContrasena);
		
		botonMostrarContrasena = new JButton("●");
		botonMostrarContrasena.setBounds(350, 220, 30, 30);
		botonMostrarContrasena.setFont(new Font("Arial", Font.BOLD, 14));
		botonMostrarContrasena.setFocusPainted(false);
		botonMostrarContrasena.setBackground(new Color(1,87,146));
		botonMostrarContrasena.setForeground(Color.WHITE); 
		botonMostrarContrasena.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		add(botonMostrarContrasena);
//		final boolean[] visibilidad = {false};
//		botonMostrarContrasenaSignUp.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                if (visibilidad[0]) {
//                	textoContrasena.setEchoChar('●');
//                	botonMostrarContrasenaSignUp.setText("●");
//                }
//                else {
//                	textoContrasena.setEchoChar((char) 0);
//                	botonMostrarContrasenaSignUp.setText("A");
//                }
//                visibilidad[0] = !visibilidad[0];
//            }
//        });
		labelTerminos = new JLabel("<html><u>Acepta los Términos y Condiciones de uso:</u></html>");
		labelTerminos.setBounds(80, 270, 275, 30);
		labelTerminos.setFont(new Font("Arial", Font.BOLD, 13));
		labelTerminos.setForeground(Color.WHITE);
		add(labelTerminos);
		
		checkTerminos = new JCheckBox();
		checkTerminos.setBounds(357, 278, 15, 15);
		checkTerminos.setFocusPainted(false);
		checkTerminos.setHorizontalAlignment(SwingConstants.CENTER);
		checkTerminos.setVerticalAlignment(SwingConstants.CENTER);
		add(checkTerminos);
		
		botonRegistrar = new JButton("Registrarse");
		botonRegistrar.setBounds(150, 320, 140, 30);
		botonRegistrar.setFont(new Font("Arial", Font.PLAIN, 15));
		botonRegistrar.setMargin(new Insets(0, 0, 0, 0));
		botonRegistrar.setFocusPainted(false);
		botonRegistrar.setBackground(new Color(1,87,146));
		botonRegistrar.setForeground(Color.WHITE); 
		botonRegistrar.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		add(botonRegistrar);
//		botonRegistrar.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                nombre=textoNombre.getText();
//                apellido=textoApellido.getText();
//                mail=textoMail.getText();
//                contrasena=new String(textoContrasena.getPassword());
//                terminos=checkTerminos.isSelected();
//                evento=e;
//            }
//        });
		
		botonAtras = new JButton("Atras");
		botonAtras.setBounds(360, 320, 45, 30);
		botonAtras.setFont(new Font("Arial", Font.BOLD, 12));
		botonAtras.setMargin(new Insets(0, 0, 0, 0));
		botonAtras.setFocusPainted(false);
		botonAtras.setBackground(new Color(1,87,146));
		botonAtras.setForeground(Color.WHITE);
		botonAtras.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		add(botonAtras);
//		botonAtras.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//            	panelSignUp.setVisible(false);
//            	ventanaLogIn();
//            }
//        });
		
		popupTerminos = new JPopupMenu("HOLA");
		add(popupTerminos);
    }

	public JLabel getLabelTitulo() {
		return labelTitulo;
	}

	public JLabel getLabelNombre() {
		return labelNombre;
	}

	public JLabel getLabelApellido() {
		return labelApellido;
	}

	public JLabel getLabelEmail() {
		return labelEmail;
	}

	public JLabel getLabelContrasena() {
		return labelContrasena;
	}

	public JLabel getLabelTerminos() {
		return labelTerminos;
	}

	public JTextField getTextoNombre() {
		return textoNombre;
	}

	public JTextField getTextoApellido() {
		return textoApellido;
	}

	public JTextField getTextoMail() {
		return textoMail;
	}

	public JPasswordField getTextoContrasena() {
		return textoContrasena;
	}

	public JCheckBox getCheckTerminos() {
		return checkTerminos;
	}

	public JButton getBotonAtras() {
		return botonAtras;
	}

	public JButton getBotonRegistrar() {
		return botonRegistrar;
	}

	public JButton getBotonMostrarContrasena() {
		return botonMostrarContrasena;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public boolean getTerminos() {
		return terminos;
	}

	public void setTerminos(boolean terminos) {
		this.terminos = terminos;
	}
	
	public JPopupMenu getPopupTerminos() {
		return popupTerminos;
	}
}
