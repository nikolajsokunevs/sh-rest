package lv.sh;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lv.sh.beans.Device;
import org.bson.codecs.configuration.CodecRegistry;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;
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
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        String uriString = "mongodb://user1:user1@ds249025.mlab.com:49025/sh";
        MongoClientURI uri = new MongoClientURI(uriString);
        MongoClient mongoClient = new MongoClient(uri);

        MongoDatabase db = mongoClient.getDatabase("sh");
        db.withCodecRegistry(pojoCodecRegistry);

       MongoCollection<Device> collection= db.getCollection("device", Device.class);
        Device document = new Device();
       document.setPercentage(50.5);
       document.setId(1233);
        collection.insertOne(document);


       // try {
       //     db = uri.getDatabase();
       // } catch (UnknownHostException e) {
        //    e.printStackTrace();
       // }
        System.out.println(db);

      //  final HttpServer server = startServer();
      //  System.out.println(String.format("Jersey app started with WADL available at " + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
      //  System.in.read();
      //  server.shutdown();
    }
}

