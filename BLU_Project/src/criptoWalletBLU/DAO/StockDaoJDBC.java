package criptoWalletBLU.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import criptoWalletBLU.CLASES.Moneda;
import criptoWalletBLU.SINGLETONS.SingletonConexiones;

public class StockDaoJDBC implements StockDao {

	public int crearTablaStock() {
		Connection coneccion = null;
		try {
			coneccion = SingletonConexiones.getConexion();
			Statement st = coneccion.createStatement();
			String sql = ("CREATE TABLE IF NOT EXISTS \"STOCK\" (\r\n"
					+ "	\"NOMENCLATURA\"	TEXT NOT NULL UNIQUE,\r\n" + "	\"PRECIO\"	REAL NOT NULL,\r\n"
					+ "	\"CANTIDAD\"	REAL NOT NULL,\r\n" + "	\"NOMBRE\"	TEXT NOT NULL UNIQUE,\r\n"
					+ "	\"VOLATILIDAD\"	REAL,\r\n" + "	\"TIPO\"	TEXT NOT NULL,\r\n"
					+ "	PRIMARY KEY(\"NOMENCLATURA\")\r\n" + ");");
			st.executeUpdate(sql);
			sql = "INSERT OR IGNORE INTO STOCK (NOMENCLATURA, PRECIO, CANTIDAD, NOMBRE, VOLATILIDAD, TIPO) " +
		             "VALUES ('BTC', " + 0 + ", " + 0 + ", 'BITCOIN', " + 0 + ", 'CRIPTO');";
			st.executeUpdate(sql);
			sql = "INSERT OR IGNORE INTO STOCK (NOMENCLATURA, PRECIO, CANTIDAD, NOMBRE, VOLATILIDAD, TIPO) " +
		             "VALUES ('ETH', " + 0 + ", " + 0 + ", 'ETHEREUM', " + 0 + ", 'CRIPTO');";
			st.executeUpdate(sql);
			sql = "INSERT OR IGNORE INTO STOCK (NOMENCLATURA, PRECIO, CANTIDAD, NOMBRE, VOLATILIDAD, TIPO) " +
		             "VALUES ('USDC', " + 0 + ", " + 0 + ", 'USDCOIN', " + 0 + ", 'CRIPTO');";
			st.executeUpdate(sql);
			sql = "INSERT OR IGNORE INTO STOCK (NOMENCLATURA, PRECIO, CANTIDAD, NOMBRE, VOLATILIDAD, TIPO) " +
		             "VALUES ('USDT', " + 0 + ", " + 0 + ", 'TETHER', " + 0 + ", 'CRIPTO');";
			st.executeUpdate(sql);
			sql = "INSERT OR IGNORE INTO STOCK (NOMENCLATURA, PRECIO, CANTIDAD, NOMBRE, VOLATILIDAD, TIPO) " +
		             "VALUES ('DOGE', " + 0 + ", " + 0 + ", 'DOGECOIN', " + 0 + ", 'CRIPTO');";
			st.executeUpdate(sql);
			sql = "INSERT OR IGNORE INTO STOCK (NOMENCLATURA, PRECIO, CANTIDAD, NOMBRE, VOLATILIDAD, TIPO) " +
		             "VALUES ('USD', " + 1 + ", " + 0 + ", 'DOLAR', " + 0 + ", 'FIAT');";
			st.executeUpdate(sql);
			sql = "INSERT OR IGNORE INTO STOCK (NOMENCLATURA, PRECIO, CANTIDAD, NOMBRE, VOLATILIDAD, TIPO) " +
		             "VALUES ('EUR', " + 0 + ", " + 0 + ", 'EURO', " + 0 + ", 'FIAT');";
			st.executeUpdate(sql);
			sql = "INSERT OR IGNORE INTO STOCK (NOMENCLATURA, PRECIO, CANTIDAD, NOMBRE, VOLATILIDAD, TIPO) " +
		             "VALUES ('BRL', " + 0 + ", " + 0 + ", 'REAL', " + 0 + ", 'FIAT');";
			st.executeUpdate(sql);
			sql = "INSERT OR IGNORE INTO STOCK (NOMENCLATURA, PRECIO, CANTIDAD, NOMBRE, VOLATILIDAD, TIPO) " +
		             "VALUES ('ARS', " + 0 + ", " + 0 + ", 'PESO ARGENTINO', " + 0 + ", 'FIAT');";
			st.executeUpdate(sql);
			sql = "INSERT OR IGNORE INTO STOCK (NOMENCLATURA, PRECIO, CANTIDAD, NOMBRE, VOLATILIDAD, TIPO) " +
		             "VALUES ('GBP', " + 0 + ", " + 0 + ", 'LIBRAS', " + 0 + ", 'FIAT');";
			st.executeUpdate(sql);
			st.close();
			return 1;
		} catch (SQLException e) {
			System.out.println("ERROR EN METODO: crearTablaStock (clase StockDaoJDBC)");
			System.out.println(e.getMessage());
			return -1;
		}
	}

