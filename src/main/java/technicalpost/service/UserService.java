package technicalpost.service;
import org.springframework.beans.factory.annotation.Autowired;
import technicalpost.model.User;
import org.springframework.stereotype.Service;
import technicalpost.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository repository;
    public User login(User user){
        User existingUser = repository.checkUser(user.getUsername(), user.getPassword());
        if(existingUser != null)
            return existingUser;
        else
            return null;
    }
    public void registerUser(User newUser){
        repository.registerUser(newUser);
    }
}
