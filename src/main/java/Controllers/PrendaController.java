package Controllers;

import Entities.Ropas.Guardarropa;
import Entities.Ropas.Prenda;
import Entities.Telas.*;
import Entities.TipoPrenda.*;
import Repositories.RepositorioGuardarropa;
import Repositories.RepositorioPrenda;
import Repositories.factories.FactoryRepositorioGuardarropa;
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
        RepositorioGuardarropa repo = FactoryRepositorioGuardarropa.get();
        Guardarropa guardarropa = repo.buscar(new Integer(request.params("id")));
        parametros.put("prendas", guardarropa.getPrendas());
        return new ModelAndView(parametros, "prendas.hbs");
    }
}
