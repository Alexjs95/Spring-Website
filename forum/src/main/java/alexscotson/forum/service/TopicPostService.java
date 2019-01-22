package alexscotson.forum.service;

import alexscotson.forum.domain.TopicPost;
import alexscotson.forum.domain.TopicPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicPostService {
    @Autowired
    private TopicPostRepository topicPostRepository;

    public List<TopicPost> findByTopicId(Integer id) {
        return this.topicPostRepository.findByTopicId(id);
    }

    public void save(TopicPost topicPost) {
        this.topicPostRepository.save(topicPost);
    }

}
