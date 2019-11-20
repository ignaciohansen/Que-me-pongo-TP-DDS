package Models;

import Entities.Ropas.Atuendo;
import db.EntityManagerHelper;

import java.util.List;

public class AtuendoModel extends Model {
	private static AtuendoModel instance;

	public static AtuendoModel getInstance() {
        if(instance == null){
            instance = new AtuendoModel();
        }
        return instance;
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Atuendo> buscarTodos() {
		return EntityManagerHelper.getEntityManager().createQuery("FROM Entities.Ropas.Atuendo").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Atuendo buscar(int id) {
		return (Atuendo) EntityManagerHelper.getEntityManager().createQuery("from Entities.Ropas.Atuendo where atuendo_id = :atuendo_id")
				.setParameter("atuendo_id", id).getSingleResult();
	}

}
