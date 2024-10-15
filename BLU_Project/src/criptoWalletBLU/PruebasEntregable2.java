package criptoWalletBLU;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 
import criptoWalletBLU.DAO.*;

public class PruebasEntregable2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		generarStock();
		listarStock(in);
	}

	public static void crearMoneda(Scanner in) {
		System.out.println("Ingrese tipo (CRIPTO o FIAT)");
		String tipo = in.next().toUpperCase();
		while ((!tipo.equals("CRIPTO"))&& (!tipo.equals("FIAT"))){
			System.out.println("ERROR: tipo no válido");
			System.out.println("Ingrese tipo (CRIPTO o FIAT)");
			tipo = in.next().toUpperCase();
		}
		System.out.println("Ingrese nombre");
		String nombre = in.next();
		System.out.println("Ingrese nomenclatura");
		String nomenclatura= in.next().toUpperCase();
		System.out.println("Ingrese valor en dolar");
		double dolar = in.nextDouble();
		System.out.println("Ingrese stock disponible");
		double stock = in.nextDouble();
		System.out.println("Confirmar operacion (Y/N)");
		String confirmar = in.next().toUpperCase();
		while ((!confirmar.equals("Y"))&& (!confirmar.equals("N"))){
			System.out.println("ERROR");
			System.out.println("Confirmar operacion (Y/N)");
			confirmar = in.next().toUpperCase();
		}
		if (confirmar.equals("Y")) {
			STOCKDAO stockDao = FACTORYDAO.getSTOCKDAO();
			stockDao.insertSTOCK(nomenclatura, dolar, stock, nombre, tipo);
		}
		else System.out.println("Operacion cancelada.");
	}
	
	public static void listarMonedas(Scanner in) {
		System.out.println("Ingrese criterio de ordenacion (VALOR/NOMENCLATURA)");
		String i = in.next().toUpperCase();
		while ((!i.equals("VALOR"))&& (!i.equals("NOMENCLATURA"))){
			System.out.println("ERROR: criterio no válido");
			System.out.println("Ingrese criterio de ordenacion (VALOR/NOMENCLATURA)");
			i = in.next().toUpperCase();
		}
		STOCKDAO stockDao = FACTORYDAO.getSTOCKDAO();
		List<Moneda> l = new ArrayList<Moneda>();
		ResultSet result = stockDao.selectSTOCK();
		try {
			while(result.next()) {
				l.add(new Moneda(result.getDouble("PRECIO"),result.getDouble("CANTIDAD") , result.getString("NOMBRE"), result.getString("NOMENCLATURA"), result.getDouble("VOLATILIDAD")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i.equals("VALOR"))l.sort(new ComparadorValor());
		else l.sort(new ComparadorNomenclatura());
		for (Moneda moneda : l) System.out.println(moneda.getNomenclatura()+" "+moneda.getNombre()+" "+moneda.getPrecio());
	}
	
	public static void listarStock(Scanner in) {
		System.out.println("Ingrese criterio de ordenacion (CANTIDAD/NOMENCLATURA)");
		String i = in.next().toUpperCase();
		while ((!i.equals("CANTIDAD"))&& (!i.equals("NOMENCLATURA"))){
			System.out.println("ERROR: criterio no válido");
			System.out.println("Ingrese criterio de ordenacion (CANTIDAD/NOMENCLATURA)");
			i = in.next().toUpperCase();
		}
		STOCKDAO stockDao = FACTORYDAO.getSTOCKDAO();
		List<Moneda> l = new ArrayList<Moneda>();
		ResultSet result = stockDao.selectSTOCK();
		try {
			while(result.next()) {
				l.add(new Moneda(result.getDouble("PRECIO"),result.getDouble("CANTIDAD") , result.getString("NOMBRE"), result.getString("NOMENCLATURA"), result.getDouble("VOLATILIDAD")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i.equals("CANTIDAD"))l.sort(new ComparadorCantidad());
		else l.sort(new ComparadorNomenclatura());
		for (Moneda moneda : l) System.out.println(moneda.getNomenclatura()+" "+moneda.getNombre()+" "+moneda.getCantidad());
	}
	
	public static void generarStock() {
		System.out.println("hola");
		STOCKDAO stockDao = FACTORYDAO.getSTOCKDAO();
		int cant = stockDao.contarSTOCK();
		for (int i=1; i<=cant; i++) {
			stockDao.updateCantidad(i, Math.random()*10001);
		}
	}
}
