package be.jorisgulinck.domoticaspringbackend.services;

import be.jorisgulinck.domoticaspringbackend.domain.models.building.Room;
import be.jorisgulinck.domoticaspringbackend.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional
public class RoomService implements CrudService<Room>{

    @Autowired
    private RoomRepository roomRepository;

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
        roomRepository.delete(getById(id));
    }
}
