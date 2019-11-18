package Repositories;

import Entities.TipoPrenda.*;
import Repositories.daos.DAO;

import java.util.List;

public class RepositorioTipoPrenda extends Repositorio {
	private static RepositorioTipoPrenda instance;

    public static RepositorioTipoPrenda getInstance(DAO dao) {
        if(instance == null){
            instance = new RepositorioTipoPrenda(dao);
        }
        return instance;
    }

    private RepositorioTipoPrenda(DAO dao){
        this.setDao(dao);
    }

    public TipoPrenda buscar(int id){
        return this.dao.buscar(id);
    }

    public List<TipoPrenda> buscarTodos(){
        return this.dao.buscarTodos();
    }
}
