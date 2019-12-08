package Entities.Sensibilidad;

import javax.persistence.*;

import Entities.TipoPrenda.TipoPrenda;

@Entity
@DiscriminatorValue(value="caluroso")
public class Caluroso extends tipoSensibilidad {

	public Caluroso() {}
	
    public Caluroso(TipoPrenda.parteDelCuerpoQueAbriga parteCuerpo) {
        this.setValor(-7);
        this.setParteCuerpo(parteCuerpo);
        if(parteCuerpo == TipoPrenda.parteDelCuerpoQueAbriga.Ninguna)
            this.setTipo("Caluroso");
        else{
            this.setTipo("Caluroso que abriga especialmente: " + parteCuerpo);
        }
    }
}
