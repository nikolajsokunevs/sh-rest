package lv.sh;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import lv.sh.beans.Device;
import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class MyResourceTest {

    private static HttpServer server;
    private static WebTarget target;

    @BeforeAll
    public static void setUp() throws Exception {
        server = Main.startServer();
        Client c = ClientBuilder.newClient();
        target = c.target(Main.BASE_URI);
    }

    @AfterAll
    public static void tearDown() throws Exception {
        server.shutdown();
    }

    @Test
    public void testGetIt() {
        Device responseMsg = target.path("myresource").request().get(Device.class);
        Assertions.assertEquals("Got it!", responseMsg);
    }
}
