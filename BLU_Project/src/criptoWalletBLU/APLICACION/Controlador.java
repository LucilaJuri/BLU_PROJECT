package criptoWalletBLU.APLICACION;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import criptoWalletBLU.EXCEPTIONS.ExcepcionPopupError;
import criptoWalletBLU.EXCEPTIONS.MailExcepcion;
import criptoWalletBLU.EXCEPTIONS.TerminosExcepcion;

public class Controlador {
	
	private Vista vista;
	private Modelo modelo;
	
	public Controlador(Vista vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
		
		vista.getPanelLogIn().getBotonRegistrarse().addActionListener(new BotonVentanaRegistrarListener());
		vista.getPanelLogIn().getBotonMostrarContrasena().addActionListener(new BotonMostrarContrasenaListener());
		vista.getPanelLogIn().getBotonLogin().addActionListener(new BotonLogInListener());
		
		vista.getPanelSignUp().getBotonAtras().addActionListener(new BotonAtrasListener());
		vista.getPanelSignUp().getBotonMostrarContrasena().addActionListener(new BotonMostrarContrasenaListener());
		vista.getPanelSignUp().getBotonRegistrar().addActionListener(new BotonRegistrarseListener());
		
		vista.getPanelMenuPrincipal().getBotonLogOut().addActionListener(new BotonLogOutListener());
		
		//iniciarSegundoPlano();
	}
	
	public class BotonVentanaRegistrarListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			vista.getPanelLogIn().setVisible(false);
			vista.setSize(vista.getPanelSignUp().getSize());
			vista.getPanelSignUp().setVisible(true);
			vista.repaint();
		}
		
	}
	
	public class BotonAtrasListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			vista.getPanelSignUp().setVisible(false);
			vista.setSize(vista.getPanelLogIn().getSize());
			vista.getPanelLogIn().setVisible(true);
			vista.repaint();
		}
		
	}
	
	public class BotonMostrarContrasenaListener implements ActionListener{
		
		final boolean[] visibilidad = {false};
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(vista.getPanelLogIn().getBotonMostrarContrasena())) {
				if (visibilidad[0]) {
					vista.getPanelLogIn().getTextoContrasena().setEchoChar('●');
		            vista.getPanelLogIn().getBotonMostrarContrasena().setText("●");
		        }
		        else {
		        	vista.getPanelLogIn().getTextoContrasena().setEchoChar((char) 0);
		            vista.getPanelLogIn().getBotonMostrarContrasena().setText("A");
		        }
		        visibilidad[0] = !visibilidad[0];
			}
			else if (e.getSource().equals(vista.getPanelSignUp().getBotonMostrarContrasena())) {
				if (visibilidad[0]) {
					vista.getPanelSignUp().getTextoContrasena().setEchoChar('●');
		            vista.getPanelSignUp().getBotonMostrarContrasena().setText("●");
		        }
		        else {
		        	vista.getPanelSignUp().getTextoContrasena().setEchoChar((char) 0);
		            vista.getPanelSignUp().getBotonMostrarContrasena().setText("A");
		        }
		        visibilidad[0] = !visibilidad[0];
			}
		 };
	}

	public class BotonRegistrarseListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			try {
			vista.getPanelSignUp().setTerminos(vista.getPanelSignUp().getCheckTerminos().isSelected());
			if (! vista.getPanelSignUp().getTerminos())throw new TerminosExcepcion();
			if (modelo.existeMail(vista.getPanelSignUp().getTextoMail().getText())) throw new MailExcepcion(vista.getPanelSignUp().getTextoMail().getText());else {
			if (vista.getPanelSignUp().getTextoMail().getText().isBlank() || vista.getPanelSignUp().getTextoNombre().getText().isBlank() || vista.getPanelSignUp().getTextoApellido().getText().isBlank() || new String(vista.getPanelSignUp().getTextoContrasena().getPassword()).isBlank()) {
				JOptionPane.showMessageDialog(vista.getPanelSignUp(), "Es obligatorio completar todos los campos solicitados.", "Campos vacíos", JOptionPane.ERROR_MESSAGE);
				return;
			}else {
				modelo.insertUsuario(vista.getPanelSignUp().getTextoNombre().getText(), vista.getPanelSignUp().getTextoApellido().getText(), vista.getPanelSignUp().getTextoMail().getText(), new String(vista.getPanelSignUp().getTextoContrasena().getPassword()));
				JOptionPane.showMessageDialog(vista.getPanelSignUp(), "Usuario creado exitosamente, bienvenido a BLU PROJECT: CRIPTO WALLET.", "Bienvenido", JOptionPane.PLAIN_MESSAGE);
				vista.getPanelSignUp().setVisible(false);
				inicializarMenu();
			}
			}
		}
			catch (ExcepcionPopupError x) {
				JOptionPane.showMessageDialog(vista.getPanelSignUp(),x.getCuerpo(),x.getTitulo(),x.getIcono() );	
			}
		}
	}

	public class BotonLogInListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if (vista.getPanelLogIn().getTextoMail().getText().isBlank() || new String(vista.getPanelLogIn().getTextoContrasena().getPassword()).isBlank()) {
				JOptionPane.showMessageDialog(vista.getPanelSignUp(), "Es obligatorio completar todos los campos solicitados.", "Campos vacíos", JOptionPane.ERROR_MESSAGE);
				return;
			}else {
			if (modelo.cargarUsuario(vista.getPanelLogIn().getTextoMail().getText(), new String(vista.getPanelLogIn().getTextoContrasena().getPassword()))==null) {
				JOptionPane.showMessageDialog(vista.getPanelSignUp(), "No existe ningún usuario registrado con los datos ingresados.", "Datos erróneos", JOptionPane.ERROR_MESSAGE);
				return;
			}}
			JOptionPane.showMessageDialog(vista.getPanelSignUp(), modelo.getPersonaLogeada().getNombre()+" bienvenido a BLU PROJECT: CRIPTO WALLET.", "Bienvenido", JOptionPane.PLAIN_MESSAGE);
			vista.getPanelLogIn().setVisible(false);
			inicializarMenu();
		}
		
	}
	
	public class BotonLogOutListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(vista.getPanelMenuPrincipal(),"Hasta pronto "+modelo.getPersonaLogeada().getNombre()+", gracias por elegirnos. ATTE: BLU PROJECT.", "Hasta pronto", JOptionPane.PLAIN_MESSAGE);
			vista.getPanelMenuPrincipal().setVisible(false);
			vista.setSize(vista.getPanelLogIn().getSize());
			vista.getPanelLogIn().setVisible(true);
			vista.setLocationRelativeTo(null);
			vista.repaint();
		}
		
	}
	
	public void inicializarMenu() {
		vista.getPanelMenuPrincipal().setVisible(true);
		vista.setSize(vista.getPanelMenuPrincipal().getSize());
		vista.setLocationRelativeTo(null);
		vista.getPanelMenuPrincipal().getLabelLetrasFoto().setText(modelo.getIniciales());
		vista.getPanelMenuPrincipal().getLabelNombre().setText(modelo.getPersonaLogeada().getNombre()+" "+modelo.getPersonaLogeada().getApellido());
		vista.getPanelMenuPrincipal().getLabelMail().setText(modelo.getUsuarioLogeado().getMail());
		vista.getPanelMenuPrincipal().getLabelSaldo().setText("Saldo: $"+modelo.getSaldo());
		vista.repaint();
	}
	
	public void iniciarSegundoPlano() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
        modelo.actualizarCriptos();
        SwingUtilities.invokeLater(() -> {
        });
        }, 0, 5, TimeUnit.SECONDS);
	}
}
