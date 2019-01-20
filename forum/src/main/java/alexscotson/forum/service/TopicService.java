package alexscotson.forum.service;

import alexscotson.forum.domain.Topic;
import alexscotson.forum.domain.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> findAllEntries() {
        return this.topicRepository.findAll();
    }



//    public List<topic> findRecent5() {
//        return this.topicRepository.find5Topics();
//    }

}
