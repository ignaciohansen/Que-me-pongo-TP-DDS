package Sensibilidad;

import TipoPrenda.TipoPrenda;

public class Friolento extends tipoSensibilidad {

    public Friolento(TipoPrenda.parteDelCuerpoQueAbriga parteCuerpo) {
        this.setValor(4);
        this.setParteCuerpo(parteCuerpo);
    }
}
