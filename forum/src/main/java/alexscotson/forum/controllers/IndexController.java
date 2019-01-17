package alexscotson.forum.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class IndexController  {




    @GetMapping("/")
    public String index() {
//        List<Topic> topics = topicService.findAll();
//        model.addAttribute("topics", topics);
//
//        List<Topic> latest3Topics = topics.stream().limit(3).collect(Collectors.toList());
//        model.addAttribute("latest3Topics", latest3Topics);
        return "index";
    }




}
