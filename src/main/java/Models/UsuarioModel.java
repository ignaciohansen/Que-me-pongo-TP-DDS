package Models;

import java.util.List;
import db.EntityManagerHelper;

import Entities.Usuario.Usuario;

public class UsuarioModel extends Model {
	private static UsuarioModel instance;

    public static UsuarioModel getInstance() {
        if(instance == null){
            instance = new UsuarioModel();
        }
        return instance;
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> buscarTodos() {
		return EntityManagerHelper.getEntityManager().createQuery("FROM Usuario.Usuario").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Usuario buscar(int id) {
		return EntityManagerHelper.getEntityManager().find(Usuario.class, id);
	}
	
	public Usuario buscarPorUsuario(String usuario) {
		return (Usuario) EntityManagerHelper.getEntityManager().createQuery("from Entities.Usuario.Usuario where usuario_nombre = :usuario_nombre")
				.setParameter("usuario_nombre", usuario).getSingleResult();
	}
	
}
