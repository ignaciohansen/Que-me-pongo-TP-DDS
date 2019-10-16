package Repositories.factories;

import Models.GuardarropaModel;
import Repositories.RepositorioGuardarropa;
import Repositories.daos.DAOMySQL;

public class FactoryRepositorioGuardarropa {
	private static RepositorioGuardarropa repo;

    public static RepositorioGuardarropa get(){
        if(repo == null){
                repo = RepositorioGuardarropa.getInstance(new DAOMySQL(GuardarropaModel.getInstance()));
        }
        return repo;
    }

}
