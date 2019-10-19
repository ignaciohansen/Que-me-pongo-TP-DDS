package Controllers;

import Entities.Ropas.Guardarropa;
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
        List<Guardarropa> guardarropas = new ArrayList<Guardarropa>();
        guardarropa.setId(1);
        guardarropa.setDescripcion("Hay de todo aca papa");
        guardarropas.add(guardarropa);
        parametros.put("guardarropas", guardarropas);
        return new ModelAndView(parametros, "guardarropas.hbs");
    }
}
