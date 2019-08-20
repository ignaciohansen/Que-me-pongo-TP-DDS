package Sensibilidad;

import TipoPrenda.TipoPrenda;

public class Caluroso extends tipoSensibilidad {

    public Caluroso(TipoPrenda.parteDelCuerpoQueAbriga parteCuerpo) {
        this.setValor(-5);
        this.setParteCuerpo(parteCuerpo);
    }
}
