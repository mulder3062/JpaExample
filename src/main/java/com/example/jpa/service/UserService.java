package com.example.jpa.service;

import com.example.jpa.repository.UserRepository;
import com.example.jpa.vo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UserRepository userRepository;

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(e -> users.add(e));

        return users;
    }

    public Optional<User> findById(String userId) {
        return userRepository.findById(userId);
    }
    
    public void deleteById(String userId) {
        userRepository.deleteById(userId);
    }
    
    public User save(User user) {
        return userRepository.save(user);
    }
    
    public Optional<User> updateById(String userId, User user) {
        Optional<User> foundUser = userRepository.findById(userId);
        
        if (foundUser.isPresent()) {
            User user1 = foundUser.get();
            user1.setName(user.getName());
            userRepository.save(user1);

            return foundUser;
        }

        return Optional.empty();
    }

}
