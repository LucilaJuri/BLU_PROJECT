package criptoWalletBLU.APLICACION;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import criptoWalletBLU.DAO.FactoryDao;
import criptoWalletBLU.DAO.StockDao;
import criptoWalletBLU.EXCEPTIONS.ActivoExcepcion;
import criptoWalletBLU.EXCEPTIONS.CompletarDatosExcepcion;
import criptoWalletBLU.EXCEPTIONS.DatosErroneosExcepcion;
import criptoWalletBLU.EXCEPTIONS.ExcepcionPopupError;
import criptoWalletBLU.EXCEPTIONS.MailExcepcion;
import criptoWalletBLU.EXCEPTIONS.StockExcepcion;
import criptoWalletBLU.EXCEPTIONS.TerminosExcepcion;
import criptoWalletBLU.SERVICIOS.ApiCriptos;

public class Controlador {
	
	private Vista vista;
	private Modelo modelo;
	private ActualizarThread actualizarThread;
	private TimerCompraListener timerListener;
	
	public Controlador(Vista vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
		
		vista.getPanelLogIn().getBotonRegistrarse().addActionListener(new BotonVentanaRegistrarListener());
		vista.getPanelLogIn().getBotonMostrarContrasena().addActionListener(new BotonMostrarContrasenaListener());
		vista.getPanelLogIn().getBotonLogin().addActionListener(new BotonLogInListener());
		
		vista.getPanelSignUp().getBotonAtras().addActionListener(new BotonAtrasListener());
		vista.getPanelSignUp().getBotonMostrarContrasena().addActionListener(new BotonMostrarContrasenaListener());
		vista.getPanelSignUp().getBotonRegistrar().addActionListener(new BotonRegistrarseListener());
		vista.getPanelSignUp().getLabelTerminos().addMouseListener(new LabelTerminosListener());
		
		vista.getPanelMenuPrincipal().getBotonLogOut().addActionListener(new BotonLogOutListener());
		vista.getPanelMenuPrincipal().getTableCotizaciones().addMouseListener(new TableCotizacionesMouseListener());
		vista.getPanelMenuPrincipal().getBotonDatosPrueba().addActionListener(new BotonGenerarDatosListener());
		vista.getPanelMenuPrincipal().getBotonCSV().addActionListener(new BotonExportarListener());
		
		vista.getPanelCompra().getBoxFiat().addActionListener(new BoxFiatActionListener());
		vista.getPanelCompra().getTextoMonto().getDocument().addDocumentListener(new TextoMontoDocumentListener());
		vista.getPanelCompra().getBotonAtras().addActionListener(new BotonAtrasMenuPrincipalListener());
		vista.getPanelCompra().getBotonCompra().addActionListener(new BotonCompraMenuPrincipalListener());
	
		this.actualizarThread= new ActualizarThread();
		actualizarThread.iniciar();;
	}
	
	public class BotonVentanaRegistrarListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			vista.getPanelLogIn().setVisible(false);
			vista.getPanelLogIn().getTextoContrasena().setText("");
			vista.getPanelLogIn().getTextoMail().setText("");
			vista.setSize(vista.getPanelSignUp().getSize());
			vista.getPanelSignUp().setVisible(true);
			vista.repaint();
		}
		
	}
	
	public class BotonAtrasListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			vista.getPanelSignUp().setVisible(false);
			vista.getPanelSignUp().getTextoNombre().setText("");
			vista.getPanelSignUp().getTextoApellido().setText("");
			vista.getPanelSignUp().getTextoMail().setText("");
			vista.getPanelSignUp().getTextoContrasena().setText("");
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
				if (! vista.getPanelSignUp().getTerminos()) {
					throw new TerminosExcepcion();}
				if (modelo.existeMail(vista.getPanelSignUp().getTextoMail().getText())) {
					throw new MailExcepcion(vista.getPanelSignUp().getTextoMail().getText());}
				if (vista.getPanelSignUp().getTextoMail().getText().isBlank() || vista.getPanelSignUp().getTextoNombre().getText().isBlank() || vista.getPanelSignUp().getTextoApellido().getText().isBlank() || new String(vista.getPanelSignUp().getTextoContrasena().getPassword()).isBlank()) {
					throw new CompletarDatosExcepcion();}
				modelo.insertUsuario(vista.getPanelSignUp().getTextoNombre().getText(), vista.getPanelSignUp().getTextoApellido().getText(), vista.getPanelSignUp().getTextoMail().getText(), new String(vista.getPanelSignUp().getTextoContrasena().getPassword()));
				JOptionPane.showMessageDialog(vista.getPanelSignUp(), "Usuario creado exitosamente, bienvenido a BLU PROJECT: CRIPTO WALLET.", "Bienvenido", JOptionPane.PLAIN_MESSAGE, new ImageIcon(new ImageIcon(getClass().getResource("/assets/BLUPROJECT2.png")).getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH)));
				vista.getPanelSignUp().setVisible(false);
				vista.getPanelSignUp().getTextoNombre().setText("");
				vista.getPanelSignUp().getTextoApellido().setText("");
				vista.getPanelSignUp().getTextoMail().setText("");
				vista.getPanelSignUp().getTextoContrasena().setText("");
				inicializarMenu();
			}
			catch (ExcepcionPopupError x) {
				JOptionPane.showMessageDialog(vista.getPanelSignUp(),x.getCuerpo(),x.getTitulo(),x.getIcono() );	
			}
		}
	}

	public class BotonLogInListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			try {
			if (vista.getPanelLogIn().getTextoMail().getText().isBlank() || new String(vista.getPanelLogIn().getTextoContrasena().getPassword()).isBlank()) {
				throw new CompletarDatosExcepcion();}
			if (modelo.cargarUsuario(vista.getPanelLogIn().getTextoMail().getText(), new String(vista.getPanelLogIn().getTextoContrasena().getPassword())).estaVacio()) {
				throw new DatosErroneosExcepcion();}
			JOptionPane.showMessageDialog(vista.getPanelSignUp(), modelo.getPersonaLogeada().getNombre()+" bienvenido a BLU PROJECT: CRIPTO WALLET.", "Bienvenido", JOptionPane.PLAIN_MESSAGE, new ImageIcon(new ImageIcon(getClass().getResource("/assets/BLUPROJECT2.png")).getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH)));
			vista.getPanelLogIn().setVisible(false);
			vista.getPanelLogIn().getTextoContrasena().setText("");
			vista.getPanelLogIn().getTextoMail().setText("");
			inicializarMenu();
		}
		catch (ExcepcionPopupError x) {
			JOptionPane.showMessageDialog(vista.getPanelSignUp(),x.getCuerpo(),x.getTitulo(),x.getIcono());	
		}
		
	}
}
	
	public class BotonLogOutListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(vista.getPanelMenuPrincipal(),"Hasta pronto "+modelo.getPersonaLogeada().getNombre()+", gracias por elegirnos. ATTE: BLU PROJECT.", "Hasta pronto", JOptionPane.PLAIN_MESSAGE, new ImageIcon(new ImageIcon(getClass().getResource("/assets/BLUPROJECT2.png")).getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH)));
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
		vista.getPanelMenuPrincipal().setIniciales(modelo.getIniciales());
		vista.getPanelMenuPrincipal().getLabelNombre().setText(modelo.getPersonaLogeada().getNombre()+" "+modelo.getPersonaLogeada().getApellido());
		vista.getPanelMenuPrincipal().getLabelMail().setText(modelo.getUsuarioLogeado().getMail());
		vista.getPanelMenuPrincipal().getLabelSaldo().setText("Saldo: $"+modelo.getSaldo());
		vista.getPanelMenuPrincipal().actualizarTablaActivos(modelo.getListaActivos());
		vista.getPanelMenuPrincipal().actualizarTablaTransacciones(modelo.getListaTransacciones());
		vista.repaint();
	}
	
	public class ActualizarThread extends Thread {
	    private ApiCriptos apiCriptos;
	    private StockDao stockDao;
	    private boolean flag;
	    private boolean pausado;
	    private final Object pausa = new Object();

	    public ActualizarThread() {
	        this.apiCriptos = modelo.getApiCriptos();
	        this.stockDao = FactoryDao.getStockDao();
	    }

	    @Override
	    public void run() {
	        while (flag) {
	            synchronized (pausa) {
	                while (pausado) {
	                    try {
	                    	pausa.wait();
	                    } catch (InterruptedException e) {
	                        e.printStackTrace();
	                    }
	                }
	            }
	            apiCriptos.actualizarApiCriptos();
	            if (apiCriptos.getJson() != null) {
	                stockDao.updatePrecio("BTC", apiCriptos.getBTC());
	                stockDao.updatePrecio("ETH", apiCriptos.getETH());
	                stockDao.updatePrecio("USDC", apiCriptos.getUSDC());
	                stockDao.updatePrecio("USDT", apiCriptos.getUSDT());
	                stockDao.updatePrecio("DOGE", apiCriptos.getDOGE());
	                SwingUtilities.invokeLater(() -> {
	                    vista.getPanelMenuPrincipal().getTableCotizaciones().getModel().setValueAt(apiCriptos.getBTC(), 0, 3);
	                    vista.getPanelMenuPrincipal().getTableCotizaciones().getModel().setValueAt(apiCriptos.getETH(), 1, 3);
	                    vista.getPanelMenuPrincipal().getTableCotizaciones().getModel().setValueAt(apiCriptos.getUSDC(), 2, 3);
	                    vista.getPanelMenuPrincipal().getTableCotizaciones().getModel().setValueAt(apiCriptos.getUSDT(), 3, 3);
	                    vista.getPanelMenuPrincipal().getTableCotizaciones().getModel().setValueAt(apiCriptos.getDOGE(), 4, 3);
	                    vista.getPanelMenuPrincipal().actualizarTablaActivos(modelo.getListaActivos());
	                    vista.repaint();
	                });
	            }

	            try {
	                TimeUnit.MINUTES.sleep(1);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    public void iniciar() {
	        if (!isAlive()) {
	            flag = true;
	            pausado = false;
	            start();
	        }
	    }

	    public void parar() {
	        flag = false; 
	        synchronized (pausa) {
	            pausado = false;
	            pausa.notifyAll();
	        }
	    }

	    public void pausar() {
	        synchronized (pausa) {
	            pausado = true;
	        }
	    }

	    public void reanudar() {
	        synchronized (pausa) {
	            pausado = false;
	            pausa.notifyAll();
	        }
	    }
	}
	
	public class TableCotizacionesMouseListener extends MouseAdapter {
		@Override
        public void mouseClicked(MouseEvent e) {
			timerListener = new TimerCompraListener();
			vista.getPanelCompra().setTimer(timerListener);
			vista.optionPane((String)vista.getPanelMenuPrincipal().getTableCotizaciones().getValueAt(vista.getPanelMenuPrincipal().getTableCotizaciones().getSelectedRow(), 2),(String)vista.getPanelMenuPrincipal().getTableCotizaciones().getValueAt(vista.getPanelMenuPrincipal().getTableCotizaciones().getSelectedRow(), 1),modelo.getStockMoneda((String)vista.getPanelMenuPrincipal().getTableCotizaciones().getValueAt(vista.getPanelMenuPrincipal().getTableCotizaciones().getSelectedRow(), 1)),(double)vista.getPanelMenuPrincipal().getTableCotizaciones().getValueAt(vista.getPanelMenuPrincipal().getTableCotizaciones().getSelectedRow(), 3),modelo.swapDisponible((String)vista.getPanelMenuPrincipal().getTableCotizaciones().getValueAt(vista.getPanelMenuPrincipal().getTableCotizaciones().getSelectedRow(), 1)), modelo.selectNomenclaturaCantidadUsuario());
        }
	}
	
	public class BoxFiatActionListener implements ActionListener {
		@Override
        public void actionPerformed(ActionEvent e) {
			vista.getPanelCompra().getLabelCantidad().setText(modelo.selectCantidadNomenclatura((String)vista.getPanelCompra().getBoxFiat().getSelectedItem())+" "+(String)vista.getPanelCompra().getBoxFiat().getSelectedItem()+" disponibles.");
			vista.getPanelCompra().getLabelMonto().setText("Cantidad de "+(String)vista.getPanelCompra().getBoxFiat().getSelectedItem()+" a convertir: ");
		}
	}
	public class TextoMontoDocumentListener implements DocumentListener{
            @Override
            public void insertUpdate(DocumentEvent e) {
                textoModificado();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }

            private void textoModificado() {
            	try {
            		vista.getPanelCompra().getLabelEquivale().setText("Equivale a "+modelo.convertir(Double.parseDouble(vista.getPanelCompra().getTextoMonto().getText()),(String)vista.getPanelCompra().getBoxFiat().getSelectedItem(),vista.getPanelCompra().getNomenclatura())+" "+vista.getPanelCompra().getNomenclatura());
            	}
            	catch (NumberFormatException e) {
            		JOptionPane.showMessageDialog(vista.getPanelCompra(),"Ingrese una cantidad válida","Cantidad inválida",JOptionPane.ERROR_MESSAGE);
            	}
            }
        }
	
	public class BotonAtrasMenuPrincipalListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			vista.getPanelCompra().setVisible(false);
			vista.getPanelCompra().getTimer().removeActionListener(timerListener);
			inicializarMenu();
			vista.getPanelCompra().getTextoMonto().setText("");
		}
	}
	
	public class BotonCompraMenuPrincipalListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
			if (vista.getPanelCompra().getTextoMonto().getText().isBlank()) throw new CompletarDatosExcepcion();
			if (modelo.convertir(Double.parseDouble(vista.getPanelCompra().getTextoMonto().getText()),(String)vista.getPanelCompra().getBoxFiat().getSelectedItem(),vista.getPanelCompra().getNomenclatura())>modelo.getStockMoneda(vista.getPanelCompra().getNomenclatura())) throw new StockExcepcion();
			if (Double.parseDouble(vista.getPanelCompra().getTextoMonto().getText())>modelo.selectCantidadNomenclatura((String)vista.getPanelCompra().getBoxFiat().getSelectedItem())) throw new ActivoExcepcion();
			modelo.compra(Double.parseDouble(vista.getPanelCompra().getTextoMonto().getText()),vista.getPanelCompra().getNomenclatura(),modelo.convertir(Double.parseDouble(vista.getPanelCompra().getTextoMonto().getText()),(String)vista.getPanelCompra().getBoxFiat().getSelectedItem(),vista.getPanelCompra().getNomenclatura()),(String)vista.getPanelCompra().getBoxFiat().getSelectedItem());
			JOptionPane.showMessageDialog(vista.getPanelCompra(),"Compra realizada exitosamente, se ha generado el comprobante correspondiente.","Compra exitosa.",JOptionPane.INFORMATION_MESSAGE);
			vista.getPanelCompra().setVisible(false);
			vista.getPanelCompra().getTimer().removeActionListener(timerListener);
			inicializarMenu();
			actualizarThread.reanudar();
			}
			catch (ExcepcionPopupError x) {
				JOptionPane.showMessageDialog(vista.getPanelCompra(),x.getCuerpo(),x.getTitulo(),x.getIcono());
			}
			vista.getPanelCompra().getTextoMonto().setText("");
		}
			
	}
	
	public class TimerCompraListener implements ActionListener{
		int segundos = 60;

        @Override
        public void actionPerformed(ActionEvent e) {
        	if (segundos==60) actualizarThread.pausar();
        	SwingUtilities.invokeLater(() -> {
        		vista.getPanelCompra().getLabelTimer().setText("Tiempo: "+segundos);
        		vista.repaint();
	        });
        	segundos--;
        	if (segundos==0) {
    			JOptionPane.showMessageDialog(vista.getPanelCompra(),"Tiempo de compra agotado. Intente nuevamente.","Tiempo agotado.",JOptionPane.ERROR_MESSAGE);
        		((Timer)e.getSource()).stop();
        		vista.getPanelCompra().setVisible(false);
        		inicializarMenu();
        		actualizarThread.reanudar();
        		vista.getPanelCompra().getTextoMonto().setText("");
        		vista.repaint();
        	} 
        }
			
	}
	
	
	public class LabelTerminosListener extends MouseAdapter {
		@Override
        public void mouseClicked(MouseEvent e) {
			JFrame frame = new JFrame("NO HAY PRESUPUESTO");
	        frame.setSize(1000, 800);
	        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/assets/BLU_LADRON.jpg"));
		    Image originalImage = imageIcon.getImage();
		    Image resizedImage = originalImage.getScaledInstance(1000, 800, Image.SCALE_SMOOTH);
			ImageIcon resizedIcon = new ImageIcon(resizedImage);
	        JLabel imageLabel = new JLabel(resizedIcon);
	        frame.add(imageLabel);
	        frame.setVisible(true);
        }
	}
	
	public class BotonGenerarDatosListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			modelo.generarStock();
			modelo.generarActivos();
			vista.getPanelMenuPrincipal().actualizarTablaActivos(modelo.getListaActivos());
			vista.repaint();
		}
	}
	
	public class BotonExportarListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				modelo.exportar();
				JOptionPane.showMessageDialog(vista.getPanelMenuPrincipal(),"Datos exportados exitosamente.","Exportación exitosa. ",JOptionPane.PLAIN_MESSAGE, new ImageIcon(new ImageIcon(getClass().getResource("/assets/BLUPROJECT2.png")).getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH)));
			} catch (IOException x) {
				JOptionPane.showMessageDialog(vista.getPanelMenuPrincipal(),"Error con la exportación del archivo .csv, intente nuevamente.","Error exportación. ",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
}


	
