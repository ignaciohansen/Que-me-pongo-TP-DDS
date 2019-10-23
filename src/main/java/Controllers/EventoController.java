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
import java.util.List;
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


    private void asignarAtributosA(Evento evento, Request request){
        if(request.queryParams("id") != null){
            int id = new Integer(request.queryParams("id"));
            evento.setId(id);
        }

        if(request.queryParams("lugar") != null){
            evento.setLugar(request.queryParams("lugar"));
        }

        if(request.queryParams("diasEnQueSeRepite") != null){
            int dias = new Integer(request.queryParams("diasEnQueSeRepite"));
            evento.setDiasEnQueSeRepite(dias);
        }
/*
        if(request.queryParams("fecha") != null && !request.queryParams("fecha").isEmpty()){
            LocalDate fecha = LocalDate.parse(request.queryParams("fecha"));
            evento.setFecha(fecha); //problema con la fecha en formato LocalDate en calendar de entities.eventos.evento
        }*/
        }

    public ModelAndView crear(Request request, Response response){
        Evento evento = new Evento();
        asignarAtributosA(evento, request);
        this.repo.agregar(evento);
        response.redirect("/evento");
        return new ModelAndView(evento, "evento.hbs");
    }






}



