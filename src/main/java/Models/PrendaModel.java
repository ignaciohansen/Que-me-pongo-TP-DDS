package Models;

import java.util.List;

import Entities.Ropas.Prenda;
import db.EntityManagerHelper;

public class PrendaModel extends Model {
	private static PrendaModel instance;

    public static PrendaModel getInstance() {
        if(instance == null){
            instance = new PrendaModel();
        }
        return instance;
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Prenda> buscarTodos() {
		return EntityManagerHelper.getEntityManager().createQuery("FROM Entities.Ropas.Prenda").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Prenda buscar(int id) {
		return (Prenda) EntityManagerHelper.getEntityManager().createQuery("from Entities.Ropas.Prenda where prenda_id = :prenda_id")
				.setParameter("prenda_id", id).getSingleResult();
	}

}
