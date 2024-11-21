package criptoWalletBLU.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import criptoWalletBLU.CLASES.Usuario;
import criptoWalletBLU.SINGLETONS.SingletonConexiones;

public class UsuariosDaoJDBC implements UsuariosDao {
	
	public int crearTablaUsuarios() {
		Connection coneccion = null;
		try {
			coneccion = SingletonConexiones.getConexion();
			Statement st = coneccion.createStatement();
			String sql = ("CREATE TABLE IF NOT EXISTS \"USUARIO\" (\r\n"
					+ "	\"ID\"	INTEGER NOT NULL UNIQUE,\r\n"
					+ "	\"IDPERSONA\"	INTEGER NOT NULL UNIQUE,\r\n"
					+ "	\"MAIL\"	TEXT NOT NULL UNIQUE,\r\n"
					+ "	\"CONTRASENA\"	TEXT NOT NULL,\r\n"
					+ "	\"TERMINOS\"	BOOLEAN NOT NULL,\r\n"
					+ "	PRIMARY KEY(\"ID\" AUTOINCREMENT),\r\n"
					+ "	FOREIGN KEY(\"IDPERSONA\") REFERENCES \"PERSONA\"(\"ID\")\r\n"
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
	
	public int insertUsuario(Usuario usuario) {
		Connection coneccion = null;
		try {
			coneccion = SingletonConexiones.getConexion();
			Statement st = coneccion.createStatement();
			String sql = "INSERT INTO USUARIO (IDPERSONA, MAIL, CONTRASENA, TERMINOS) " +
                    "VALUES (" + usuario.getIdPersona() + ", '" + usuario.getMail() + "', '" + usuario.getContrasenia() + "', TRUE)";
			st.executeUpdate(sql);
			int result = st.getGeneratedKeys().getInt(1);
			st.close();
			return result;
		} catch (SQLException e) {
			System.out.println("ERROR EN METODO: insertUsuario (clase UsuariosDaoJDBC)");
			System.out.println(e.getMessage());
			return -1;
		}
	}
	
	public Usuario selectUsuario(String contrasena, String mail) {
		Connection coneccion = null;
		Usuario resultUsuario = null;
		try {
			coneccion = SingletonConexiones.getConexion();
			Statement st = coneccion.createStatement();
			String sql = "SELECT * FROM USUARIO WHERE CONTRASENA='"+contrasena+"' AND MAIL='"+mail+"'";
			ResultSet result = st.executeQuery(sql);
			if (result.next()) {
				resultUsuario=new Usuario(result.getInt("ID"),result.getInt("IDPERSONA"),result.getString("MAIL"),result.getString("CONTRASENA"));
			}
			st.close();
			return resultUsuario;
		} catch (SQLException e) {
			System.out.println("ERROR EN METODO: selectUsuario (clase UsuariosDaoJDBC)");
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public boolean existsMail(String mail) {
		Connection coneccion = null;
		try {
			coneccion = SingletonConexiones.getConexion();
			Statement st = coneccion.createStatement();
			String sql = "SELECT * FROM USUARIO WHERE MAIL='"+mail+"'";
			ResultSet result = st.executeQuery(sql);
			boolean resultado = result.next();
			st.close();
			return resultado;
		} catch (SQLException e) {
			System.out.println("ERROR EN METODO: existsMail (clase UsuariosDaoJDBC)");
			System.out.println(e.getMessage());
			return false;
		}
	}
}
