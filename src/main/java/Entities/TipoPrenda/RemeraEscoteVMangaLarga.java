package Entities.TipoPrenda;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="remera_escote_v_manga_larga")
public class RemeraEscoteVMangaLarga extends TipoPrenda {
    public RemeraEscoteVMangaLarga() {
        this.setNivelDeAbrigo(8);
        this.setSuTipo("remera_escote_v_manga_larga");
    }
}
