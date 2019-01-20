package alexscotson.forum.controller;

import alexscotson.forum.domain.Topic;
import alexscotson.forum.service.TopicService;
import alexscotson.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private TopicService topicService;

    @Autowired
    private UserService userService;


    @GetMapping("/")
    public String index(Model model) {
//        List<topic> topics = topicService.findRecent5();
//        model.addAttribute("topics", topics);
        return "index";
    }

    @GetMapping("/topics")
    public String viewTopics(Model model) {
        List<Topic> topics = topicService.findAllEntries();
        model.addAttribute("topics", topics);
        return "Topic/index";
    }



}
