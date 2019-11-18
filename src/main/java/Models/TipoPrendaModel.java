package Models;

import Entities.TipoPrenda.*;
import db.EntityManagerHelper;
import java.util.List;

public class TipoPrendaModel extends Model {
	private static TipoPrendaModel instance;

    public static TipoPrendaModel getInstance() {
        if(instance == null){
            instance = new TipoPrendaModel();
        }
        return instance;
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoPrenda> buscarTodos() {
			return EntityManagerHelper.getEntityManager().createQuery("FROM Entities.TipoPrenda.TipoPrenda").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public TipoPrenda buscar(int id) {
		return (TipoPrenda) EntityManagerHelper.getEntityManager().createQuery("from Entities.TipoPrenda.TipoPrenda where tipo_prenda_id = :tipo_prenda_id")
				.setParameter("tipo_prenda_id", id).getSingleResult();
	}

}
