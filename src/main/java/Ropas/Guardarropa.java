package Ropas;

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
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Set<Prenda> prendas;

    public Guardarropa(){
        this.prendas = new HashSet<Prenda>();
    }
    public Guardarropa(Set<Prenda> prendas) {
        this.prendas = new HashSet<Prenda>();
        this.prendas = prendas; }

    public Set<Prenda> getPrendas() {
        return prendas;
    }

    public void sacarPrenda(Prenda prenda){
        prendas.remove(prenda);
        prenda.setEstaEnGuardarropa(false);
    }

    public void agregarPrenda(Prenda prenda) throws Exceptions.En2Guardarropas {

        if(prenda.getEstaEnGuardarropa()){
        throw new Exceptions.En2Guardarropas("La prenda ya esta asignada en un guardarropa");
        }else{
        prendas.add(prenda);
        prenda.setEstaEnGuardarropa(true);
        }

    }

    public int cantidadDePrendas(){
        return prendas.size();
    }
}