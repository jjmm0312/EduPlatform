package vaninside.eduplatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
//@ComponentScan
public class Eduplaftorm2020Application {

	public static void main(String[] args) {
		SpringApplication.run(Eduplaftorm2020Application.class, args);
	}
	
}