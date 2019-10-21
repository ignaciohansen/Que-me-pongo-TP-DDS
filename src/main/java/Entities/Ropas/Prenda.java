package Entities.Ropas;

import Entities.Exceptions.TelaIncompatible;
import Entities.Telas.Tela;
import Entities.TipoPrenda.TipoPrenda;

import javax.persistence.*;

@Entity
@Table(name="PRENDA")
public class Prenda {

	@Id
	@GeneratedValue
	@Column(name="prenda_id")
	private long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="prenda_color_prim")
    private Color colorPrimario;
	
	@Enumerated(EnumType.STRING)
	@Column(name="prenda_color_sec")
    private Color colorSecundario;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private TipoPrenda tipoDePrenda;
    
    @Enumerated(EnumType.STRING)
	@Column(name="prenda_categoria")
    private CategoriaPrenda categoria;
    
    @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Tela tela;

    @Column(name="prenda_descripcion")
    private String descripcion;
    
    @Column(name="prenda_esta_en_guard")
    private Boolean estaEnGuardarropa = false;
    
    @Column(name="prenda_utiliza_atuendo")
    private Boolean seUtilizaEnUnAtuendo = false;

    public Prenda() {}
    
    public Prenda(Color colorPrimario, Color colorSecundario, TipoPrenda tipoDePrenda,CategoriaPrenda categoria,Tela unaTela,String descripcion) throws Exception {
        this.colorPrimario = colorPrimario;
        this.tipoDePrenda = tipoDePrenda;
        this.categoria = categoria;
        this.descripcion = descripcion;
        setColorSecundario(colorSecundario);
        setTela(unaTela);
    }

    public String getDescripcion() {
    	return descripcion;
    }
    
    public Color getColorPrimario() {
        return colorPrimario;
    }

    public void setColorPrimario(Color colorPrimario) {
        this.colorPrimario = colorPrimario;
    }

    public Color getColorSecundario() {
        return colorSecundario;
    }

    public void setColorSecundario(Color colorSecundario) throws Exception {
        if (!colorSecundario.equals(this.colorPrimario)) {
            this.colorSecundario = colorSecundario;
        } else{
            throw new Exception("El color secundario es el mismo que el primario");
        }
    }

    public TipoPrenda getTipoDePrenda() {
        return tipoDePrenda;
    }

    public void setTipoDePrenda(TipoPrenda tipoDePrenda) {
        this.tipoDePrenda = tipoDePrenda;
    }

    public CategoriaPrenda getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaPrenda categoria) {
        this.categoria = categoria;
    }

    public void setTela(Tela tela) throws TelaIncompatible {
        if(tela.incompatible(this.tipoDePrenda)){
            throw new TelaIncompatible();
        } else this.tela = tela;
    }

    public int suCapa(){ return tipoDePrenda.getNivelDeAbrigo(); }
    public Tela getTela() { return tela; }
    
    public Boolean getEstaEnGuardarropa() {
		return estaEnGuardarropa;
	}

	public void setEstaEnGuardarropa(Boolean estaEnGuardarropa) {
		this.estaEnGuardarropa = estaEnGuardarropa;
	}

	public Boolean getSeUtilizaEnUnAtuendo() {
		return seUtilizaEnUnAtuendo;
	}

	public void setSeUtilizaEnUnAtuendo(Boolean seUtilizaEnUnAtuendo) {
		this.seUtilizaEnUnAtuendo = seUtilizaEnUnAtuendo;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public enum Color {Rojo, Verde, Azul, Negro, Blanco, Gris, Amarillo, Marron, Rosa, Violeta, Celeste};

    public enum CategoriaPrenda {ParteSuperior, ParteInferior, Calzado, Accesorio}; //Ver si agregar manos, cabeza como categoria

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Prenda) {
            Prenda tmpPrenda = (Prenda) obj;
            return (this.tipoDePrenda == tmpPrenda.tipoDePrenda
                    && this.colorPrimario == tmpPrenda.colorPrimario
                    && this.colorSecundario == tmpPrenda.colorSecundario
                    && this.categoria.ordinal() == tmpPrenda.categoria.ordinal());
        }

        return false;
    }
/*
    @Override
    public String toString() {
        return "Ropas.Prenda{" +
                "colorPrimario=" + colorPrimario +
                ", colorSecundario=" + colorSecundario +
                ", tipoDePrenda='" + tipoDePrenda + '\'' +
                ", categoria=" + categoria +
                ", tela=" + tela +
                ", estaEnGuardarropa=" + estaEnGuardarropa +
                '}';
    }
*/
    @Override
    public String toString() {
        return descripcion + " " + colorPrimario;
    }

}