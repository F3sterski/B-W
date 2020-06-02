package com.meet.up.blackandwhite.resource;

import com.meet.up.blackandwhite.model.User;
import com.meet.up.blackandwhite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
public class UserResource {

    UserRepository userRepository;

    public UserResource(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "customers", produces = APPLICATION_JSON_VALUE)
    public List<User> getAll(){
        return userRepository.listAll();
    }

    @PostMapping(value = "customer", produces = APPLICATION_JSON_VALUE)
    public int postOne(@RequestBody User user){
        return userRepository.save(user);
    }



}
