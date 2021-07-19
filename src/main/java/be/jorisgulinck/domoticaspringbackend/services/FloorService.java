package be.jorisgulinck.domoticaspringbackend.services;

import be.jorisgulinck.domoticaspringbackend.models.building.Floor;
import be.jorisgulinck.domoticaspringbackend.repository.FloorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class FloorService implements CrudService<Floor> {

    @Autowired
    private FloorRepository floorRepository;

    public FloorService() {
    }

    @Override
    public Floor save(Floor floor) {
        return floorRepository.save(floor);
    }

    @Override
    public Floor getById(int id) {
        return floorRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Floor> getAll() {
        return floorRepository.findAll();
    }

    @Override
    public void delete(int id) {
        floorRepository.delete(getById(id));
    }
}
