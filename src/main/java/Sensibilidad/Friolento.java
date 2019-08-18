package Sensibilidad;

import TipoPrenda.TipoPrenda;

public class Friolento extends tipoSensibilidad {

    public Friolento(TipoPrenda.parteDelCuerpoQueAbriga parteCuerpo) {
        this.setValor(5);
        this.setParteCuerpo(parteCuerpo);
    }
}
