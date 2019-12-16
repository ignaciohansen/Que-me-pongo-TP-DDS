package Entities.Telas;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="cuero")
public class Cuero extends Tela {

    public Cuero() {
        this.getPrendasIncompatibles().add("remera_cuello_redondo_manga_corta");
        this.getPrendasIncompatibles().add("remera_cuello_redondo_manga_larga");
        this.getPrendasIncompatibles().add("remera_escote_v_manga_corta");
        this.getPrendasIncompatibles().add("remera_escote_v_manga_larga");
        this.getPrendasIncompatibles().add("sweater");
        this.getPrendasIncompatibles().add("campera");
        this.getPrendasIncompatibles().add("pantalon_corto");
        this.getPrendasIncompatibles().add("pantalon_largo");
        this.getPrendasIncompatibles().add("bermuda");
        this.getPrendasIncompatibles().add("pollera");
        this.getPrendasIncompatibles().add("calza");
        this.getPrendasIncompatibles().add("buzo");
        this.getPrendasIncompatibles().add("musculosa");
        setDescripcion("Cuero");
    }

    @Override
    public String toString() {
        return "Cuero";
    }
}

