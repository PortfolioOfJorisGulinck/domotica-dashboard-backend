package be.jorisgulinck.domoticaspringbackend.repository;

import be.jorisgulinck.domoticaspringbackend.models.building.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloorRepository extends JpaRepository<Floor, Integer> {
}
