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
import java.util.stream.Collectors;

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

    public ModelAndView mostrarAtuendoGenerado(Request request, Response response) throws atuendoEnListaNegra, ListaRopaVacia {

    	Map<String, Object> parametros = new HashMap<>();
    	Usuario usuario = usuarioModel.buscarPorUsuario(request.session().attribute("currentUser"));

    	//Se agarra el guardarropa del menu de seleccion
    	
    	String idGuardarropa = String.valueOf(new Integer(request.params("id")));
    	Guardarropa guardarropaElegido = usuario.getGuardarropas().stream().filter(guardarropa -> idGuardarropa.equals(String.valueOf(guardarropa.getId()))).collect(Collectors.toList()).get(0);

    	Atuendo atuendoCreado = new Atuendo();
    	if(guardarropaElegido != null){
    		atuendoCreado = generador.generarAtuendoGR(guardarropaElegido,usuario);
    	}
    	
    	parametros.put("atuendo", atuendoCreado);
    	parametros.put("guardarropa", idGuardarropa);
    	request.session().attribute("atuendo", atuendoCreado);
    	return new ModelAndView(parametros, "atuendoCreado.hbs");
    }
    
    public ModelAndView rechazar(Request request, Response response) throws ListaRopaVacia, atuendoEnListaNegra {
    	Map<String, Object> parametros = new HashMap<>();
    	Usuario usuario = usuarioModel.buscarPorUsuario(request.session().attribute("currentUser"));
    	String idGuardarropa = String.valueOf(new Integer(request.params("id")));
    	
    	// traigo el atuendo que rechace y lo agrego a la lista del usuario como rechazado
    	Atuendo atuendo = request.session().attribute("atuendo");
    	atuendo.setAceptado(false);
    	usuario.getAtuendos().add(atuendo);
    	
    	usuarioModel.modificar(usuario);
    	
    	Guardarropa guardarropaElegido = usuario.getGuardarropas().stream().filter(guardarropa -> idGuardarropa.equals(String.valueOf(guardarropa.getId()))).collect(Collectors.toList()).get(0);
    	
    	Atuendo atuendoCreado = new Atuendo();
    	
    	if(guardarropaElegido != null){
    		atuendoCreado = generador.generarAtuendoGR(guardarropaElegido,usuario);
    	}
    	
    	parametros.put("atuendo", atuendoCreado);
    	parametros.put("guardarropa", idGuardarropa);
    	request.session().attribute("atuendo", atuendoCreado);
    	return new ModelAndView(parametros, "atuendoCreado.hbs");
    }
    
    public Response aceptarAtuendo(Request request, Response response) {
    	Usuario usuario = usuarioModel.buscarPorUsuario(request.session().attribute("currentUser"));
    	
    	
    	Atuendo atuendo = request.session().attribute("atuendo");
    	atuendo.setAceptado(true);
    	usuario.getAtuendos().add(atuendo);
    	
    	usuarioModel.modificar(usuario);
    	request.session().removeAttribute("atuendo");
    	
    	response.redirect("/atuendos");
    	return null;
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