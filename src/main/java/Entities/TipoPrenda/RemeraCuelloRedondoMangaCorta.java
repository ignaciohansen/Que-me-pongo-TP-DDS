package Entities.TipoPrenda;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="remera_cuello_redondo_manga_corta")
public class RemeraCuelloRedondoMangaCorta extends TipoPrenda {

    public RemeraCuelloRedondoMangaCorta() {
        this.setNivelDeAbrigo(5);
        this.setSuTipo("remera_cuello_redondo_manga_corta");
    }
}
