package alexscotson.forum.controller;


import alexscotson.forum.domain.Topic;
import alexscotson.forum.domain.TopicPost;
import alexscotson.forum.service.TopicPostService;
import alexscotson.forum.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class TopicPostController {
    @Autowired
    private TopicPostService topicPostService;

    @Autowired
    private TopicService topicService;

    @GetMapping("/post/create/{id}")
    public String newPostView(@PathVariable("id") Integer id, Model model) {
        Topic topic = topicService.findById(id);
        model.addAttribute("topic", topic);
        model.addAttribute("topicpost", new TopicPost());
        return "/post/create";
    }

    @PostMapping("/post/create/{id}")
    public String createPost(@PathVariable("id") Integer topic_id, TopicPost topicPost) {
        Date dt = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");      // mySQL date format.
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Topic topic = topicService.findById(topic_id);

        topicPost.setDate(df.format(dt));
        topicPost.setTopic(topic);
        topicPost.setUsername(auth.getName());
        this.topicPostService.save(topicPost);
        return "redirect:/topic/index";
    }
}
