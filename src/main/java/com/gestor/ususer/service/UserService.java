package com.gestor.ususer.service;

import com.gestor.ususer.model.Usuario;

import java.util.List;

public interface UserService {

    Usuario createUser(Usuario user);

    List<Usuario> findAll();

    Usuario findByUsername(String username);

}
