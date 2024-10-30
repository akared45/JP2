package E2.Service;

import E2.Entity.Room;
import E2.General.Generic;

import java.util.HashMap;
import java.util.Map;

public class RoomService implements Generic<Room> {
    private Map<Integer, Room> rooms=new HashMap<>();

    @Override
    public void add(Room room) {
        rooms.put(room.getId(),room);
    }

    @Override
    public Room findById(Integer id) {
        return rooms.entrySet().stream()
                .filter(r->r.getKey().equals(id))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(null);
    }
}
