import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    public void generarAtuendoGR(){
        Prenda superior = prendas.stream()
                .filter(prenda -> prenda.getCategoria().ordinal() == 0)
                .collect(Collectors.toList()).get(0);
        Prenda inferior = prendas.stream()
                .filter(prenda -> prenda.getCategoria().ordinal() == 1)
                .collect(Collectors.toList()).get(0);
        Prenda calzado = prendas.stream()
                .filter(prenda -> prenda.getCategoria().ordinal() == 2)
                .collect(Collectors.toList()).get(0);
        Prenda accesorio = prendas.stream()
                .filter(prenda -> prenda.getCategoria().ordinal() == 3)
                .collect(Collectors.toList()).get(0);

        List<Prenda> listaPrenda = new ArrayList<>();

        listaPrenda.add(superior);
        listaPrenda.add(inferior);
        listaPrenda.add(calzado);
        listaPrenda.add(accesorio);

        Atuendo atuendo = new Atuendo(listaPrenda);
    }
}
