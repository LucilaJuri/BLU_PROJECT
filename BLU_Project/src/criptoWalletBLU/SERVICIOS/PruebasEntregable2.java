package criptoWalletBLU.SERVICIOS;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import criptoWalletBLU.CLASES.Moneda;
import criptoWalletBLU.CLASES.OperacionCompra;
import criptoWalletBLU.COMPARATORS.*;
import criptoWalletBLU.DAO.*;

public class PruebasEntregable2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("BIENVENIDO A BLU PROJECT: CRIPTO WALLET");
		System.out.println();
		System.out.println("INGRESE TAREA A REALIZAR");
		System.out.println("1) Crear MONEDA.");
		System.out.println("2) Listar MONEDAS.");
		System.out.println("3) Generar STOCK.");
		System.out.println("4) Listar STOCK.");
		System.out.println("5) Crear mis ACTIVOS.");
		System.out.println("6) Listar mis ACTIVOS.");
		System.out.println("7) Compra de CRIPTOMONEDAS.");
		System.out.println("8) SWAP.");
		System.out.println("9) SALIR.");
		int eleccion = in.nextInt();
		while (eleccion!=9) {
			switch (eleccion) {
			case 1 : crearMoneda(in);break;
			case 2 : listarMonedas(in);break;
			case 3 : generarStock();break;
			case 4 : listarStock(in);break;
			case 5 : crearActivo(in);break;
			case 6 : listarActivos(in);break;
			case 7 : simularCompra(in);break;
			case 8 : simularSwap(in);break;
			case 9 : break;
			default: System.out.println("ERROR: OPCION NO VALIDA, INTENTE NUEVAMENTE.");
			}
			System.out.println();
			System.out.println("INGRESE TAREA A REALIZAR");
			System.out.println("1) Crear MONEDA.");
			System.out.println("2) Listar MONEDAS.");
			System.out.println("3) Generar STOCK.");
			System.out.println("4) Listar STOCK.");
			System.out.println("5) Crear mis ACTIVOS.");
			System.out.println("6) Listar mis ACTIVOS.");
			System.out.println("7) Compra de CRIPTOMONEDAS.");
			System.out.println("8) SWAP.");
			System.out.println("9) SALIR.");
			eleccion = in.nextInt();
		}
		System.out.println();
		System.out.println("MUCHAS GRACIAS.");System.out.println("ATTE: BLU PROJECT INC.");
		
		
	}

	public static void crearMoneda(Scanner in) {
		System.out.println("Ingrese tipo (CRIPTO o FIAT)");
		String tipo = in.next().toUpperCase();
		while ((!tipo.equals("CRIPTO"))&& (!tipo.equals("FIAT"))){
			System.out.println("ERROR: tipo no válido");
			System.out.println("Ingrese tipo (CRIPTO o FIAT)");
			tipo = in.next().toUpperCase();
		}
		System.out.println("Ingrese nombre: ");
		String nombre = in.next();
		System.out.println("Ingrese nomenclatura: ");
		String nomenclatura= in.next().toUpperCase();
		System.out.println("Ingrese valor en dolar: ");
		double precio = in.nextDouble();
		double volatilidad;
		double cantidad;
		if (tipo.equals("CRIPTO")) {
			System.out.println("Ingrese volatilidad: ");
			volatilidad = in.nextDouble();
			System.out.println("Ingrese stock disponible");
			cantidad = in.nextDouble();
		}
		else {
			volatilidad = 0;
			cantidad = 0;
		}
		System.out.println("Confirmar operacion (Y/N)");
		String confirmar = in.next().toUpperCase();
		while ((!confirmar.equals("Y"))&& (!confirmar.equals("N"))){
			System.out.println("ERROR");
			System.out.println("Confirmar operacion (Y/N)");
			confirmar = in.next().toUpperCase();
		}
		if (confirmar.equals("Y")) {
			Moneda moneda = new Moneda(precio, cantidad, nombre, nomenclatura, volatilidad);
			STOCKDAO stockDao = FACTORYDAO.getSTOCKDAO();
			stockDao.insertSTOCK(moneda, tipo);
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
		List<Moneda> listaStock = stockDao.selectSTOCK();
		if (i.equals("VALOR"))listaStock.sort(new ComparadorValor());
		else listaStock.sort(new ComparadorNomenclatura());
		for (Moneda moneda : listaStock) System.out.println(moneda.getNomenclatura()+" "+moneda.getNombre()+" "+moneda.getPrecio());
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
		List<Moneda> listaStock = stockDao.selectSTOCKCripto();
		if (i.equals("CANTIDAD"))listaStock.sort(new ComparadorCantidad());
		else listaStock.sort(new ComparadorNomenclatura());
		for (Moneda moneda : listaStock) System.out.println(moneda.getNomenclatura()+" "+moneda.getNombre()+" "+moneda.getCantidad());
	}
	
	public static void generarStock() {
		STOCKDAO stockDao = FACTORYDAO.getSTOCKDAO();
		List<String> listaNomenclaturas = stockDao.selectNomenclaturasCripto();
		Moneda moneda=new Moneda();
		for (String nomenclatura : listaNomenclaturas) {
			moneda.setNomenclatura(nomenclatura);
			moneda.setCantidad(Math.random()*10001);
			stockDao.updateCantidad(moneda);
		}
	}
	
	public static int crearActivo(Scanner in) {
		STOCKDAO stockDao = FACTORYDAO.getSTOCKDAO();
		ACTIVODAO activoDao = FACTORYDAO.getACTIVODAO();
		List<String> listaStock = stockDao.selectNomenclaturas();
		List<String> listaActivos = activoDao.selectNomenclaturas(0);
		List<String> listaInterseccion = new ArrayList<String>();
		for (String str : listaStock) {
			if (!listaActivos.contains(str)) listaInterseccion.add(str);
		}
		
		System.out.println("Ingrese nomenclatura");
		System.out.println(listaInterseccion.toString());
		String nomenclatura = in.next().toUpperCase();
		while (!listaInterseccion.contains(nomenclatura)) {
			System.out.println("ERROR");
			System.out.println("Ingrese nomenclatura");
			System.out.println(listaInterseccion.toString());
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
			Moneda moneda = new Moneda();
			moneda.setNomenclatura(nomenclatura);
			moneda.setCantidad(cantidad);
			return activoDao.insertACTIVO(0, moneda);
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
		ACTIVODAO activoDao = FACTORYDAO.getACTIVODAO();
		List<Moneda> listaActivos = activoDao.selectACTIVOS(0);
		if (i.equals("CANTIDAD"))listaActivos.sort(new ComparadorCantidad());
		else listaActivos.sort(new ComparadorNomenclatura());
		for (Moneda moneda : listaActivos) System.out.println(moneda.getNomenclatura()+" "+moneda.getNombre()+" "+moneda.getCantidad());
	}
	
	private static void simularCompra(Scanner in) {
		STOCKDAO stockDao = FACTORYDAO.getSTOCKDAO();
		ACTIVODAO activoDao = FACTORYDAO.getACTIVODAO();
		List<String> listaCriptos = new ArrayList<String>();
		List<String> listaFiats = new ArrayList<String>();
		List<Moneda> listaActivos = new ArrayList<Moneda>();
		boolean validacion = false;
		boolean existeCripto=false;
		double cantidadComprada;
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
		Moneda fiatElegidaMoneda = new Moneda();
		fiatElegidaMoneda.setNomenclatura(fiatElegida);
		fiatElegidaMoneda.setPrecio(stockDao.selectPrecioNomenclatura(fiatElegidaMoneda));
		
		Moneda criptoElegidaMoneda = new Moneda();
		criptoElegidaMoneda.setNomenclatura(criptomonedaElegida);
		criptoElegidaMoneda.setPrecio(stockDao.selectPrecioNomenclatura(criptoElegidaMoneda));
		cantidadEnStock=(stockDao.selectCantidadNomenclatura(criptoElegidaMoneda));
		
		cantidadComprada=fiatElegidaMoneda.convertir(cantidadElegida, criptoElegidaMoneda);
		if (cantidadComprada>cantidadEnStock) {
			System.out.println("ERROR: no hay STOCK suficiente de: "+criptomonedaElegida);
			return;
		}
		criptoElegidaMoneda.setCantidad(cantidadEnStock-cantidadComprada);
		stockDao.updateCantidad(criptoElegidaMoneda);
		
		fiatElegidaMoneda.setCantidad(cantidadActivo-cantidadElegida);
		activoDao.updateCantidad(0,fiatElegidaMoneda);
		
		if (existeCripto) {
			double cantidadCriptomoneda = activoDao.selectCantidadNomenclatura(criptoElegidaMoneda);
			criptoElegidaMoneda.setCantidad(cantidadCriptomoneda+cantidadComprada);
			activoDao.updateCantidad(0,criptoElegidaMoneda);
		}
		else {
			criptoElegidaMoneda.setCantidad(cantidadComprada);
			activoDao.insertACTIVO(0, criptoElegidaMoneda);
		}
		
		OperacionCompra datosOperacion = new OperacionCompra(criptomonedaElegida,fiatElegida,cantidadComprada,cantidadElegida,Calendar.getInstance().getTime().toString());
		DATOSCOMPRADAO compraDAO=FACTORYDAO.getDATOSCOMPRADAO();
		compraDAO.insertDATOSCOMPRA(datosOperacion);
	}
	
	private static void simularSwap(Scanner in) {
		STOCKDAO stockDao = FACTORYDAO.getSTOCKDAO();
		ACTIVODAO activoDao = FACTORYDAO.getACTIVODAO();
		List<String> listaCriptosActivos = new ArrayList<String>();
		List<String> listaCriptos = new ArrayList<String>();
		List<String> listaFiats = new ArrayList<String>();
		List<Moneda> listaActivos = new ArrayList<Moneda>();
		boolean validacion = false;
		boolean existeCripto=false;
		double cantidadEnStock=0;
		double cantidadActivo=0;
	
		listaCriptosActivos = activoDao.selectNomenclaturasCripto(0);
		
		System.out.println("Ingrese CRIPTOMONEDA a convertir:");
		System.out.println(listaCriptosActivos.toString());
		String criptomonedaConvertir = in.next().toUpperCase();
		while (!listaCriptosActivos.contains(criptomonedaConvertir)) {
			System.out.println("ERROR: CRIPTOMONEDA no valida.");
			System.out.println("Ingrese CRIPTOMONEDA a convertir:");
			System.out.println(listaCriptosActivos.toString());
			criptomonedaConvertir = in.next().toUpperCase();
		}
		
		listaCriptos=stockDao.selectNomenclaturasCripto();
		System.out.println("Ingrese CRIPTOMONEDA esperada:");
		System.out.println(listaCriptos.toString());
		String criptomonedaEsperada = in.next().toUpperCase();
		while (!listaCriptos.contains(criptomonedaEsperada)) {
			System.out.println("ERROR: CRIPTOMONEDA no valida.");
			System.out.println("Ingrese CRIPTOMONEDA a esperada:");
			System.out.println(listaCriptos.toString());
			criptomonedaEsperada = in.next().toUpperCase();
		}
		
		System.out.println("Ingrese cantidad de "+criptomonedaConvertir+" a convertir:");
		double cantidadElegida = in.nextInt();
		listaActivos=activoDao.selectACTIVOS(0);
		for (Moneda activo : listaActivos) {
			if(activo.getNomenclatura().equals(criptomonedaConvertir)) {
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
			System.out.println("ERROR: no posee esa CRIPTOMONEDA.");
			return;
		}
		
		for (Moneda activo : listaActivos) {
			if(activo.getNomenclatura().equals(criptomonedaEsperada)) {
				existeCripto=true;
				break;
			}
		}
		Moneda criptoConvertirMoneda = new Moneda();
		criptoConvertirMoneda.setNomenclatura(criptomonedaConvertir);
		criptoConvertirMoneda.setPrecio(stockDao.selectPrecioNomenclatura(criptoConvertirMoneda));
		
		Moneda criptoEsperadaMoneda = new Moneda();
		criptoEsperadaMoneda.setNomenclatura(criptomonedaEsperada);
		criptoEsperadaMoneda.setPrecio(stockDao.selectPrecioNomenclatura(criptoEsperadaMoneda));
		double cantidadEsperadaStock=(stockDao.selectCantidadNomenclatura(criptoEsperadaMoneda));
		double cantidadConvertirStock=(stockDao.selectCantidadNomenclatura(criptoConvertirMoneda));
		
		double cantidadConvertida=criptoConvertirMoneda.convertir(cantidadElegida, criptoEsperadaMoneda);
		if (cantidadConvertida>cantidadEsperadaStock) {
			System.out.println("ERROR: no hay STOCK suficiente de: "+criptomonedaEsperada);
			return;
		}
		criptoEsperadaMoneda.setCantidad(cantidadEsperadaStock-cantidadConvertida);
		stockDao.updateCantidad(criptoEsperadaMoneda);
		
		criptoConvertirMoneda.setCantidad(cantidadConvertirStock+cantidadElegida);
		stockDao.updateCantidad(criptoConvertirMoneda);
		
		criptoConvertirMoneda.setCantidad(cantidadActivo-cantidadElegida);
		activoDao.updateCantidad(0,criptoConvertirMoneda);
		
		if (existeCripto) {
			double cantidadEsperada = activoDao.selectCantidadNomenclatura(criptoElegidaMoneda);
			criptoElegidaMoneda.setCantidad(cantidadCriptomoneda+cantidadComprada);
			activoDao.updateCantidad(0,criptoElegidaMoneda);
		}
		else {
			criptoElegidaMoneda.setCantidad(cantidadComprada);
			activoDao.insertACTIVO(0, criptoElegidaMoneda);
		}
		
		OperacionCompra datosOperacion = new OperacionCompra(criptomonedaElegida,fiatElegida,cantidadComprada,cantidadElegida,Calendar.getInstance().getTime().toString());
		DATOSCOMPRADAO compraDAO=FACTORYDAO.getDATOSCOMPRADAO();
		compraDAO.insertDATOSCOMPRA(datosOperacion);
	}
}
