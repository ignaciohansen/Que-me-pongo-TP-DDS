package Controllers;

import Entities.Ropas.Guardarropa;
import Entities.Ropas.Prenda;
import Entities.Telas.*;
import Entities.TipoPrenda.*;
import Models.PrendaModel;
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

    public ModelAndView crearPrenda(Request request, Response response){
        Map<String, Object> parametros = new HashMap<>();
        /*List<TipoPrenda> tipos = new ArrayList<TipoPrenda>();
        Remera remera = new Remera();
        remera.setId(1);
        Pantalon pantalon = new Pantalon();
        pantalon.setId(2);
        tipos.add(remera);
        tipos.add(pantalon);
        parametros.put("tipos", tipos);
        Guardarropa g1 = new Guardarropa();
        Guardarropa g2 = new Guardarropa();
        g1.setDescripcion("g1");
        g1.setId(1);
        g2.setDescripcion("g2");
        g2.setId(2);
        List<Guardarropa> guardarropas = new ArrayList<Guardarropa>();
        guardarropas.add(g1);
        guardarropas.add(g2);
        parametros.put("guardarropas", guardarropas);*/
        PrendaModel model = new PrendaModel();


        return new ModelAndView(parametros, "prenda.hbs");
    }

    public Response guardar(Request request, Response response){
        Prenda prenda = new Prenda();
        if(request.queryParams("tipoDePrenda") != null){
            Remera tipo = new Remera();
            prenda.setTipoDePrenda(tipo);
            System.out.println("Paso por el guardar" + tipo.getSuTipo());
        }
        response.redirect("/guardarropas");
        return response;
    }
}
