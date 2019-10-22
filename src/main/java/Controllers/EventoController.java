package Controllers;

import Entities.Eventos.Evento;
import Entities.Usuario.Usuario;
import Models.UsuarioModel;
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
        /*            REVISAR

        if(request.queryParams("fecha") != null && !request.queryParams("fecha").isEmpty()){
            Date fecha = Date.parse(request.queryParams("fecha"));
            evento.setFecha(fecha);
        }
*/
    }

}



