package alexscotson.forum.controllers;



import alexscotson.forum.TopicService;
import alexscotson.forum.models.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@Controller
public class IndexController  {

    @Autowired
    private TopicService topicService;

    @GetMapping("/")
    public String index(Model model) {
        List<Topic> topics = topicService.findAll();
        model.addAttribute("topics", topics);

        List<Topic> latest3Topics = topics.stream().limit(3).collect(Collectors.toList());
        model.addAttribute("latest3Topics", latest3Topics);
        return "index";
    }




}
