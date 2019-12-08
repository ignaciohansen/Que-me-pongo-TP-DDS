package Models;

import Entities.Sensibilidad.*;
import db.EntityManagerHelper;
import java.util.List;

public class SensibilidadModel extends Model {
    private static SensibilidadModel instance;

    public static SensibilidadModel getInstance() {
        if(instance == null){
            instance = new SensibilidadModel();
        }
        return instance;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<tipoSensibilidad> buscarTodos() {
        return EntityManagerHelper.getEntityManager().createQuery("FROM Entities.Sensibilidad.tipoSensibilidad").getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public tipoSensibilidad buscar(int id) {
        return (tipoSensibilidad) EntityManagerHelper.getEntityManager().createQuery("from Entities.Sensibilidad.tipoSensibilidad where tipoSensibilidad_id = :tipoSensibilidad_id")
                .setParameter("tipoSensibilidad_id", id).getSingleResult();
    }

}

