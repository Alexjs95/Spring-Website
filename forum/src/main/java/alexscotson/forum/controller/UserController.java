package alexscotson.forum.controller;

import alexscotson.forum.domain.User;
import alexscotson.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
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

    @RequestMapping(value="/dashboard", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getUsername() + " (" + user.getEmail() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }



//    @RequestMapping(value="/login", method = RequestMethod.POST)
//    public String validateLogin(@Valid User user, BindingResult bindingResult){
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        boolean loggedIn = userService.validateUser(user.getEmail(), user.getPassword());
//
//        if (loggedIn == true) {
//            System.out.println("logged in");
//        }
//        System.out.println("NOT logged in");
//
//
//        return "redirect:/topic/index";
//    }








//    @GetMapping(value="user/login")
//    public String login(Model model){
//        model.addAttribute("user", new User());
//        return "user/login";
//    }
//
//    @GetMapping(value="user/register")
//    public String registration(Model model){
//        model.addAttribute("user", new User());
//        return "user/register";
//    }
//
//    @PostMapping("/user/login")
//    public String attemptLogin(@Valid User user, BindingResult bindingResult) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        user = userService.findUserByEmail(auth.getName());
//        return "redirect:/topic/index";
//    }
//
//    @PostMapping("/user/create")
//    public String save (User user) {     // saves the new user to DB
//        User exists = userService.findUserByEmail(user.getEmail());
//        if (exists == null) {
//            userService.saveUser(user);
//            return "redirect:/topic/index";
//        } else {
//            // user already registered
//
//        }
//        return "redirect:/topic/index";
//    }

//
//    @GetMapping("/user/register")
//    public String createView(Model model) {
//        model.addAttribute("user", new User());       // returns the view to create a new user.
//        return "user/register";
//    }



}
