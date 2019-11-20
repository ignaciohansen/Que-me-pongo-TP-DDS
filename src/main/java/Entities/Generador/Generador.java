package Entities.Generador;

import Api.Clima.Accuweather.ApiClimaAccuweather;
import Entities.Exceptions.ListaRopaVacia;
import Entities.Exceptions.atuendoEnListaNegra;
import Entities.Ropas.Atuendo;
import Entities.Ropas.Guardarropa;
import Entities.Ropas.Prenda;
import Entities.TipoPrenda.TipoPrenda;
import Entities.Usuario.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Generador {

    Boolean usuarioConforme = true;

    ApiClimaAccuweather api = new ApiClimaAccuweather();
    int grados = api.getTemperatura();

    private int gradosQueHacenApi = grados;
    private int numeroReferenciaParaCalculo = 30; // Podria ir en un archiv config
    
    public List<Atuendo> atuendosCreados = new ArrayList<Atuendo>();

    /*public void setGrados(int grados){
        this.gradosQueHacenApi = grados;
    }*/

    // Se toma una prenda random de una lista que esta filtrada segun categoria y de la capa1
    private List<Prenda> listaDePrendasDeCapaYcategoria(Guardarropa guardarropa,int capa,int categoria){
        return  guardarropa.getPrendas().stream()
                .filter(prenda -> prenda.getSeUtilizaEnUnAtuendo() == false)
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

       List<Prenda> listaAccesorios = this.ListaDePrendasAccesorioCapa1(guardarropa);

        if(!usuario.parteSensible().equals(TipoPrenda.parteDelCuerpoQueAbriga.Ninguna)){
        List<Prenda> listaAccesoriosParteCuerpo = listaAccesorios.stream().filter(prenda -> prenda.getTipoDePrenda().getParteDelCuerpo().equals(usuario.parteSensible())).collect(Collectors.toList());

       if(listaAccesoriosParteCuerpo.size()==0){
           usuarioConforme = false;
           return listaAccesorios; } // No encontre la prenda que le cubra su parte sensible

        System.out.println("Parte a cubrir: " + usuario.parteSensible() + ", Accesorio cubre " + listaAccesoriosParteCuerpo.stream().map(prenda -> "Es un " + prenda.getDescripcion()+ " que cubre " + prenda.getTipoDePrenda().getParteDelCuerpo()).collect(Collectors.toList()));
        return listaAccesoriosParteCuerpo;
        }
        return listaAccesorios;
    }

    private void verificarSiQuedanRopasExcepcion(List<Prenda> lista) throws ListaRopaVacia {
        if(lista.size() == 0)
           throw new ListaRopaVacia();
    }

    private Boolean verificarSiQuedanRopas(List<Prenda> lista){return lista.size() > 0;}

    private Prenda tomarUnaPrendaExcepcion(List<Prenda> lista) throws ListaRopaVacia {
        verificarSiQuedanRopasExcepcion(lista);
        int random = (int)(Math.random()*(lista.size()));
        return lista.get(random);
    }

    private Prenda tomarUnaPrenda(List<Prenda> lista) {
        int random = (int)(Math.random()*(lista.size()));
        return lista.get(random);
    }

    private void utilizarLasPrendas(List<Prenda> lista){
        lista.stream().forEach(prenda -> prenda.setSeUtilizaEnUnAtuendo(true)); // Con esto, otro usuario que quiera un atuendo no va a tener estas ropas

    }

    private List<Prenda> armarCapa1(Guardarropa guardarropa,Usuario usuario) throws ListaRopaVacia, atuendoEnListaNegra {
        System.out.println("Parte del cuerpo a cubrir: " + usuario.parteSensible());
        System.out.println("Mis accesorios cubren: " + this.ListaDePrendasAccesorioCapa1(guardarropa).stream().map(prenda -> prenda.getTipoDePrenda().getParteDelCuerpo()).collect(Collectors.toList()));

        Prenda superior = tomarUnaPrendaExcepcion(this.ListaDePrendasParteSuperiorCapa1(guardarropa));
        Prenda inferior = tomarUnaPrendaExcepcion(this.ListaDePrendasParteInferiorCapa1(guardarropa));
        Prenda calzado = tomarUnaPrendaExcepcion(this.ListaDePrendasCalzadoCapa1(guardarropa));
        Prenda accesorio = tomarUnaPrendaExcepcion(this.AccesoriosParteCuerpo(guardarropa,usuario));

        List<Prenda> listaPrenda = new ArrayList<>();

        listaPrenda.add(superior);
        listaPrenda.add(inferior);
        listaPrenda.add(calzado);
        listaPrenda.add(accesorio);
        return listaPrenda;
    }


    public Atuendo generarAtuendoGR(Guardarropa guardarropa,Usuario usuario) throws ListaRopaVacia, atuendoEnListaNegra {

        System.out.println("Temperatura actual: " + gradosQueHacenApi );

        List<Prenda> listaPrenda = armarCapa1(guardarropa,usuario);

        int nivelAbrigoPrimeraCapa = listaPrenda.stream().mapToInt(Prenda::suCapa).sum();
        int valorReferencia = this.numeroReferenciaParaCalculo-this.gradosQueHacenApi+usuario.nivelSensibilidad();

        if(valorReferencia>nivelAbrigoPrimeraCapa)
        // Ej hacen 5 grados => 30-5 = 25 nivel de abrigo objetivo, lleno ropa hasta que llegue a eso
        {
            //Lleno con ropa segunda capa
            List<Prenda> prendasCapaDosPSuperior = this.listaDePrendasDeCapaYcategoria(guardarropa,2,0);
            if(this.verificarSiQuedanRopas(prendasCapaDosPSuperior)) {

                Prenda superior2Capa = tomarUnaPrenda(prendasCapaDosPSuperior);
                listaPrenda.add(superior2Capa);
                int nivelAbrigoPrimeraSuperposicion = listaPrenda.stream().mapToInt(Prenda::suCapa).sum();

            // Si al tener ya la primera superposicion sigue sin alcanzar, le agrego otra mas ej ( remera-sweater-campera)
            if(valorReferencia>nivelAbrigoPrimeraSuperposicion) {

                List<Prenda> prendasCapaTresPSuperior = this.listaDePrendasDeCapaYcategoria(guardarropa, 3, 0);
                if (this.verificarSiQuedanRopas(prendasCapaTresPSuperior)) {

                    Prenda superior3Capa = tomarUnaPrenda(prendasCapaTresPSuperior);
                    listaPrenda.add(superior3Capa);
                }
            }else{usuarioConforme=false;}
            }
        }

//        utilizarLasPrendas(listaPrenda);

        Atuendo atuendoCreado = new Atuendo(listaPrenda);
        
        if(this.atuendosCreados.contains(atuendoCreado)) {
        	this.generarAtuendoGR(guardarropa, usuario);
        }

//Agregado de aceptar atuendo , se pone en la lista

        if(!usuarioConforme){
        	System.out.println("El atuendo no es aceptado por tipo de sensibilidad u otro factor (codigo)");
            usuario.agregarAListaNegra(atuendoCreado);
            this.generarAtuendoGR(guardarropa, usuario);
        }else{
        	// no aceptar atuendo hasta que no ponga que SI
//            usuario.aceptarUnAtuendo(atuendoCreado);
        }

        this.atuendosCreados.add(atuendoCreado);
        System.out.println(atuendoCreado);
        return atuendoCreado;
}

}

// POR COMO ESTA AHORA EL CLIMA, SE GENERAN ATUENDOS CON PRENDAS DE DOS CAPAS