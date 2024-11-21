package criptoWalletBLU.APLICACION;

import java.util.List;

import criptoWalletBLU.CLASES.Moneda;
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
		usuarioLogeado=usuariosDao.selectUsuario(contrasena, mail);
		if (usuarioLogeado!=null) {
			personaLogeada = personasDao.selectPersona(usuarioLogeado.getIdPersona());
		}
		return usuarioLogeado;
	}
	
	public String getIniciales() {
		 return (personaLogeada.getNombre().substring(0,1)+personaLogeada.getApellido().substring(0,1));
	}
	
	public double getSaldo() {
		List<Moneda> listaMonedas = stockDao.selectMonedasUsuario(usuarioLogeado.getIdUsuario());
		double result=0;
		for (Moneda m : listaMonedas) result+=(m.getCantidad()*m.getPrecio());
		return result;
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

	public Usuario getUsuarioLogeado() {
		return usuarioLogeado;
	}

	public Persona getPersonaLogeada() {
		return personaLogeada;
	}
	
	public ApiCriptos getApiCriptos() {
		return apiCriptos;
	}
}
