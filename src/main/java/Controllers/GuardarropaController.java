package Controllers;

import Entities.Exceptions.SuperoLimiteDeGuardarropas;
import Entities.Ropas.Guardarropa;
import Entities.Usuario.Usuario;
import Models.GuardarropaModel;
import Models.UsuarioModel;
import Repositories.RepositorioGuardarropa;
import Repositories.factories.FactoryRepositorioGuardarropa;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GuardarropaController {

    private Guardarropa guardarropa = new Guardarropa();
    private GuardarropaModel guardarropaModel = new GuardarropaModel();

    private RepositorioGuardarropa repo;

    public GuardarropaController() {
        this.repo = FactoryRepositorioGuardarropa.get();
    }

    public ModelAndView mostrarTodos(Request request, Response response) {
    	LoginController.ensureUserIsLoggedIn(request, response);
        Map<String, Object> parametros = new HashMap<>();
        UsuarioModel model = new UsuarioModel();
        Usuario usuario = model.buscarPorUsuario(request.session().attribute("currentUser"));
        List<Guardarropa> guardarropas = usuario.getGuardarropas().stream().filter(guardarropa -> guardarropa.getEliminado() == 0).collect(Collectors.toList());
        parametros.put("guardarropas", guardarropas);
        return new ModelAndView(parametros, "guardarropas.hbs");
}

    public ModelAndView crear(Request request, Response response) {
    	LoginController.ensureUserIsLoggedIn(request, response);
        Map<String, Object> parametros = new HashMap<>();
       // UsuarioModel model = new UsuarioModel();
      //  Usuario usuario = model.buscarPorUsuario(request.session().attribute("currentUser"));
        return new ModelAndView(parametros, "guardarropa.hbs");
    }

    public Response guardar(Request request, Response response) throws SuperoLimiteDeGuardarropas {
    	LoginController.ensureUserIsLoggedIn(request, response);
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


    public ModelAndView mostrarEliminar(Request request, Response response) {
        LoginController.ensureUserIsLoggedIn(request, response);
        Map<String, Object> parametros = new HashMap<>();
        return new ModelAndView(parametros, "eliminarGuardarropa.hbs");
    }

    public Response Eliminar(Request request, Response response) {
        LoginController.ensureUserIsLoggedIn(request, response);
        Map<String, Object> parametros = new HashMap<>();
        Guardarropa guardarropaAEliminar = repo.buscar(new Integer(request.params("id")));
       guardarropaAEliminar.Eliminar();
       guardarropaModel.modificar(guardarropaAEliminar);
        response.redirect("/guardarropas");
        return  response;
    }
}
