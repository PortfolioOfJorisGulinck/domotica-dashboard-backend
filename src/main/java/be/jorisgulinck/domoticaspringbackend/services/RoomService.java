package be.jorisgulinck.domoticaspringbackend.services;

import be.jorisgulinck.domoticaspringbackend.domain.models.building.Room;
import be.jorisgulinck.domoticaspringbackend.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService implements CrudService<Room>{

    private final RoomRepository roomRepository;

    @Override
    public Room save(Room entity) {
        return roomRepository.save(entity);
    }

    @Override
    public Room getById(int id) {
        return roomRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Room> getAll() {
        return roomRepository.findAll();
    }

    @Override
    public void delete(int id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        roomRepository.delete(room);
    }
}
