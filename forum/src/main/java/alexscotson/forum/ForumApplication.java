package alexscotson.forum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication

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

