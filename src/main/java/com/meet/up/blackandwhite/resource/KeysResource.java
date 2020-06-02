package com.meet.up.blackandwhite.resource;

import com.meet.up.blackandwhite.model.Keys;
import com.meet.up.blackandwhite.model.User;
import com.meet.up.blackandwhite.repository.KeysRepository;
import com.meet.up.blackandwhite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
public class KeysResource {

    KeysRepository keysRepository;

    public KeysResource(@Autowired KeysRepository keysRepository) {
        this.keysRepository = keysRepository;
    }

    @GetMapping(value = "keys", produces = APPLICATION_JSON_VALUE)
    public List<Keys> getAll(){
        return keysRepository.findAll();
    }

    @PostMapping(value = "key", produces = APPLICATION_JSON_VALUE)
    public Keys postOne(@RequestBody Keys key){
        return keysRepository.save(key);
    }



}
