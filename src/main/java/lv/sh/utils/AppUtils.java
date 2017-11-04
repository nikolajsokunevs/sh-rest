package lv.sh.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.util.JSON;
import org.bson.Document;

public class AppUtils {

    private static ObjectMapper mapper = new ObjectMapper();

    public static Document toDBObject(Object pojo) {
        String json="";
        try {
            json = mapper.writeValueAsString(pojo);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return (Document) JSON.parse(json);
    }
}
