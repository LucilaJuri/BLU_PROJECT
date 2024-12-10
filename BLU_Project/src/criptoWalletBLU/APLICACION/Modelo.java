package criptoWalletBLU.APLICACION;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import criptoWalletBLU.CLASES.Moneda;
import criptoWalletBLU.CLASES.OperacionCompra;
import criptoWalletBLU.CLASES.Persona;
import criptoWalletBLU.CLASES.Usuario;
import criptoWalletBLU.DAO.ActivoDao;
import criptoWalletBLU.DAO.DatosCompraDao;
import criptoWalletBLU.DAO.DatosSwapDao;
import criptoWalletBLU.DAO.FactoryDao;
import criptoWalletBLU.DAO.PersonasDao;
import criptoWalletBLU.DAO.StockDao;
import criptoWalletBLU.DAO.UsuariosDao;
import criptoWalletBLU.SERVICIOS.ApiCriptos;

public class Modelo {
	
	private UsuariosDao usuariosDao;
	private PersonasDao personasDao;
	private StockDao stockDao;
	private ActivoDao activosDao;
	private DatosCompraDao datosCompraDao;
	private DatosSwapDao datosSwapDao;
	
	private Usuario usuarioLogeado;
	private Persona personaLogeada;
	
	private ApiCriptos apiCriptos;
	
	public Modelo() {
		inicializarDataBase();
		inicializarSesion();
		apiCriptos = new ApiCriptos();
	}
	
	public void inicializarDataBase() {
		stockDao = FactoryDao.getStockDao();
		stockDao.crearTablaStock();
		
		activosDao = FactoryDao.getActivoDao();
		activosDao.crearTablaActivos();
		
		datosCompraDao = FactoryDao.getDatosCompraDao();
		datosCompraDao.crearTablaDatosCompra();
		
		datosSwapDao = FactoryDao.getDatosSwapDao();
		datosSwapDao.crearTablaDatosSwap();
		
		usuariosDao = FactoryDao.getUsuariosDao();
		usuariosDao.crearTablaUsuarios();
		
		personasDao = FactoryDao.getPersonasDao();
		personasDao.crearTablaPersonas();
	}
	
	public void inicializarSesion() {
		usuarioLogeado = new Usuario();
		personaLogeada = new Persona();
	}
	
	public boolean existeMail(String mail) { 
		return usuariosDao.existsMail(mail);
	}
	
	public void insertUsuario(String nombre, String apellido, String mail, String contrasena) {
		personaLogeada.setNombre(nombre);
		personaLogeada.setApellido(apellido);
		usuarioLogeado.setIdPersona(personasDao.insertPersona(personaLogeada));
		usuarioLogeado.setMail(mail);
		usuarioLogeado.setContrasenia(contrasena);
		usuarioLogeado.setIdUsuario(usuariosDao.insertUsuario(usuarioLogeado));
	}
	
	public Usuario cargarUsuario(String mail, String contrasena) {
		Usuario aux = usuariosDao.selectUsuario(contrasena, mail);
		if (aux!=null) {
			usuarioLogeado=aux;
			personaLogeada = personasDao.selectPersona(usuarioLogeado.getIdPersona());
		}
		return usuarioLogeado;
	}
	
	public String getIniciales() {
		 return (personaLogeada.getNombre().substring(0,1)+personaLogeada.getApellido().substring(0,1)).toUpperCase();
	}
	
	public BigDecimal getSaldo() {
		List<Moneda> listaMonedas = stockDao.selectMonedasUsuario(usuarioLogeado.getIdUsuario());
		double result=0;
		for (Moneda m : listaMonedas) result+=(m.getCantidad()*m.getPrecio());
		return new BigDecimal(result).setScale(2, RoundingMode.DOWN);
	}
	
	public void actualizarCriptos() {
		apiCriptos.actualizarApiCriptos();
		if (apiCriptos.getJson()==null) return;
		stockDao.updatePrecio("BTC", apiCriptos.getBTC());
		stockDao.updatePrecio("ETH", apiCriptos.getETH());
		stockDao.updatePrecio("USDC", apiCriptos.getUSDC());
		stockDao.updatePrecio("USDT", apiCriptos.getUSDT());
		stockDao.updatePrecio("DOGE", apiCriptos.getDOGE());
	}
	
