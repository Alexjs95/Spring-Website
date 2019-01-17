package alexscotson.forum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("alexscotson.forum") //to activate MongoDB repositories

public class ForumApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ForumApplication.class, args);
	}

}

