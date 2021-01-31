package technicalpost.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import technicalpost.model.Post;
import technicalpost.model.User;
import technicalpost.service.PostService;
@Controller
public class UserController {
    @Autowired
    private PostService postService;
    @RequestMapping("users/login")
    public String login(){
        return "users/login";
    }
    @RequestMapping("users/registration")
    public String registration(){
        return "users/registration";
    }
    @RequestMapping(value="users/login", method = RequestMethod.POST)
    public String loginUser(User user){
        return "redirect:/posts";
    }
    @RequestMapping("users/logout")
    public String logout(Model model){
        ArrayList<Post> posts=postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "index";
    }
}
