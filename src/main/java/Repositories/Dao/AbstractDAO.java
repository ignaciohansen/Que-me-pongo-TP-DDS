package Repositories.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

public abstract class AbstractDAO {
	
	static EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
	
	static EntityTransaction transaccion = entityManager.getTransaction();
	
	
	public static void agregar(Object objeto) throws Exception {

		transaccion.begin();
		entityManager.persist(objeto);
		transaccion.commit();
		
	}
	
	
	public static void agregar(List<Object> objetos) throws Exception {
		
		for (int i = 0; i < objetos.size(); i++) {
			agregar(objetos.get(i));
		}
		
	}
	
	public static void borrar(Object objeto) throws Exception {
		
		transaccion.begin();
		entityManager.remove(objeto);
		transaccion.commit();
		
	}
	
	public static void actualizar(Object objeto) throws Exception {
		
		transaccion.begin();
		entityManager.merge(objeto);
		transaccion.commit();
		
	}
	
}