package criptoWalletBLU.APLICACION;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import criptoWalletBLU.CLASES.Moneda;
import criptoWalletBLU.CLASES.OperacionCompra;

@SuppressWarnings("serial")
public class PanelMenuPrincipal extends JPanel {

	private JScrollPane scrollCotizaciones;
	private JTable tableCotizaciones;
	private DefaultTableModel modeloCotizaciones;
	
	private JScrollPane scrollActivos;
	private JTable tableActivos;
	private DefaultTableModel modeloActivos;
	
	private JScrollPane scrollTransacciones;
	private JTable tableTransacciones;
	private DefaultTableModel modeloTransacciones;
	
	private JLabel labelLetrasFoto;
	private JLabel labelNombre;
	private JLabel labelMail;
	private JLabel labelSaldo;
	private JLabel labelCotizaciones;
	private JLabel labelActivos;
	
	private JButton botonDatosPrueba;
	private JButton botonLogOut;
	private JButton botonCSV;
	
	private final String a = "/assets/";
	private final String b = ".png";
	private String iniciales;
	
	public PanelMenuPrincipal() {
		new JPanel();
    	setBounds(0, 0, 1000,600);
    	setLayout(null);
    	setBackground(new Color(40,40,40));
    	
    	modeloCotizaciones = new DefaultTableModel() {
    		
            @Override
            public Class<?> getColumnClass(int columna) {
                switch (columna) {
                    case 0: return ImageIcon.class;
                    case 1: return String.class;
                    case 2: return String.class;
                    case 3: return Double.class;
                    default: return Object.class;
                }
            }
            
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        
    	modeloCotizaciones.addColumn("");
    	modeloCotizaciones.addColumn("NOMENCLATURA");
    	modeloCotizaciones.addColumn("NOMBRE");
    	modeloCotizaciones.addColumn("PRECIO");
    	
    	modeloCotizaciones.addRow(new Object[]{new ImageIcon(getClass().getResource("/assets/BTC.png")),"BTC","Bitcoin",0});
    	modeloCotizaciones.addRow(new Object[]{new ImageIcon(getClass().getResource("/assets/ETH.png")),"ETH","Ethereum",0});
    	modeloCotizaciones.addRow(new Object[]{new ImageIcon(getClass().getResource("/assets/USDC.png")),"USDC","USD Coin",0});
    	modeloCotizaciones.addRow(new Object[]{new ImageIcon(getClass().getResource("/assets/USDT.png")),"USDT","Tether",0});
    	modeloCotizaciones.addRow(new Object[]{new ImageIcon(getClass().getResource("/assets/DOGE.png")),"DOGE","Dogecoin",0});
    	
    	tableCotizaciones = new JTable(modeloCotizaciones);
    	tableCotizaciones.getTableHeader().setReorderingAllowed(false);
    	
    	TableRowSorter<DefaultTableModel> sorter1 = new TableRowSorter<>(modeloCotizaciones);
    	sorter1.setSortable(0, false);
        sorter1.setSortKeys(java.util.Collections.singletonList(new RowSorter.SortKey(1, SortOrder.ASCENDING)));
    	tableCotizaciones.setRowSorter(sorter1);
    	tableCotizaciones.setRowHeight(100);
    	
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(
                    JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setFont(new Font("Arial", Font.BOLD, 20));
                setHorizontalAlignment(SwingConstants.CENTER);
                return c;
            }
        };
        for (int i = 1; i < tableCotizaciones.getColumnCount(); i++) {
        	tableCotizaciones.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
        
    	scrollCotizaciones = new JScrollPane(tableCotizaciones);
    	scrollCotizaciones.setBounds(410, 60, 580, 215);
    	add(scrollCotizaciones);
    	
    	modeloActivos = new DefaultTableModel() {
    		
            @Override
            public Class<?> getColumnClass(int columna) {
                switch (columna) {
                    case 0: return ImageIcon.class;
                    case 1: return String.class;
                    case 2: return String.class;
                    case 3: return Double.class;
                    default: return Object.class;
                }
            }
            
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        
        modeloActivos.addColumn("");
        modeloActivos.addColumn("NOMENCLATURA");
        modeloActivos.addColumn("NOMBRE");
        modeloActivos.addColumn("MONTO");
        
        tableActivos = new JTable(modeloActivos);
        tableActivos.getTableHeader().setReorderingAllowed(false);
        TableRowSorter<DefaultTableModel> sorter2 = new TableRowSorter<>(modeloActivos);
    	sorter2.setSortable(0, false);
        sorter2.setSortKeys(java.util.Collections.singletonList(new RowSorter.SortKey(1, SortOrder.ASCENDING)));
        tableActivos.setRowSorter(sorter2);
        tableActivos.setRowHeight(100);
    	
        for (int i = 1; i < tableActivos.getColumnCount(); i++) {
        	tableActivos.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
        
    	scrollActivos = new JScrollPane(tableActivos);
    	scrollActivos.setBounds(410, 345, 580, 215);
    	add(scrollActivos);
    	
    	modeloTransacciones = new DefaultTableModel() {
    		
            @Override
            public Class<?> getColumnClass(int columna) {
            switch(columna) {
	            case 0: return String.class;
	            case 1: return Double.class;
	            case 2: return String.class;
	            case 3: return Double.class;
	            case 4: return String.class;
	            default: return Object.class;
	        }
            }
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        
        modeloTransacciones.addColumn("FIAT");
        modeloTransacciones.addColumn("CANT FIAT");
        modeloTransacciones.addColumn("CRIPTO");
        modeloTransacciones.addColumn("CANT CRIPTO");
        modeloTransacciones.addColumn("FECHA");
        
        tableTransacciones = new JTable(modeloTransacciones);
        tableTransacciones.getTableHeader().setReorderingAllowed(false);
        TableRowSorter<DefaultTableModel> sorter3 = new TableRowSorter<>(modeloTransacciones);
    	sorter3.setSortable(0, false);
        sorter3.setSortKeys(java.util.Collections.singletonList(new RowSorter.SortKey(1, SortOrder.ASCENDING)));
        tableTransacciones.setRowSorter(sorter3);
        tableTransacciones.setRowHeight(20);
        tableTransacciones.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableTransacciones.getColumnModel().getColumn(4).setPreferredWidth(180);
    	
        DefaultTableCellRenderer renderer2 = new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(
                    JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setFont(new Font("Arial", Font.PLAIN, 15));
                setHorizontalAlignment(SwingConstants.CENTER);
                return c;
            }
        };
        for (int i = 1; i < tableCotizaciones.getColumnCount(); i++) {
        	tableTransacciones.getColumnModel().getColumn(i).setCellRenderer(renderer2);
        }
        
    	scrollTransacciones = new JScrollPane(tableTransacciones);
    	scrollTransacciones.setBounds(20, 220, 360, 270);
    	scrollTransacciones.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    	add(scrollTransacciones);
    	
    	labelCotizaciones=new JLabel("COTIZACIONES");
    	labelCotizaciones.setBounds(580, 10, 300, 40);
    	labelCotizaciones.setFont(new Font("Arial", Font.BOLD, 30));
    	labelCotizaciones.setForeground(Color.WHITE);
    	add(labelCotizaciones);
    	
    	labelActivos=new JLabel("ACTIVOS");
    	labelActivos.setBounds(625, 295, 300, 40);
    	labelActivos.setFont(new Font("Arial", Font.BOLD, 30));
    	labelActivos.setForeground(Color.WHITE);
    	add(labelActivos);
    	
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
    	labelSaldo.setBounds(80, 170, 400, 40);
    	labelSaldo.setFont(new Font("Arial", Font.PLAIN, 35));
    	labelSaldo.setForeground(Color.WHITE);
    	add(labelSaldo);
    	
    	botonDatosPrueba = new JButton("Generar Datos");
    	botonDatosPrueba.setBounds(40, 110, 150, 40);
    	botonDatosPrueba.setFont(new Font("Arial", Font.BOLD, 20));
    	botonDatosPrueba.setFocusPainted(false);
    	botonDatosPrueba.setBackground(new Color(1,87,146));
    	botonDatosPrueba.setForeground(Color.WHITE); 
    	botonDatosPrueba.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		add(botonDatosPrueba);
		
		botonCSV = new JButton("Exportar CSV");
		botonCSV.setBounds(210, 110, 150, 40);
		botonCSV.setFont(new Font("Arial", Font.BOLD, 20));
		botonCSV.setFocusPainted(false);
		botonCSV.setBackground(new Color(1,87,146));
		botonCSV.setForeground(Color.WHITE); 
		botonCSV.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		add(botonCSV);
		
		
		botonLogOut = new JButton("Cerrar sesión");
		botonLogOut.setBounds(100, 510, 200, 40);
		botonLogOut.setFont(new Font("Arial", Font.BOLD, 20));
		botonLogOut.setFocusPainted(false);
		botonLogOut.setBackground(new Color(241,47,74));
		botonLogOut.setForeground(Color.WHITE); 
		botonLogOut.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
		add(botonLogOut);
    	
    	
	}
	
	public void actualizarTablaActivos(List<Moneda> listaActivos) {
		modeloActivos.setRowCount(0);
		for (Moneda m : listaActivos) {
			modeloActivos.addRow(new Object[]{new ImageIcon(getClass().getResource(a+m.getNomenclatura()+b)),m.getNomenclatura(),m.getNombre(),new BigDecimal(m.getCantidad()*m.getPrecio()).setScale(2, RoundingMode.DOWN)});
		}
	}
	
	public void actualizarTablaTransacciones(List<OperacionCompra> listaOperaciones) {
		modeloTransacciones.setRowCount(0);
		for (OperacionCompra o : listaOperaciones) {
			modeloTransacciones.addRow(new Object[] {o.getFiat(),o.getCantFiat(),o.getCripto(),o.getCantCripto(),o.getFecha()});
		}
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(1,87,146));
        g.fillOval(10, 10, 75, 75);
        g.setColor(new Color(1,87,146));
        g.fillRect(400, 0, 5, 600);
        g.fillRect(405,280,595,5);
        g.setColor(Color.WHITE);
        g.drawRect(400, 0, 5, 600);
        g.drawRect(405,280,595,5);
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.BOLD, 40));
        FontMetrics fm = g2d.getFontMetrics();
        int textWidth = fm.stringWidth(iniciales);
        int textHeight = fm.getAscent();
        int centerX = 11 + (75 - textWidth) / 2;
        int centerY = 7 + (75 + textHeight) / 2;
        g2d.drawString(iniciales, centerX, centerY);
        
        
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
	
	public JButton getBotonDatosPrueba() {
		return botonDatosPrueba;
	}
	
	public JButton getBotonCSV() {
		return botonCSV;
	}
	
	public JTable getTableCotizaciones() {
		return tableCotizaciones;
	}
	
	public DefaultTableModel getModeloCotizaciones() {
		return modeloCotizaciones;
	}

	public void setIniciales(String iniciales) {
		this.iniciales = iniciales;
	}
}
