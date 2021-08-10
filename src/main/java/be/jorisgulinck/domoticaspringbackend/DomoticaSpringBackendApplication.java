package be.jorisgulinck.domoticaspringbackend;

import be.jorisgulinck.domoticaspringbackend.repository.UserRepository;
import be.jorisgulinck.domoticaspringbackend.repository.data.StarterData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "be.jorisgulinck.domoticaspringbackend.repository")
public class DomoticaSpringBackendApplication {

    @PersistenceUnit
    private EntityManagerFactory emf;

    UserRepository userRepository;

    @Autowired
    public DomoticaSpringBackendApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DomoticaSpringBackendApplication.class, args);
    }

    @PostConstruct
    public void start() {
        EntityManager entityManager = emf.createEntityManager();
        StarterData starterData = new StarterData();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        starterData.createUser(userRepository);
        starterData.fillDatabase(entityManager);
        transaction.commit();
        entityManager.close();
    }
}
