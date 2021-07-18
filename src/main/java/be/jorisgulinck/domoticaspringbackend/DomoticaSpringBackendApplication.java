package be.jorisgulinck.domoticaspringbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class DomoticaSpringBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DomoticaSpringBackendApplication.class, args);
	}

}
