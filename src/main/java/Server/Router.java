package Server;

import Controllers.*;
import db.EntityManagerHelper;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import Spark.utils.BooleanHelper;
import Spark.utils.HandlebarsTemplateEngineBuilder;

public class Router {
    private static HandlebarsTemplateEngine engine;

    private static void initEngine() {
        Router.engine = HandlebarsTemplateEngineBuilder
                .create()
                .withDefaultHelpers()
                .withHelper("isTrue", BooleanHelper.isTrue)
                .build();
    }

    public static void init() throws Exception {
        Router.initEngine();
        Spark.staticFileLocation("/public");
        Router.configure();
    }

    private static void configure() throws Exception {

        UsuarioController usuarioController = new UsuarioController();
        EventoController eventoController = new EventoController();
        PrendaController prendaController = new PrendaController();
        GuardarropaController guardarropaController = new GuardarropaController();
        LoginController loginController = new LoginController();
        HomeController homeController = new HomeController();
        AtuendoController atuendoController = new AtuendoController();


        Spark.get("/login", loginController::mostrarLogin, Router.engine);

        Spark.post("/login", loginController::login);

        Spark.get("/home",homeController::mostrarHome, Router.engine);

        Spark.get("/usuarios", usuarioController::mostrarTodos, Router.engine);

        Spark.get("/informacion", usuarioController::mostrarInfo, Router.engine);

        Spark.get("/eventos", eventoController::mostrarTodos, Router.engine);


        Spark.get("/evento", eventoController::crear, Router.engine);

        Spark.post("/evento", eventoController::guardar);

        Spark.get("/prendas/:id", prendaController::mostrarTodos, Router.engine);

        Spark.get("/guardarropas", guardarropaController::mostrarTodos, Router.engine);

        Spark.get("/guardarropa", guardarropaController::crear, Router.engine);  // creo que deberia ser un post o tener un metodo post tambien

        Spark.post("/guardarropa", guardarropaController::guardar);

        Spark.get("/atuendos", atuendoController::mostrarTodos, Router.engine);

        Spark.get("/atuendo", atuendoController::crear, Router.engine);
        
        Spark.get("/atuendoGenerado/:id", atuendoController::mostrarAtuendoGenerado, Router.engine);
        
        Spark.get("/rechazar/:id", atuendoController::rechazar, Router.engine);
        
        Spark.post("/atuendoGenerado/:id", atuendoController::aceptarAtuendo);
        
        Spark.post("/rechazar/:id", atuendoController::aceptarAtuendo);
        
        Spark.get("/crearPrenda", prendaController::crearPrimeraPartePrenda, Router.engine);

        Spark.post("/crearPrenda", prendaController::guardarPrimeraParte);

        Spark.get("/SegundoPasoCrearPrenda", prendaController::crearSegundaPartePrenda, Router.engine);

        Spark.post("/SegundoPasoCrearPrenda", prendaController::guardarSegundaParte);

        Spark.get("/calificar/:id", atuendoController::mostrarCalificacion, Router.engine);

        Spark.post("/calificar/:id", atuendoController::guardarCalificacion);

        Spark.after((req, res) -> {
            EntityManagerHelper.getEntityManager().close();
        });
    }
}
