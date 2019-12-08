package Repositories;

import Entities.Sensibilidad.*;
import Repositories.daos.DAO;

import java.util.List;

public class RepositorioSensibilidad extends Repositorio {
    private static RepositorioSensibilidad instance;

    public static RepositorioSensibilidad getInstance(DAO dao) {
        if(instance == null){
            instance = new RepositorioSensibilidad(dao);
        }
        return instance;
    }

    private RepositorioSensibilidad(DAO dao){
        this.setDao(dao);
    }

    public tipoSensibilidad buscar(int id){
        return this.dao.buscar(id);
    }

    public List<tipoSensibilidad> buscarTodos(){
        return this.dao.buscarTodos();
    }
}
