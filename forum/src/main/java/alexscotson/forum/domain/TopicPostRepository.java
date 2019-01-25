package alexscotson.forum.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicPostRepository extends CrudRepository<TopicPost, Integer> {
    List<TopicPost> findByTopicId(Integer id);
    void deleteAllByTopicId(Integer id);
}
