package ca.skip.skipchallange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@EnableJdbcRepositories
public class SkipChallangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkipChallangeApplication.class, args);
	}
}
