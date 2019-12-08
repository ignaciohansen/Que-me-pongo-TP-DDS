package Repositories.factories;

import Models.SensibilidadModel;
import Repositories.RepositorioSensibilidad;
import Repositories.daos.DAOMySQL;

public class FactoryRepositorioSensibilidad {
    private static RepositorioSensibilidad repo;

    public static RepositorioSensibilidad get(){
        if(repo == null){
            repo = RepositorioSensibilidad.getInstance(new DAOMySQL(SensibilidadModel.getInstance()));
        }
        return repo;
    }

}
