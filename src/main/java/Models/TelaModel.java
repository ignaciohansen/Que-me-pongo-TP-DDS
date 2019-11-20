package Models;

import Entities.Telas.*;
import db.EntityManagerHelper;
import java.util.List;

public class TelaModel extends Model {
	private static TelaModel instance;

    public static TelaModel getInstance() {
        if(instance == null){
            instance = new TelaModel();
        }
        return instance;
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Tela> buscarTodos() {
		return EntityManagerHelper.getEntityManager().createQuery("FROM Entities.Telas.Tela").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Tela buscar(int id) {
		return (Tela) EntityManagerHelper.getEntityManager().createQuery("from Entities.Telas.Tela where tela_id = :tela_id")
				.setParameter("tela_id", id).getSingleResult();
	}

}
