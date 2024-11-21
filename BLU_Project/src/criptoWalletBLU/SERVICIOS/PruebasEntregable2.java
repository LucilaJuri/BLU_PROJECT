//package criptoWalletBLU.SERVICIOS;
//
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.List;
//import java.util.Scanner;
//
//import criptoWalletBLU.CLASES.Moneda;
//import criptoWalletBLU.CLASES.OperacionCompra;
//import criptoWalletBLU.CLASES.OperacionSwap;
//import criptoWalletBLU.COMPARATORS.*;
//import criptoWalletBLU.DAO.*;
//import criptoWalletBLU.ENUMS.StringsConstantes;
//
//public class PruebasEntregable2 {
//
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		inicializarDataBase();
//		System.out.println("BIENVENIDO A BLU PROJECT: CRIPTO WALLET\n");
//		System.out.println(
//				"INGRESE TAREA A REALIZAR \n1) Crear MONEDA.\n2) Listar MONEDAS.\n3) Generar STOCK.\n4) Listar STOCK.\n5) Crear mis ACTIVOS.\n6) Listar mis ACTIVOS.\n7) Compra de CRIPTOMONEDAS.\n8) SWAP.\n9) SALIR.");
//		int eleccion = in.nextInt();
//		in.nextLine();
//		while (eleccion != 9) {
//			switch (eleccion) {
//			case 1:
//				crearMoneda(in);
//				break;
//			case 2:
//				listarMonedas(in);
//				break;
//			case 3:
//				generarStock();
//				break;
//			case 4:
//				listarStock(in);
//				break;
//			case 5:
//				crearActivo(in);
//				break;
//			case 6:
//				listarActivos(in);
//				break;
//			case 7:
//				simularCompra(in);
//				break;
//			case 8:
//				simularSwap(in);
//				break;
//			case 9:
//				break;
//			default:
//				System.out.println("ERROR: OPCION NO VALIDA, INTENTE NUEVAMENTE.");
//			}
//			System.out.println();
//			System.out.println(
//					"INGRESE TAREA A REALIZAR \n1) Crear MONEDA.\n2) Listar MONEDAS.\n3) Generar STOCK.\n4) Listar STOCK.\n5) Crear mis ACTIVOS.\n6) Listar mis ACTIVOS.\n7) Compra de CRIPTOMONEDAS.\n8) SWAP.\n9) SALIR.");
//			eleccion = in.nextInt();
//			in.nextLine();
//		}
//		System.out.println("\nMUCHAS GRACIAS.\nATTE: BLU PROJECT INC. SA.");
//
//	}
//
//	public static void inicializarDataBase() {
//		StockDao stockDao = FactoryDao.getStockDao();
//		ActivoDao activoDao = FactoryDao.getActivoDao();
//		DatosSwapDao swapDao = FactoryDao.getDatosSwapDao();
//		DatosCompraDao compraDao = FactoryDao.getDatosCompraDao();
//
//		stockDao.crearTablaStock();
//		activoDao.crearTablaActivos();
//		swapDao.crearTablaDatosSwap();
//		compraDao.crearTablaDatosCompra();
//	}
//
//	public static void crearMoneda(Scanner in) {
//		System.out.println(
//				"Ingrese tipo (" + StringsConstantes.CRIPTO.getStr() + " o " + StringsConstantes.FIAT.getStr() + ")");
//		String tipo = in.nextLine().toUpperCase();
//		while ((!tipo.equals(StringsConstantes.CRIPTO.getStr())) && (!tipo.equals(StringsConstantes.FIAT.getStr()))) {
//			System.out.println("ERROR: tipo no válido.\nIngrese tipo (" + StringsConstantes.CRIPTO.getStr() + " o "
//					+ StringsConstantes.FIAT.getStr() + ")");
//			tipo = in.nextLine().toUpperCase();
//		}
//		System.out.println("Ingrese nombre: ");
//		String nombre = in.nextLine();
//		System.out.println("Ingrese nomenclatura: ");
//		String nomenclatura = in.nextLine().toUpperCase();
//		System.out.println("Ingrese valor en dolar: ");
//		double precio = in.nextDouble();
//		in.nextLine();
//		double volatilidad;
//		double cantidad;
//		if (tipo.equals(StringsConstantes.CRIPTO.getStr())) {
//			System.out.println("Ingrese volatilidad: ");
//			volatilidad = in.nextDouble();
//			System.out.println("Ingrese stock disponible");
//			cantidad = in.nextDouble();
//			in.nextLine();
//		} else {
//			volatilidad = 0;
//			cantidad = 0;
//		}
//		System.out.println("TIPO de la moneda a crear: " + tipo);
//		System.out.println("NOMENCALTURA de la moneda a crear: " + nomenclatura);
//		System.out.println("NOMBRE de la moneda a crear: " + nombre);
//		System.out.println("PRECIO de la moneda a crear: " + precio);
//		if (tipo.equals(StringsConstantes.CRIPTO.getStr())) {
//			System.out.println("VOLATILIDAD de la moneda a crear: " + volatilidad);
//			System.out.println("STOCK de la moneda a crear: " + cantidad);
//		}
//		System.out.println(
//				"Confirmar operacion (" + StringsConstantes.Y.getStr() + "/" + StringsConstantes.N.getStr() + ")");
//		String confirmar = in.nextLine().toUpperCase();
//		while ((!confirmar.equals(StringsConstantes.Y.getStr())) && (!confirmar.equals(StringsConstantes.N.getStr()))) {
//			System.out.println("ERROR\nConfirmar operacion (" + StringsConstantes.Y.getStr() + "/"
//					+ StringsConstantes.N.getStr() + ")");
//			confirmar = in.nextLine().toUpperCase();
//		}
//		if (confirmar.equals(StringsConstantes.Y.getStr())) {
//			Moneda moneda = new Moneda(precio, cantidad, nombre, nomenclatura, volatilidad);
//			StockDao stockDao = FactoryDao.getStockDao();
//			stockDao.insertStock(moneda, tipo);
//		} else
//			System.out.println("Operacion cancelada.");
//	}
//
//	public static void listarMonedas(Scanner in) {
//		System.out.println("Ingrese criterio de ordenacion (" + StringsConstantes.VALOR.getStr() + "/"
//				+ StringsConstantes.NOMENCLATURA.getStr() + ")");
//		String i = in.nextLine().toUpperCase();
//		while ((!i.equals(StringsConstantes.VALOR.getStr())) && (!i.equals(StringsConstantes.NOMENCLATURA.getStr()))) {
//			System.out.println("ERROR: criterio no válido.\nIngrese criterio de ordenacion ("
//					+ StringsConstantes.VALOR.getStr() + "/" + StringsConstantes.NOMENCLATURA.getStr() + ")");
//			i = in.nextLine().toUpperCase();
//		}
//		StockDao stockDao = FactoryDao.getStockDao();
//		List<Moneda> listaStock = stockDao.selectStock();
//		if (i.equals(StringsConstantes.VALOR.getStr()))
//			listaStock.sort(new ComparadorValor());
//		else
//			listaStock.sort(new ComparadorNomenclatura());
//		for (Moneda moneda : listaStock)
//			System.out.println(moneda.getNomenclatura() + " " + moneda.getNombre() + " " + moneda.getPrecio());
//	}
//
//	public static void listarStock(Scanner in) {
//		System.out.println("Ingrese criterio de ordenacion (" + StringsConstantes.CANTIDAD.getStr() + "/"
//				+ StringsConstantes.NOMENCLATURA.getStr() + ")");
//		String i = in.nextLine().toUpperCase();
//		while ((!i.equals(StringsConstantes.CANTIDAD.getStr()))
//				&& (!i.equals(StringsConstantes.NOMENCLATURA.getStr()))) {
//			System.out.println("ERROR: criterio no válido.\nIngrese criterio de ordenacion ("
//					+ StringsConstantes.CANTIDAD.getStr() + "/" + StringsConstantes.NOMENCLATURA.getStr() + ")");
//			i = in.nextLine().toUpperCase();
//		}
//		StockDao stockDao = FactoryDao.getStockDao();
//		List<Moneda> listaStock = stockDao.selectStockCripto();
//		if (i.equals(StringsConstantes.CANTIDAD.getStr()))
//			listaStock.sort(new ComparadorCantidad());
//		else
//			listaStock.sort(new ComparadorNomenclatura());
//		for (Moneda moneda : listaStock)
//			System.out.println(moneda.getNomenclatura() + " " + moneda.getNombre() + " " + moneda.getCantidad());
//	}
//
//	public static void generarStock() {
//		StockDao stockDao = FactoryDao.getStockDao();
//		List<String> listaNomenclaturas = stockDao.selectNomenclaturasCripto();
//		Moneda moneda = new Moneda();
//		for (String nomenclatura : listaNomenclaturas) {
//			moneda.setNomenclatura(nomenclatura);
//			moneda.setCantidad(Math.random() * 10001);
//			stockDao.updateCantidad(moneda);
//		}
//	}
//
//	public static int crearActivo(Scanner in) {
//		StockDao stockDao = FactoryDao.getStockDao();
//		ActivoDao activoDao = FactoryDao.getActivoDao();
//		List<String> listaStock = stockDao.selectNomenclaturas();
//		List<String> listaActivos = activoDao.selectNomenclaturas(0);
//		List<String> listaInterseccion = new ArrayList<String>();
//		for (String str : listaStock) {
//			if (!listaActivos.contains(str))
//				listaInterseccion.add(str);
//		}
//		System.out.println("Ingrese nomenclatura");
//		System.out.println(listaInterseccion.toString());
//		String nomenclatura = in.nextLine().toUpperCase();
//		while (!listaInterseccion.contains(nomenclatura)) {
//			System.out.println("ERROR.\nIngrese nomenclatura");
//			System.out.println(listaInterseccion.toString());
//			nomenclatura = in.nextLine().toUpperCase();
//		}
//		System.out.println("Ingrese cantidad");
//		double cantidad = in.nextDouble();
//		in.nextLine();
//
//		System.out.println("NOMENCALTURA del activo a crear: " + nomenclatura);
//		System.out.println("CANTIDAD del activo a crear: " + cantidad);
//		System.out.println(
//				"Confirmar operacion (" + StringsConstantes.Y.getStr() + "/" + StringsConstantes.N.getStr() + ")");
//		String confirmar = in.nextLine().toUpperCase();
//		while ((!confirmar.equals(StringsConstantes.Y.getStr())) && (!confirmar.equals(StringsConstantes.N.getStr()))) {
//			System.out.println("ERROR\nConfirmar operacion (" + StringsConstantes.Y.getStr() + "/"
//					+ StringsConstantes.N.getStr() + ")");
//			confirmar = in.nextLine().toUpperCase();
//		}
//		if (confirmar.equals(StringsConstantes.Y.getStr())) {
//			Moneda moneda = new Moneda();
//			moneda.setNomenclatura(nomenclatura);
//			moneda.setCantidad(cantidad);
//			return activoDao.insertActivo(0, moneda);
//		} else
//			System.out.println("Operacion cancelada.");
//		return 0;
//	}
//
//	public static void listarActivos(Scanner in) {
//		System.out.println("Ingrese criterio de ordenacion (" + StringsConstantes.CANTIDAD.getStr() + "/"
//				+ StringsConstantes.NOMENCLATURA.getStr() + ")");
//		String i = in.nextLine().toUpperCase();
//		while ((!i.equals(StringsConstantes.CANTIDAD.getStr()))
//				&& (!i.equals(StringsConstantes.NOMENCLATURA.getStr()))) {
//			System.out.println("ERROR: criterio no válido.\nIngrese criterio de ordenacion ("
//					+ StringsConstantes.CANTIDAD.getStr() + "/" + StringsConstantes.NOMENCLATURA.getStr() + ")");
//			i = in.nextLine().toUpperCase();
//		}
//		ActivoDao activoDao = FactoryDao.getActivoDao();
//		List<Moneda> listaActivos = activoDao.selectActivos(0);
//		if (i.equals(StringsConstantes.CANTIDAD.getStr()))
//			listaActivos.sort(new ComparadorCantidad());
//		else
//			listaActivos.sort(new ComparadorNomenclatura());
//		for (Moneda moneda : listaActivos)
//			System.out.println(moneda.getNomenclatura() + " " + moneda.getNombre() + " " + moneda.getCantidad());
//	}
//
//	private static void simularCompra(Scanner in) {
//		StockDao stockDao = FactoryDao.getStockDao();
//		ActivoDao activoDao = FactoryDao.getActivoDao();
//		List<String> listaCriptos = new ArrayList<String>();
//		List<String> listaFiats = new ArrayList<String>();
//		List<Moneda> listaActivos = new ArrayList<Moneda>();
//		boolean validacion = false;
//		boolean existeCripto = false;
//		double cantidadComprada;
//		double cantidadEnStock = 0;
//		double cantidadActivo = 0;
//
//		listaCriptos = stockDao.selectNomenclaturasCripto();
//
//		System.out.println("Ingrese CRIPTOMONEDA a comprar:");
//		System.out.println(listaCriptos.toString());
//		String criptomonedaElegida = in.nextLine().toUpperCase();
//		while (!listaCriptos.contains(criptomonedaElegida)) {
//			System.out.println("ERROR: CRIPTOMONEDA no valida.");
//			System.out.println("Ingrese CRIPTOMONEDA a comprar:");
//			System.out.println(listaCriptos.toString());
//			criptomonedaElegida = in.nextLine().toUpperCase();
//		}
//
//		listaFiats = stockDao.selectNomenclaturasFiat();
//		System.out.println("Ingrese FIAT a convertir:");
//		System.out.println(listaFiats.toString());
//		String fiatElegida = in.nextLine().toUpperCase();
//		while (!listaFiats.contains(fiatElegida)) {
//			System.out.println("ERROR: FIAT no valida.");
//			System.out.println("Ingrese FIAT a convertir:");
//			System.out.println(listaFiats.toString());
//			fiatElegida = in.nextLine().toUpperCase();
//		}
//
//		System.out.println("Ingrese cantidad de " + fiatElegida + " a convertir:");
//		double cantidadElegida = in.nextInt();
//		in.nextLine();
//		listaActivos = activoDao.selectActivos(0);
//		for (Moneda activo : listaActivos) {
//			if (activo.getNomenclatura().equals(fiatElegida)) {
//				if (activo.getCantidad() >= cantidadElegida) {
//					cantidadActivo = activo.getCantidad();
//					validacion = true;
//					break;
//				}
//				System.out.println("ERROR: fondos insuficientes.");
//				return;
//			}
//		}
//		if (!validacion) {
//			System.out.println("ERROR: no posee esa FIAT");
//			return;
//		}
//
//		for (Moneda activo : listaActivos) {
//			if (activo.getNomenclatura().equals(criptomonedaElegida)) {
//				existeCripto = true;
//				break;
//			}
//		}
//		Moneda fiatElegidaMoneda = new Moneda();
//		fiatElegidaMoneda.setNomenclatura(fiatElegida);
//		fiatElegidaMoneda.setPrecio(stockDao.selectPrecioNomenclatura(fiatElegidaMoneda));
//
//		Moneda criptoElegidaMoneda = new Moneda();
//		criptoElegidaMoneda.setNomenclatura(criptomonedaElegida);
//		criptoElegidaMoneda.setPrecio(stockDao.selectPrecioNomenclatura(criptoElegidaMoneda));
//		cantidadEnStock = (stockDao.selectCantidadNomenclatura(criptoElegidaMoneda));
//
//		cantidadComprada = fiatElegidaMoneda.convertir(cantidadElegida, criptoElegidaMoneda);
//		if (cantidadComprada > cantidadEnStock) {
//			System.out.println("ERROR: no hay STOCK suficiente de: " + criptomonedaElegida);
//			return;
//		}
//
//		System.out.println("CRIPTOMONEDA a COMPRAR: " + criptomonedaElegida);
//		System.out.println("FIAT a CONVERTIR: " + fiatElegida);
//		System.out.println("CANTIDAD a CONVERTIR: " + cantidadElegida);
//
//		System.out.println(
//				"Confirmar operacion (" + StringsConstantes.Y.getStr() + "/" + StringsConstantes.N.getStr() + ")");
//		String confirmar = in.nextLine().toUpperCase();
//		while ((!confirmar.equals(StringsConstantes.Y.getStr())) && (!confirmar.equals(StringsConstantes.N.getStr()))) {
//			System.out.println("ERROR\nConfirmar operacion (" + StringsConstantes.Y.getStr() + "/"
//					+ StringsConstantes.N.getStr() + ")");
//			confirmar = in.nextLine().toUpperCase();
//		}
//		if (confirmar.equals(StringsConstantes.N.getStr())) {
//			System.out.println("Operacion cancelada.");
//		} else {
//
//			criptoElegidaMoneda.setCantidad(cantidadEnStock - cantidadComprada);
//			stockDao.updateCantidad(criptoElegidaMoneda);
//
//			fiatElegidaMoneda.setCantidad(cantidadActivo - cantidadElegida);
//			activoDao.updateCantidad(0, fiatElegidaMoneda);
//
//			if (existeCripto) {
//				double cantidadCriptomoneda = activoDao.selectCantidadNomenclatura(criptoElegidaMoneda);
//				criptoElegidaMoneda.setCantidad(cantidadCriptomoneda + cantidadComprada);
//				activoDao.updateCantidad(0, criptoElegidaMoneda);
//			} else {
//				criptoElegidaMoneda.setCantidad(cantidadComprada);
//				activoDao.insertActivo(0, criptoElegidaMoneda);
//			}
//
//			OperacionCompra datosOperacion = new OperacionCompra(criptomonedaElegida, fiatElegida, cantidadComprada,
//					cantidadElegida, Calendar.getInstance().getTime().toString());
//			DatosCompraDao compraDao = FactoryDao.getDatosCompraDao();
//			compraDao.insertDatosCompra(datosOperacion);
//		}
//	}
//
//	private static void simularSwap(Scanner in) {
//		StockDao stockDao = FactoryDao.getStockDao();
//		ActivoDao activoDao = FactoryDao.getActivoDao();
//		List<String> listaCriptosActivos = new ArrayList<String>();
//		List<String> listaCriptos = new ArrayList<String>();
//		List<Moneda> listaActivos = new ArrayList<Moneda>();
//		boolean validacion = false;
//		boolean existeCripto = false;
//		double cantidadActivo = 0;
//
//		listaCriptosActivos = activoDao.selectNomenclaturasCripto(0);
//
//		System.out.println("Ingrese CRIPTOMONEDA a convertir:");
//		System.out.println(listaCriptosActivos.toString());
//		String criptomonedaConvertir = in.nextLine().toUpperCase();
//		while (!listaCriptosActivos.contains(criptomonedaConvertir)) {
//			System.out.println("ERROR: CRIPTOMONEDA no valida.");
//			System.out.println("Ingrese CRIPTOMONEDA a convertir:");
//			System.out.println(listaCriptosActivos.toString());
//			criptomonedaConvertir = in.nextLine().toUpperCase();
//		}
//
//		listaCriptos = stockDao.selectNomenclaturasCripto();
//		listaCriptos.remove(criptomonedaConvertir);
//		System.out.println("Ingrese CRIPTOMONEDA esperada:");
//		System.out.println(listaCriptos.toString());
//		String criptomonedaEsperada = in.nextLine().toUpperCase();
//		while (!listaCriptos.contains(criptomonedaEsperada)) {
//			System.out.println("ERROR: CRIPTOMONEDA no valida.");
//			System.out.println("Ingrese CRIPTOMONEDA a esperada:");
//			System.out.println(listaCriptos.toString());
//			criptomonedaEsperada = in.nextLine().toUpperCase();
//		}
//
//		System.out.println("Ingrese cantidad de " + criptomonedaConvertir + " a convertir:");
//		double cantidadElegida = in.nextInt();
//		in.nextLine();
//		listaActivos = activoDao.selectActivos(0);
//		for (Moneda activo : listaActivos) {
//			if (activo.getNomenclatura().equals(criptomonedaConvertir)) {
//				if (activo.getCantidad() >= cantidadElegida) {
//					cantidadActivo = activo.getCantidad();
//					validacion = true;
//					break;
//				}
//				System.out.println("ERROR: fondos insuficientes.");
//				return;
//			}
//		}
//		if (!validacion) {
//			System.out.println("ERROR: no posee esa CRIPTOMONEDA.");
//			return;
//		}
//
//		for (Moneda activo : listaActivos) {
//			if (activo.getNomenclatura().equals(criptomonedaEsperada)) {
//				existeCripto = true;
//				break;
//			}
//		}
//		Moneda criptoConvertirMoneda = new Moneda();
//		criptoConvertirMoneda.setNomenclatura(criptomonedaConvertir);
//		criptoConvertirMoneda.setPrecio(stockDao.selectPrecioNomenclatura(criptoConvertirMoneda));
//		double cantidadConvertirStock = (stockDao.selectCantidadNomenclatura(criptoConvertirMoneda));
//
//		Moneda criptoEsperadaMoneda = new Moneda();
//		criptoEsperadaMoneda.setNomenclatura(criptomonedaEsperada);
//		criptoEsperadaMoneda.setPrecio(stockDao.selectPrecioNomenclatura(criptoEsperadaMoneda));
//		double cantidadEsperadaStock = (stockDao.selectCantidadNomenclatura(criptoEsperadaMoneda));
//
//		double cantidadConvertida = criptoConvertirMoneda.convertir(cantidadElegida, criptoEsperadaMoneda);
//		if (cantidadConvertida > cantidadEsperadaStock) {
//			System.out.println("ERROR: no hay STOCK suficiente de: " + criptomonedaEsperada);
//			return;
//		}
//
//		System.out.println("CRIPTOMONEDA a CONVERTIR: " + criptomonedaConvertir);
//		System.out.println("CANTIDAD a CONVERTIR: " + cantidadElegida);
//		System.out.println("CRIPTOMONEDA ESPERADA: " + criptomonedaEsperada);
//
//		System.out.println(
//				"Confirmar operacion (" + StringsConstantes.Y.getStr() + "/" + StringsConstantes.N.getStr() + ")");
//		String confirmar = in.nextLine().toUpperCase();
//		while ((!confirmar.equals(StringsConstantes.Y.getStr())) && (!confirmar.equals(StringsConstantes.N.getStr()))) {
//			System.out.println("ERROR\nConfirmar operacion (" + StringsConstantes.Y.getStr() + "/"
//					+ StringsConstantes.N.getStr() + ")");
//			confirmar = in.nextLine().toUpperCase();
//		}
//		if (confirmar.equals(StringsConstantes.N.getStr())) {
//			System.out.println("Operacion cancelada.");
//		} else {
//
//			criptoEsperadaMoneda.setCantidad(cantidadEsperadaStock - cantidadConvertida);
//			stockDao.updateCantidad(criptoEsperadaMoneda);
//
//			criptoConvertirMoneda.setCantidad(cantidadConvertirStock + cantidadElegida);
//			stockDao.updateCantidad(criptoConvertirMoneda);
//
//			criptoConvertirMoneda.setCantidad(cantidadActivo - cantidadElegida);
//			activoDao.updateCantidad(0, criptoConvertirMoneda);
//
//			if (existeCripto) {
//				double cantidadEsperadaHay = activoDao.selectCantidadNomenclatura(criptoEsperadaMoneda);
//				criptoEsperadaMoneda.setCantidad(cantidadEsperadaHay + cantidadConvertida);
//				activoDao.updateCantidad(0, criptoEsperadaMoneda);
//			} else {
//				criptoEsperadaMoneda.setCantidad(cantidadConvertida);
//				activoDao.insertActivo(0, criptoEsperadaMoneda);
//			}
//
//			OperacionSwap datosOperacion = new OperacionSwap(criptomonedaConvertir, criptomonedaEsperada,
//					cantidadElegida, cantidadConvertida, Calendar.getInstance().getTime().toString());
//			DatosSwapDao swapDao = FactoryDao.getDatosSwapDao();
//			swapDao.insertDatosSwap(datosOperacion);
//		}
//	}
//}
