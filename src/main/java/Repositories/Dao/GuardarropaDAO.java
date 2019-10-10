package Repositories.Dao;

import Entities.Ropas.Guardarropa;

public class GuardarropaDAO extends AbstractDAO {
	
	public Guardarropa obtenerGuardarropa(long id) throws Exception {
		return (Guardarropa) entityManager.createQuery("from Ropas.Guardarropa where guardarropa_id = :guardarropa_id")
				.setParameter("guardarropa_id", id).getSingleResult();
	}
	
}
