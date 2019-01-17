package alexscotson.forum.controllers;


import alexscotson.forum.TopicService;
import alexscotson.forum.models.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/topics")
    public List<Topic> getAllComments () {
        return topicService.findAll();
    }

//    @GetMapping ("/comment/{id}")
//    public GuestBookEntry findGuestBookEntryById (@PathVariable("id") Integer id) {
//        return this.guestBookService.findGuestBookEntryById (id);
//    }
//
//    @DeleteMapping("/comment/{id}")
//    public void deleteGuestBookEntryById (@PathVariable ("id") Integer id) {
//        this.guestBookService.deleteGuestBookEntryById (id);
//    }
//
//    @GetMapping ("/user/{user}")
//    public List <GuestBookEntry> findGuestBookEntryByUser (@PathVariable ("user") String user) {
//        return this.guestBookService.findGuestBookEntryByUser (user);
//    }
//
//    @PostMapping ("/add")
//    public void addComment (@RequestBody GuestBookEntry guestBookEntry) {
//        this.guestBookService.save (guestBookEntry);
//    }
//
//    @PostMapping ("/update")
//    public void updateComment (@RequestBody GuestBookEntry guestBookEntry) {
//        this.guestBookService.save (guestBookEntry);
//    }
}
