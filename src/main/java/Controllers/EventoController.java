package Controllers;

import Entities.Eventos.Evento;
import Repositories.RepositorioEvento;
import Repositories.factories.FactoryRepositorioEvento;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.*;


public class EventoController {

    public Evento eventoDiaDeHoy = new Evento(new Date(),"CABA",1);


    private RepositorioEvento repo;

    public EventoController(){
        this.repo = FactoryRepositorioEvento.get();
    }

    public ModelAndView mostrarTodos(Request request, Response response) {
        Map<String, Object> parametros = new HashMap<>();
        //List<Evento> eventos = this.repo.buscarTodos();
        List<Evento> eventos = new ArrayList<Evento>();
        eventoDiaDeHoy.setId(1);
        eventos.add(eventoDiaDeHoy);
        parametros.put("eventos", eventos);
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
            Date fecha = Date.parse(request.queryParams("fecha"));
            evento.setFecha(fecha);
        }
*/
    }

}



