package criptoWalletBLU.APLICACION;

import javax.swing.*;

@SuppressWarnings("serial")
public class Vista extends JFrame{
	
	private PanelLogIn panelLogIn;
	
    private PanelSignUp panelSignUp;
    
    private PanelMenuPrincipal panelMenuPrincipal;
    
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
	
	
	
}
