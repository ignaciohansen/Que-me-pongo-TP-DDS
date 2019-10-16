package Repositories.factories;

import Models.PrendaModel;
import Repositories.RepositorioPrenda;
import Repositories.daos.DAOMySQL;

public class FactoryRepositorioPrenda {
	private static RepositorioPrenda repo;

    public static RepositorioPrenda get(){
        if(repo == null){
                repo = RepositorioPrenda.getInstance(new DAOMySQL(PrendaModel.getInstance()));
        }
        return repo;
    }
}
