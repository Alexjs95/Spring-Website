package alexscotson.forum.controller;

import alexscotson.forum.domain.Topic;
import alexscotson.forum.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class TopicController {
    @Autowired
    private TopicService topicService;



    @GetMapping("/topic/index")
    public String viewTopics(Model model) {
        List<Topic> topics = topicService.findAll();
        model.addAttribute("topics", topics);
        return "topic/index";
    }



    @GetMapping("/topic/view/{id}")
    public String viewTopic (@PathVariable("id") Integer id, Model model) {
        Topic topic = topicService.findById(id);
        model.addAttribute("topic", topic);
        return  "topic/view";
    }





    @GetMapping("/topic/create")
    public String createView(Model model) {
        model.addAttribute("topic", new Topic());
        return "topic/create";
    }



    @PostMapping("/topic/create")
    public String create (@RequestBody Topic topic) {
      // topic.setDate(new Date());
        this.topicService.create(topic);
        return "topic/index";
    }





    @PostMapping("/topic/edit")
    public void edit(@RequestBody Topic topic) {
        this.topicService.edit(topic);
    }

    @DeleteMapping("topic/delete/{id}")
    public void delete (@PathVariable ("id") Integer id) {
        this.topicService.delete(id);
    }

}
