package Sensibilidad;

import javax.persistence.*;

import TipoPrenda.TipoPrenda;

@Entity
@DiscriminatorValue(value="friolento")
public class Friolento extends tipoSensibilidad {

    public Friolento(TipoPrenda.parteDelCuerpoQueAbriga parteCuerpo) {
        this.setValor(7);
        this.setParteCuerpo(parteCuerpo);
    }
}
