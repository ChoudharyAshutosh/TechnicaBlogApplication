package technicalpost.service;
import org.springframework.beans.factory.annotation.Autowired;
import technicalpost.model.Post;
import org.springframework.stereotype.Service;
import technicalpost.repository.PostRepository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.sql.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;


@Service
public class PostService {
    @Autowired
    PostRepository repository;
    public ArrayList<Post> getAllPosts(){

        ArrayList<Post> posts = new ArrayList<>();
        /*
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/technicalblog","postgres","123456789");
            Statement statement= connection.createStatement();
            ResultSet rs=statement.executeQuery("select * from posts");
            while(rs.next()){
                Post post=new Post();
                post.setTitle(rs.getString("title"));
                post.setBody(rs.getString("body"));
                posts.add(post);
            }
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }*/
/*        ArrayList<Post> posts=new ArrayList<>();
        Post post1=new Post();
        post1.setTitle("Post 1");
        post1.setBody("Post Body 1");
        post1.setDate(new Date());
        Post post2=new Post();
        post2.setTitle("Post 2");
        post2.setBody("Post Body 2");
        post2.setDate(new Date());
        Post post3=new Post();
        post3.setTitle("Post 3");
        post3.setBody("Post Body 3");
        post1.setDate(new Date());
        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
*/       return posts;
    }
    public List<Post> getOnePost(){
        Post post1= new Post();
        List<Post> posts = repository.getAllPosts();
        return posts;
        /**post1.setTitle("This is your Post");
        post1.setBody("This is your Post. It has some valid content");
        post1.setDate(new Date());
        posts.add(post1);
        return posts;*/
    }
    public void createPost (Post newPost){
        newPost.setDate(new Date());
        repository.createPost(newPost);
        System.out.println("New Post : "+newPost);
    }

    public Post getPost(Integer postId) {
        return repository.getPost(postId);
    }

    public void updatePost(Post updatedPost) {
        updatedPost.setDate(new Date());
        repository.updatePost(updatedPost);
    }

    public void deletePost(Integer postId) {
        repository.deletePost(postId);
    }
}
