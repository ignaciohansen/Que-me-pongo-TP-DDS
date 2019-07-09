package Generador;

import Ropas.Atuendo;
import Ropas.Guardarropa;
import Ropas.Prenda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Generador {

    private int gradosQueHacenSinApi = 10;
    private int numeroReferenciaParaCalculo = 30; // Podria ir en un archiv config

    public void setGrados(int grados){
        this.gradosQueHacenSinApi = grados;
    }
// Se toma una prenda random de una lista que esta filtrada segun categoria y de la capa1
    private List<Prenda> listaDePrendasDeCapaYcategoria(Guardarropa guardarropa,int capa,int categoria){
        return  guardarropa.getPrendas().stream().
                filter(prenda -> prenda.getTipoDePrenda().suNivelDeCapaEs(capa))
                .filter(prenda -> prenda.getCategoria().ordinal() == categoria)
                .collect(Collectors.toList());}

    private List<Prenda> ListaDePrendasParteSuperiorCapa1(Guardarropa guardarropa) {return
            this.listaDePrendasDeCapaYcategoria(guardarropa,1,0);}
    private List<Prenda> ListaDePrendasParteInferiorCapa1(Guardarropa guardarropa){return
            this.listaDePrendasDeCapaYcategoria(guardarropa,1,1);}

    private List<Prenda> ListaDePrendasCalzadoCapa1(Guardarropa guardarropa){return
            this.listaDePrendasDeCapaYcategoria(guardarropa,1,2);}

    private List<Prenda> ListaDePrendasAccesorioCapa1(Guardarropa guardarropa)
    {return this.listaDePrendasDeCapaYcategoria(guardarropa,1,3);}

     /*   {return guardarropa.getPrendas().stream()
            .filter(prenda -> prenda.getTipoDePrenda().suNivelDeCapaEs(1))
            .filter(prenda -> prenda.getCategoria().ordinal() == 3)
            .collect(Collectors.toList()); }

      */

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

        int nivelAbrigoPrimeraCapa = listaPrenda.stream().mapToInt(Prenda::suCapa).sum();

        if((this.numeroReferenciaParaCalculo-this.gradosQueHacenSinApi)>nivelAbrigoPrimeraCapa)
        // Ej hacen 5 grados => 30-5 = 25 nivel de abrigo objetivo, lleno ropa hasta que llegue a eso
        {
            //Lleno con ropa segunda capa
            List<Prenda> prendasCapaDosPSuperior = this.listaDePrendasDeCapaYcategoria(guardarropa,2,0);
            int random2PSuperior = (int)(Math.random()*(prendasCapaDosPSuperior.size()));
            Prenda superior2Capa = prendasCapaDosPSuperior.get(random2PSuperior);
            listaPrenda.add(superior2Capa);
            int nivelAbrigoPrimeraSuperposicion = listaPrenda.stream().mapToInt(Prenda::suCapa).sum();

            // Si al tener ya la primera superposicion sigue sin alcanzar, le agrego otra mas ej ( remera-sweater-campera)
            if((this.numeroReferenciaParaCalculo-this.gradosQueHacenSinApi)>nivelAbrigoPrimeraSuperposicion){
                List<Prenda> prendasCapaTresPSuperior = this.listaDePrendasDeCapaYcategoria(guardarropa,3,0);
                int random3PSuperior = (int)(Math.random()*(prendasCapaTresPSuperior.size()));
                Prenda superior3Capa = prendasCapaTresPSuperior.get(random3PSuperior);
                listaPrenda.add(superior3Capa);
            }

        }
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


// POR COMO ESTA AHORA EL CLIMA, SE GENERAN ATUENDOS CON PRENDAS DE DOS CAPAS