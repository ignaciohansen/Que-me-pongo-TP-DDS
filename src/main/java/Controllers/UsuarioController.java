package Controllers;

import Entities.Usuario.Usuario;
import Entities.Usuario.UsuarioGratuito;
import Entities.Usuario.UsuarioPremium;
import Models.UsuarioModel;
import Repositories.RepositorioUsuario;
import Repositories.factories.FactoryRepositorioUsuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsuarioController {

    private RepositorioUsuario repo;
    UsuarioModel model = new UsuarioModel();

    public UsuarioController(){
        this.repo = FactoryRepositorioUsuario.get();
    }

    public ModelAndView mostrarTodos(Request request, Response response) {
        Map<String, Object> parametros = new HashMap<>();
        List<Usuario> usuarios = this.repo.buscarTodos();
        parametros.put("usuarios", usuarios);
        return new ModelAndView(parametros, "usuarios.hbs");
    }

    public ModelAndView mostrarInfo(Request request, Response response) {
        Map<String, Object> parametros = new HashMap<>();
        Usuario usuario = model.buscarPorUsuario(request.session().attribute("currentUser"));
        parametros.put("usuario", usuario);
        return new ModelAndView(parametros, "informacion.hbs");
    }

}

/*
    public ModelAndView mostrar(Request request, Response response){
        Usuario usuario = this.repo.buscar(new Integer(request.params("id")));
        RepositorioRol repoRol = FactoryRepositorioRol.get();
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("usuario", usuario);
        parametros.put("roles", repoRol.buscarTodos());
        return new ModelAndView(parametros, "usuario.hbs");
    }

    public Response modificar(Request request, Response response){
        Usuario usuario = this.repo.buscar(new Integer(request.params("id")));
        asignarAtributosA(usuario, request);
        this.repo.modificar(usuario);
        response.redirect("/usuarios");
        return response;
    }


*/