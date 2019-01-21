package alexscotson.forum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
(scanBasePackages={"alexscotson.forum.controller", "alexscotson.forum.domain", "alexscotson.forum.service", "alexscotson.forum.config"})
@EnableJpaRepositories
public class ForumApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForumApplication.class, args);
    }

}

