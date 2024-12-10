package criptoWalletBLU.APLICACION;

import java.awt.Image;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.swing.*;

import criptoWalletBLU.CLASES.Moneda;

@SuppressWarnings("serial")
public class Vista extends JFrame{
	
	private PanelLogIn panelLogIn;
    private PanelSignUp panelSignUp;
    private PanelMenuPrincipal panelMenuPrincipal;
    private PanelCompra panelCompra;
    
    public Vista() {
    	setTitle("BLU PROJECT: CRIPTO WALLET");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setResizable(false);
    	setLayout(null);
    	setSize(450,300);
    	setLocationRelativeTo(null);
    	
    	panelLogIn = new PanelLogIn();
    	add(panelLogIn);
    	
    	panelSignUp = new PanelSignUp();
    	add(panelSignUp);
    	panelSignUp.setVisible(false);
    	
    	panelMenuPrincipal = new PanelMenuPrincipal();
    	add(panelMenuPrincipal);
    	panelMenuPrincipal.setVisible(false);
    	
    	panelCompra = new PanelCompra();
    	add(panelCompra);
    	panelCompra.setVisible(false);
    	
    	setVisible(true);
    }
    
	public PanelLogIn getPanelLogIn() {
		return panelLogIn;
	}

	public PanelSignUp getPanelSignUp() {
		return panelSignUp;
	}

	public PanelMenuPrincipal getPanelMenuPrincipal() {
		return panelMenuPrincipal;
	}
	
	public PanelCompra getPanelCompra() {
		return panelCompra;
	}
	
	public void optionPane(String nombre, String nomenclatura, double stock, double precio, boolean swap, List<Moneda> activos) {
		String message = "Seleccione operacion a realizar ("+nomenclatura+")";
		Object[] options;
		if (swap) {options = new Object[]{"Compra", "Swap", "Atrás"};}
        else {options = new Object[]{"Compra", "Atrás"};}
        int choice = JOptionPane.showOptionDialog(
            null,
            message,
            "Opciones",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            new ImageIcon(getClass().getResource("/assets/"+nomenclatura+".png")),
            options,
            options[0]
        );

        switch (choice) {
            case 0:
            	panelCompra.getLabelStock().setText("Stock disponible: "+ new BigDecimal(stock).setScale(2, RoundingMode.DOWN) +" "+nombre+" ("+nomenclatura+")");
            	panelCompra.getLabelCompra().setText("Precio de compra: "+precio+" USD");
            	panelCompra.setNomenclatura(nomenclatura);
            	panelCompra.actualizarActivos(activos);
            	panelMenuPrincipal.setVisible(false);
                setSize(panelCompra.getSize());
                panelCompra.setVisible(true);
                setLocationRelativeTo(null);
                panelCompra.getTimer().restart();
                repaint();
                break;
            case 1: // Swap
            	if (swap) {
	            	JFrame frame = new JFrame("NO HAY PRESUPUESTO");
	    	        frame.setSize(1000, 800);
	    	        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/assets/BLU_LADRON2.jpg"));
	    		    Image originalImage = imageIcon.getImage();
	    		    Image resizedImage = originalImage.getScaledInstance(1000, 800, Image.SCALE_SMOOTH);
	    			ImageIcon resizedIcon = new ImageIcon(resizedImage);
	    	        JLabel imageLabel = new JLabel(resizedIcon);
	    	        frame.add(imageLabel);
	    	        frame.setVisible(true);
            	}
                break;
            case 2:break;
            default:break;
        }
	}
	
}
