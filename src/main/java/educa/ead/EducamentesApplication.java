package educa.ead;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableAsync()
@EnableWebMvc
@ComponentScan(basePackages = {"educa.ead.*"})
@AutoConfigurationPackage(basePackages = {"educa.ead.*"})
@SpringBootApplication
public class EducamentesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EducamentesApplication.class, args);
	}

}
