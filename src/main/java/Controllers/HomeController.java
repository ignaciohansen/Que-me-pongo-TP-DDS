package Controllers;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class HomeController {

	public ModelAndView mostrarHome(Request request, Response response) {
		LoginController.ensureUserIsLoggedIn(request, response);
		Map<String, Object> parametros = new HashMap<>();
		return new ModelAndView(parametros, "home.hbs");
	}
}
