package lv.sh;

import com.fasterxml.jackson.databind.ObjectMapper;
import lv.sh.models.Device;
import lv.sh.service.DeviceServiceImpl;
import lv.sh.service.IDeviceService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.IOException;

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

    @POST
    @Path("post")
    @Produces("application/json")
    public String post(){
        IDeviceService deviceService=new DeviceServiceImpl();
        deviceService.addBird(new Device());
        return "DONE";
    }
}
