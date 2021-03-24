package technicalpost.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import technicalpost.model.Post;
import technicalpost.model.User;
import technicalpost.model.UserProfile;
import technicalpost.service.PostService;
import technicalpost.service.UserService;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;
    @RequestMapping("/users/login")
    public String login(){
        return "/users/login";
    }

    @RequestMapping(value="/users/login", method = RequestMethod.POST)
    public String loginUser(User user, HttpSession session){
        User existingUser=userService.login(user);
        if(existingUser != null)
        {   session.setAttribute("loggeduser", existingUser);
            return "redirect:/posts";}
        else
            return "redirect:/users/login";
    }
    @RequestMapping("users/logout")
    public String logout(Model model){
        ArrayList<Post> posts=postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "index";
    }

    @RequestMapping("users/registration")
    public String registration(Model model){
        User user=new User();
        UserProfile profile=new UserProfile();
        user.setProfile(profile);
        model.addAttribute("User", user);
        return "users/registration";
    }

    @RequestMapping(value = "users/registration", method = RequestMethod.POST)
    public String registerUser(User user){
        userService.registerUser(user);
        return "users/login";
    }
}
