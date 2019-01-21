package alexscotson.forum.controller;

import alexscotson.forum.domain.User;
import alexscotson.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/user/login")
    public String login(Model model) {
        model.addAttribute("user", new User());       // returns the view to create a new topic.

        return "user/login";
    }

    @PostMapping("/user/login")
    public String attemptLogin(User user) {
        if (!userService.authenticate(
                user.getUsername(), user.getPassword())) {
//            notifyService.addErrorMessage("Invalid login!");
            return "redirect:/topic/index";
        }

        return null;
    }


    @GetMapping("/user/register")
    public String createView(Model model) {
        model.addAttribute("user", new User());       // returns the view to create a new user.
        return "user/register";
    }

    @PostMapping("/user/create")
    public String save (User user) {     // saves the new user to DB
        this.userService.save(user);
        return "redirect:/topic/index";
    }

}
