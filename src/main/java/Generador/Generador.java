package Generador;

import Ropas.Atuendo;
import Ropas.Guardarropa;
import Ropas.Prenda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Generador {

// Se toma una prenda random de una lista que esta filtrada segun categoria y de la capa1

    private List<Prenda> ListaDePrendasParteSuperiorCapa1(Guardarropa guardarropa) {return guardarropa.getPrendas().stream()
            .filter(prenda -> prenda.getTipoDePrenda().suNivelDeCapaEs(1))
            .filter(prenda -> prenda.getCategoria().ordinal() == 0)
            .collect(Collectors.toList()); }
    private List<Prenda> ListaDePrendasParteInferiorCapa1(Guardarropa guardarropa) {return guardarropa.getPrendas().stream()
            .filter(prenda -> prenda.getTipoDePrenda().suNivelDeCapaEs(1))
            .filter(prenda -> prenda.getCategoria().ordinal() == 1)
            .collect(Collectors.toList()); }
    private List<Prenda> ListaDePrendasCalzadoCapa1(Guardarropa guardarropa) {return guardarropa.getPrendas().stream()
            .filter(prenda -> prenda.getTipoDePrenda().suNivelDeCapaEs(1))
            .filter(prenda -> prenda.getCategoria().ordinal() == 2)
            .collect(Collectors.toList()); }
    private List<Prenda> ListaDePrendasAccesorioCapa1(Guardarropa guardarropa) {return guardarropa.getPrendas().stream()
            .filter(prenda -> prenda.getTipoDePrenda().suNivelDeCapaEs(1))
            .filter(prenda -> prenda.getCategoria().ordinal() == 3)
            .collect(Collectors.toList()); }

    public Atuendo generarAtuendoGR(Guardarropa guardarropa){
        int randomPSuperior = (int)(Math.random()*(this.ListaDePrendasParteSuperiorCapa1(guardarropa).size()));
        int randomPInferior = (int)(Math.random()*(this.ListaDePrendasParteInferiorCapa1(guardarropa).size()));
        int randomCalzado = (int)(Math.random()*(this.ListaDePrendasCalzadoCapa1(guardarropa).size()));
        int randomAccesorio = (int)(Math.random()*(this.ListaDePrendasAccesorioCapa1(guardarropa).size()));

        Prenda superior = this.ListaDePrendasParteSuperiorCapa1(guardarropa).get(randomPSuperior);
        Prenda inferior = this.ListaDePrendasParteInferiorCapa1(guardarropa).get(randomPInferior);
        Prenda calzado = this.ListaDePrendasCalzadoCapa1(guardarropa).get(randomCalzado);
        Prenda accesorio = this.ListaDePrendasAccesorioCapa1(guardarropa).get(randomAccesorio);

        List<Prenda> listaPrenda = new ArrayList<>();

        listaPrenda.add(superior);
        listaPrenda.add(inferior);
        listaPrenda.add(calzado);
        listaPrenda.add(accesorio);

        // VER ACA, SI EL NIVEL DE ABRIGO ES MENOR A UNO QUE TENGA Q VER CON LA TEMPERATURA (EJ: 30-GRADOS DEL LUGAR), HAY QUE AGREGAR ROPA DE CAPA2 , SINO SE DEVUELVE ESE ATUENDO
        int nivelAbrigoPrimeraCapa = listaPrenda.stream().mapToInt(Prenda::suCapa).sum();

        return new Atuendo(listaPrenda);
    }

    public List<Atuendo> generarAtuendos(List<Guardarropa> guardarropas){
        List<Atuendo> atuendos = new ArrayList<Atuendo>();

        for (int i = 0; i < guardarropas.size(); i++) {
            atuendos.add(this.generarAtuendoGR(guardarropas.get(i)));
        }

        return atuendos;
    }
}
