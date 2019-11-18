package Entities.TipoPrenda;

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
	private long id;

	@Column(name="tipo_prenda_su_tipo")
    private String suTipo;
	
	@Column(name="tipo_prenda_capa")
    private int CapaDePrenda = 1;
	
	@Column(name="tipo_prenda_nivel")
    private int nivelDeAbrigo = 0;
	
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

    public void setSuTipo(String suTipo) {
        this.suTipo = suTipo;
    }

    public void setCapaDePrenda(int capaDePrenda) {
        CapaDePrenda = capaDePrenda;
    }

    public void setNivelDeAbrigo(int nivelDeAbrigo) {
        this.nivelDeAbrigo = nivelDeAbrigo;
    }

    public boolean suNivelDeCapaEs(int nivelObjetivo){
        return nivelObjetivo == this.getCapaDePrenda();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public enum parteDelCuerpoQueAbriga {Cabeza,Manos,Ninguna};

    public parteDelCuerpoQueAbriga getParteDelCuerpo() {
        return parteDelCuerpo;
    }

    public void setParteDelCuerpo(parteDelCuerpoQueAbriga parteDelCuerpo) {
        this.parteDelCuerpo = parteDelCuerpo;
    }
    
}
