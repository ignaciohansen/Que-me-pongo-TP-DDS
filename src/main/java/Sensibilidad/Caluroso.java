package Sensibilidad;

import javax.persistence.*;

import TipoPrenda.TipoPrenda;

@Entity
@DiscriminatorValue(value="caluroso")
public class Caluroso extends tipoSensibilidad {

    public Caluroso(TipoPrenda.parteDelCuerpoQueAbriga parteCuerpo) {
        this.setValor(-7);
        this.setParteCuerpo(parteCuerpo);
    }
}
