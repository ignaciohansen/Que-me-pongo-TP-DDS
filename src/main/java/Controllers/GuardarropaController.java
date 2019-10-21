package Controllers;

import Entities.Ropas.Guardarropa;
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

public class GuardarropaController {

    private Guardarropa guardarropa = new Guardarropa();

    private RepositorioGuardarropa repo;

    public GuardarropaController() {
        this.repo = FactoryRepositorioGuardarropa.get();
    }

    public ModelAndView mostrarTodos(Request request, Response response) {
        Map<String, Object> parametros = new HashMap<>();
        //List<Evento> eventos = this.repo.buscarTodos();
        UsuarioModel model = new UsuarioModel();
        Usuario usuario = model.buscarPorUsuario(request.session().attribute("currentUser"));
        parametros.put("guardarropas", usuario.getGuardarropas());
        return new ModelAndView(parametros, "guardarropas.hbs");
    }
}
