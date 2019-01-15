package alexscotson.forum;

import alexscotson.forum.models.Topic;
import alexscotson.forum.models.TopicRepository;
import alexscotson.forum.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> findAll() {
        return this.topicRepository.findAll();
    }


    public Topic findTopicById(Integer id) {
        return this.topicRepository.findTopicById(id);
    }

    public void deleteTopicById (Integer id) {
        this.topicRepository.deleteTopicById(id);
    }

    public List <Topic> findTopicByUser (String author) {
        return this.topicRepository.findTopicByAuthor(author);
    }

    public void save (Topic newEntry) {
        this.topicRepository.save (newEntry);
    }


}
