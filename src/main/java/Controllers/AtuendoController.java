package Controllers;

import Entities.Exceptions.ListaRopaVacia;
import Entities.Exceptions.atuendoEnListaNegra;
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
import Models.PrendaModel;
import Models.UsuarioModel;
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
    UsuarioModel usuarioModel = new UsuarioModel();
    PrendaModel prendaModel = new PrendaModel();

    public AtuendoController() throws Exception {}

    public ModelAndView mostrarTodos(Request request, Response response) {
        Map<String, Object> parametros = new HashMap<>();

        Usuario usuario = usuarioModel.buscarPorUsuario(request.session().attribute("currentUser"));
        parametros.put("atuendos", usuario.getAtuendosAceptados());
        return new ModelAndView(parametros, "atuendos.hbs");
    }


    public ModelAndView crear(Request request, Response response){
        Map<String, Object> parametros = new HashMap<>();
        Usuario usuario = usuarioModel.buscarPorUsuario(request.session().attribute("currentUser"));
        parametros.put("guardarropas", usuario.getGuardarropas());
        return new ModelAndView(parametros, "atuendo.hbs");
    }

    public Response guardar(Request request, Response response) throws atuendoEnListaNegra, ListaRopaVacia {

    Usuario usuario = usuarioModel.buscarPorUsuario(request.session().attribute("currentUser"));

    //Se agarra el guardarropa del menu de seleccion
    Guardarropa guardarropaElegido = usuario.getGuardarropas().get(new Integer(request.queryParams("descripcion")) -1);

    if(guardarropaElegido != null){
          generador.generarAtuendoGR(guardarropaElegido,usuario);
        }
        //quizas falta agregar
        // Falla en  " field listanegraatuendos_atuendo_id' doesn't have a default value "
        usuarioModel.modificar(usuario);
        response.redirect("/atuendos");
        return response;
    }

}