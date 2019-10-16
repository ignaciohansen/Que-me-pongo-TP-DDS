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
		return EntityManagerHelper.getEntityManager().find(Prenda.class, id);
	}

}
