package Repositories;

import Entities.Ropas.Atuendo;
import Repositories.daos.DAO;

import java.util.List;

public class RepositorioAtuendo extends Repositorio {
    private static RepositorioAtuendo instance;

    public static RepositorioAtuendo getInstance(DAO dao) {
        if(instance == null){
            instance = new RepositorioAtuendo(dao);
        }
        return instance;
    }

    private RepositorioAtuendo(DAO dao){
        this.setDao(dao);
    }

    public List<Atuendo> buscarTodos(){
        return this.dao.buscarTodos();
    }

    public Atuendo buscar(int id){
        return this.dao.buscar(id);
    }
}
