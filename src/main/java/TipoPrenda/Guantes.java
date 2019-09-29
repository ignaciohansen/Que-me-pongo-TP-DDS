package TipoPrenda;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="guantes")
public class Guantes extends Accesorio {


    public Guantes() {
        this.setSuTipo("guantes");
        this.setNivelDeAbrigo(3);
        this.setParteDelCuerpo(parteDelCuerpoQueAbriga.Manos);

    }
}