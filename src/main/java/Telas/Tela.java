package Telas;

import TipoPrenda.TipoPrenda;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "TELA")
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tela_tipo", discriminatorType = DiscriminatorType.STRING)
public abstract class Tela {
	
	@Id
	@GeneratedValue
	@Column(name="tela_id")
	private long id;
	
	@ElementCollection
	@CollectionTable(name="prendasIncompatibles", joinColumns=@JoinColumn(name="tela_id"))
	@Column(name="prendasIncompatibles")
    public List<String> prendasIncompatibles = new ArrayList<>();


    //public Boolean incompatible(TipoPrenda tipoDePrenda){ return false;
    public Boolean incompatible(TipoPrenda tipoDePrenda){
        return prendasIncompatibles.contains(tipoDePrenda.getSuTipo());
}

    public List<String> getPrendasIncompatibles() {
        return prendasIncompatibles;
    }

    public void setPrendasIncompatibles(List<String> prendasIncompatibles) {
        this.prendasIncompatibles = prendasIncompatibles;
    }

    public int cantidadPrendasIncompatibles(){
        return prendasIncompatibles.size();
    }
}



