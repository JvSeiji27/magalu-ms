package joaovitorseiji.com.magalu_microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MagaluMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MagaluMicroservicesApplication.class, args);
	}

}
