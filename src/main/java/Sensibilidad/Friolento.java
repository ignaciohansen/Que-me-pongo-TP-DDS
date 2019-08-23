package Sensibilidad;

import TipoPrenda.TipoPrenda;

public class Friolento extends tipoSensibilidad {

    public Friolento(TipoPrenda.parteDelCuerpoQueAbriga parteCuerpo) {
        this.setValor(7);
        this.setParteCuerpo(parteCuerpo);
    }
}
