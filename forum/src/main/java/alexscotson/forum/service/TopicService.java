package alexscotson.forum.service;

import alexscotson.forum.models.Topic;
import alexscotson.forum.respository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
