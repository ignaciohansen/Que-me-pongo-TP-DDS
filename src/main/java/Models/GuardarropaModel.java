package Models;

import java.util.List;

import Entities.Ropas.Guardarropa;
import db.EntityManagerHelper;

public class GuardarropaModel extends Model {
	private static GuardarropaModel instance;
	
	public static GuardarropaModel getInstance() {
        if(instance == null){
            instance = new GuardarropaModel();
        }
        return instance;
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Guardarropa> buscarTodos() {
		return EntityManagerHelper.getEntityManager().createQuery("FROM Entities.Ropas.Guardarropa").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Guardarropa buscar(int id) {
		return (Guardarropa) EntityManagerHelper.getEntityManager().createQuery("from Entities.Ropas.Guardarropa where guardarropa_id = :guardarropa_id")
				.setParameter("guardarropa_id", id).getSingleResult();
	}

}
