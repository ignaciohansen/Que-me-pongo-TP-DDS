package Ropas;

import java.util.ArrayList;
import java.util.List;


public class Atuendo {
    private List<Prenda> prendas;

    public Atuendo(){
        this.prendas = new ArrayList<Prenda>();
    }

    public Atuendo(List<Prenda> prendas) {
        this.prendas = new ArrayList<Prenda>();
        this.prendas = prendas;
    }

    public int cantidadDePrendas(){
        return prendas.size();
    }

    public void setPrendas(List<Prenda> prendas) {
        this.prendas = prendas;
    }

    public List<Prenda> getPrendas() {
        return prendas;
    }

    public int nivelAbrigo(){ return  prendas.stream().mapToInt(Prenda::suCapa).sum();}

    @Override
    public String toString() {
        return "Ropas.Atuendo{" +
                "prendas=" + prendas +
                '}';
    }
}