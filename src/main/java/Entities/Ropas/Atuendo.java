package Entities.Ropas;

import Entities.TipoPrenda.TipoPrenda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.*;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name="ATUENDO")
public class Atuendo {

    @Id
	@GeneratedValue
	@Column(name="atuendo_id")
	protected long id;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Prenda> prendas;
	
	@Column(name="atuendo_aceptado")
	private boolean aceptado;

    @Column(name="atuendo_eliminado")
    private int eliminado;

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    @Column(name="calificacion")
    private int calificacion;

    public Atuendo(){
        this.prendas = new ArrayList<Prenda>();
    }

    public Atuendo(List<Prenda> prendas) {
        this.prendas = new ArrayList<Prenda>();
        this.prendas = prendas;
        this.eliminado = 0;
    }

    public int cantidadDePrendas(){
        return prendas.size();
    }

    public void setPrendas(List<Prenda> prendas) {
        this.prendas = prendas;
    }


    public List<Prenda> getPrendas() {
        return prendas;
    }
    
    public boolean getAceptado() {
		return aceptado;
	}

	public void setAceptado(boolean aceptado) {
		this.aceptado = aceptado;
	}

	public List<TipoPrenda> getTipoPrenda()  {
        return prendas.stream().map(prenda -> prenda.getTipoDePrenda()).collect(Collectors.toList());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int nivelAbrigo(){ return  prendas.stream().mapToInt(Prenda::suCapa).sum();}

    public int getEliminado() { return eliminado; }

    public void Eliminar() {
        prendas.forEach(prenda -> prenda.setSeUtilizaEnUnAtuendo(false));
        this.eliminado = 1; }

    @Override
    public String toString() {
        return "Creamos un atuendo compuesto por: " + prendas.stream().map(prenda -> prenda.getDescripcion()).collect(Collectors.toList());

    }
        // return "Ropas.Atuendo{"+"prendas=" + this.getTipoPrenda() + '}';
       // return this.getClass().getSimpleName();
        //return "Prendas=" + prendas.stream().map(prenda -> prenda.getDescripcion() + " de color " + prenda.getColorPrimario()).collect(Collectors.toList());


}