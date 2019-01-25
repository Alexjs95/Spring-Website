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
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class TopicController {
    @Autowired
    private TopicService topicService;

    @Autowired
    private TopicPostService topicPostService;

    Authentication auth = SecurityContextHolder.getContext().getAuthentication();

    @GetMapping("/topic/index")
    public String viewTopics(@RequestParam(value = "search", required = false) String search, Model model) {
        List<Topic> topics;
        if (search != null) {
            topics = topicService.findByUsername(search);
        } else {
            topics = topicService.findAll();        // finds all topics.
        }

        model.addAttribute("topic", new Topic());
        model.addAttribute("topics", topics);       // returns the topics to the view.
        return "topic/index";
    }

    @GetMapping("/topic/view/{id}")
    public String viewTopicByUser (@PathVariable("id") Integer id, Model model) {     //requests input of an id.
        Topic topic = topicService.findById(id);
        List<TopicPost> topicPosts = topicPostService.findByTopicId(id);
        model.addAttribute("topic", topic);
        model.addAttribute("topicPost", topicPosts);     // returns the topic to the view.
        return  "topic/view";
    }


    @GetMapping("/topic/create")
    public String createView(Model model) {
        model.addAttribute("topic", new Topic());       // returns the view to create a new topic.
        return "topic/create";
    }



    @PostMapping("/topic/create")
    public String save (Topic topic) {     // saves the new topic to DB
        Date dt = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");      // mySQL date format.
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        topic.setDate(df.format(dt));       // sets date to now.
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


    @PostMapping("/topic/edit/{id}")
    public String saveEdits(@PathVariable("id") Integer id, Topic topic) {
        Date dt = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Topic existingTopic = topicService.findById(id);


        topic.setId(existingTopic.getId());
        topic.setTopicTitle(existingTopic.getTopicTitle());
        topic.setDate(df.format(dt));
        topic.setusername(auth.getName());

        //this.topicService.save(topic);
        this.topicService.edit(topic);

        return "redirect:/topic/index";
    }


    @RequestMapping(value = "topic/delete/{id}", method = RequestMethod.GET)
    public String delete (@PathVariable ("id") Integer id) {
        this.topicService.deleteById(id);

        return "redirect:/topic/index";
    }

}
