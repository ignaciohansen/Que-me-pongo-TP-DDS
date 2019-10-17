package Models;

import java.util.List;

import Entities.Eventos.Evento;
import db.EntityManagerHelper;

public class EventoModel extends Model {
	private static EventoModel instance;

	public static EventoModel getInstance() {
        if(instance == null){
            instance = new EventoModel();
        }
        return instance;
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Evento> buscarTodos() {
		return EntityManagerHelper.getEntityManager().createQuery("FROM Entities.Eventos.Evento").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Evento buscar(int id) {
		return (Evento) EntityManagerHelper.getEntityManager().createQuery("from Entities.Eventos.Evento where evento_id = :evento_id")
				.setParameter("evento_id", id).getSingleResult();
	}

}
