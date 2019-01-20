package alexscotson.forum.controller;

import alexscotson.forum.domain.Topic;
import alexscotson.forum.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class TopicController {
    @Autowired
    private TopicService topicService;


    @RequestMapping("/topics/index")
    public String index (Model model) {
        List<Topic> topics = topicService.findAll();
        model.addAttribute("topic", topics);
        return "topic/index";
    }

    @RequestMapping("/topics/view/{id}")
    public String viewTopic (@PathVariable("id") Integer id, Model model) {
        Topic topic = topicService.findById(id);
        model.addAttribute("topic", topic);
        return "topic/view";
    }

    @PostMapping("/topics/create")
    public void create (@RequestBody Topic topic) {
        this.topicService.create(topic);
    }

    @PostMapping("/topics/edit")
    public void edit(@RequestBody Topic topic) {
        this.topicService.edit(topic);
    }

    @DeleteMapping("topics/delete/{id}")
    public void delete (@PathVariable ("id") Integer id) {
        this.topicService.delete(id);
    }

}
