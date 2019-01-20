package alexscotson.forum.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface TopicRepository extends CrudRepository<Topic, Integer> {

    List<Topic> findAll();


    //void create(Topic topic);
    //Topic edit(Topic topic);

    void deleteById(Integer id);

}
