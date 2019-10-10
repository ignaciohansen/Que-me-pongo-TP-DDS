package Repositories;

import Repositories.Dao.AbstractDAO;

public abstract class Repositorio {
    protected AbstractDAO dao;

    public void setDao(AbstractDAO dao) {
        this.dao = dao;
    }
/*
    public void agregar(Object unObjeto){
        this.dao.agregar(unObjeto);
    }

    public void modificar(Object unObjeto){
        this.dao.modificar(unObjeto);
    }

    public void eliminar(Object unObjeto){
        this.dao.eliminar(unObjeto);
    }

 */
}
