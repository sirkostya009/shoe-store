package ua.sirkostya009.userservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import ua.sirkostya009.userservice.dao.Role;
import ua.sirkostya009.userservice.dao.User;
import ua.sirkostya009.userservice.repository.UserRepository;

@SpringBootApplication
@ConfigurationPropertiesScan
public class UserMicroservice {

	public static void main(String[] args) {
		SpringApplication.run(UserMicroservice.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserRepository repository, PasswordEncoder encoder) {
		return args -> {
			repository.deleteAll();

			repository.save(User.builder()
					.name("admin")
					.email("admin@example.com")
					.username("admin")
					.password(encoder.encode("password"))
					.roles(Role.Presets.SUPER_USER)
					.build());
		};
	}

}
