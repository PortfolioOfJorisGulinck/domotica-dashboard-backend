package be.jorisgulinck.domoticaspringbackend.services;

import be.jorisgulinck.domoticaspringbackend.domain.models.building.Floor;
import be.jorisgulinck.domoticaspringbackend.repository.FloorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FloorService implements CrudService<Floor> {

    private final FloorRepository floorRepository;

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
        Floor floor = floorRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        floorRepository.delete(floor);
    }
}
