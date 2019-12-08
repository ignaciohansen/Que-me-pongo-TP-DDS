package Repositories;

import Entities.TipoPrenda.*;
import Entities.Usuario.TipoUsuario;
import Repositories.daos.DAO;

import java.util.List;

public class RepositorioTipoUsuario extends Repositorio {
    private static RepositorioTipoUsuario instance;

    public static RepositorioTipoUsuario getInstance(DAO dao) {
        if(instance == null){
            instance = new RepositorioTipoUsuario(dao);
        }
        return instance;
    }

    private RepositorioTipoUsuario(DAO dao){
        this.setDao(dao);
    }

    public TipoUsuario buscar(int id){
        return this.dao.buscar(id);
    }

    public List<TipoUsuario> buscarTodos(){
        return this.dao.buscarTodos();
    }
}
