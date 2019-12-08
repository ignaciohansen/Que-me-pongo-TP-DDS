package Entities.Sensibilidad;

import Entities.TipoPrenda.TipoPrenda;

import javax.persistence.*;
import java.util.stream.Stream;

@Entity
@Table(name="TIPO_SENSIBILIDAD")
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
public abstract class tipoSensibilidad {

	@Id
	@GeneratedValue
	@Column(name="tipo_sensibilidad_id")
	protected long id;

    @Column(name="tipo_sensibilidad")
    private String tipo;

	@Column(name="tipo_sensibilidad_valor")
    private int valor;    // Este valor influye en el calculo para generar los atuendos ( suma o resta segun si es caluroso o friolento)
	
	@Enumerated(EnumType.STRING)
    @Column(name="tipo_sensibilidad_cuerpo")
    private TipoPrenda.parteDelCuerpoQueAbriga parteCuerpo;// Esto hay que verificar con los accesorios para decir que me abrigue esa parte

    public TipoPrenda.parteDelCuerpoQueAbriga getParteCuerpo() {
        return parteCuerpo;
    }

    public void setParteCuerpo(TipoPrenda.parteDelCuerpoQueAbriga parteCuerpo) {
        this.parteCuerpo = parteCuerpo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getTipo() { return tipo; }

    public void setTipo(String tipo) { this.tipo = tipo; }

}
