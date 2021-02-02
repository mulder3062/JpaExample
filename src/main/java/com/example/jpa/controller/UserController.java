package com.example.jpa.controller;

import com.example.jpa.service.UserService;
import com.example.jpa.vo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UserService userService;

    @GetMapping(value = "/all", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<User>> findAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<User> getTodo(@PathVariable("userId") String userId) {
        Optional<User> user = userService.findById(userId);

        return new ResponseEntity<>(user.get(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> delete(@PathVariable("userId") String userId) {
        userService.deleteById(userId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/{userId}",
            consumes = { MediaType.APPLICATION_JSON_VALUE},
            produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<User> update(@PathVariable("userId") String userId, @RequestBody User user) {
        Optional<User> user1 = userService.updateById(userId, user);

        if (user1.isPresent()) return new ResponseEntity<>(user1.get(), HttpStatus.OK);
        else return new ResponseEntity<>(user, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE},
            produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<User> save(@RequestBody User user) {
        return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    }
}
