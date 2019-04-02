package com.gestor.ususer.rest;

import com.gestor.ususer.model.Usuario;
import com.gestor.ususer.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserRest {

    private UserService userService;

    public UserRest( UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users/")
    public ResponseEntity saveUsuario(@RequestBody Usuario user) {
        return userService.findByUsername(user.getUsername()) == null ?
                ResponseEntity.ok(userService.createUser(user)):
                new ResponseEntity("user name  " + user.getUsername() + "  Existe", HttpStatus.CONFLICT);
    }

    @GetMapping("/users/")
    public ResponseEntity getAllUsuarios() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/users/{username}")
    public ResponseEntity getUsuario(@PathVariable String username) {
        return ResponseEntity.ok(userService.findByUsername(username));
    }
}
