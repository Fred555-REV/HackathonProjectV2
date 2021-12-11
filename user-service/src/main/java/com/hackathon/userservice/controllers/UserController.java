package com.hackathon.userservice.controllers;

import com.hackathon.userservice.models.Resetpw;
import com.hackathon.userservice.models.User;
import com.hackathon.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Value("${ticketservice.path}")
    public String ticketPath;

    @Bean
    private RestTemplate restTemplate() {
        return restTemplate();
    }

    @Autowired
    public UserService service;

    @GetMapping("/tickets/{userID}")
    public ArrayList<?> getTicketsFromUser(Long id) {
        return restTemplate().getForObject(ticketPath + "/tickets/user/" + id, ArrayList.class);
    }

    @GetMapping
    public List<User> getUsers() {
//        System.out.println(url);
        return service.getAllUsers();
    }

    @GetMapping("/{userID}")
    public User getUserByID(@PathVariable("userID") Long userID) {
        return service.getUserByID(userID);
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return service.addUser(user);
    }

    @PutMapping("/resetpw/{id}")
    public void resetPassword(@PathVariable("id") Long id, @RequestBody Resetpw resetpw) {
        //prevpass
        //newpass
        //confirmation
        service.changePassword(resetpw, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id, @RequestBody String incomingAuthorization) {
        service.deleteUser(id, incomingAuthorization);
    }

}
