package Repositories.Dao;

import java.util.List;

import Entities.Usuario.Usuario;

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
	
	@SuppressWarnings("unchecked")
	public List<Usuario> obtenerUsuarios() throws Exception {

		return entityManager.createQuery("FROM Usuario.Usuario").getResultList();

	}
}
