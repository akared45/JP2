package E2.Controller;

import E2.Entity.Customer;
import E2.Entity.Room;
import E2.Service.RoomService;

public class RoomController {
    private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    public void addRoom(Room room) {
        roomService.add(room);
    }

    public Room getRoom(int id) {
        Room room = roomService.findById(id);
        if (room == null) {
            return null;
        }
        return room;
    }
}
