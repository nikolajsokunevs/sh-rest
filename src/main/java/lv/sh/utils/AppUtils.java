package lv.sh.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

public class AppUtils {

    private static ObjectMapper mapper = new ObjectMapper();

    public static DBObject toDBObject(Object pojo) {
        String json="";
        try {
            json = mapper.writeValueAsString(pojo);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return (DBObject) JSON.parse(json);
    }
}