	public int insertStock(Moneda moneda, String tipo) {
		Connection coneccion = null;
		try {
			coneccion = SingletonConexiones.getConexion();
			Statement st = coneccion.createStatement();
			String sql = ("INSERT INTO STOCK (NOMENCLATURA, PRECIO, CANTIDAD, NOMBRE, TIPO, VOLATILIDAD)" + "VALUES ("
					+ "'" + moneda.getNomenclatura() + "'" + ", " + moneda.getPrecio() + ", " + moneda.getCantidad()
					+ ", " + "'" + moneda.getNombre() + "', " + "'" + tipo + "', " + moneda.getVolatilidad() + ");");
			int result = st.executeUpdate(sql);
			st.close();
			return result;
		} catch (SQLException e) {
			System.out.println("ERROR EN METODO: insertStock (clase StockDaoJDBC)");
			System.out.println(e.getMessage());
			return -1;
		}
	}

	public List<Moneda> selectStock() {
		Connection coneccion = null;
		List<Moneda> listaStock = new ArrayList<Moneda>();
		try {
			coneccion = SingletonConexiones.getConexion();
			Statement st = coneccion.createStatement();
			String sql = ("SELECT * FROM STOCK");
			ResultSet result = st.executeQuery(sql);
			while (result.next()) {
				listaStock.add(new Moneda(result.getDouble("PRECIO"), result.getDouble("CANTIDAD"),
						result.getString("NOMBRE"), result.getString("NOMENCLATURA"), result.getDouble("VOLATILIDAD")));
			}

			st.close();
			return listaStock;
		} catch (SQLException e) {
			System.out.println("ERROR EN METODO: selectStock (clase StockDaoJDBC)");
			System.out.println(e.getMessage());
			return null;
		}
	}

	public int contarStock() {
		Connection coneccion = null;
		try {
			coneccion = SingletonConexiones.getConexion();
			Statement st = coneccion.createStatement();
			String sql = ("SELECT COUNT(*) FROM STOCK");
			int result = st.executeQuery(sql).getInt(1);
			st.close();
			return result;
		} catch (SQLException e) {
			System.out.println("ERROR EN METODO: contarStock (clase StockDaoJDBC)");
			System.out.println(e.getMessage());
			return 0;
		}
	}

	public int updateCantidad(Moneda moneda) {
		Connection coneccion = null;
		try {
			coneccion = SingletonConexiones.getConexion();
			Statement st = coneccion.createStatement();
			String sql = ("UPDATE STOCK " + "SET CANTIDAD = " + moneda.getCantidad() + " WHERE NOMENCLATURA='"
					+ moneda.getNomenclatura() + "';");
			int result = st.executeUpdate(sql);
			st.close();
			return result;
		} catch (SQLException e) {
			System.out.println("ERROR EN METODO: updateCantidad (clase StockDaoJDBC)");
			System.out.println(e.getMessage());
			return 0;
		}
	}

	public List<String> selectNomenclaturas() {
		Connection coneccion = null;
		List<String> listaNomenclaturas = new ArrayList<String>();
		try {
			coneccion = SingletonConexiones.getConexion();
			Statement st = coneccion.createStatement();
			String sql = ("SELECT NOMENCLATURA FROM STOCK");
			ResultSet result = st.executeQuery(sql);
			while (result.next()) {
				listaNomenclaturas.add(result.getString("NOMENCLATURA"));
			}
			st.close();
			return listaNomenclaturas;
		} catch (SQLException e) {
			System.out.println("ERROR EN METODO: selectNomenclaturas (clase StockDaoJDBC)");
			System.out.println(e.getMessage());
			return null;
		}
	}

	public List<String> selectNomenclaturasCripto() {
		Connection coneccion = null;
		List<String> listaCriptos = new ArrayList<String>();
		try {
			coneccion = SingletonConexiones.getConexion();
			Statement st = coneccion.createStatement();
			String sql = ("SELECT NOMENCLATURA FROM STOCK WHERE TIPO='CRIPTO'");
			ResultSet result = st.executeQuery(sql);
			while (result.next()) {
				listaCriptos.add(result.getString("NOMENCLATURA"));
			}
			st.close();
			return listaCriptos;
		} catch (SQLException e) {
			System.out.println("ERROR EN METODO: selectNomenclaturasCripto (clase StockDaoJDBC)");
			System.out.println(e.getMessage());
			return null;
		}
	}

