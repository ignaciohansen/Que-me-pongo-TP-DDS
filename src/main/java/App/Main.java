package App;

import Server.*;
import spark.Spark;
import spark.debug.DebugScreen;

public class Main {
    public static void main(String[] args) throws Exception {
        Spark.port(getHerokuAssignedPort());
       // Spark.port(9000);
        Router.init();
        DebugScreen.enableDebugScreen();
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}

