package criptoWalletBLU.DAO;

import criptoWalletBLU.CLASES.Usuario;

public interface UsuariosDao {
	
	public int insertUsuario(Usuario usuario);
	
	public Usuario selectUsuario(String contrasena, String mail);
	
	public boolean existsMail(String mail);
	
	public int crearTablaUsuarios();
}
