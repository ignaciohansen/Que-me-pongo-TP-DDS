package Dao;

import Eventos.Evento;

public class EventoDAO extends AbstractDAO{

	public Evento obtenerGuardarropa(long id) throws Exception {
		return (Evento) entityManager.createQuery("from Eventos.Evento where evento_id = :evento_id")
				.setParameter("evento_id", id).getSingleResult();
	}
	
}
