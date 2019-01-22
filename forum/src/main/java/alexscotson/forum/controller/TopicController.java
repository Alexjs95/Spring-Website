package alexscotson.forum.controller;

import alexscotson.forum.domain.Topic;
import alexscotson.forum.service.TopicService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class TopicController {
    @Autowired
    private TopicService topicService;


    Authentication auth = SecurityContextHolder.getContext().getAuthentication();

    @GetMapping("/topic/index")
    public String viewTopics(Model model) {
        List<Topic> topics = topicService.findAll();        // finds all topics.
        model.addAttribute("topics", topics);       // returns the topics to the view.
        return "topic/index";
    }

    @GetMapping("/topic/view/{id}")
    public String viewTopic (@PathVariable("id") Integer id, Model model) {     //requests input of an id.
        Topic topic = topicService.findById(id);        // searches for 1 topic by id.
        model.addAttribute("topic", topic);     // returns the topic to the view.
        return  "topic/view";
    }


    @GetMapping("/topic/create")
    public String createView(Model model) {
        model.addAttribute("topic", new Topic());       // returns the view to create a new topic.
        return "topic/create";
    }



    @PostMapping("/topic/create")
    public String save ( Topic topic) {     // saves the new topic to DB
        Date dt = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");      // mySQL date format.

        topic.setDate(df.format(dt));       // sets date to now.

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        topic.setusername(auth.getName());
        this.topicService.save(topic);
        return "redirect:/topic/index";
    }


    @GetMapping("/topic/edit/{id}")
    public String editView(@PathVariable("id") Integer id, Model model) {
        Topic topic = topicService.findById(id);
        model.addAttribute("topic", topic);
        return "topic/edit";
    }


    @PostMapping("/topic/edit/")
    public String saveEdits(Topic topic) {
        Date dt = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        topic.setDate(df.format(dt));

        this.topicService.save(topic);
        this.topicService.edit(topic);

        return "topic/index";
    }


    @RequestMapping(value = "topic/delete/{id}", method = RequestMethod.GET)
    public String delete (@PathVariable ("id") Integer id) {
        this.topicService.deleteById(id);
        return "redirect:/topic/index";
    }

}
