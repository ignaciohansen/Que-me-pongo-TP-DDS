package Ropas;

import java.util.HashSet;
import java.util.Set;

public class Guardarropa {
    private Set<Prenda> prendas;
    public Boolean perteneceAUsuario = false;

    public Guardarropa(){
        this.prendas = new HashSet<Prenda>();
    }
    public Guardarropa(Set<Prenda> prendas) {
        this.prendas = new HashSet<Prenda>();
        this.prendas = prendas;
    }

    public void setPrendas(Set<Prenda> prendas) {
        this.prendas = prendas;
    }

    public Set<Prenda> getPrendas() {
        return prendas;
    }

    public void agregarPrenda(Prenda prenda) throws Exceptions.En2Guardarropas {


       // VER ESTA IMPLEMENTACION PARA NO REPETIR ROPA EN GUARDARROPAS

        if(prenda.estaEnGuardarropa){
        throw new Exceptions.En2Guardarropas("La prenda ya esta asignada en un guardarropa");
        }else{
        prendas.add(prenda);
        prenda.estaEnGuardarropa = true;
        }


       // prendas.add(prenda);
    }

    public int cantidadDePrendas(){
        return prendas.size();
    }
}