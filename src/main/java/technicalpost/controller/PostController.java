package technicalpost.controller;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import technicalpost.model.Category;
import technicalpost.model.Post;
import technicalpost.model.User;
import technicalpost.service.PostService;

import javax.servlet.http.HttpSession;

@Controller
public class PostController {
    @Autowired
    private PostService postService;
    @RequestMapping("posts")
    public String getUsersPosts(Model model){
        List<Post> posts=postService.getOnePost();
        model.addAttribute("posts", posts);
        return "posts";
    }
    @RequestMapping("/posts/newpost")
    public String newPost(){
        return "posts/createPost";
    }
    @RequestMapping(value="/posts/create",method=RequestMethod.POST)
    public String createPost(Post newPost, HttpSession session){
        User user=(User)session.getAttribute("loggeduser");
        newPost.setUser(user);
        if(newPost.getSpringBlog() != null){
            Category springBlogCategory= new Category();
            springBlogCategory.setCategory(newPost.getSpringBlog());
            newPost.getCategories().add(springBlogCategory);
        }
        if(newPost.getJavaBlog() != null){
            Category javaBlogCategory=new Category();
            javaBlogCategory.setCategory(newPost.getJavaBlog());
            newPost.getCategories().add(javaBlogCategory);
        }
        postService.createPost(newPost);
        return "redirect:/posts";
    }
    @RequestMapping(value = "/editPost", method = RequestMethod.GET)
    public String editPost(@RequestParam(name="postId") Integer postId, Model model){
        Post post=postService.getPost(postId);
        model.addAttribute("post", post);
        return "posts/editPost";
    }
    @RequestMapping(value = "/editPost", method = RequestMethod.POST)
    public String editPostSubmit(@RequestParam(name="postId") Integer postId, Post updatedPost, HttpSession session){
        updatedPost.setId(postId);
        User user=(User) session.getAttribute("loggeduser");
        updatedPost.setUser(user);
        postService.updatePost(updatedPost);
        return "redirect:/posts";
    }
    @RequestMapping(value = "/deletePost", method = RequestMethod.POST)
    public String deletePostSubmit(@RequestParam(name = "postId") Integer postId){
        postService.deletePost(postId);
        return "redirect:/posts";
    }
}
