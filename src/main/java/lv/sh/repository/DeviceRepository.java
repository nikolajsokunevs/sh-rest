package lv.sh.repository;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lv.sh.models.Device;
import lv.sh.config.ApplicationProperties;
import lv.sh.utils.AppUtils;
import org.bson.Document;


import static java.lang.String.format;

import static lv.sh.config.ApplicationProperties.getString;

public class DeviceRepository {

    private static String HOST=getString(ApplicationProperties.ApplicationProperty.DB_HOST);
    private static String PORT=getString(ApplicationProperties.ApplicationProperty.DB_PORT);
    private static String DB_NAME= getString(ApplicationProperties.ApplicationProperty.DB_NAME);

    private static String USER= getString(ApplicationProperties.ApplicationProperty.DB_USER);
    private static String PASSWORD= getString(ApplicationProperties.ApplicationProperty.DB_PASSWORD);

    private MongoDatabase db;

    public DeviceRepository() {
        MongoClientURI uri = new MongoClientURI(getConnectionURL());
        MongoClient mongoClient = new MongoClient(uri);
        db = mongoClient.getDatabase(DB_NAME);
    }

    private static String getConnectionURL(){
        String url = format("mongodb://%s:%s@%s:%s/%s", USER, PASSWORD, HOST, PORT, DB_NAME);
        return url;
    }

    public void insert(Device device){
        MongoCollection<Document> collection= db.getCollection("device");
        collection.insertOne(AppUtils.toDBObject(device));
    }
}
