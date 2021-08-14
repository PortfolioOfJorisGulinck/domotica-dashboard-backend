package be.jorisgulinck.domoticaspringbackend.services;

import be.jorisgulinck.domoticaspringbackend.domain.models.building.Room;
import be.jorisgulinck.domoticaspringbackend.domain.models.schema.Schema;
import be.jorisgulinck.domoticaspringbackend.repository.SchemaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SchemaService implements CrudService<Schema> {

    private final SchemaRepository schemaRepository;

    @Override
    public Schema save(Schema entity) {
        return schemaRepository.save(entity);
    }

    public List<Schema> getByRoom(Room room) {
        return schemaRepository.findByRoom(room);
    }

    @Override
    public Schema getById(int id) {
        return schemaRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Schema> getAll() {
        return schemaRepository.findAll();
    }

    @Override
    public void delete(int id) {
        Schema schema = schemaRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        schemaRepository.delete(schema);
    }
}
