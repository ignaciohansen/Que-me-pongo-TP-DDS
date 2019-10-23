package Controllers;

import Entities.Generador.Generador;
import  Entities.Ropas.Atuendo;
//import Repositories.RepositorioAtuendo;
//import Repositories.factories.FactoryRepositorioAtuendo;
import Entities.Ropas.Guardarropa;
import Entities.Ropas.Prenda;
import Entities.Telas.Algodon;
import Entities.TipoPrenda.Remera;
import Entities.TipoPrenda.Sweater;
import Repositories.RepositorioGuardarropa;
import Repositories.factories.FactoryRepositorioGuardarropa;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AtuendoController {

Atuendo atuendoPrueba = new Atuendo();
Prenda remera = new Prenda(Prenda.Color.Negro, Prenda.Color.Rojo, new Remera(), Prenda.CategoriaPrenda.ParteSuperior,new Algodon(),"remera");
Prenda sweater = new Prenda(Prenda.Color.Negro, Prenda.Color.Rojo, new Sweater(), Prenda.CategoriaPrenda.ParteSuperior,new Algodon(),"sweater");
Generador generador = new Generador();


List<Prenda> prendas = new ArrayList<Prenda>();

public AtuendoController() throws Exception {}

    public ModelAndView mostrarTodos(Request request, Response response) {
        Map<String, Object> parametros = new HashMap<>();
        //List<Evento> eventos = this.repo.buscarTodos();
        List<Atuendo> atuendos = new ArrayList<Atuendo>();
        prendas.add(remera);
        prendas.add(sweater);
        atuendoPrueba.setPrendas(prendas);
        atuendos.add(atuendoPrueba);
        System.out.println(atuendoPrueba);
        parametros.put("atuendos", atuendos);
        return new ModelAndView(parametros, "atuendos.hbs");
    }


    public ModelAndView crear(Request request, Response response){
        Map<String, Object> parametros = new HashMap<>();

        //RepositorioGuardarropa repositorioGuardarropa = FactoryRepositorioGuardarropa.get();
        //parametros.put("guardarropas", repositorioGuardarropa.buscarTodos());  // ver como buscar todos
        Guardarropa g1 = new Guardarropa();
        Guardarropa g2 = new Guardarropa();
        g1.setDescripcion("g1");
        g1.setId(1);
        g2.setDescripcion("g2");
        g2.setId(2);
        List<Guardarropa> guardarropas = new ArrayList<Guardarropa>();
        guardarropas.add(g1);
        guardarropas.add(g2);
        parametros.put("guardarropas", guardarropas);
        return new ModelAndView(parametros, "atuendo.hbs");
    }
/*
    public Response guardar(Request request, Response response){
     if(request.queryParams("guardarropa") != null){
           generador.generarAtuendoGR(request.queryParams("guardarropa"),);
        }
        this.repo.agregar(atuendo);
        response.redirect("/atuendos");
        return response;
    }
  */
    }