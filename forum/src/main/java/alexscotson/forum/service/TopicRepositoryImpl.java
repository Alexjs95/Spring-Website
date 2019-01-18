package alexscotson.forum.service;

import alexscotson.forum.models.Topic;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicRepositoryImpl implements TopicRepository {
    @Override
    public List<Topic> findAll() {
        return null;
    }

    @Override
    public Topic findTopicById(Integer id) {
        return null;
    }

    @Override
    public Topic deleteTopicById(Integer id) {
        return null;
    }

    @Override
    public List<Topic> findTopicByAuthor(String author) {
        return null;
    }
}
