package Repositories.factories;

import Models.TipoPrendaModel;
import Repositories.RepositorioTipoPrenda;
import Repositories.daos.DAOMySQL;

public class FactoryRepositorioTipoPrenda {
	private static RepositorioTipoPrenda repo;

    public static RepositorioTipoPrenda get(){
        if(repo == null){
                repo = RepositorioTipoPrenda.getInstance(new DAOMySQL(TipoPrendaModel.getInstance()));
        }
        return repo;
    }

}
