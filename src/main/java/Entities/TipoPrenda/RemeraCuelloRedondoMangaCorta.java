package Entities.TipoPrenda;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="remera_cuelloredondo_mangacorta")
public class RemeraCuelloRedondoMangaCorta extends TipoPrenda {

    public RemeraCuelloRedondoMangaCorta() {
        this.setNivelDeAbrigo(5);
        this.setSuTipo("remera_cuelloredondo_mangacorta");
    }
}
