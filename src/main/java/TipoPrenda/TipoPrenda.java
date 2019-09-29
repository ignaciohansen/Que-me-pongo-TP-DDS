package TipoPrenda;

import javax.persistence.*;
import javax.swing.*;

@Entity
@Table(name = "TIPO_PRENDA")
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "prenda_tipo", discriminatorType = DiscriminatorType.STRING)
public abstract class TipoPrenda {
	
	@Id
	@GeneratedValue
	@Column(name="tipo_prenda_id")
	protected long id;

	@Column(name="tipo_prenda_su_tipo")
    private String suTipo;
	
	@Column(name="tipo_prenda_capa")
    private int CapaDePrenda = 1;
	
	@Column(name="tipo_prenda_nivel")
    private int nivelDeAbrigo = 0;
	
	@Column(name="tipo_prenda_foto")
    private ImageIcon foto;
	
    @Enumerated(EnumType.STRING)
    @Column(name="tipo_prenda_parte")
    private parteDelCuerpoQueAbriga parteDelCuerpo;

    public String getSuTipo() {
        return suTipo;
    }

    public int getCapaDePrenda() {
        return CapaDePrenda;
    }

    public int getNivelDeAbrigo() {
        return nivelDeAbrigo;
    }

    public ImageIcon getFoto() {
        return foto;
    }

    public void setSuTipo(String suTipo) {
        this.suTipo = suTipo;
    }

    public void setCapaDePrenda(int capaDePrenda) {
        CapaDePrenda = capaDePrenda;
    }

    public void setNivelDeAbrigo(int nivelDeAbrigo) {
        this.nivelDeAbrigo = nivelDeAbrigo;
    }

    public void setFoto(ImageIcon foto) {
        this.foto = foto;
    }

    public boolean suNivelDeCapaEs(int nivelObjetivo){
        return nivelObjetivo == this.getCapaDePrenda();
    }

    public enum parteDelCuerpoQueAbriga {Cabeza,Manos,Ninguna};

    public parteDelCuerpoQueAbriga getParteDelCuerpo() {
        return parteDelCuerpo;
    }

    public void setParteDelCuerpo(parteDelCuerpoQueAbriga parteDelCuerpo) {
        this.parteDelCuerpo = parteDelCuerpo;
    }

}
