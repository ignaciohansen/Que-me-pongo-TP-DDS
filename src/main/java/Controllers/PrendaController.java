package Controllers;

import Entities.Exceptions.En2Guardarropas;
import Entities.Exceptions.TelaIncompatible;
import Entities.Ropas.Guardarropa;
import Entities.Ropas.Prenda;
import Entities.Telas.*;
import Entities.TipoPrenda.*;
import Models.GuardarropaModel;
import Models.PrendaModel;
import Models.TelaModel;
import Models.TipoPrendaModel;
import Repositories.*;
import Repositories.factories.*;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrendaController {

    Prenda prendaAcrear;
    Guardarropa guardarropa;
    TipoPrenda tipoPrendaElegido;
    TipoPrendaModel tipoPrendaModel = new TipoPrendaModel();
    TelaModel telaModel = new TelaModel();
    PrendaModel prendaModel = new PrendaModel();
    GuardarropaModel guardarropaModel = new GuardarropaModel();

    RepositorioTipoPrenda repositorioTipoPrenda = FactoryRepositorioTipoPrenda.get();
    RepositorioGuardarropa repositorioGuardarropa = FactoryRepositorioGuardarropa.get();
    RepositorioTela repositorioTela = FactoryRepositorioTela.get();

    private RepositorioPrenda repositorioPrenda;

    private Prenda.CategoriaPrenda obtenerCategoria(String descripcionTipoPrenda){
        if(descripcionTipoPrenda.equals("zapatilla") || descripcionTipoPrenda.equals("pantufla")){
            return Prenda.CategoriaPrenda.Calzado;
        }
        else if(descripcionTipoPrenda.equals("gorro") || descripcionTipoPrenda.equals("reloj") || descripcionTipoPrenda.equals("pulsera")){
            return Prenda.CategoriaPrenda.Accesorio;
        }
        else if(descripcionTipoPrenda.equals("joggin") || descripcionTipoPrenda.equals("pantalon")){
            return Prenda.CategoriaPrenda.ParteInferior;
        }
        else{
            return Prenda.CategoriaPrenda.ParteSuperior;
        }
    }

    public PrendaController() throws Exception {
        this.repositorioPrenda = FactoryRepositorioPrenda.get();
    }

    public ModelAndView mostrarTodos(Request request, Response response) {
    	LoginController.ensureUserIsLoggedIn(request, response);
        Map<String, Object> parametros = new HashMap<>();
        guardarropa = repositorioGuardarropa.buscar(new Integer(request.params("id")));
        Set<Prenda> prendas = guardarropa.getPrendas().stream().filter(prenda -> prenda.getEstaEnGuardarropa() && prenda.getEliminado() == 0).collect(Collectors.toSet());
        parametros.put("prendas",prendas);
        return new ModelAndView(parametros, "prendas.hbs");
    }

    public ModelAndView crearPrimeraPartePrenda(Request request, Response response){

        String guardarropaId = request.session().attribute("guardarropaId");
    	LoginController.ensureUserIsLoggedIn(request, response);
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("tipos", repositorioTipoPrenda.buscarTodos());
        parametros.put("guardarropaId", guardarropaId);
        return new ModelAndView(parametros, "prenda1.hbs");
    }

    public ModelAndView crearSegundaPartePrenda(Request request, Response response){
    	LoginController.ensureUserIsLoggedIn(request, response);
        Map<String, Object> parametros = new HashMap<>();
        List<Tela> telasrepo = repositorioTela.buscarTodos();
        List<Tela> telas = telasrepo.stream().filter(unaTela -> !unaTela.getPrendasIncompatibles().contains(prendaAcrear.getTipoDePrenda().getSuTipo())).collect(Collectors.toList());
        parametros.put("telas",telas);
        return new ModelAndView(parametros, "prenda2.hbs");
    }

    public Response guardarPrimeraParte(Request request, Response response){
    	LoginController.ensureUserIsLoggedIn(request, response);
        prendaAcrear = new Prenda();
        tipoPrendaElegido = repositorioTipoPrenda.buscar(new Integer(request.queryParams("suTipo")));
        prendaAcrear.setColorPrimario(Prenda.Color.valueOf(request.queryParams("colores")));
        prendaAcrear.setTipoDePrenda(tipoPrendaElegido);
        prendaAcrear.setDescripcion(tipoPrendaElegido.getSuTipo());
        prendaAcrear.setCategoria(this.obtenerCategoria(tipoPrendaElegido.getSuTipo()));
        response.redirect("/SegundoPasoCrearPrenda");
        return response;
    }

    @Transactional
    public Response guardarSegundaParte(Request request, Response response) throws Exception {

        if(!prendaAcrear.getColorPrimario().equals(Prenda.Color.valueOf(request.queryParams("colores")))) {prendaAcrear.setColorSecundario(Prenda.Color.valueOf(request.queryParams("colores"))); }
        else{
            response.redirect("/crearPrenda");
        }       // Te lleva a la primera parte de crear prenda, Deberia mostrar un error de porque

        Tela tela = repositorioTela.buscar(new Integer(request.queryParams("descripcion")));
        prendaAcrear.setTela(tela);
        guardarropa.agregarPrenda(prendaAcrear);
        guardarropaModel.modificar(guardarropa);
        response.redirect("/prendas/" + request.session().attribute("guardarropaId"));

        return response;
    }

    public ModelAndView mostrarEliminar(Request request, Response response) {
        LoginController.ensureUserIsLoggedIn(request, response);
        Map<String, Object> parametros = new HashMap<>();
        return new ModelAndView(parametros, "eliminarPrenda.hbs");
    }

    public Response Eliminar(Request request, Response response) {
        LoginController.ensureUserIsLoggedIn(request, response);
        Map<String, Object> parametros = new HashMap<>();
        Prenda prenda = repositorioPrenda.buscar(new Integer(request.params("id")));
        prenda.Eliminar();
        prendaModel.modificar(prenda);
        response.redirect("/home");
        //response.redirect("/prendas/:id");
        return  response;
    }
}
