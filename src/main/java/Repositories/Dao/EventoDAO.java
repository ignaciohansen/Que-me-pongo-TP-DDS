package Repositories.Dao;

import Entities.Eventos.Evento;

public class EventoDAO extends AbstractDAO{

	public Evento obtenerEvento(long id) throws Exception {
		return (Evento) entityManager.createQuery("from Eventos.Evento where evento_id = :evento_id")
				.setParameter("evento_id", id).getSingleResult();
	}
	
}
