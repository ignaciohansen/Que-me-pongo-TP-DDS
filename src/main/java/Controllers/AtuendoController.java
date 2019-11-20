package Controllers;

import Entities.Exceptions.ListaRopaVacia;
import Entities.Exceptions.atuendoEnListaNegra;
import Entities.Generador.Generador;
import  Entities.Ropas.Atuendo;
import Models.AtuendoModel;
import Repositories.*;

import Entities.Ropas.Guardarropa;
import Entities.Ropas.Prenda;
import Entities.Telas.Algodon;
import Entities.TipoPrenda.Remera;
import Entities.TipoPrenda.Sweater;
import Entities.Usuario.Usuario;
import Models.PrendaModel;
import Models.UsuarioModel;
import Repositories.factories.FactoryRepositorioAtuendo;
import Repositories.factories.FactoryRepositorioTipoPrenda;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AtuendoController {

    // Pruebas hardcodeadas
    Atuendo atuendo1 = new Atuendo();
    Atuendo atuendo2 = new Atuendo();

    List<Atuendo> atuendos = new ArrayList<>();

    RepositorioAtuendo repositorioAtuendo = FactoryRepositorioAtuendo.get();
    Prenda remera = new Prenda(Prenda.Color.Negro, Prenda.Color.Rojo, new Remera(), Prenda.CategoriaPrenda.ParteSuperior,new Algodon(),"remera");
    Prenda sweater = new Prenda(Prenda.Color.Negro, Prenda.Color.Rojo, new Sweater(), Prenda.CategoriaPrenda.ParteSuperior,new Algodon(),"sweater");
    Generador generador = new Generador();
    List<Prenda> prendas = new ArrayList<Prenda>();
    UsuarioModel usuarioModel = new UsuarioModel();
    PrendaModel prendaModel = new PrendaModel();


    public AtuendoController() throws Exception {
        atuendo1.setId(1);
        atuendo2.setId(2);
        atuendo1.setCalificacion(4);
        atuendos.add(atuendo1);
        atuendos.add(atuendo2);
    }

    public ModelAndView mostrarTodos(Request request, Response response) {
        Map<String, Object> parametros = new HashMap<>();
        Usuario usuario = usuarioModel.buscarPorUsuario(request.session().attribute("currentUser"));
        //parametros.put("atuendos", usuario.getAtuendosAceptados());
        parametros.put("atuendos", atuendos);
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


    public ModelAndView mostrarCalificacion(Request request, Response response) {
        Map<String, Object> parametros = new HashMap<>();
        return new ModelAndView(parametros, "calificar.hbs");
    }

    public Response guardarCalificacion(Request request, Response response){
        //atuendoPrueba = repositorioAtuendo.buscar(new Integer(request.params("id")));
        atuendo2.setCalificacion(new Integer(request.queryParams("calificacion")));
        response.redirect("/atuendos");
        return response;
    }


}