package criptoWalletBLU.SERVICIOS;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import criptoWalletBLU.CLASES.Moneda;
import criptoWalletBLU.COMPARATORS.ComparadorCantidad;
import criptoWalletBLU.COMPARATORS.ComparadorNomenclatura;
import criptoWalletBLU.COMPARATORS.ComparadorValor;
import criptoWalletBLU.DAO.*;

public class PruebasEntregable2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		generarStock();
	}
	/*
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
	*/
	public static void generarStock() {
		STOCKDAO stockDao = FACTORYDAO.getSTOCKDAO();
		ResultSet result = stockDao.selectNomenclaturas();
		List<String> l = new ArrayList<String>();
		try {
			while(result.next()) {
				l.add(result.getString("NOMENCLATURA"));
			}
			for (String nomenclatura : l) {
				stockDao.updateCantidad(nomenclatura, Math.random()*10001);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	public static int crearActivo(Scanner in) {
		STOCKDAO stockDao = FACTORYDAO.getSTOCKDAO();
		ResultSet result = stockDao.selectNomenclaturas();
		List<String> l = new ArrayList<String>();
		try {
			while(result.next()) {
				l.add(result.getString("NOMENCLATURA"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Ingrese nomenclatura");
		System.out.println(l.toString());
		String nomenclatura = in.next().toUpperCase();
		while (!l.contains(nomenclatura)) {
			System.out.println("ERROR");
			System.out.println("Ingrese nomenclatura");
			System.out.println(l.toString());
			nomenclatura = in.next().toUpperCase();
		}
		System.out.println("Ingrese cantidad");
		double cantidad = in.nextDouble();
		System.out.println("Confirmar operacion (Y/N)");
		String confirmar = in.next().toUpperCase();
		while ((!confirmar.equals("Y"))&& (!confirmar.equals("N"))){
			System.out.println("ERROR");
			System.out.println("Confirmar operacion (Y/N)");
			confirmar = in.next().toUpperCase();
		}
		if (confirmar.equals("Y")) {
			ACTIVODAO activoDao = FACTORYDAO.getACTIVODAO();
			return activoDao.instertACTIVO(0, cantidad, nomenclatura);
		}
		else System.out.println("Operacion cancelada.");
		return 0;
	}
	
	public static void listarActivos(Scanner in) {
		System.out.println("Ingrese criterio de ordenacion (CANTIDAD/NOMENCLATURA)");
		String i = in.next().toUpperCase();
		while ((!i.equals("CANTIDAD"))&& (!i.equals("NOMENCLATURA"))){
			System.out.println("ERROR: criterio no válido");
			System.out.println("Ingrese criterio de ordenacion (CANTIDAD/NOMENCLATURA)");
			i = in.next().toUpperCase();
		}
		//System.out.println("Ingrese idUsuario: ");
		//int idusuario = in.nextInt();
		ACTIVODAO activoDao = FACTORYDAO.getACTIVODAO();
		List<Moneda> l = new ArrayList<Moneda>();
		ResultSet result = activoDao.selectACTIVOS(0);
		try {
			while(result.next()) {
				l.add(new Moneda(0,result.getDouble("CANTIDAD") ,"", result.getString("NOMENCLATURA"),0));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i.equals("CANTIDAD"))l.sort(new ComparadorCantidad());
		else l.sort(new ComparadorNomenclatura());
		for (Moneda moneda : l) System.out.println(moneda.getNomenclatura()+" "+moneda.getNombre()+" "+moneda.getCantidad());
	}
	*/
	private static void mosequenombreponerle(Scanner in) {
		STOCKDAO stockDao = FACTORYDAO.getSTOCKDAO();
		ACTIVODAO activoDao = FACTORYDAO.getACTIVODAO();
		List<String> listaCriptos = new ArrayList<String>();
		List<String> listaFiats = new ArrayList<String>();
		List<Moneda> listaActivos = new ArrayList<Moneda>();
		Moneda fiatElegidaMoneda = new Moneda();
		boolean validacion = false;
		boolean existeCripto=false;
		double cantidadComprada;
		double precioCripto=0;
		double cantidadEnStock=0;
		double cantidadActivo=0;
	
		listaCriptos = stockDao.selectNomenclaturasCripto();
		
		System.out.println("Ingrese CRIPTOMONEDA a comprar:");
		System.out.println(listaCriptos.toString());
		String criptomonedaElegida = in.next().toUpperCase();
		while (!listaCriptos.contains(criptomonedaElegida)) {
			System.out.println("ERROR: CRIPTOMONEDA no valida.");
			System.out.println("Ingrese CRIPTOMONEDA a comprar:");
			System.out.println(listaCriptos.toString());
			criptomonedaElegida = in.next().toUpperCase();
		}
		
		listaFiats=stockDao.selectNomenclaturasFiat();
		System.out.println("Ingrese FIAT a convertir:");
		System.out.println(listaFiats.toString());
		String fiatElegida = in.next().toUpperCase();
		while (!listaFiats.contains(fiatElegida)) {
			System.out.println("ERROR: FIAT no valida.");
			System.out.println("Ingrese FIAT a convertir:");
			System.out.println(listaFiats.toString());
			fiatElegida = in.next().toUpperCase();
		}
		
		System.out.println("Ingrese cantidad de "+fiatElegida+" a convertir:");
		double cantidadElegida = in.nextInt();
		listaActivos=activoDao.selectACTIVOS(0);
		for (Moneda activo : listaActivos) {
			if(activo.getNomenclatura().equals(fiatElegida)) {
				if(activo.getCantidad()>=cantidadElegida) {
					cantidadActivo=activo.getCantidad();
					validacion = true;
					break;
				}
				System.out.println("ERROR: fondos insuficientes.");
				return;
			}
		}
		if (!validacion) {
			System.out.println("ERROR: no posee esa FIAT");
			return;
		}
		
		for (Moneda activo : listaActivos) {
			if(activo.getNomenclatura().equals(criptomonedaElegida)) {
				existeCripto=true;
				break;
			}
		}

		fiatElegidaMoneda.setPrecio(stockDao.selectPrecioNomenclatura(fiatElegida));
		precioCripto=(stockDao.selectPrecioNomenclatura(criptomonedaElegida));
		cantidadEnStock=(stockDao.selectCantidadNomenclatura(criptomonedaElegida));
		
		cantidadComprada=fiatElegidaMoneda.convertir(cantidadElegida, precioCripto);
		if (cantidadComprada>cantidadEnStock) {
			System.out.println("ERROR: no hay STOCK suficiente de: "+criptomonedaElegida);
			return;
		}

		stockDao.updateCantidad(criptomonedaElegida, cantidadEnStock-cantidadComprada);
		activoDao.updateCantidad(fiatElegida, cantidadActivo-cantidadElegida, 0);
		
	}
}
