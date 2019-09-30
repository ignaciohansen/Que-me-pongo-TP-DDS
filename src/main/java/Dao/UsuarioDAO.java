package Dao;

import Usuario.Usuario;

public class UsuarioDAO extends AbstractDAO{
	
	public Usuario obtenerUsuario(String usuario) throws Exception {
		return (Usuario) entityManager.createQuery("from Usuario.Usuario where usuario_nombre = :usuario_nombre")
				.setParameter("usuario_nombre", usuario).getSingleResult();
	}
	
	public void actualizarUsuario(Usuario usuario) throws Exception {
		transaccion.begin();
		entityManager.merge(usuario);
		transaccion.commit();
	}
	
}
