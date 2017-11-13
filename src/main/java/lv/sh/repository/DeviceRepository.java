package lv.sh.repository;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lv.sh.models.Device;
import lv.sh.config.ApplicationProperties;
import lv.sh.models.DeviceCodec;
import lv.sh.utils.AppUtils;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;


import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

import static lv.sh.config.ApplicationProperties.getString;

public class DeviceRepository {

    public static DeviceRepository instance;

    private static String HOST = getString(ApplicationProperties.ApplicationProperty.DB_HOST);
    private static String PORT = getString(ApplicationProperties.ApplicationProperty.DB_PORT);
    private static String DB_NAME = getString(ApplicationProperties.ApplicationProperty.DB_NAME);

    private static String USER = getString(ApplicationProperties.ApplicationProperty.DB_USER);
    private static String PASSWORD = getString(ApplicationProperties.ApplicationProperty.DB_PASSWORD);

    private MongoDatabase db;

    private CodecRegistry codecDeviceRegistry;

    private DeviceRepository() {

        Codec<Document> defaultDocumentCodec = MongoClient.getDefaultCodecRegistry().get(Document.class);
        DeviceCodec deviceCodec = new DeviceCodec(defaultDocumentCodec);
        codecDeviceRegistry = CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry(), CodecRegistries.fromCodecs(deviceCodec));

        MongoClientURI uri = new MongoClientURI(getConnectionURL());
        MongoClient mongoClient = new MongoClient(uri);
        db = mongoClient.getDatabase(DB_NAME);
    }

    public static DeviceRepository getInstance() {
        if (instance != null) return instance;
        instance = new DeviceRepository();
        return instance;
    }

    private static String getConnectionURL() {
        String url = format("mongodb://%s:%s@%s:%s/%s", USER, PASSWORD, HOST, PORT, DB_NAME);
        return url;
    }

    public void insert(Device device) {
        MongoCollection<Device> collection = db.getCollection("device", Device.class).withCodecRegistry(codecDeviceRegistry);
        collection.insertOne(device);
    }

    public List<Device> getAllDevices() {
        MongoCollection<Device> collection = db.getCollection("device", Device.class).withCodecRegistry(codecDeviceRegistry);
        List<Device> foundDocument = collection.find().into(new ArrayList<Device>());
        return foundDocument;
    }
}
