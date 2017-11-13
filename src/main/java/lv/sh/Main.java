package lv.sh;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lv.sh.models.Device;
import lv.sh.repository.DeviceRepository;
import org.bson.codecs.configuration.CodecRegistry;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class Main {

    public static final String BASE_URI = "http://localhost:8080/myapp/";

    public static HttpServer startServer() {
        final ResourceConfig rc = new ResourceConfig().packages("lv.sh");
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    public static void main(String[] args) throws IOException {

        final Device in = new Device();
        in.setId("first");
        in.setDeviceName("first");

        final Device in2 = new Device();
        in2.setId("second");
        in2.setDeviceName("second");
        List<Device> list1=new ArrayList<>();
        list1.add(in2);

        in.setRelatedDevices(list1);

        List<Device> list=new ArrayList<>();
        list.add(in);

        Device device=new Device();
        device.setId("iuuh");
        device.setPercentage(5);
        device.setDeviceName("wetw");
        device.setRelatedDevices(list);
        DeviceRepository d=DeviceRepository.getInstance();
        //d.insert(device);
        d.getAllDevices();
        final HttpServer server = startServer();
        System.out.println(String.format("Jersey app started with WADL available at " + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
        System.in.read();
        server.shutdown();
    }
}

