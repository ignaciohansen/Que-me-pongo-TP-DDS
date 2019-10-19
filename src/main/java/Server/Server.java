package Server;

import spark.Spark;
import spark.debug.DebugScreen;

public class Server {
	public static void main(String[] args) throws Exception {
		Spark.port(9000);
		Router.init();
		DebugScreen.enableDebugScreen();
	}
}
