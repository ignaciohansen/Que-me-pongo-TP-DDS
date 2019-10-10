package Repositories.Dao;

import Entities.Ropas.Prenda;
import Entities.Usuario.Usuario;

public class PrendaDAO extends AbstractDAO {

	public Usuario obtenerPrendaPorId(long id) throws Exception {
		return (Usuario) entityManager.createQuery("from Ropas.Prenda where prenda_id = :prenda_id")
				.setParameter("prenda_id", id).getSingleResult();
	}
	
	public void actualizarPrenda(Prenda prenda) throws Exception {
		transaccion.begin();
		entityManager.merge(prenda);
		transaccion.commit();
	}
	
}
