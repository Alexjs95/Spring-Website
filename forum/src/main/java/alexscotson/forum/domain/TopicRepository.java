package alexscotson.forum.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends CrudRepository<Topic, Integer> {

    List<Topic> findAll();

    void deleteById(Integer id);
}
