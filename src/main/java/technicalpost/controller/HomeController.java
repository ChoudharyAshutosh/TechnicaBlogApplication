package technicalpost.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import technicalpost.model.Post;
import technicalpost.service.PostService;
@Controller
public class HomeController {
    @Autowired
    private PostService postService;

    @RequestMapping("/")
    public String getAllPosts(Model model){
        ArrayList<Post> posts=postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "index";
    }
}
