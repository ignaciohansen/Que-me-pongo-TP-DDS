package Repositories;

import Entities.Ropas.Prenda;
import Repositories.daos.DAO;

public class RepositorioPrenda extends Repositorio {
	private static RepositorioPrenda instance;

    public static RepositorioPrenda getInstance(DAO dao) {
        if(instance == null){
            instance = new RepositorioPrenda(dao);
        }
        return instance;
    }

    private RepositorioPrenda(DAO dao){
        this.setDao(dao);
    }

    public Prenda buscar(int id){
        return this.dao.buscar(id);
    }
}
