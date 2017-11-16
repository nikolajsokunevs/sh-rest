package lv.sh;

import com.sun.grizzly.http.SelectorThread;
import com.sun.jersey.api.container.grizzly.GrizzlyWebContainerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static String BASE_URI = "http://localhost:" + (System.getenv("PORT") != null ? System.getenv("PORT") : "8080") + "/";
    public static Map<String, String> initParams = new HashMap<>();

    //   public static HttpServer startServer()  throws IOException{
    //    initParams.put("lv.sh","resources");
    //    SelectorThread threadSelector = GrizzlyWebContainerFactory.create(BASE_URI, initParams);
    //   return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    // }

    public static void main(String[] args) throws IOException {
        initParams.put("lv.sh","resources");
        SelectorThread threadSelector = GrizzlyWebContainerFactory.create(BASE_URI, initParams);

        //final HttpServer server = startServer();
        //System.out.println(String.format("Jersey app started with WADL available at " + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
        //System.in.read();
        //server.shutdown();
    }
}