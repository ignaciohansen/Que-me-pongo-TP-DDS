package controllers;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

//importar modelos cuando se refactorizen las clases a carpeta modelo

import java.util.HashMap;
import java.util.Map;

public class HomeController {

	public static ModelAndView usuario(Request req, Response res) {
		Map<String, Object> view = new HashMap<>();

		return new ModelAndView(view, "usuario.hbs"); //completar viewname con template
	}

	//agregar modelandview que se necesiten acceder aca

}
