package alexscotson.forum.controller;

import alexscotson.forum.domain.Topic;
import alexscotson.forum.domain.User;
import alexscotson.forum.service.TopicService;
import alexscotson.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private TopicService topicService;

    @Autowired
    private UserService userService;


    @GetMapping("/")
    public String index() {

        return "index";
    }

    @GetMapping("/topics/index")
    public String viewTopics(Model model) {
        List<Topic> topics = topicService.findAll();
        model.addAttribute("topics", topics);
        return "topic/index";
    }


}
