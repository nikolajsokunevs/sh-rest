package lv.sh.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import lv.sh.models.Device;
import org.bson.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppUtils {

    private static ObjectMapper mapper = new ObjectMapper();

    public static Document toDBObject(Object pojo) {
        String json = "";
        try {
            json = mapper.writeValueAsString(pojo);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return Document.parse(json.toString());
    }

    public static List<Device> toJavaObject(List<BasicDBObject> collections) {
        String json = "";
        List<Device> devices=new ArrayList<>();
        for (BasicDBObject current:collections) {
            try {
                Device d=mapper.readValue(current.toJson(), Device.class);
                devices.add(d);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return devices;
    }
}
