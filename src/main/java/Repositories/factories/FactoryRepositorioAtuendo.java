package Repositories.factories;

import Models.AtuendoModel;
import Repositories.RepositorioAtuendo;
import Repositories.daos.DAOMySQL;

public class FactoryRepositorioAtuendo {
    private static RepositorioAtuendo repo;

    public static RepositorioAtuendo get(){
        if(repo == null){
                repo = RepositorioAtuendo.getInstance(new DAOMySQL(AtuendoModel.getInstance()));
        }
        return repo;
    }
}
