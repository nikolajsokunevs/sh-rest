package lv.sh.service.room;

import lv.sh.models.Room;
import lv.sh.repository.DeviceRepository;

import java.util.List;

public class RoomServiceImpl implements IRoomService {

    private DeviceRepository deviceRepository = DeviceRepository.getInstance();

    @Override
    public Room addRoom(Room room) {
        deviceRepository.insertRoom(room);
        return null;
    }

    @Override
    public List<Room> getAllRooms() {
        return deviceRepository.getAllRooms();
    }
}
