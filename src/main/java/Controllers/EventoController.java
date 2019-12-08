package Controllers;

import Entities.Eventos.Evento;
import Entities.Usuario.Usuario;
import Models.EventoModel;
import Models.UsuarioModel;
import Repositories.RepositorioEvento;
import Repositories.factories.FactoryRepositorioEvento;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EventoController {

    public Evento evento= new Evento();
    EventoModel eventoModel = new EventoModel();

    private RepositorioEvento repo;

    public EventoController(){
        this.repo = FactoryRepositorioEvento.get();
    }

    public ModelAndView mostrarTodos(Request request, Response response) {
    	LoginController.ensureUserIsLoggedIn(request, response);
        Map<String, Object> parametros = new HashMap<>();
        UsuarioModel model = new UsuarioModel();
        Usuario usuario = model.buscarPorUsuario(request.session().attribute("currentUser"));
        List<Evento> eventos = usuario.getEventos().stream().filter(evento -> evento.getEliminado() == 0).collect(Collectors.toList());
        parametros.put("eventos", eventos );
        return new ModelAndView(parametros, "eventos.hbs");
    }

    public ModelAndView crear(Request request, Response response) {
    	LoginController.ensureUserIsLoggedIn(request, response);
        Map<String, Object> parametros = new HashMap<>();
        UsuarioModel model = new UsuarioModel();
        Usuario usuario = model.buscarPorUsuario(request.session().attribute("currentUser"));
        List<Evento> eventos = usuario.getEventos().stream().filter(evento -> evento.getEliminado() == 0).collect(Collectors.toList());
        parametros.put("eventos", eventos );
        return new ModelAndView(parametros, "evento.hbs");
    }


    public ModelAndView guardar(Request request, Response response){
    	LoginController.ensureUserIsLoggedIn(request, response);

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

    public ModelAndView mostrarEliminar(Request request, Response response) {
        LoginController.ensureUserIsLoggedIn(request, response);
        Map<String, Object> parametros = new HashMap<>();
        return new ModelAndView(parametros, "eliminarEvento.hbs");
    }

    public Response Eliminar(Request request, Response response) {
        LoginController.ensureUserIsLoggedIn(request, response);
        Map<String, Object> parametros = new HashMap<>();
        Evento evento = repo.buscar(new Integer(request.params("id")));
        evento.Eliminar();
        eventoModel.modificar(evento);
        response.redirect("/eventos");
        return  response;
    }
}








