package Models;

import java.util.List;

import Entities.Usuario.TipoUsuario;
import db.EntityManagerHelper;


public class tipoUsuarioModel extends Model {
    private static tipoUsuarioModel instance;

    public static tipoUsuarioModel getInstance() {
        if(instance == null){
            instance = new tipoUsuarioModel();
        }
        return instance;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<TipoUsuario> buscarTodos() {
        return EntityManagerHelper.getEntityManager().createQuery("FROM Entities.Usuario.TipoUsuario").getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public TipoUsuario buscar(int id) {
        return (TipoUsuario) EntityManagerHelper.getEntityManager().createQuery("from Entities.Usuario.TipoUsuario where tipo_usu_id = :tipo_usu_id")
                .setParameter("tipo_usu_id", id).getSingleResult();
    }


}
