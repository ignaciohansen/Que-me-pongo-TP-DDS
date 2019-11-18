package Repositories;

import Entities.Telas.*;
import Repositories.daos.DAO;

import java.util.List;

public class RepositorioTela extends Repositorio {
	private static RepositorioTela instance;

    public static RepositorioTela getInstance(DAO dao) {
        if(instance == null){
            instance = new RepositorioTela(dao);
        }
        return instance;
    }

    private RepositorioTela(DAO dao){
        this.setDao(dao);
    }

    public Tela buscar(int id){
        return this.dao.buscar(id);
    }

    public List<Tela> buscarTodos(){
        return this.dao.buscarTodos();
    }
}
