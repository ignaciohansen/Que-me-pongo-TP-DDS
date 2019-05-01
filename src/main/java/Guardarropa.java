import java.util.Set;

public class Guardarropa {
    private Set<Prenda> prendas;

    public Guardarropa(Set<Prenda> prendas) {
        this.prendas = prendas;
    }

    public void setPrendas(Set<Prenda> prendas) {
        this.prendas = prendas;
    }

    public Set<Prenda> getPrendas() {
        return prendas;
    }
}