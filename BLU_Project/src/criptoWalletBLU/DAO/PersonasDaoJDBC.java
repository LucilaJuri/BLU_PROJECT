package criptoWalletBLU.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import criptoWalletBLU.CLASES.Persona;
import criptoWalletBLU.SINGLETONS.SingletonConexiones;

public class PersonasDaoJDBC implements PersonasDao {
	
	public int crearTablaPersonas() {
		Connection coneccion = null;
		try {
			coneccion = SingletonConexiones.getConexion();
			Statement st = coneccion.createStatement();
			String sql = ("CREATE TABLE IF NOT EXISTS \"PERSONA\" (\r\n"
					+ "	\"ID\"	INTEGER NOT NULL UNIQUE,\r\n"
					+ "	\"NOMBRE\"	TEXT NOT NULL,\r\n"
					+ "	\"APELLIDO\"	TEXT NOT NULL,\r\n"
					+ "	PRIMARY KEY(\"ID\" AUTOINCREMENT)\r\n"
					+ ");");
			int result = st.executeUpdate(sql);
			st.close();
			return result;
		} catch (SQLException e) {
			System.out.println("ERROR EN METODO: crearTablaStock (clase StockDaoJDBC)");
			System.out.println(e.getMessage());
			return -1;
		}
	}
	
	public int insertPersona(Persona persona) {
		Connection coneccion = null;
		try {
			coneccion = SingletonConexiones.getConexion();
			Statement st = coneccion.createStatement();
			String sql = "INSERT INTO PERSONA (NOMBRE, APELLIDO) VALUES ('" + persona.getNombre() + "', '" + persona.getApellido() + "');";
			st.executeUpdate(sql);
			int result = st.getGeneratedKeys().getInt(1);
			st.close();
			return result;
		} catch (SQLException e) {
			System.out.println("ERROR EN METODO: insertPersona (clase PersonasDaoJDBC)");
			System.out.println(e.getMessage());
			return -1;
		}
	}
	
	public List<Persona> selectPersonas() {
		Connection coneccion = null;
		List<Persona> listaPersonas = new ArrayList<Persona>();
		try {
			coneccion = SingletonConexiones.getConexion();
			Statement st = coneccion.createStatement();
			String sql = "SELECT * FROM PERSONA";
			ResultSet result = st.executeQuery(sql);
			while (result.next()) {
				listaPersonas.add(new Persona(result.getString("NOMBRE"),result.getString("APELLIDO")));
			}
			st.close();
			return listaPersonas;
		} catch (SQLException e) {
			System.out.println("ERROR EN METODO: selectPersonas (clase PersonasDaoJDBC)");
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public Persona selectPersona(int idPersona) {
		Connection coneccion = null;
		Persona persona;
		try {
			coneccion = SingletonConexiones.getConexion();
			Statement st = coneccion.createStatement();
			String sql = "SELECT * FROM PERSONA WHERE ID="+idPersona;
			ResultSet result = st.executeQuery(sql);
			persona = new Persona(result.getString("NOMBRE"),result.getString("APELLIDO"));
			st.close();
			return persona;
		} catch (SQLException e) {
			System.out.println("ERROR EN METODO: selectPersonas (clase PersonasDaoJDBC)");
			System.out.println(e.getMessage());
			return null;
		}
	}
}
