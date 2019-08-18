package Sensibilidad;

import TipoPrenda.TipoPrenda;

public class Caluroso extends tipoSensibilidad {

    public Caluroso(TipoPrenda.parteDelCuerpoQueAbriga parteCuerpo) {
        this.setValor(-4);
        this.setParteCuerpo(parteCuerpo);
    }
}
