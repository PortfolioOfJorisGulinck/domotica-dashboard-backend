package be.jorisgulinck.domoticaspringbackend.repository;

import be.jorisgulinck.domoticaspringbackend.models.domotica.Schema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchemaRepository extends JpaRepository<Schema, Integer>{
}
