package com.gestor.ususer.rest;

import com.gestor.ususer.model.Usuario;
import com.gestor.ususer.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRest {

    private UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserRest(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/users/")
    public void saveUsuario(@RequestBody Usuario user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @GetMapping("/users/")
    public List<Usuario> getAllUsuarios() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{username}")
    public Usuario getUsuario(@PathVariable String username) {
        return userRepository.findByUsername(username);
    }
}
