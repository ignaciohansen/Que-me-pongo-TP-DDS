package Generador;

import Clima.ApiClima;
import Ropas.Atuendo;
import Ropas.Guardarropa;
import Ropas.Prenda;
import TipoPrenda.TipoPrenda;
import Usuario.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Generador {

    /*
    //Lo que deberia poder hacer:
    ApiClima api = new ApiClima();
    api.obtenerHttp(); //finalmente cambiar a void, devuelve string por motivos de testeo.
    int temperatura = Header.getTemperatura().getMetric().getValue();
    //Utilizar temperatura en el generador.
     */

    ApiClima api = new ApiClima();
    int grados = api.obtenerHttp();

    private int gradosQueHacenApi = grados;
    private int numeroReferenciaParaCalculo = 30; // Podria ir en un archiv config

    public void setGrados(int grados){
        this.gradosQueHacenApi = grados;
    }


    // Se toma una prenda random de una lista que esta filtrada segun categoria y de la capa1
    private List<Prenda> listaDePrendasDeCapaYcategoria(Guardarropa guardarropa,int capa,int categoria){
        return  guardarropa.getPrendas().stream()
                .filter(prenda -> prenda.seUtilizaEnUnAtuendo == false)
                .filter(prenda -> prenda.getTipoDePrenda().suNivelDeCapaEs(capa))
                .filter(prenda -> prenda.getCategoria().ordinal() == categoria)
                .collect(Collectors.toList());}

//Armo lista de ropa segun categoria y la capa 1 para armar el atuendo

    private List<Prenda> ListaDePrendasParteSuperiorCapa1(Guardarropa guardarropa) {return
            this.listaDePrendasDeCapaYcategoria(guardarropa,1,0);}
    private List<Prenda> ListaDePrendasParteInferiorCapa1(Guardarropa guardarropa){return
            this.listaDePrendasDeCapaYcategoria(guardarropa,1,1);}

    private List<Prenda> ListaDePrendasCalzadoCapa1(Guardarropa guardarropa){return
            this.listaDePrendasDeCapaYcategoria(guardarropa,1,2);}

    private List<Prenda> ListaDePrendasAccesorioCapa1(Guardarropa guardarropa)
    {return this.listaDePrendasDeCapaYcategoria(guardarropa,1,3);}

   private List<Prenda> AccesoriosParteCuerpo(Guardarropa guardarropa,Usuario usuario) {
  // private void AccesoriosParteCuerpo(Guardarropa guardarropa,Usuario usuario) {
       List<Prenda> listaAccesorios = this.ListaDePrendasAccesorioCapa1(guardarropa);
       System.out.println("Prueba metodo:  Parte a cubrir: " + usuario.parteSensible());
       System.out.println("Prueba metodo:  Mis accesorios cubren: " + listaAccesorios.stream().map(prenda -> prenda.getTipoDePrenda().getParteDelCuerpo()).collect(Collectors.toList()));

        if(!usuario.parteSensible().equals(TipoPrenda.parteDelCuerpoQueAbriga.Ninguna)){
        List<Prenda> listaAccesoriosParteCuerpo = listaAccesorios.stream().filter(prenda -> prenda.getTipoDePrenda().getParteDelCuerpo().equals(usuario.parteSensible())).collect(Collectors.toList());
        System.out.println("Prueba metodo:  Parte a cubrir: " + usuario.parteSensible() + ", Accesorio cubre " + listaAccesoriosParteCuerpo.stream().map(prenda -> "Es un " + prenda.getDescripcion()+ " que cubre " + prenda.getTipoDePrenda().getParteDelCuerpo()).collect(Collectors.toList()));
        return listaAccesoriosParteCuerpo;
        }
        return listaAccesorios;
    }


    public Atuendo generarAtuendoGR(Guardarropa guardarropa,Usuario usuario){
        //Calculo de randoms segun elementos totales
        // Antes de calcular los randoms, tengo que elegir mi accesorio para mi parte del cuerpo sensible

        int randomPSuperior = (int)(Math.random()*(this.ListaDePrendasParteSuperiorCapa1(guardarropa).size()));
        int randomPInferior = (int)(Math.random()*(this.ListaDePrendasParteInferiorCapa1(guardarropa).size()));
        int randomCalzado = (int)(Math.random()*(this.ListaDePrendasCalzadoCapa1(guardarropa).size()));
        //int randomAccesorio = (int)(Math.random()*(this.ListaDePrendasAccesorioCapa1(guardarropa).size()));
        int randomAccesorio = (int)(Math.random()*(this.AccesoriosParteCuerpo(guardarropa,usuario).size()));


        //Agarro un elemento de cada lista
        Prenda superior = this.ListaDePrendasParteSuperiorCapa1(guardarropa).get(randomPSuperior);
        Prenda inferior = this.ListaDePrendasParteInferiorCapa1(guardarropa).get(randomPInferior);
        Prenda calzado = this.ListaDePrendasCalzadoCapa1(guardarropa).get(randomCalzado);
        Prenda accesorio = this.AccesoriosParteCuerpo(guardarropa,usuario).get(randomAccesorio);

        List<Prenda> listaPrenda = new ArrayList<>();

        listaPrenda.add(superior);
        listaPrenda.add(inferior);
        listaPrenda.add(calzado);
        listaPrenda.add(accesorio);

        int nivelAbrigoPrimeraCapa = listaPrenda.stream().mapToInt(Prenda::suCapa).sum();
        int valorReferencia = this.numeroReferenciaParaCalculo-this.gradosQueHacenApi+usuario.nivelSensibilidad();

        if(valorReferencia>nivelAbrigoPrimeraCapa)
        // Ej hacen 5 grados => 30-5 = 25 nivel de abrigo objetivo, lleno ropa hasta que llegue a eso
        {
            //Lleno con ropa segunda capa
            List<Prenda> prendasCapaDosPSuperior = this.listaDePrendasDeCapaYcategoria(guardarropa,2,0);
            int random2PSuperior = (int)(Math.random()*(prendasCapaDosPSuperior.size()));
            Prenda superior2Capa = prendasCapaDosPSuperior.get(random2PSuperior);
            listaPrenda.add(superior2Capa);
            int nivelAbrigoPrimeraSuperposicion = listaPrenda.stream().mapToInt(Prenda::suCapa).sum();

            // Si al tener ya la primera superposicion sigue sin alcanzar, le agrego otra mas ej ( remera-sweater-campera)

            if(valorReferencia>nivelAbrigoPrimeraSuperposicion){
                List<Prenda> prendasCapaTresPSuperior = this.listaDePrendasDeCapaYcategoria(guardarropa,3,0);
                int random3PSuperior = (int)(Math.random()*(prendasCapaTresPSuperior.size()));
                Prenda superior3Capa = prendasCapaTresPSuperior.get(random3PSuperior);
                listaPrenda.add(superior3Capa);
            }

        }
        listaPrenda.stream().forEach(prenda -> prenda.seUtilizaEnUnAtuendo = true); // Con esto, otro usuario que quiera un atuendo no va a tener estas ropas
        return new Atuendo(listaPrenda);
}
// Ver si dejar este metodo
    public List<Atuendo> generarAtuendos(List<Guardarropa> guardarropas,Usuario usuario){
        List<Atuendo> atuendos = new ArrayList<Atuendo>();

        for (int i = 0; i < guardarropas.size(); i++) {
            atuendos.add(this.generarAtuendoGR(guardarropas.get(i),usuario));
        }

        return atuendos;
    }
}


// POR COMO ESTA AHORA EL CLIMA, SE GENERAN ATUENDOS CON PRENDAS DE DOS CAPAS