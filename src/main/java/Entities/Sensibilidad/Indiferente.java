package Entities.Sensibilidad;

import Entities.TipoPrenda.TipoPrenda;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="indiferente")
public class Indiferente extends tipoSensibilidad {


	public Indiferente() {}
	
    public Indiferente(TipoPrenda.parteDelCuerpoQueAbriga parteCuerpo) {
        this.setValor(0);
        this.setParteCuerpo(parteCuerpo);
        this.setTipo("Indiferente");
    }
}
