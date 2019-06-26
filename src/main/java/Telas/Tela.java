package Telas;

import TipoPrenda.TipoPrenda;

import java.util.ArrayList;
import java.util.List;

public abstract class Tela {
    public List<String> prendasIncompatibles = new ArrayList<>();


    //public Boolean incompatible(TipoPrenda tipoDePrenda){ return false;
    public Boolean incompatible(TipoPrenda tipoDePrenda){
        return prendasIncompatibles.contains(tipoDePrenda.getSuTipo());
}

    public List<String> getPrendasIncompatibles() {
        return prendasIncompatibles;
    }

    public void setPrendasIncompatibles(List<String> prendasIncompatibles) {
        this.prendasIncompatibles = prendasIncompatibles;
    }

    public int cantidadPrendasIncompatibles(){
        return prendasIncompatibles.size();
    }
}



