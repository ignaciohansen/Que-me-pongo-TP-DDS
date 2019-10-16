package Repositories.factories;

import config.Config;
import Models.UsuarioModel;
import Repositories.RepositorioUsuario;
import Repositories.daos.DAOMySQL;

public class FactoryRepositorioUsuario {
    private static RepositorioUsuario repo;

    public static RepositorioUsuario get(){
        if(repo == null){
                repo = RepositorioUsuario.getInstance(new DAOMySQL(UsuarioModel.getInstance()));
        }
        return repo;
    }
}
