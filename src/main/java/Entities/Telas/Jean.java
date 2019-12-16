package Entities.Telas;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="jean")
public class Jean extends Tela {

    public Jean() {
        this.getPrendasIncompatibles().add("remera_cuello_redondo_manga_corta");
        this.getPrendasIncompatibles().add("remera_cuello_redondo_manga_larga");
        this.getPrendasIncompatibles().add("remera_escote_v_manga_corta");
        this.getPrendasIncompatibles().add("remera_escote_v_manga_larga");
        this.getPrendasIncompatibles().add("sweater");
        this.getPrendasIncompatibles().add("campera");
        this.getPrendasIncompatibles().add("calza");
        this.getPrendasIncompatibles().add("buzo");
        this.getPrendasIncompatibles().add("zapatilla");
        this.getPrendasIncompatibles().add("zapato");
        this.getPrendasIncompatibles().add("sandalia");
        this.getPrendasIncompatibles().add("musculosa");
        setDescripcion("Jean");
    }

    @Override
    public String toString() {
        return "Jean";
    }
}


