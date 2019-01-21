package alexscotson.forum.service;

import alexscotson.forum.domain.User;
import alexscotson.forum.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;



    public User findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    public void save(User user) {
        this.userRepository.save(user);
    }

    public boolean authenticate(String username, String password) {

        User user = userRepository.findByUsername(username);

        if (user.getUsername() == username && user.getPassword() == password) {
            return true;
        }
        return false;
    }


}
