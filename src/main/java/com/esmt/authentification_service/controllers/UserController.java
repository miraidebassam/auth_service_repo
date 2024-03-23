package com.esmt.authentification_service.controllers;

import com.esmt.authentification_service.entites.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.esmt.authentification_service.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        System.out.println("Auth Service est appele MI");
//        hlrService.activateSubscriber(number, subscriberType);
        return ResponseEntity.ok("Test reussit!");
    }

    @GetMapping("/displayUsers")
    public ResponseEntity<List<Utilisateur>> displayUsers() {
        List<Utilisateur> users = userService.displayAllUser();
        if (!users.isEmpty()) {
            return ResponseEntity.ok(users);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/addNewUser")
    public ResponseEntity<String> addNewUser(@RequestBody Utilisateur utilisateur) {
        userService.addNewUser(utilisateur);
        return ResponseEntity.status(HttpStatus.CREATED).body("User added avec succès dans le Auth");
    }

    @GetMapping("/display/")
    public ResponseEntity<Utilisateur> displayUser(@RequestParam String username) {
        Utilisateur user = userService.displayUserByUsername(username);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
