package Sensibilidad;

import TipoPrenda.TipoPrenda;

public class Indiferente extends tipoSensibilidad {


    public Indiferente(TipoPrenda.parteDelCuerpoQueAbriga parteCuerpo) {
        this.setValor(0);
        this.setParteCuerpo(parteCuerpo);
    }
}
