import java.util.HashSet;
import java.util.Set;

public class Guardarropa {
    private Set<Prenda> prendas;

    public Guardarropa(){
        this.prendas = new HashSet<Prenda>();
    }
    public Guardarropa(Set<Prenda> prendas) {
        this.prendas = new HashSet<Prenda>();
        this.prendas = prendas;
    }

    public void setPrendas(Set<Prenda> prendas) {
        this.prendas = prendas;
    }

    public Set<Prenda> getPrendas() {
        return prendas;
    }

    public void agregarPrenda(Prenda prenda){
        prendas.add(prenda);
    }
}