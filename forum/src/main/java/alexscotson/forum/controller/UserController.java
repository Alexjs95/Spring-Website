package alexscotson.forum.controller;

import alexscotson.forum.domain.User;
import alexscotson.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping(value="user/login")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping(value="user/registration")
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "user/registration")
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("registration");

        }
        return modelAndView;
    }



//    @GetMapping("/user/login")
//    public String login(Model model) {
//        model.addAttribute("user", new User());       // returns the view to create a new topic.
//
//        return "user/login";
//    }


//
//    @PostMapping("/user/login")
//    public String attemptLogin(User user) {
//        if (!userService.authenticate(
//                user.getUsername(), user.getPassword())) {
////            notifyService.addErrorMessage("Invalid login!");
//            return "redirect:/topic/index";
//        }
//
//        return null;
//    }

//
//    @GetMapping("/user/register")
//    public String createView(Model model) {
//        model.addAttribute("user", new User());       // returns the view to create a new user.
//        return "user/register";
//    }

//    @PostMapping("/user/create")
//    public String save (User user) {     // saves the new user to DB
//        this.userService.save(user);
//        return "redirect:/topic/index";
//    }

}
