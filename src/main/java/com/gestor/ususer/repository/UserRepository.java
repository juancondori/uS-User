package com.gestor.ususer.repository;

import com.gestor.ususer.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);
}
