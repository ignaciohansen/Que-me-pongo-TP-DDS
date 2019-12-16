package Entities.TipoPrenda;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="remera_escote_v_manga_corta")
public class RemeraEscoteVMangaCorta extends TipoPrenda {
    public RemeraEscoteVMangaCorta() {
        this.setNivelDeAbrigo(5);
        this.setSuTipo("remera_escote_v_manga_corta");
    }
}
