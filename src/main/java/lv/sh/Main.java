package lv.sh;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;
import java.util.Optional;

public class Main {

   // public static final String BASE_URI;
    public static final String protocol;
    public static final Optional<String> host;
    public static final String path;
  //  public static final Optional<String> port;

    static{
        protocol = "http://";
        host = Optional.ofNullable(System.getenv("HOSTNAME"));
      //  port = Optional.ofNullable(System.getenv("PORT"));
        path = "myapp";
      //  BASE_URI = protocol + host.orElse("localhost") + ":" + port.orElse("8080") + "/" + path + "/";
    }
    public static HttpServer startServer(URI baseUri) {
        final ResourceConfig rc = new ResourceConfig().packages("lv.sh.resources");

        return GrizzlyHttpServerFactory.createHttpServer(baseUri, rc);
    }

    public static void main(String[] args) throws IOException {
        final int port = System.getenv("PORT") != null ? Integer.valueOf(System.getenv("PORT")) : 8080;
        final URI baseUri = UriBuilder.fromUri("http://0.0.0.0/").port(port).build();
        final HttpServer server = startServer(baseUri);
        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", baseUri.toString()));
        server.shutdown();
    }
}