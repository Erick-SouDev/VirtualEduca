package educa.ead;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableAsync
@EnableWebMvc
@ComponentScan(basePackages = {"educa.ead.*"})
@EnableJpaRepositories(basePackages = "educa.ead.repository")
@EntityScan(basePackages = "educa.ead.modelos")
@SpringBootApplication
public class EducamentesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EducamentesApplication.class, args);
	}

}
