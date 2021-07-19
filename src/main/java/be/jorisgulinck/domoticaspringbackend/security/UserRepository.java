package be.jorisgulinck.domoticaspringbackend.security;

import be.jorisgulinck.domoticaspringbackend.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String userName);
}