package Entities.TipoPrenda;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="remera_cuelloredondo_mangalarga")
public class RemeraCuelloRedondoMangaLarga extends TipoPrenda {
    public RemeraCuelloRedondoMangaLarga() {
        this.setNivelDeAbrigo(8);
        this.setSuTipo("remera_cuello_redondo_manga_larga");
    }
}
