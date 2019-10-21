package Controllers;

import Repositories.factories.FactoryRepositorioUsuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

import Entities.Usuario.Usuario;
import Models.UsuarioModel;
import Repositories.RepositorioUsuario;

public class LoginController {
	private RepositorioUsuario repo;

	public LoginController(){
		this.repo = FactoryRepositorioUsuario.get();
	}
	
	public ModelAndView mostrarLogin(Request request, Response response) {
		Map<String, Object> parametros = new HashMap<>();
		request.session().removeAttribute("currentUser");
        
        return new ModelAndView(parametros, "login.hbs");
    }
	
	public Response login(Request request, Response response) {
		Map<String, Object> parametros = new HashMap<>();
		
		if(authenticate(request.queryParams("username"),request.queryParams("password"))) {
			request.session().attribute("currentUser", request.queryParams("username"));
			response.redirect("/home");
		}
		
		return response;
	}
	
	public boolean authenticate(String user, String password) {
		
		UsuarioModel model = new UsuarioModel();
		
		try {
			Usuario usuario = model.buscarPorUsuario(user);
			System.out.println(usuario.getNombre());
			System.out.println(usuario.getPassword());
			if(usuario == null) {
				return false;
			}
			else {
				return usuario.getPassword().equals(password);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
