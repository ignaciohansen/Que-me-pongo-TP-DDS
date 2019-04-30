import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Generador {


    private List<Prenda> ListaDePrendasParteSuperior(Guardarropa guardarropa) {return guardarropa.getPrendas().stream()
            .filter(prenda -> prenda.getCategoria().ordinal() == 0)
            .collect(Collectors.toList()); }
    private List<Prenda> ListaDePrendasParteInferior(Guardarropa guardarropa) {return guardarropa.getPrendas().stream()
            .filter(prenda -> prenda.getCategoria().ordinal() == 1)
            .collect(Collectors.toList()); }
    private List<Prenda> ListaDePrendasCalzado(Guardarropa guardarropa) {return guardarropa.getPrendas().stream()
            .filter(prenda -> prenda.getCategoria().ordinal() == 2)
            .collect(Collectors.toList()); }
    private List<Prenda> ListaDePrendasAccesorio(Guardarropa guardarropa) {return guardarropa.getPrendas().stream()
            .filter(prenda -> prenda.getCategoria().ordinal() == 3)
            .collect(Collectors.toList()); }

    public void generarAtuendoGR(Guardarropa guardarropa){
        int randomPSuperior = (int)(Math.random()*(this.ListaDePrendasParteSuperior(guardarropa).size()));
        int randomPInferior = (int)(Math.random()*(this.ListaDePrendasParteInferior(guardarropa).size()));
        int randomCalzado = (int)(Math.random()*(this.ListaDePrendasCalzado(guardarropa).size()));
        int randomAccesorio = (int)(Math.random()*(this.ListaDePrendasAccesorio(guardarropa).size()));

        Prenda superior = this.ListaDePrendasParteSuperior(guardarropa).get(randomPSuperior);
        Prenda inferior = this.ListaDePrendasParteInferior(guardarropa).get(randomPInferior);
        Prenda calzado = this.ListaDePrendasCalzado(guardarropa).get(randomCalzado);
        Prenda accesorio = this.ListaDePrendasAccesorio(guardarropa).get(randomAccesorio);

        List<Prenda> listaPrenda = new ArrayList<>();

        listaPrenda.add(superior);
        listaPrenda.add(inferior);
        listaPrenda.add(calzado);
        listaPrenda.add(accesorio);

        Atuendo atuendo = new Atuendo(listaPrenda);
    }
}
