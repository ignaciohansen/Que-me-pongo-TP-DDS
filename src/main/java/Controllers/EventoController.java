package Controllers;

import Entities.Eventos.Evento;
import Entities.Exceptions.ListaRopaVacia;
import Entities.Exceptions.atuendoEnListaNegra;
import Entities.Generador.Generador;
import Entities.Ropas.Atuendo;
import Entities.Ropas.Guardarropa;
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

    EventoModel eventoModel = new EventoModel();
    UsuarioModel usuarioModel = new UsuarioModel();
    Generador generador = new Generador();
    Guardarropa guardarropaElegidoEnAtuendoCreado = new Guardarropa();
    // Evento EventoParaAsistir = new Evento();

    private RepositorioEvento repo;

    public EventoController(){
        this.repo = FactoryRepositorioEvento.get();
    }

    public ModelAndView mostrarTodos(Request request, Response response) {
    	LoginController.ensureUserIsLoggedIn(request, response);
        Map<String, Object> parametros = new HashMap<>();
        Usuario usuario = usuarioModel.buscarPorUsuario(request.session().attribute("currentUser"));
        List<Evento> eventos = usuario.getEventos().stream().filter(evento -> evento.getEliminado() == 0).collect(Collectors.toList());
        eventos.forEach(evento -> evento.actualizarSiElEventoEsHoy());
        usuarioModel.modificar(usuario);
        parametros.put("eventos", eventos );
        return new ModelAndView(parametros, "eventos.hbs");
    }

    public ModelAndView crear(Request request, Response response) {
    	LoginController.ensureUserIsLoggedIn(request, response);
        Map<String, Object> parametros = new HashMap<>();
        return new ModelAndView(parametros, "evento.hbs");
    }


    public ModelAndView guardar(Request request, Response response){
    	LoginController.ensureUserIsLoggedIn(request, response);

        LocalDate fecha = LocalDate.parse(request.queryParams("fecha"));
        String lugar = request.queryParams("lugar");
        int diaRepeticion = new Integer(request.queryParams("diasEnQueSeRepite"));

        Evento evento = new Evento(fecha,lugar,diaRepeticion);
        //evento = evento.crearEvento(fecha, lugar, diaRepeticion);
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



    /*
    Falta: Del boton asistir, te lleve de nuevo a la vista "atuendo", puede ser "atuendoevento" donde:
 <a type="button" class="btn-verde" style="float:right" href="/atuendoGenerado/{{id}}" class="btn-border-blue">Crear Atuendo</a>

    sea asistencia/{{id}


Vistas: Asistir te lleva a mostrarGuardarropasParaAsistencia, el volver te lleva a eventos y el crear te lleva a Asistencia, desp tenes el guardar y rechazar
 */


    public ModelAndView mostrarGuardarropasParaAsistencia(Request request, Response response){
        Map<String, Object> parametros = new HashMap<>();
        Usuario usuario = usuarioModel.buscarPorUsuario(request.session().attribute("currentUser"));
        Evento EventoParaAsistir = repo.buscar(new Integer(request.params("id")));
        parametros.put("guardarropas", usuario.getGuardarropas());
        parametros.put("evento", EventoParaAsistir);
        request.session().attribute("evento", EventoParaAsistir);

        return new ModelAndView(parametros, "atuendo.hbs");

        // Para reutilizar esta vista, hay que poner un if evento para el volver
    }

    public ModelAndView Asistencia(Request request, Response response) throws atuendoEnListaNegra, ListaRopaVacia {
        LoginController.ensureUserIsLoggedIn(request, response);

        Map<String, Object> parametros = new HashMap<>();
        Usuario usuario = usuarioModel.buscarPorUsuario(request.session().attribute("currentUser"));

        //Se agarra el guardarropa del menu de seleccion

        String idGuardarropa = String.valueOf(new Integer(request.params("id")));
        guardarropaElegidoEnAtuendoCreado = usuario.getGuardarropas().stream().filter(guardarropa -> idGuardarropa.equals(String.valueOf(guardarropa.getId()))).collect(Collectors.toList()).get(0);

        Atuendo atuendoCreado = new Atuendo();
        if(guardarropaElegidoEnAtuendoCreado != null){
            atuendoCreado = generador.generarAtuendoGR(guardarropaElegidoEnAtuendoCreado,usuario);
        }

        parametros.put("atuendo", atuendoCreado);
        parametros.put("guardarropa", idGuardarropa);
        parametros.put("guardarropaDescripcion", guardarropaElegidoEnAtuendoCreado.getDescripcion());
        request.session().attribute("atuendo", atuendoCreado);
        return new ModelAndView(parametros, "atuendoCreado.hbs");
    }

    public Response guardarAsistencia(Request request, Response response) throws atuendoEnListaNegra, ListaRopaVacia {
        LoginController.ensureUserIsLoggedIn(request, response);
        Usuario usuario = usuarioModel.buscarPorUsuario(request.session().attribute("currentUser"));
        Evento EventoParaAsistir = request.session().attribute("evento");
        EventoParaAsistir.Eliminar();
        usuario.asistirAEvento(EventoParaAsistir);

        Atuendo atuendo = request.session().attribute("atuendo");
        atuendo.setAceptado(true);
        usuario.getAtuendos().add(atuendo);

        eventoModel.modificar(EventoParaAsistir);
        usuarioModel.modificar(usuario);
        request.session().removeAttribute("atuendo");
        request.session().removeAttribute("evento");

        response.redirect("/eventos");
        return response;
    }

    public ModelAndView rechazar(Request request, Response response) throws ListaRopaVacia, atuendoEnListaNegra {
        LoginController.ensureUserIsLoggedIn(request, response);
        Map<String, Object> parametros = new HashMap<>();
        Usuario usuario = usuarioModel.buscarPorUsuario(request.session().attribute("currentUser"));

        // traigo el atuendo que rechace y lo agrego a la lista del usuario como rechazado
        Atuendo atuendo = request.session().attribute("atuendo");
        atuendo.setAceptado(false);
        usuario.getAtuendos().add(atuendo);

        usuarioModel.modificar(usuario);


        Atuendo atuendoCreado = new Atuendo();

        if(guardarropaElegidoEnAtuendoCreado != null){
            atuendoCreado = generador.generarAtuendoGR(guardarropaElegidoEnAtuendoCreado,usuario);
        }

        parametros.put("atuendo", atuendoCreado);
        parametros.put("guardarropaDescripcion", guardarropaElegidoEnAtuendoCreado.getDescripcion());
        request.session().attribute("atuendo", atuendoCreado);
        return new ModelAndView(parametros, "atuendoCreado.hbs");
    }
}








