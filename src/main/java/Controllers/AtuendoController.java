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
import Entities.Usuario.Usuario;
import Models.UsuarioModel;
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
    UsuarioModel model = new UsuarioModel();

    public AtuendoController() throws Exception {}

    public ModelAndView mostrarTodos(Request request, Response response) {
        Map<String, Object> parametros = new HashMap<>();

        Usuario usuario = model.buscarPorUsuario(request.session().attribute("currentUser"));


         /* PRUEBAS - OK con la base PRUEBAS
         List<Atuendo> atuendos = new ArrayList<Atuendo>();
         prendas.add(remera);
         prendas.add(sweater);
         atuendoPrueba.setPrendas(prendas);
         atuendos.add(atuendoPrueba);
         usuario.setAtuendosAceptados(atuendos);
*/


        parametros.put("atuendos", usuario.getAtuendosAceptados());
        return new ModelAndView(parametros, "atuendos.hbs");
    }


    public ModelAndView crear(Request request, Response response){
        Map<String, Object> parametros = new HashMap<>();
        Usuario usuario = model.buscarPorUsuario(request.session().attribute("currentUser"));
        parametros.put("guardarropas", usuario.getGuardarropas());
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