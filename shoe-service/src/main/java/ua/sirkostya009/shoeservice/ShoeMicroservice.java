package ua.sirkostya009.shoeservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import ua.sirkostya009.shoeservice.dao.Shoe;
import ua.sirkostya009.shoeservice.repository.ShoeRepository;

import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableMethodSecurity
public class ShoeMicroservice {

	public static void main(String[] args) {
		SpringApplication.run(ShoeMicroservice.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ShoeRepository repository) {
		return args -> {
			repository.deleteAll();

			var countries = List.of("Korea", "Ukraine", "Japan", "USA");
			var colors = List.of("red", "yellow", "blue");
			var previews = List.of("siberian_republic.png", "tsardom_of_muscovy.png", "fareastern_republic.png", "ural_republic.png");

			var random = new Random();
			for (var i = 0; i < 100; ++i) {
				var name = "shoe " + i;
				var color = colors.get(random.nextInt(colors.size()));
				var price = random.nextInt(500, 10000);
				var country = countries.get(random.nextInt(colors.size()));
				var previewPic = previews.get(random.nextInt(previews.size()));

				repository.save(Shoe.builder()
								.color(color)
								.price(price)
								.name(name)
								.countryManufacturer(country)
								.imageFileName(previewPic)
								.build());
			}
		};
	}

}
