package Ropas;

import java.util.HashSet;
import java.util.Set;

public class Guardarropa {
    private Set<Prenda> prendas;

    public Guardarropa(){
        this.prendas = new HashSet<Prenda>();
    }
    public Guardarropa(Set<Prenda> prendas) {
        this.prendas = new HashSet<Prenda>();
        this.prendas = prendas; }

    public Set<Prenda> getPrendas() {
        return prendas;
    }

    public void sacarPrenda(Prenda prenda){
        prendas.remove(prenda);
        prenda.estaEnGuardarropa = false;
    }

    public void agregarPrenda(Prenda prenda) throws Exceptions.En2Guardarropas {

        if(prenda.estaEnGuardarropa){
        throw new Exceptions.En2Guardarropas("La prenda ya esta asignada en un guardarropa");
        }else{
        prendas.add(prenda);
        prenda.estaEnGuardarropa = true;
        }

    }

    public int cantidadDePrendas(){
        return prendas.size();
    }
}