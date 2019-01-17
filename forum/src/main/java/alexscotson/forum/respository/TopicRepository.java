package alexscotson.forum.respository;

import alexscotson.forum.models.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends CrudRepository <Topic, Long> {
    @Override
    List<Topic> findAll ();

    Topic findTopicById (Integer id);
    Topic deleteTopicById (Integer id);
    List<Topic> findTopicByAuthor (String author);

}
