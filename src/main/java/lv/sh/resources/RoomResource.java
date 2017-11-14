package lv.sh.resources;

import lv.sh.models.Room;
import lv.sh.service.room.IRoomService;
import lv.sh.service.room.RoomServiceImpl;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("room")
public class RoomResource {

    @Path("all")
    @Produces("application/json")
    public List<Room> getAll(){
        IRoomService roomService=new RoomServiceImpl();
        return roomService.getAllRooms();
    }

    @POST
    @Path("add")
    @Produces("application/json")
    public String post(Room room){
        IRoomService roomService=new RoomServiceImpl();
        roomService.addRoom(room);
        return "DONE";
    }
}
