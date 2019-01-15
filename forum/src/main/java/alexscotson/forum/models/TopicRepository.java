package alexscotson.forum.models;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TopicRepository extends CrudRepository <Topic, Integer> {
    @Override
    List<Topic> findAll ();

    Topic findTopicById (Integer id);
    Topic deleteTopicById (Integer id);
    List<Topic> findTopicByAuthor (String author);

}