	public void generarStock() {
		for (String nomenclatura : stockDao.selectNomenclaturasCripto()) {stockDao.updateCantidad(nomenclatura,new BigDecimal(Math.random() * 10001).setScale(3, RoundingMode.DOWN));}
	}
	public List<Moneda> selectNomenclaturaCantidadUsuario(){
		return stockDao.selectNomenclaturaCantidadUsuario(usuarioLogeado.getIdUsuario());
	}
	
	public double selectCantidadNomenclatura(String nomenclatura) {
		return activosDao.selectCantidadNomenclatura(nomenclatura, usuarioLogeado.getIdUsuario());
	}
	
	public List<Moneda> getListaActivos() {
		return stockDao.selectMonedasUsuario(usuarioLogeado.getIdUsuario());
	}
	
	public double getStockMoneda(String nomenclatura) {
		return stockDao.selectCantidadNomenclatura(nomenclatura);
	}
	
	public boolean swapDisponible(String nomenclatura) {
		return activosDao.selectNomenclaturas(usuarioLogeado.getIdUsuario()).contains(nomenclatura);
	}

	public Usuario getUsuarioLogeado() {
		return usuarioLogeado;
	}

	public Persona getPersonaLogeada() {
		return personaLogeada;
	}
	
	public ApiCriptos getApiCriptos() {
		return apiCriptos;
	}

	public double convertir(double ingresado, String nomenclaturaFiat, String nomenclaturaCripto) {
		return (ingresado*stockDao.selectPrecioNomenclatura(nomenclaturaFiat))/apiCriptos.getPrecio(nomenclaturaCripto);
	}

	public void compra(double ingresado, String nomenclaturaCripto, double cantidadCripto, String nomenclaturaFiat) {
		stockDao.updateCantidad(nomenclaturaCripto,new BigDecimal(stockDao.selectCantidadNomenclatura(nomenclaturaCripto)-cantidadCripto));
		activosDao.updateCantidad(usuarioLogeado.getIdUsuario(), nomenclaturaFiat, selectCantidadNomenclatura(nomenclaturaFiat)-ingresado);

		if (activosDao.selectNomenclaturas(usuarioLogeado.getIdUsuario()).contains(nomenclaturaCripto)) activosDao.updateCantidad(usuarioLogeado.getIdPersona(), nomenclaturaCripto, selectCantidadNomenclatura(nomenclaturaCripto)+cantidadCripto);
		else activosDao.insertActivo(usuarioLogeado.getIdUsuario(), nomenclaturaCripto, new BigDecimal(cantidadCripto));

		OperacionCompra datosOperacion = new OperacionCompra(usuarioLogeado.getIdUsuario(),nomenclaturaCripto, nomenclaturaFiat, cantidadCripto,ingresado, Calendar.getInstance().getTime().toString());
		datosCompraDao.insertDatosCompra(datosOperacion);
		
	}

	public List<OperacionCompra> getListaTransacciones() {
		return datosCompraDao.selectDatosCompra(usuarioLogeado.getIdUsuario());
	}

	public void generarActivos() {
		activosDao.borrarActivos(usuarioLogeado.getIdUsuario());
		for (String nomenclatura : new String[]{"ARS","USD","EUR","BRL","GBP"}) {activosDao.insertActivo(usuarioLogeado.getIdUsuario(), nomenclatura, new BigDecimal(Math.random() * 10001).setScale(3, RoundingMode.DOWN));}
	}

	public void exportar() throws IOException {
		List<ArrayList<String>> filas = new ArrayList<ArrayList<String>>();
		List<Moneda> datos = stockDao.selectMonedasUsuario(usuarioLogeado.getIdUsuario());
		ArrayList<String> aux;
		
		for (Moneda m : datos) {
			aux= new ArrayList<String>();
			aux.add(m.getNomenclatura());
			aux.add(m.getNombre());
			aux.add(String.valueOf(m.getCantidad()*m.getPrecio()));
			filas.add(aux);
		}
		
		FileWriter csvWriter = new FileWriter("DatosBalance.csv");
		csvWriter.append("Nomenclatura");
		csvWriter.append(",");
		csvWriter.append("Nombre");
		csvWriter.append(",");
		csvWriter.append("Balance(USD)");
		csvWriter.append('\n');				
		for (List<String> datos_fila : filas) {
			csvWriter.append(String.join(",", datos_fila));
			csvWriter.append('\n');
		}
		csvWriter.close();
		
	}
}
