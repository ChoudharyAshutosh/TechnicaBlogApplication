package technicalpost.model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="post_table")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;
    @Column
    private String title;
    @Column
    private String body;
    @Column
    private Date date;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Category> categories=new ArrayList<>();
    @Transient
    private String springBlog;

    public String getSpringBlog() {
        return springBlog;
    }

    public void setSpringBlog(String springBlog) {
        this.springBlog = springBlog;
    }

    public String getJavaBlog() {
        return javaBlog;
    }

    public void setJavaBlog(String javaBlog) {
        this.javaBlog = javaBlog;
    }

    @Transient
    private String javaBlog;
    public User getUser() {
        return user;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
