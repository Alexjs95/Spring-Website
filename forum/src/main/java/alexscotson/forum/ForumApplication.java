package alexscotson.forum;

import alexscotson.forum.respository.TopicRepository;
import alexscotson.forum.service.TopicService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@ComponentScan(basePackages = "alexscotson.forum")

@SpringBootApplication
//@EnableJpaRepositories(basePackages="alexscotson.forum", entityManagerFactoryRef="emf")
@EnableJpaRepositories
@EntityScan(basePackages = "alexscotson.forum")
@EnableWebMvc
public class ForumApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ForumApplication.class, args);
	}

//	@Bean
//	public TopicService topicService() {
//		return topicService();
//	}
//
//	@Bean
//	public TopicRepository topicRepository() {
//		return topicRepository();
//	}



}

