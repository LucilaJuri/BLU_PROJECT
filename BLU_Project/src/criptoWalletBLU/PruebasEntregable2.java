package criptoWalletBLU;
import java.util.Scanner;
import java.sql.*;
public class PruebasEntregable2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		crearMoneda(in);
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
		//CARGAMOS DATABASE
		while ((!confirmar.equals("Y"))&& (!confirmar.equals("N"))){
			System.out.println("ERROR");
			System.out.println("Confirmar operacion (Y/N)");
			confirmar = in.next().toUpperCase();
		}
		if (confirmar.equals("Y")) {
		Connection coneccion = null;
		try {
			coneccion=DriverManager.getConnection("jdbc:sqlite:BLUDATABASE.db");
			Statement st = coneccion.createStatement();
			String sql = (
					"INSERT INTO STOCK (NOMENCLATURA, PRECIO, CANTIDAD, NOMBRE, TIPO)"
					+"VALUES (" 
					+ "'"+nomenclatura+"'"+", "
					+ dolar+", "
					+ stock + ", "
					+"'"+nombre+"', "
					+"'"+tipo+"');");
			st.executeUpdate(sql);
			System.out.println("Operacion exitosa.");
		}
		catch(SQLException e) {
			System.out.println("no se pudo conectar a la BD."); 
		}
		}
		else System.out.println("Operacion cancelada.");
		
		
	}
}
