package Controllers;

import Entities.Exceptions.SuperoLimiteDeGuardarropas;
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
        UsuarioModel model = new UsuarioModel();
        Usuario usuario = model.buscarPorUsuario(request.session().attribute("currentUser"));
        parametros.put("guardarropas", usuario.getGuardarropas());
        return new ModelAndView(parametros, "guardarropas.hbs");
}

    public ModelAndView crear(Request request, Response response) {
        Map<String, Object> parametros = new HashMap<>();
       // UsuarioModel model = new UsuarioModel();
      //  Usuario usuario = model.buscarPorUsuario(request.session().attribute("currentUser"));
        return new ModelAndView(parametros, "guardarropa.hbs");
    }

    public Response guardar(Request request, Response response) throws SuperoLimiteDeGuardarropas {
        UsuarioModel model = new UsuarioModel();
        Usuario usuario = model.buscarPorUsuario(request.session().attribute("currentUser"));
        Guardarropa guardarropa = new Guardarropa();
        asignarAtributosA(guardarropa, request);
        usuario.agregarUnGuardarropas(guardarropa);
        model.modificar(usuario);
        this.repo.agregar(guardarropa);
        response.redirect("/guardarropas");
        return response;
    }


    private void asignarAtributosA(Guardarropa guardarropa, Request request) {
        if (request.queryParams("descripcion") != null) {
            guardarropa.setDescripcion(request.queryParams("descripcion"));
        }
    }
}
