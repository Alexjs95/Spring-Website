package alexscotson.forum.service;

import alexscotson.forum.models.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TopicRepository{

    List<Topic> findAll ();

    Topic findTopicById (Integer id);
    Topic deleteTopicById (Integer id);
    List<Topic> findTopicByAuthor (String author);

}
