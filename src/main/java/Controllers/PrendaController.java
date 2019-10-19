package Controllers;

import Entities.Ropas.Prenda;
import Entities.Telas.*;
import Entities.TipoPrenda.*;
import Repositories.RepositorioPrenda;
import Repositories.factories.FactoryRepositorioPrenda;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.*;

public class PrendaController {


    Prenda pantufla = new Prenda(Prenda.Color.Negro, Prenda.Color.Blanco, new Pantufla() , Prenda.CategoriaPrenda.Calzado,new Cuero(),"pantufla");
    Prenda remera = new Prenda(Prenda.Color.Negro, Prenda.Color.Rojo, new Remera(), Prenda.CategoriaPrenda.ParteSuperior,new Algodon(),"remera");
    Prenda gorro = new Prenda(Prenda.Color.Blanco, Prenda.Color.Marron, new Gorro() , Prenda.CategoriaPrenda.Accesorio,new Algodon(),"gorro");

    private RepositorioPrenda repo;

    public PrendaController() throws Exception {
        this.repo = FactoryRepositorioPrenda.get();
    }

    public ModelAndView mostrarTodos(Request request, Response response) {
        Map<String, Object> parametros = new HashMap<>();
        //List<Evento> eventos = this.repo.buscarTodos();
        List<Prenda> prendas = new ArrayList<Prenda>();
        pantufla.setId(1);
        remera.setId(2);
        gorro.setId(3);
        prendas.add(pantufla);
        prendas.add(remera);
        prendas.add(gorro);
        parametros.put("prendas", prendas);
        return new ModelAndView(parametros, "prendas.hbs");
    }
}
