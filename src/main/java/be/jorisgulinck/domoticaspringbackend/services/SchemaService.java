package be.jorisgulinck.domoticaspringbackend.services;

import be.jorisgulinck.domoticaspringbackend.domain.models.domotica.Schema;
import be.jorisgulinck.domoticaspringbackend.repository.SchemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional
public class SchemaService implements CrudService<Schema> {

    @Autowired
    SchemaRepository schemaRepository;

    @Override
    public Schema save(Schema entity) {
        return schemaRepository.save(entity);
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
        schemaRepository.delete(getById(id));
    }
}
