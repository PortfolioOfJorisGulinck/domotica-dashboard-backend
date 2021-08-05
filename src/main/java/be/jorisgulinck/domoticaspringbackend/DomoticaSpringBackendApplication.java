package be.jorisgulinck.domoticaspringbackend;

import be.jorisgulinck.domoticaspringbackend.repository.data.StarterData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "be.jorisgulinck.domoticaspringbackend.repository")
public class DomoticaSpringBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DomoticaSpringBackendApplication.class, args);

		StarterData starterData = new StarterData();
		starterData.fillDatabase();
	}

}
