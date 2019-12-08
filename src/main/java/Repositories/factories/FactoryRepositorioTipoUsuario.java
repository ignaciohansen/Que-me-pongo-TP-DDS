package Repositories.factories;


import Models.tipoUsuarioModel;
import Repositories.RepositorioTipoUsuario;
import Repositories.daos.DAOMySQL;

public class FactoryRepositorioTipoUsuario {
    private static RepositorioTipoUsuario repo;

    public static RepositorioTipoUsuario get(){
        if(repo == null){
            repo = RepositorioTipoUsuario.getInstance(new DAOMySQL(tipoUsuarioModel.getInstance()));
        }
        return repo;
    }
}