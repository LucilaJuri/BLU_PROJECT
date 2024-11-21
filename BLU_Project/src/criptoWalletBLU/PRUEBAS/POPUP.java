package criptoWalletBLU.PRUEBAS;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class POPUP extends Frame {
	private TextField texto1;
	private Button si;
	private Button no;
	
	public POPUP() {
		setTitle("CONFIRMACION");
		setSize(300, 150);
		setResizable(false);
		setLayout(new BorderLayout());
		
		si = new Button("SI");
		no = new Button("NO");
		texto1 = new TextField("CONFIRMAR");
		
		add(texto1,BorderLayout.NORTH);
		add(si,BorderLayout.EAST);
		add(no,BorderLayout.WEST);
		
		si.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("apreto si!");
            }
		});
		
		no.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("apreto no!");
            }
		});
		
		
		setVisible(true);
		addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
	}
}
