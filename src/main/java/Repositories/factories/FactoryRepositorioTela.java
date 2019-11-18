package Repositories.factories;


import Models.TelaModel;
import Repositories.RepositorioTela;
import Repositories.daos.DAOMySQL;

public class FactoryRepositorioTela {
	private static RepositorioTela repo;

    public static RepositorioTela get(){
        if(repo == null){
                repo = RepositorioTela.getInstance(new DAOMySQL(TelaModel.getInstance()));
        }
        return repo;
    }

}
