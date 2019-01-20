package alexscotson.forum.controller;

import alexscotson.forum.domain.Topic;
import alexscotson.forum.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
//public class TopicController {
//    @Autowired
//    private TopicService topicService;
//
//    @RequestMapping("/topics/view/{id}")
//    public String view(@PathVariable("id") Integer id, Model model) {
//        topic topic = topicService.findByID(id);
//        model.addAttribute("topic", topic);
//        return null;        // return topic details
//    }
//}
