package com.studentmanagement.root.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagement.root.repository.RoomRepository;
import com.studentmanagement.root.entity.Room;
@Service
public class RoomService {

	@Autowired
    private RoomRepository roomRepository;
    
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }
    
    public Room getRoomById(Integer roomId) {
    	Optional<Room> room = roomRepository.findById(roomId);
    	
    	if(room.isPresent()) {
    		return room.get();
    	}else {
    		return null;
    	}
    }
    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }
    
    public void deleteRoom(Integer roomId) {
        roomRepository.deleteById(roomId);
    }
    
    public Room updateRoom(Integer roomId, Room updatedRoom) {
        Optional<Room> optionalRoom = roomRepository.findById(roomId);
        
        if (optionalRoom.isPresent()) {
            Room room = optionalRoom.get();
            room.setDescription(updatedRoom.getDescription());
            room.setCapcity(updatedRoom.getCapcity());
            room.setRoomNumber(updatedRoom.getRoomNumber());
            room.setPrice(updatedRoom.getPrice());
            room.setAvailability(updatedRoom.getAvailability());
            return roomRepository.save(room);
        }
        return null;
    }
}
