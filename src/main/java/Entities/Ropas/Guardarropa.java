package Entities.Ropas;

import Entities.Exceptions.En2Guardarropas;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="GUARDARROPA")
public class Guardarropa {
	
	@Id
	@GeneratedValue
	@Column(name="guardarropa_id")
	private long id;
	
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
    private Set<Prenda> prendas;
	
	@Column(name="guardarropa_descripcion")
	private String descripcion;

    public Guardarropa(){
        this.prendas = new HashSet<Prenda>();
    }
    public Guardarropa(Set<Prenda> prendas) {
        this.prendas = new HashSet<Prenda>();
        this.prendas = prendas; }

    public Set<Prenda> getPrendas() {
        return prendas;
    }

    public long getId() {
		return id;
	}
    
	public void setId(long id) {
		this.id = id;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void setPrendas(Set<Prenda> prendas) {
		this.prendas = prendas;
	}
	
	public void sacarPrenda(Prenda prenda){
        prendas.remove(prenda);
        prenda.setEstaEnGuardarropa(false);
    }

    public void agregarPrenda(Prenda prenda) throws En2Guardarropas {

        if(prenda.getEstaEnGuardarropa()){
        throw new En2Guardarropas("La prenda ya esta asignada en un guardarropa");
        }else{
        prendas.add(prenda);
        prenda.setEstaEnGuardarropa(true);
        }

    }

    public int cantidadDePrendas(){
        return prendas.size();
    }
	@Override
	public String toString() {
		return "Guardarropa [id=" + id + ", prendas=" + prendas + "]";
	}
    
}