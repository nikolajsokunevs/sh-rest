package lv.sh;


import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.internal.org.objectweb.asm.TypeReference;
import lv.sh.beans.Device;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

@Path("light")
public class MyResource {



    @GET
    @Produces("application/json")
    public Device[] getAll(){
        String t=DataProvider.readFromFile("devicies.json");
        ObjectMapper mapper = new ObjectMapper();
        Device[] myObjects={};
        try {
            myObjects = mapper.readValue(t, Device[].class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return myObjects;
    }
}
