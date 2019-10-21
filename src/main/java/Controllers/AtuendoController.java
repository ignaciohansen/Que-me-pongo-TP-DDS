package Controllers;

import  Entities.Ropas.Atuendo;
//import Repositories.RepositorioAtuendo;
//import Repositories.factories.FactoryRepositorioAtuendo;
import Entities.Ropas.Prenda;
import Entities.Telas.Algodon;
import Entities.TipoPrenda.Remera;
import Entities.TipoPrenda.Sweater;
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

}

