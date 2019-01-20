package alexscotson.forum.service;

import alexscotson.forum.domain.Topic;
import alexscotson.forum.domain.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService implements TopicRepository {

    public List<Topic> findAll() {
        return this.findAll();
    }

    public Topic findById(Integer id) {
        return this.findById(id);
    }

    public void create(Topic topic) {
        this.create(topic);
    }

    public Topic edit(Topic topic) {
        return this.edit(topic);
    }

    public void delete(Integer id) {
        deleteById(id);
    }

    public void deleteById(Integer id) {
        this.delete(id);
    }
}
