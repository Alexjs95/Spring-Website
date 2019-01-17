package alexscotson.forum.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Topicrepository extends CrudRepository <Topic, Integer> {
    @Override
    List<Topic> findAll ();

    Topic findTopicById (Integer id);
    Topic deleteTopicById (Integer id);
    List<Topic> findTopicByAuthor (String author);

}
