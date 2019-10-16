package server;

import controllers.HomeController;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.utils.BooleanHelper;
import spark.utils.HandlebarsTemplateEngineBuilder;

public class Router {
    private static HandlebarsTemplateEngine engine;

    private static void initEngine() {
        Router.engine = HandlebarsTemplateEngineBuilder
                .create()
                .withDefaultHelpers()
                .withHelper("isTrue", BooleanHelper.isTrue)
                .build();
    }

    static void init() {
        Router.initEngine();
        Spark.staticFileLocation("/public");
        Router.configure();
    }

    private static void configure(){
        Spark.get("/",HomeController::usuario,engine);
        //completar homecontroller:: con el modelandview creado en clase homercontroller

    }
}
