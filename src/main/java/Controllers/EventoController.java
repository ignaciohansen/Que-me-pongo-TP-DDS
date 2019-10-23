package Controllers;

import Entities.Eventos.Evento;
import Entities.Usuario.Usuario;
import Models.UsuarioModel;
import Repositories.RepositorioEvento;
import Repositories.factories.FactoryRepositorioEvento;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


public class EventoController {

    public Evento evento= new Evento();


    private RepositorioEvento repo;

    public EventoController(){
        this.repo = FactoryRepositorioEvento.get();
    }

    public ModelAndView mostrarTodos(Request request, Response response) {
        Map<String, Object> parametros = new HashMap<>();
        UsuarioModel model = new UsuarioModel();
        Usuario usuario = model.buscarPorUsuario(request.session().attribute("currentUser"));
        parametros.put("eventos", usuario.getEventos());
        return new ModelAndView(parametros, "eventos.hbs");
    }

    public ModelAndView crear(Request request, Response response) {
        Map<String, Object> parametros = new HashMap<>();
        UsuarioModel model = new UsuarioModel();
        Usuario usuario = model.buscarPorUsuario(request.session().attribute("currentUser"));
        parametros.put("eventos", usuario.getEventos());
        return new ModelAndView(parametros, "evento.hbs");
    }


    public ModelAndView guardar(Request request, Response response){


        LocalDate fecha = LocalDate.parse(request.queryParams("fecha"));
        String lugar = request.queryParams("lugar");
        int diaRepeticion = new Integer(request.queryParams("diasEnQueSeRepite"));

        Evento evento = new Evento();
        evento = evento.crearEvento(fecha, lugar, diaRepeticion);
        UsuarioModel model = new UsuarioModel();
        Usuario usuario = model.buscarPorUsuario(request.session().attribute("currentUser"));
        usuario.cargarEvento(evento);
        model.modificar(usuario);
        response.redirect("/eventos");
        return null;
    }


}








