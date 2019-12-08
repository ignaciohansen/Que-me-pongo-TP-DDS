package Controllers;

import Entities.Sensibilidad.*;
import Entities.TipoPrenda.TipoPrenda;
import Repositories.*;
import Repositories.factories.*;
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
	RepositorioSensibilidad repositorioSensibilidad  = FactoryRepositorioSensibilidad.get();
	RepositorioTipoUsuario repositorioTipoUsuario  = FactoryRepositorioTipoUsuario.get();

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
	
	public static void ensureUserIsLoggedIn(Request request, Response response) {
        if (request.session().attribute("currentUser") == null) {
            request.session().attribute("loginRedirect", request.pathInfo());
            response.redirect("/login");
        }
    }

	public ModelAndView crearUsuario(Request request, Response response) {
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("sensibilidades", repositorioSensibilidad.buscarTodos());
		parametros.put("tiposUsuario", repositorioTipoUsuario.buscarTodos());
		return new ModelAndView(parametros, "usuario.hbs");
	}

	public Response guardar(Request request, Response response) {

		UsuarioModel model = new UsuarioModel();
		Usuario usuario = new Usuario();
		this.asignarAtributosA(usuario,request);
		model.modificar(usuario);
		response.redirect("/login");
		return response;
	}

	private void asignarAtributosA(Usuario usuario, Request request) {
		if (request.queryParams("nombre") != null) {
			usuario.setNombre(request.queryParams("nombre"));
		}

		if (request.queryParams("username") != null) {
			usuario.setUser(request.queryParams("username"));
		}

		if (request.queryParams("password") != null) {
			usuario.setPassword(request.queryParams("password"));
		}

		if (request.queryParams("sensibiidad") != null) {
			tipoSensibilidad sensibilidad;
			System.out.println("Sensibilidad seleccionada" + request.queryParams("sensibildad"));
			switch (request.queryParams("sensibildad")) {
				case "Caluroso":
					 sensibilidad = new Caluroso(TipoPrenda.parteDelCuerpoQueAbriga.Ninguna);
					usuario.setSensibilidad(sensibilidad);
					break;
				case "Indiferente":
					 sensibilidad = new Indiferente(TipoPrenda.parteDelCuerpoQueAbriga.Ninguna);
					usuario.setSensibilidad(sensibilidad);
					break;
				case "Friolento":
					 sensibilidad = new Friolento(TipoPrenda.parteDelCuerpoQueAbriga.Ninguna);
					usuario.setSensibilidad(sensibilidad);
					break;
				case "FriolentoCabeza":
					 sensibilidad = new Friolento(TipoPrenda.parteDelCuerpoQueAbriga.Cabeza);
					usuario.setSensibilidad(sensibilidad);
					break;
				case "FriolentoManos":
					sensibilidad = new Friolento(TipoPrenda.parteDelCuerpoQueAbriga.Manos);
					usuario.setSensibilidad(sensibilidad);
					break;
			}
		}

		if (request.queryParams("email") != null) {
			usuario.setEmail(request.queryParams("email"));
		}

		if (request.queryParams("telefono") != null) {
			int telefono = new Integer(request.queryParams("telefono"));
			usuario.setTelefono(telefono); }
	}

}
