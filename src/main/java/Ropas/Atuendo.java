package Ropas;

import TipoPrenda.TipoPrenda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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

    public List<TipoPrenda> getTipoPrenda()  {
        return prendas.stream().map(prenda -> prenda.getTipoDePrenda()).collect(Collectors.toList());
    }

    public int nivelAbrigo(){ return  prendas.stream().mapToInt(Prenda::suCapa).sum();}

    @Override
    public String toString() {
       // return "Ropas.Atuendo{"+"prendas=" + this.getTipoPrenda() + '}';
       // return this.getClass().getSimpleName();
       return "Prendas=" + prendas.stream().map(prenda -> prenda.getDescripcion() + " de color " + prenda.getColorPrimario()).collect(Collectors.toList());
    }
}