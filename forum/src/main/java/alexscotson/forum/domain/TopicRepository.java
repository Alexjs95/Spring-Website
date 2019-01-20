package alexscotson.forum.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface TopicRepository {

    List<Topic> findAll();
    Topic findById(Integer id);
    void create(Topic topic);
    Topic edit(Topic topic);

    void deleteById(Integer id);

}
