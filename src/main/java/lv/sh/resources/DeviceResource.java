package lv.sh.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import lv.sh.DataProvider;
import lv.sh.models.Device;
import lv.sh.service.DeviceServiceImpl;
import lv.sh.service.IDeviceService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.IOException;

@Path("device")
public class DeviceResource {

    @GET
    @Path("all")
    @Produces("application/json")
    public Device[] getAll(){
        String t= DataProvider.readFromFile("devicies.json");
        ObjectMapper mapper = new ObjectMapper();
        Device[] myObjects={};
        IDeviceService deviceService=new DeviceServiceImpl();
        myObjects=deviceService.getAllDevices();
        return myObjects;
    }

    @POST
    @Path("add")
    @Produces("application/json")
    public String post(){
        IDeviceService deviceService=new DeviceServiceImpl();
        deviceService.addDevice(new Device());
        return "DONE";
    }
}
