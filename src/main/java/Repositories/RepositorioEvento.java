package Repositories;

import Entities.Eventos.Evento;
import Repositories.daos.DAO;

public class RepositorioEvento extends Repositorio {
	private static RepositorioEvento instance;

    public static RepositorioEvento getInstance(DAO dao) {
        if(instance == null){
            instance = new RepositorioEvento(dao);
        }
        return instance;
    }

    private RepositorioEvento(DAO dao){
        this.setDao(dao);
    }

    public Evento buscar(int id){
        return this.dao.buscar(id);
    }
}
