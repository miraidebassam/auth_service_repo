package com.esmt.authentification_service.services;

import com.esmt.authentification_service.entites.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esmt.authentification_service.repositorys.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<Utilisateur> displayAllUser() {
        return userRepository.findAll();
    }

    public void addNewUser(Utilisateur utilisateur) {
        userRepository.save(utilisateur);
    }

    public Utilisateur displayUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
}
