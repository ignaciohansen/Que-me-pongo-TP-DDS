package Repositories;

import Entities.Ropas.Guardarropa;
import Repositories.daos.DAO;

public class RepositorioGuardarropa extends Repositorio{
	private static RepositorioGuardarropa instance;

    public static RepositorioGuardarropa getInstance(DAO dao) {
        if(instance == null){
            instance = new RepositorioGuardarropa(dao);
        }
        return instance;
    }

    private RepositorioGuardarropa(DAO dao){
        this.setDao(dao);
    }

    public Guardarropa buscar(int id){
        return this.dao.buscar(id);
    }
}
