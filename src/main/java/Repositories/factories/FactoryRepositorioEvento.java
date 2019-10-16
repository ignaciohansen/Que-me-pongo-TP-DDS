package Repositories.factories;

import Models.EventoModel;
import Repositories.RepositorioEvento;
import Repositories.daos.DAOMySQL;

public class FactoryRepositorioEvento {
	private static RepositorioEvento repo;

    public static RepositorioEvento get(){
        if(repo == null){
                repo = RepositorioEvento.getInstance(new DAOMySQL(EventoModel.getInstance()));
        }
        return repo;
    }

}
