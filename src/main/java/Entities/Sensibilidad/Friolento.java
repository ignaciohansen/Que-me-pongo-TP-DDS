package Entities.Sensibilidad;

import javax.persistence.*;

import Entities.TipoPrenda.TipoPrenda;

@Entity
@DiscriminatorValue(value="friolento")
public class Friolento extends tipoSensibilidad {

	public Friolento() {}
	
    public Friolento(TipoPrenda.parteDelCuerpoQueAbriga parteCuerpo) {
        this.setValor(7);
        this.setParteCuerpo(parteCuerpo);
        if(parteCuerpo == TipoPrenda.parteDelCuerpoQueAbriga.Ninguna)
        this.setTipo("Friolento");
        else{
            this.setTipo("Friolento que abriga especialmente: " + parteCuerpo);
        }
    }
}