	public List<Moneda> selectStockCripto() {
		Connection coneccion = null;
		List<Moneda> listaStock = new ArrayList<Moneda>();
		try {
			coneccion = SingletonConexiones.getConexion();
			Statement st = coneccion.createStatement();
			String sql = ("SELECT * FROM STOCK WHERE TIPO='CRIPTO'");
			ResultSet result = st.executeQuery(sql);
			while (result.next()) {
				listaStock.add(new Moneda(result.getDouble("PRECIO"), result.getDouble("CANTIDAD"),
						result.getString("NOMBRE"), result.getString("NOMENCLATURA"), result.getDouble("VOLATILIDAD")));
			}
			st.close();
			return listaStock;
		} catch (SQLException e) {
			System.out.println("ERROR EN METODO: selectStockCripto (clase StockDaoJDBC)");
			System.out.println(e.getMessage());
			return null;
		}
	}

	public List<String> selectNomenclaturasFiat() {
		Connection coneccion = null;
		List<String> listaFiats = new ArrayList<String>();
		try {
			coneccion = SingletonConexiones.getConexion();
			Statement st = coneccion.createStatement();
			String sql = ("SELECT NOMENCLATURA FROM STOCK WHERE TIPO='FIAT'");
			ResultSet result = st.executeQuery(sql);
			while (result.next()) {
				listaFiats.add(result.getString("NOMENCLATURA"));
			}
			st.close();
			return listaFiats;
		} catch (SQLException e) {
			System.out.println("ERROR EN METODO: selectNomenclaturasFiat (clase StockDaoJDBC)");
			System.out.println(e.getMessage());
			return null;
		}
	}

	public double selectPrecioNomenclatura(Moneda moneda) {
		Connection coneccion = null;
		try {
			coneccion = SingletonConexiones.getConexion();
			Statement st = coneccion.createStatement();
			String sql = ("SELECT PRECIO FROM STOCK WHERE NOMENCLATURA='" + moneda.getNomenclatura() + "';");
			ResultSet result = st.executeQuery(sql);
			double resultado = result.getDouble("PRECIO");
			st.close();
			return resultado;
		} catch (SQLException e) {
			System.out.println("ERROR EN METODO: selectPrecioNomenclatura (clase StockDaoJDBC)");
			System.out.println(e.getMessage());
			return 0;
		}
	}

	public double selectCantidadNomenclatura(Moneda moneda) {
		Connection coneccion = null;
		try {
			coneccion = SingletonConexiones.getConexion();
			Statement st = coneccion.createStatement();
			String sql = ("SELECT CANTIDAD FROM STOCK WHERE NOMENCLATURA='" + moneda.getNomenclatura() + "';");
			ResultSet result = st.executeQuery(sql);
			double resultado = result.getDouble("CANTIDAD");
			st.close();
			return resultado;
		} catch (SQLException e) {
			System.out.println("ERROR EN METODO: selectCantidadNomenclatura (clase StockDaoJDBC)");
			System.out.println(e.getMessage());
			return 0;
		}
	}
	
	public List<Moneda> selectMonedasUsuario(int idUsuario) {
		Connection coneccion = null;
		List<Moneda> listaMonedas = new ArrayList<Moneda>();
		try {
			coneccion = SingletonConexiones.getConexion();
			Statement st = coneccion.createStatement();
			String sql = ("SELECT A.CANTIDAD, S.PRECIO FROM ACTIVOS A INNER JOIN STOCK S ON A.NOMENCLATURA=S.NOMENCLATURA WHERE A.IDUSUARIO="
					+ idUsuario + ";");
			ResultSet result = st.executeQuery(sql);
			while (result.next()) {
				listaMonedas.add(new Moneda(result.getDouble("PRECIO"),result.getDouble("CANTIDAD")));
			}
			st.close();
			return listaMonedas;
		} catch (SQLException e) {
			System.out.println("ERROR EN METODO: selectMonedasUsuario (clase StockDaoJDBC)");
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public int updatePrecio(String nomenclatura, double precio) {
		Connection coneccion = null;
		try {
			coneccion = SingletonConexiones.getConexion();
			Statement st = coneccion.createStatement();
			String sql = ("UPDATE STOCK " + "SET PRECIO = " + precio + " WHERE NOMENCLATURA='"
					+ nomenclatura + "';");
			int result = st.executeUpdate(sql);
			st.close();
			return result;
		} catch (SQLException e) {
			System.out.println("ERROR EN METODO: updatePrecio (clase StockDaoJDBC)");
			System.out.println(e.getMessage());
			return 0;
		}
	}

}
